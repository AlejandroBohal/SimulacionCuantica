/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cnyt.libreriacomplejos.exceptions;

/**
 *
 * @author sergio.bohorquez
 */
public class LibreriaComplejosException extends Exception {
    public static final String TAMANO_VECTOR = "Los vectores deben tener el mismo tamaño";
    public static final String TAMANO_MATRIZ = "las matrices deben ser del mismo tamaño";
    public static final String MATRIZ_CUADRADA = "la matriz debe ser cuadrada";
    public static String getMessage(int tamañoVector1,int tamañoVector2){
        String excepcion = TAMANO_VECTOR + "Tamaño vector 1 "+ tamañoVector1 + "Tamaño vector 2 " + tamañoVector2;
        return excepcion;
    }
    public LibreriaComplejosException(String message){
       super(message);
    }
}
