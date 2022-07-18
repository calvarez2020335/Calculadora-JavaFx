/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.carlosalvarez.bean;


/**
 *
 * @author Carlos Adolfo Alvarez Crúz
 * @date 10 abr 2021
 * @time 7:14:15 Codigo tecnico: IN5BV
 */
// clase hija 
public class Suma extends Operacion {

    @Override
    public float operar(float numero1, float numero2) {
        this.setNumero1(numero1);
        this.setNumero2(numero2);
        this.setOperador('+');
        this.setResultado(this.getNumero1() + this.getNumero2());
        return this.getResultado();
    }

}
