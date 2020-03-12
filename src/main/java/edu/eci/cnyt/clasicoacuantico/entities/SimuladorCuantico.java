/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cnyt.clasicoacuantico.entities;

import edu.eci.cnyt.libreriacomplejos.entities.MatrizCompleja;
import edu.eci.cnyt.libreriacomplejos.exceptions.LibreriaComplejosException;
import java.io.File;
import java.io.IOException;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.chart.ChartUtilities;

/**
 * Programming drill 3.1.1
 * @author AlejandroB
 */
public class SimuladorCuantico {
    private MatrizCompleja estadoInicial;
    private MatrizCompleja matrizEstados;
    private MatrizCompleja estadoActual;
    private MatrizCompleja vectorProbabilidad;
    
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
        for (int i=0;i<numeroClicks;i++){
            auxEstadoFinal.setMatriz(auxMatrizEstados.multiplicacion(auxEstadoFinal).getMatriz());
            
        }
        
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
    
    public static void generarBarras(String titulo) throws IOException{
       DefaultCategoryDataset dataset = new DefaultCategoryDataset();
       dataset.addValue(1, "hola", "mundo");
       dataset.addValue(2, "hola", "mundo");
       dataset.addValue(10, "hola", "mundo");
       dataset.addValue(5, "hola", "mundo");
       JFreeChart chart = ChartFactory.createBarChart("Ejemplo","X", "Y", dataset, PlotOrientation.VERTICAL, true, true, true);
       ChartPanel panel = new ChartPanel(chart);
       File dir = new File("graficasSimulaciones");
       dir.mkdirs();
       File tmp = new File(dir, titulo);
       
       ChartUtilities.saveChartAsJPEG(tmp, chart, 500, 400);
    }

    public MatrizCompleja getVectorProbabilidad() {
        return vectorProbabilidad;
    }

    public void setVectorProbabilidad(MatrizCompleja vectorProbabilidad) {
        this.vectorProbabilidad = vectorProbabilidad;
    }
    
}
