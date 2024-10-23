package com.angelodev.screenmatch.principal;

import com.angelodev.screenmatch.excepcion.ErrorEnConversionDeDuracion;
import com.angelodev.screenmatch.formateadores.UrlEncoder;
import com.angelodev.screenmatch.modelos.Titulo;
import com.angelodev.screenmatch.modelos.TituloOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrincipalConBusqueda {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner teclado = new Scanner(System.in);
        List<Titulo> listadoDeTitulos = new ArrayList<>();

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();

        while (true){
            System.out.println("Ingrese el nombre de la pelicula que desea buscar:");
            var busqueda = teclado.nextLine();

            if (busqueda.equalsIgnoreCase("Salir")){
                break;
            }

            UrlEncoder formateoDeUrls = new UrlEncoder();
            var busquedaFormateada = formateoDeUrls.encode(busqueda);
            //A continuación declaramos la URL de la API más el parámetro "busqueda"
            String direccion = ("http://www.omdbapi.com/?t="+ busquedaFormateada +"&apikey=4912ae8");

            try{
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(direccion))
                        .build();
                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());

                String json = response.body();
                System.out.println(json);

                TituloOmdb miTituloOmdb = gson.fromJson(json, TituloOmdb.class);

                System.out.println(miTituloOmdb);

                Titulo miTitulo = new Titulo(miTituloOmdb);
                System.out.println("Titulo ya convertido: " + miTitulo);
                listadoDeTitulos.add(miTitulo);

//                FileWriter escritura = new FileWriter("peliculas.txt");
//                escritura.write(miTitulo.toString());
//                escritura.close();

            } catch (NumberFormatException e){
                System.out.println("Ha ocurrido un error: ");
                System.out.println(e.getMessage());
            }
            catch (IllegalArgumentException e){
                System.out.println("Error en la URI, verifique la dirección");
            }

            catch (ErrorEnConversionDeDuracion e){
                System.out.println(e.getMensaje());
            }

        }
        System.out.println(listadoDeTitulos);
        FileWriter escritura = new FileWriter("Titulos.json");
        escritura.write(gson.toJson(listadoDeTitulos));
        escritura.close();
        System.out.println("******Finalizó el proceso de búsqueda******");
    }
}
