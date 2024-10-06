package com.angelodev.screenmatch.modelos;

import com.angelodev.screenmatch.calculos.Clasificable;

public class Episodio implements Clasificable {
    private int numeroEpisodio;

    private String nombre;

    private Serie serie;

    private int totalDeVisualizaciones;

    public int getTotalDeVisualizaciones() {
        return totalDeVisualizaciones;
    }

    public void setTotalDeVisualizaciones(int totalDeVisualizaciones) {
        this.totalDeVisualizaciones = totalDeVisualizaciones;
    }

    public int getNumeroEpisodio() {
        return numeroEpisodio;
    }

    public void setNumeroEpisodio(int numeroEpisodio) {
        this.numeroEpisodio = numeroEpisodio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Serie getSerie() {
        return serie;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }

    @Override
    public int getClasificacion() {
        if (totalDeVisualizaciones > 100){
            return 4;
        } else {
            return 2;
        }
    }
}
