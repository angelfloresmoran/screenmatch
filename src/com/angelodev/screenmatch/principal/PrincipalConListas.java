package com.angelodev.screenmatch.principal;

import com.angelodev.screenmatch.modelos.Pelicula;
import com.angelodev.screenmatch.modelos.Serie;
import com.angelodev.screenmatch.modelos.Titulo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PrincipalConListas {
    public static void main (String[] args){
        Pelicula favorita = new Pelicula("El señor de los anillos", 2021);
        favorita.evalua(10);
        Pelicula otra = new Pelicula("Jonh Wick", 2014);
        otra.evalua(9);
        var peliculaDeAngel = new Pelicula("El sobreviviente", 2000);
        peliculaDeAngel.evalua(7);
        Serie serie = new Serie("La casa de papel", 2017);

        List<Titulo> listaDeTitulos = new ArrayList<>();
        listaDeTitulos.add(favorita);
        listaDeTitulos.add(otra);
        listaDeTitulos.add(peliculaDeAngel);
        listaDeTitulos.add(serie);

        for (Titulo item: listaDeTitulos){
            System.out.println("Nombre: " + item.getNombre());
            if (item instanceof Pelicula pelicula && pelicula.getClasificacion() > 3){
                System.out.println(pelicula.getClasificacion());
            }
        }

        ArrayList <String> artistas = new ArrayList<>();
        artistas.add("Ed sheeran");
        artistas.add("Coldplay");
        artistas.add("The Killers");
        //System.out.println(artistas);
        Collections.sort(artistas);
        //System.out.println("Lista de artistas ordenada: " + artistas);

        Collections.sort(listaDeTitulos);
        System.out.println("Lista ordenada por orden alfabetico: " + listaDeTitulos);
        listaDeTitulos.sort(Comparator.comparing(Titulo::getFechaDeLanzamiento));
        System.out.println("Lista ordenada por fecha: " + listaDeTitulos);

    }
}
