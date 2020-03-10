/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cnyt.libreriacomplejos;

import edu.eci.cnyt.libreriacomplejos.entities.Complejo;
import edu.eci.cnyt.libreriacomplejos.entities.ComplejoPolar;
import edu.eci.cnyt.libreriacomplejos.entities.MatrizCompleja;
import edu.eci.cnyt.libreriacomplejos.entities.VectorComplejo;
import edu.eci.cnyt.libreriacomplejos.exceptions.LibreriaComplejosException;
import java.util.ArrayList;
import org.junit.Assert;

import org.junit.Test;

/**
 *
 * @author 2146516
 */
public class ComplejosTest {
    
    @Test
    public void deberiaSumar(){
       Complejo complejo1 = new Complejo(1.0,2.0);
       Complejo complejo2 = new Complejo(3.0,4.0);
       complejo1 = complejo1.sumar(complejo2);
       Assert.assertTrue(complejo1.equals(new Complejo(4.0,6.0)));
       
       
    }
    @Test
    public void deberiaRestar(){
       Complejo complejo1 = new Complejo(2.0,2.0);
       Complejo complejo2 = new Complejo(2.0,4.0);
       complejo1 = complejo1.restar(complejo2);
       Assert.assertTrue(complejo1.equals(new Complejo(0.0,-2.0)));
       
       
    }
    @Test
    public void deberiaMultiplicar(){
       Complejo complejo1 = new Complejo(-2.2,2.0);
       Complejo complejo2 = new Complejo(-2.2,4.0);
       complejo1 = complejo1.multiplicar(complejo2);
       Assert.assertTrue(complejo1.equals(new Complejo(-3.16,-13.2)));
       
    }
    @Test
    public void deberiaDividir(){
       Complejo complejo1 = new Complejo(-4.2,3.0);
       Complejo complejo2 = new Complejo(2.2,1.0);
       complejo1 = complejo1.dividir(complejo2);
       Assert.assertTrue(complejo1.equals(new Complejo(-1.068493,1.849315)));
    }
    @Test
    public void deberiaSacarModulo(){
       Complejo complejo1 = new Complejo(5.0,3.43);
       Assert.assertTrue(complejo1.modulo()-6.063406 <= 0.00001);
       
    }
    @Test
    public void deberiaSacarConjugado(){
       //prueba 1
       Complejo complejo1 = new Complejo(5.0,3.43);
       complejo1 = complejo1.conjugado();
       Assert.assertTrue(complejo1.equals(new Complejo(5.0,-3.43)));
       //prueba 2
       Complejo complejo2 = new Complejo(32143.33,-331421);
       complejo2 = complejo2.conjugado();
       Assert.assertTrue(complejo2.equals(new Complejo(32143.33,331421)));
       // prueba 3
       Complejo complejo3 = new Complejo(0.0,0.0);
       complejo3 = complejo3.conjugado();
       Assert.assertTrue(complejo3.equals(new Complejo(0.0,0.0)));
       
    }
    @Test
    public void deberiaConvertirAPolar(){
        Complejo complejo1 = new Complejo(5.0,3.43);
        ComplejoPolar complejoPrueba = complejo1.cartesianaAPolar();
        Assert.assertTrue(complejoPrueba.equals(new ComplejoPolar(6.063406633,0.601268065)));
    }
    @Test
    public void deberiaSumarVectores() throws LibreriaComplejosException{
        double vector1[][] = {{1.234556,3.234556},{1,5},{5,2}};
        double vector2[][] = {{2,2},{2.234556,2.234556},{0.234556,0.234556}};
        double vector3[][] = {{3.234556,5.234556},{3.234556,7.234556},{5.234556,2.234556}};
        VectorComplejo vectorOp1 = new VectorComplejo(vector1);
        VectorComplejo vectorOp2 = new VectorComplejo(vector2);
        VectorComplejo resultado = new VectorComplejo(vector3);
        Assert.assertTrue(vectorOp1.sumar(vectorOp2).equals(resultado));
        
    }
    @Test
    public void deberiaRestarVectores() throws LibreriaComplejosException{
        double vector1[][] = {{3.5,3.5},{3.5,5},{2.1,2}};
        double vector2[][] = {{3.5,3.5},{3.5,5},{2.1,2}};
        double vector3[][] = {{0.0,0.0},{0.0,0.0},{0.0,0.0}};
        VectorComplejo vectorOp1 = new VectorComplejo(vector1);
        VectorComplejo vectorOp2 = new VectorComplejo(vector2);
        VectorComplejo resultado = new VectorComplejo(vector3);
        Assert.assertTrue(vectorOp1.restar(vectorOp2).equals(resultado));
        
    }
    @Test
    public void deberiaSacarInversoVector(){
        double vector1[][] = {{3.5,3.5},{3.5,5},{2.1,2},{1.1,2},{9.0,3.3},{2.1,0.0}};
        double vector2[][] = {{-3.5,-3.5},{-3.5,-5},{-2.1,-2},{-1.1,-2},{-9.0,-3.3},{-2.1,-0.0}};
        VectorComplejo vectorOp1 = new VectorComplejo(vector1);
        VectorComplejo resultado = new VectorComplejo(vector2);
        Assert.assertTrue(vectorOp1.inversa().equals(resultado));
        
    }
    @Test
    public void deberiaSacarInversoMatriz(){
        double matriz1[][][] = {{{2,2},{3,2}},
                               {{1,2},{3,4}}};
        double matriz2[][][] = {{{-2,-2},{-3,-2}},
                               {{-1,-2},{-3,-4}}};
        MatrizCompleja matrizCompleja1 = new MatrizCompleja(matriz1);
        MatrizCompleja resultado = new MatrizCompleja(matriz2);
        Assert.assertTrue(matrizCompleja1.inversa().equals(resultado));
        
    }
    @Test
    public void deberiaSumarMatrices() throws LibreriaComplejosException{
        double matriz1[][][] = {{{2,2},{3,2}},
                               {{1,2},{3,4}}};
        double matriz2[][][] = {{{1,1},{1,1}},
                               {{1,1},{1,1}}};
        double matriz3[][][] = {{{3,3},{4,3}},
                               {{2,3},{4,5}}};
        MatrizCompleja matrizCompleja1 = new MatrizCompleja(matriz1);
        MatrizCompleja matrizCompleja2 = new MatrizCompleja(matriz2);
        MatrizCompleja matrizResultado = new MatrizCompleja(matriz3);
        Assert.assertTrue(matrizResultado.equals(matrizCompleja1.sumar(matrizCompleja2)));
        
        
        
    }
    @Test
    public void deberiaMultiplicarPorEscalar(){
        double matriz1[][][] = {{{1,1},{1,1}},
                               {{1,1},{1,1}}};
        double matriz2[][][] = {{{0,4},{0,4}},
                               {{0,4},{0,4}}};
        Complejo complejo = new Complejo(2,2);
        MatrizCompleja matrizCompleja1 = new MatrizCompleja(matriz1);
        MatrizCompleja matrizResultado = new MatrizCompleja(matriz2);
        Assert.assertTrue(matrizResultado.equals(matrizCompleja1.multiplicacionEscalar(complejo)));
        
        
    }
    @Test
    public void deberiaSacarTranspuesta(){
       double matriz1[][][] = {{{1,1},{1,1},{2,2}},
                               {{1,1},{1,1},{1,5}}};
       double matriz2[][][] = {{{1,1},{1,1}},
                              {{1,1},{1,1}},
                              {{2,2},{1,5}}};
       
       MatrizCompleja matrizCompleja1 = new MatrizCompleja(matriz1);
       MatrizCompleja matrizCompleja2 = new MatrizCompleja(matriz2);
       Assert.assertTrue(matrizCompleja1.transpuesta().equals(matrizCompleja2));
    }
    @Test
    public void deberiaSacarConjugada(){
       double matriz1[][][] = {{{1,1},{1,1},{2,2}},
                               {{1,1},{1,1},{1,5}}};
       double matriz2[][][] = {{{1,-1},{1,-1},{2,-2}},
                               {{1,-1},{1,-1},{1,-5}}};
       MatrizCompleja matrizCompleja1 = new MatrizCompleja(matriz1);
       MatrizCompleja matrizCompleja2 = new MatrizCompleja(matriz2);
       Assert.assertTrue(matrizCompleja2.equals(matrizCompleja1.conjugada()));
       
       
    }
    @Test
    public void deberiaMultiplicarMatrices() throws LibreriaComplejosException{
        double matriz1[][][] = {{{4,0},{3,0}},
                               {{2,0},{2,0}}};
        double matriz2[][][] = {{{1,0}},
                               {{2,0}}};
        double resultado[][][] = {{{10,0}},
                                 {{6,0}}};
        MatrizCompleja matrizCompleja1 = new MatrizCompleja(matriz1);
        MatrizCompleja matrizCompleja2 = new MatrizCompleja(matriz2);
        MatrizCompleja matrizResultado = new MatrizCompleja(resultado);
        Assert.assertTrue(matrizResultado.equals(matrizCompleja1.multiplicacion(matrizCompleja2)));
        
        
    }
    
    @Test
    public void deberiaSacarAdjunta(){
        double matriz1[][][] = {{{1,2},{4,2},{3,2}},
                               {{1,-3},{1,-1},{1,2}}};
        double matriz2[][][] = {{{1,-2},{1,3}},
                                {{4,-2},{1,1}},
                                {{3,-2},{1,-2}}};
        MatrizCompleja matrizCompleja1 = new MatrizCompleja(matriz1);
        MatrizCompleja resultado = new MatrizCompleja(matriz2);
        Assert.assertTrue(matrizCompleja1.adjunta().equals(resultado));
    }
    @Test
    public void deberiaSacarTraza(){
        double matriz1[][][] = {{{4,0},{-1,0},{3,1},{1,1}},
                               {{2,0},{1,0},{2,0},{1,3}}};
        Complejo resultado = new Complejo(5,0);
        MatrizCompleja matrizCompleja1 = new MatrizCompleja(matriz1);
        Assert.assertTrue(resultado.equals(matrizCompleja1.traza()));
        
    }
    @Test
    public void deberiaSacarProductorInterno() throws LibreriaComplejosException{
       double matriz1[][][] = {{{5,-2},{2,1}},  
                               {{3,-4},{1,3}}};
       double matriz2[][][] = {{{3,-2},{2.2,1}},  
                               {{1,4},{6,13}}};
       Complejo complejo = new Complejo(56.4,6.8);
       MatrizCompleja matrizCompleja1 = new MatrizCompleja(matriz1);
       MatrizCompleja matrizCompleja2 = new MatrizCompleja(matriz2);
       Assert.assertTrue(complejo.equals(matrizCompleja1.productoInterno(matrizCompleja2)));
       
       
       
    }
    @Test
    public void deberiaSacarNorma() throws LibreriaComplejosException{
        double matriz1[][][] = {{{5,-2},{2,1}},
                               {{2,1},{1,3}}};
        MatrizCompleja matrizCompleja1 = new MatrizCompleja(matriz1);
        MatrizCompleja matrizCompleja2 = new MatrizCompleja(matriz1);
        Assert.assertTrue(7.0-matrizCompleja1.norma()<=0.0001);        
        
    }
    @Test
    public void deberiaSacarDistancia() throws LibreriaComplejosException{
        double matriz1[][][] = {{{5,-2},{2,1}},
                               {{2,1},{1,3}}};
        double matriz2[][][] = {{{10,-2},{2,1}},
                               {{5,1},{1,-3}}};
        MatrizCompleja matrizCompleja1 = new MatrizCompleja(matriz1);
        MatrizCompleja matrizCompleja2 = new MatrizCompleja(matriz2);
        Assert.assertTrue(8.36660026-matrizCompleja1.distancia(matrizCompleja2)<=0.00001);
        
    }
    @Test
    public void deberiaSerHermitian() throws LibreriaComplejosException{
        double matriz[][][] = {{{5,0},{4,5},{6,-16}},
                              {{4,-5},{13,0},{7,0}},
                              {{6,16},{7,0},{-2.1,0}}};
        MatrizCompleja matrizCompleja1 = new MatrizCompleja(matriz);
        Assert.assertTrue(matrizCompleja1.esHermitian());
        double matriz2[][][] = {{{7,0},{6,5}},
                               {{6,-5},{-3,0}}};
        MatrizCompleja matrizCompleja2 = new MatrizCompleja(matriz2);
        Assert.assertTrue(matrizCompleja2.esHermitian());
        
    }
    @Test
    public void deberiaSerUnitaria() throws LibreriaComplejosException{
        double matriz[][][] = {{{0.5,0.5},{0,1/Math.sqrt(3)},{3/(2*Math.sqrt(15)),1/(2*Math.sqrt(15))}},
                              {{-0.5,0},{1/Math.sqrt(3),0},{4/(2*Math.sqrt(15)),3/(2*Math.sqrt(15))}},
                              {{0.5,0},{0,-1/Math.sqrt(3)},{0,5/(2*Math.sqrt(15))}}};
        MatrizCompleja matrizCompleja1 = new MatrizCompleja(matriz);
        Assert.assertTrue(matrizCompleja1.esUnitaria());
        double matriz2[][][] = {{{Math.cos(0.5),0},{-Math.sin(0.5),0},{0,0}},
                                {{Math.sin(0.5),0},{Math.cos(0.5),0},{0,0}},
                                {{0,0},{0,0},{1,0}}};
        MatrizCompleja matrizCompleja2 = new MatrizCompleja(matriz2);
        Assert.assertTrue(matrizCompleja2.esUnitaria());

    }
    @Test
    public void deberiaSacarTensor() throws LibreriaComplejosException{

        double matriz1[][][] = {{{1.0,0.0},{2.3,0.2},{1.2,0.2}},{{1.5,0.5},{2.3,2.2},{1.4,1.0}},{{1.5,2.5},{2.2,3.2},{1.1,2.3}}};
        double matriz2[][][] = {{{1.0,0.3},{1.3,2.2}},{{1.4,2.1},{2.5,0.6}}};
        MatrizCompleja matrizCompleja1 = new MatrizCompleja(matriz1);
        MatrizCompleja matrizCompleja2 = new MatrizCompleja(matriz2);
        
        System.out.println(matrizCompleja1.productoTensor(matrizCompleja2));
   
    }
    @Test
    public void experimento() throws LibreriaComplejosException{
        MatrizCompleja matriz1 = MatrizCompleja.H;
        MatrizCompleja matriz2 = MatrizCompleja.H;
        MatrizCompleja matriz3 = MatrizCompleja.H;
        MatrizCompleja x = MatrizCompleja.X;
        MatrizCompleja tensor1 = matriz1.productoTensor(matriz2);
        MatrizCompleja tensor2 = matriz3.productoTensor(x);
        MatrizCompleja zero = new MatrizCompleja (new double[][][] {{{1,0}},{{0,0}},{{0,0}},{{0,0}}});
        MatrizCompleja resultado = tensor2.multiplicacion(tensor1).multiplicacion(zero);
        System.out.println(resultado);
    }
    
    
    
    
}
