/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.carlosalvarez.bean;

/**
 *
 * @author Carlos Adolfo Alvarez Crúz
 * @date 21 abr 2021
 * @time 14:10:05 Codigo tecnico: IN5BV
 */
// clase padre
public abstract class Operacion {

    //atributos
    private float numero1;
    private float numero2;
    private float resultado;
    private char operador;

    //constructores
    public Operacion() {
    }

    //Getter y setters
    public float getNumero1() {
        return numero1;
    }

    public void setNumero1(float numero1) {
        this.numero1 = numero1;
    }

    public float getNumero2() {
        return numero2;
    }

    public void setNumero2(float numero2) {
        this.numero2 = numero2;
    }

    public float getResultado() {
        return resultado;
    }

    public void setResultado(float resultado) {
        this.resultado = resultado;
    }

    public char getOperador() {
        return operador;
    }

    public void setOperador(char operador) {
        this.operador = operador;
    }

    public abstract float operar(float numero1, float numero2);
    
    @Override
    public String toString(){
        return ""+ this.getNumero1()+ "" + this.getOperador() + "" + this.getNumero2() + "=" + this.getResultado();
    }

    
}
