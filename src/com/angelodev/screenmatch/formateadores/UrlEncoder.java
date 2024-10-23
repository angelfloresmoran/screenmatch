package com.angelodev.screenmatch.formateadores;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class UrlEncoder {
    public static String encode(String value) {
        try {
            // Se utiliza UTF-8 como el conjunto de caracteres de codificación
            return URLEncoder.encode(value, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            // Si ocurre una excepción, se imprime el error y se devuelve la cadena original
            System.err.println("Error en la codificación: " + e.getMessage());
            return value;
        }
    }
}
