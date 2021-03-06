/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cnyt.clasicoacuantico;

import edu.eci.cnyt.clasicoacuantico.entities.SimuladorCuantico;
import edu.eci.cnyt.libreriacomplejos.entities.MatrizCompleja;
import edu.eci.cnyt.libreriacomplejos.exceptions.LibreriaComplejosException;
import java.io.IOException;
import org.junit.Test;

/**
 *
 * @author AlejandroB
 */
public class SimuladorClasicoCuanticoTest {
    @Test
    public void noDeberiaGenerarCanicas() throws LibreriaComplejosException, IOException{
      double[][] matriz=
                   {{0,0,0,0,0,0},
                    {0,0,0,1,0,0},
                    {0,1,0,0,0,1},
                    {0,0,1,0,0,0},
                    {0,0,0,0,1,0},
                    {1,0,0,0,0,0}};
      double[][] estadoInicial= {{6},
                                 {5},
                                 {4},
                                 {3},
                                 {2},
                                 {1}};
      MatrizCompleja m = new MatrizCompleja(matriz);
      MatrizCompleja estado = new MatrizCompleja(estadoInicial);
      SimuladorCuantico s = new SimuladorCuantico(estado,m);
      s.click(3000);
      s.generarBarras("Canicas clásico");
      
      
    }
    @Test
    public void noDeberiaGenerarCanicas2() throws LibreriaComplejosException, IOException{
      double[][] matriz=
                   {{0,0,0,0,0,0},
                    {0,0,0,1,0,0},
                    {0,1,0,0,0,1},
                    {0,0,1,0,0,0},
                    {0,0,0,0,1,0},
                    {1,0,0,0,0,0}};
      double[][] estadoInicial= {{1},
                                 {0},
                                 {0},
                                 {0},
                                 {0},
                                 {0}};
      MatrizCompleja m = new MatrizCompleja(matriz);
      MatrizCompleja estado = new MatrizCompleja(estadoInicial);
      SimuladorCuantico s = new SimuladorCuantico(estado,m);
      s.click(2019);
      s.generarBarras("Canicas clásico2");
      
    }
    @Test
    public void DeberiaGenerarCanicas() throws LibreriaComplejosException{
      double[][] matriz=
                   {{0,0,1,0,0,0},
                    {0,0,0,1,0,0},
                    {0,0,0,0,0,1},
                    {0,0,1,0,0,0},
                    {0,0,1,0,1,0},
                    {1,0,0,0,0,0}};
      double[][] estadoInicial= {{1},
                                 {0},
                                 {0},
                                 {0},
                                 {0},
                                 {0}};
      MatrizCompleja m = new MatrizCompleja(matriz);
      MatrizCompleja estado = new MatrizCompleja(estadoInicial);
      SimuladorCuantico s = new SimuladorCuantico(estado,m);
      s.click(2019);
      
    }
    @Test
    public void experimentoMultiplesRendijasClasico() throws LibreriaComplejosException, IOException{
        double[][] matriz = {{0,0,0,0,0,0,0,0,0,0,0},
                             {(1.0/3.0),0,0,0,0,0,0,0,0,0,0},
                             {(1.0/3.0),0,0,0,0,0,0,0,0,0,0},
                             {(1.0/3.0),0,0,0,0,0,0,0,0,0,0},
                             {0,   (1.0/3.0),0,1,0,0,0,0,0,0,0},
                             {0,   (1.0/3.0),0,0,0,1,0,0,0,0,0},
                             {0,   (1.0/3.0),(1.0/3.0),0,0,0,1,0,0,0,0},
                             {0,   0,    (1.0/3.0),0,0,0,0,1,0,0,0},
                             {0,   0,    (1.0/3.0),(1.0/3.0),0,0,0,0,1,0,0},
                             {0,   0,    0,    (1.0/3.0),0,0,0,0,0,1,0},
                             {0,   0,    0,    (1.0/3.0),0,0,0,0,0,0,1}};
        double[][] x0 = {{1},{0},{0},{0},{0},{0},{0},{0},{0},{0},{0}};
        MatrizCompleja matrizC = new MatrizCompleja(matriz);
        MatrizCompleja vectorEstados = new MatrizCompleja(x0);
        
        SimuladorCuantico s = new SimuladorCuantico(vectorEstados,matrizC);
        s.click(5);
        s.generarBarras("Múltiple rendija Clásico");
        
           
    }
    @Test
    public void experimentoMultiplesRendijasCuantico() throws LibreriaComplejosException, IOException{
        double[][][] matriz = {{{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0}}
                                ,{{0,1.0/Math.sqrt(3.0)},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0}},
                                {{0,1.0/Math.sqrt(3.0)},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0}},
                                {{0,1.0/Math.sqrt(3.0)},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0}},
                                {{0,0},{-0,1.0/Math.sqrt(3.0)},{0,0},{0,0},{1,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0}},
                                {{0,0},{0,1.0/Math.sqrt(3.0)},{0,0},{0,0},{0,0},{1,0},{0,0},{0,0},{0,0},{0,0},{0,0}},
                                {{0,0},{-0,1.0/Math.sqrt(3.0)},{0,1.0/Math.sqrt(3.0)},{0,0},{0,0},{0,0},{1,0},{0,0},{0,0},{0,0},{0,0}},
                                {{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{1,0},{0,0},{0,0},{0,0}},
                                {{0,0},{0,0},{0,1.0/Math.sqrt(3.0)},{-0,1.0/Math.sqrt(3.0)},{0,0},{0,0},{0,0},{0,0},{1,0},{0,0},{0,0}},
                                {{0,0},{0,0},{0,0},{0,1.0/Math.sqrt(3.0)},{0,0},{0,0},{0,0},{0,0},{0,0},{1,0},{0,0}},
                                {{0,0},{0,0},{0,0},{-0,1.0/Math.sqrt(3.0)},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{1,0}}};
        double[][] x0 = {{1},{0},{0},{0},{0},{0},{0},{0},{0},{0},{0}};
        MatrizCompleja matrizC = new MatrizCompleja(matriz);
        MatrizCompleja vectorEstados = new MatrizCompleja(x0);
        
        SimuladorCuantico s = new SimuladorCuantico(vectorEstados,matrizC);
        s.click(5);
        s.generarBarras("Múltiple rendija Cuántico");
        
    }
    
}
