/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cnyt.clasicoacuantico.entities;

import edu.eci.cnyt.libreriacomplejos.entities.MatrizCompleja;
import edu.eci.cnyt.libreriacomplejos.exceptions.LibreriaComplejosException;

/**
 * Programming drill 3.1.1
 * @author AlejandroB
 */
public class SimuladorCuantico {
    private MatrizCompleja estadoInicial;
    private MatrizCompleja matrizEstados;
    private MatrizCompleja estadoActual;
    
    /**
     * Constructor con valores booleanos, reales o complejos.
     * @param estadoInicial valor del estado inicial
     * @param matrizEstados matriz de estados booleanos
     * 
     */
    public SimuladorCuantico(MatrizCompleja estadoInicial, MatrizCompleja matrizEstados) {
        
        this.estadoInicial = estadoInicial;
        this.matrizEstados = matrizEstados;
        this.estadoActual = estadoInicial;
    }
    /**
     * Método que hace cambios en el estado del sistema dado estado inicial y matriz estados
     * @param numeroClicks cantidad de ves que se hará click
     * @return 
     */
    public MatrizCompleja click(int numeroClicks) throws LibreriaComplejosException{
        MatrizCompleja auxEstadoFinal  = new MatrizCompleja(estadoInicial.size(),estadoInicial.get(0).size());
        auxEstadoFinal.setMatriz(estadoInicial.getMatriz());
        MatrizCompleja auxMatrizEstados  = new MatrizCompleja(estadoInicial.size(),estadoInicial.get(0).size());
        auxMatrizEstados.setMatriz(matrizEstados.getMatriz());
        for (int i=0;i<numeroClicks-1;i++){
            auxMatrizEstados.setMatriz(auxMatrizEstados.multiplicacion(auxMatrizEstados).getMatriz());
        }
        auxEstadoFinal.setMatriz(auxMatrizEstados.multiplicacion(auxEstadoFinal).getMatriz());
        estadoActual.setMatriz(auxEstadoFinal.getMatriz());
        return auxEstadoFinal;
    }
    public void volverAEstadoInicial(){
        estadoActual.setMatriz(estadoInicial.getMatriz());
    }
   
    public MatrizCompleja getEstadoInicial() {
        return estadoInicial;
    }

    public void setEstadoInicial(MatrizCompleja estadoInicial) {
        this.estadoInicial = estadoInicial;
    }

    public MatrizCompleja getMatrizEstados() {
        return matrizEstados;
    }

    public void setMatrizEstados(MatrizCompleja matrizEstados) {
        this.matrizEstados = matrizEstados;
    }

    public MatrizCompleja getEstadoActual() {
        return estadoActual;
    }

    public void setEstadoActual(MatrizCompleja estadoActual) {
        this.estadoActual = estadoActual;
    }
    
}
