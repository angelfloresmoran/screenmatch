package com.angelodev.screenmatch.excepcion;

public class ErrorEnConversionDeDuracion extends RuntimeException{

    private String mensaje;

    public ErrorEnConversionDeDuracion(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return this.mensaje;
    }
}
