package com.angelodev.screenmatch.principal;

import com.angelodev.screenmatch.calculos.CalculadoraDeTiempo;
import com.angelodev.screenmatch.calculos.FiltroRecomendacion;
import com.angelodev.screenmatch.modelos.Episodio;
import com.angelodev.screenmatch.modelos.Pelicula;
import com.angelodev.screenmatch.modelos.Serie;

import java.util.ArrayList;

public class Principal {
    public static void main(String[] args){
        Pelicula miPelicula = new Pelicula("Encanto", 2021);
        miPelicula.setDuracionEnMinutos(190);
        miPelicula.setIncluidoEnElPlan(true);
        miPelicula.evalua(10);
        miPelicula.evalua(10);
        miPelicula.evalua(7.8);
        System.out.println("******************");
        miPelicula.muestraFichaTecnica();
        System.out.println("---");
        System.out.println("El total de evaluaciones es: " + miPelicula.getTotalDeLasEvaluaciones());
        System.out.println("La media es: " + miPelicula.calculaMedia());
        System.out.println("******************");

        Serie casaDragon = new Serie("La casa del dragon", 2022);
        casaDragon.setTemporadas(1);
        casaDragon.setMinutosPorEpisodio(50);
        casaDragon.setEpisodiosPorTemporada(10);
        casaDragon.muestraFichaTecnica();
        System.out.println("---");
        System.out.println("Duración de toda la serie en minutos: " + casaDragon.getDuracionEnMinutos());

        Pelicula otraPelicula = new Pelicula("Avengers", 2012);
        otraPelicula.setDuracionEnMinutos(180);
        System.out.println("\n********************************");
        otraPelicula.muestraFichaTecnica();
        System.out.println("********************************\n");

        System.out.println("*****Calculadora de maratones: *****");
        CalculadoraDeTiempo calculadora = new CalculadoraDeTiempo();
        calculadora.incluye(miPelicula);
        calculadora.incluye(casaDragon);
        calculadora.incluye(otraPelicula);
        System.out.println("Tiempo necesario para ver tus titulos favoritos " + calculadora.getTiempoTotal() + " minutos.");
        System.out.println("********************");

        FiltroRecomendacion filtroRecomendacion = new FiltroRecomendacion();
        filtroRecomendacion.filtra(miPelicula);

        Episodio episodio = new Episodio();
        episodio.setNumeroEpisodio(1);
        episodio.setNombre("La casa taegueris");
        episodio.setSerie(casaDragon);
        episodio.setTotalDeVisualizaciones(101);
        filtroRecomendacion.filtra(episodio);

        //Pelicula (esta palabra "Pelicula" es una variable de referencia y se puede sustituit por "var") peliculaDeAngel = new Pelicula (este es el tipo de dato()
        var peliculaDeAngel = new Pelicula("El señor de los anillos", 2001);
        //peliculaDeAngel.setNombre("El señor de los Anillos");
        peliculaDeAngel.setDuracionEnMinutos(180);

        ArrayList<Pelicula> listaDePeliculas = new ArrayList<>();
        listaDePeliculas.add(peliculaDeAngel);
        listaDePeliculas.add(miPelicula);
        listaDePeliculas.add(otraPelicula);
        System.out.println("Tamaño de la lista: " + listaDePeliculas.size());
        System.out.println("La primera pelicula es: " + listaDePeliculas.get(0).getNombre());

        System.out.println(listaDePeliculas);
        System.out.println("toString de la pelicula: " + listaDePeliculas.get(0).toString());



    }
}
