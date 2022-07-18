/*
   
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.carlosalvarez.controller;

import org.carlosalvarez.bean.Division;
import org.carlosalvarez.bean.Multiplicacion;
import org.carlosalvarez.bean.Resta;
import org.carlosalvarez.bean.Suma;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.carlosalvarez.bean.Operacion;

/**
 * FXML Controller class
 *
 * @author Carlos Adolfo Alvarez Crúz
 */
public class FXMLCalculadoraController implements Initializable {

    private float resultado = 0.0f;
    private boolean punto = true;
    private float numero = 0.0f;
    private int contadorOperadores = 0;
    private String operadorAnterior;
    private boolean ingresoNuevo = false;

    public float getResultado() {
        return resultado;
    }

    public void setResultado(float resultado) {
        this.resultado = resultado;
    }

    public float getNumero() {
        return numero;
    }

    public void setNumero(float numero) {
        this.numero = numero;
    }

    public int getContadorOperadores() {
        return contadorOperadores;
    }

    public void setContadorOperadores(byte contadorOperadores) {
        this.contadorOperadores = contadorOperadores;
    }

    public String getOperador() {
        return operadorAnterior;
    }

    public void setOperador(String operador) {
        this.operadorAnterior = operador;
    }

    @FXML
    private Label lblPantalla;
    @FXML
    private Button btnBorrar;
    @FXML
    private Button btnPorcentaje;
    @FXML
    private Button btnDividir;
    @FXML
    private Button btnSiete;
    @FXML
    private Button btnCuatro;
    @FXML
    private Button btnOcho;
    @FXML
    private Button btnCinco;
    @FXML
    private Button btnMultiplicacion;
    @FXML
    private Button btnNueve;
    @FXML
    private Button btnSeis;
    @FXML
    private Button btnMenos;
    @FXML
    private Button btnUno;
    @FXML
    private Button btnMasMenos;
    @FXML
    private Button btnDos;
    @FXML
    private Button btnTres;
    @FXML
    private Button btnMas;
    @FXML
    private Button btnPunto;
    @FXML
    private Button btnIgual;
    @FXML
    private Button btnS;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

    }

    @FXML
    private void clicBorrar(ActionEvent event) {
        limpiar();
    }

    private void limpiar() {
        lblPantalla.setText("");
        resultado = 0.0f;
        punto = true;
        numero = 0.0f;
        contadorOperadores = 0;
        operadorAnterior = "";
        contadorOperadores = 0;
        ingresoNuevo = false;
    }

    @FXML
    private void clicPorcentaje(ActionEvent event) {
        //lblPantalla.setText(lblPantalla.getText().concat("%"));
        resultado = resultado / 100;
    }

    @FXML
    private void clicDividir(ActionEvent event) {
        calcular("/");
    }

    @FXML
    private void clicSiete(ActionEvent event) {
        actualizarPantalla("7");
    }

    @FXML
    private void clicCuatro(ActionEvent event) {
        actualizarPantalla("4");
    }

    @FXML
    private void clicOcho(ActionEvent event) {
        actualizarPantalla("8");
    }

    @FXML
    private void clicCinco(ActionEvent event) {
        actualizarPantalla("5");
    }

    @FXML
    private void clicMultiplicacion(ActionEvent event) {
        calcular("*");
    }

    @FXML
    private void clicNueve(ActionEvent event) {
        actualizarPantalla("9");
    }

    @FXML
    private void clicSeis(ActionEvent event) {
        actualizarPantalla("6");
    }

    @FXML
    private void clicMenos(ActionEvent event) {
        calcular("-");
    }

    @FXML
    private void clicUno(ActionEvent event) {
        actualizarPantalla("1");
    }

    @FXML
    private void clicMasMenos(ActionEvent event) {
        resultado = (-1) * Float.parseFloat(lblPantalla.getText());
        lblPantalla.setText(String.valueOf(resultado));
    }

    @FXML
    private void clicDos(ActionEvent event) {
        actualizarPantalla("2");
    }

    @FXML
    private void clicTres(ActionEvent event) {
        actualizarPantalla("3");
    }

    @FXML
    private void clicMas(ActionEvent event) {
        calcular("+");
    }

    @FXML
    private void clicPunto(ActionEvent event) {
        if (ingresoNuevo) {
            lblPantalla.setText("");
        }

        String cadena = lblPantalla.getText();

        if (cadena.length() <= 0) {
            lblPantalla.setText("0.");
            ingresoNuevo = false;
        }

        if (lblPantalla.getText().contains(".")) {
        } else {
            lblPantalla.setText(lblPantalla.getText() + ".");
            punto = false;
        }
    }

    public void actualizarPantalla(String digito) {

        if (ingresoNuevo) {
            lblPantalla.setText("");
        }
        lblPantalla.setText(lblPantalla.getText().concat(digito));
        ingresoNuevo = false;
    }

    @FXML
    private void clicIgual(ActionEvent event) {
        calcular(String.valueOf(this.operadorAnterior));

        lblPantalla.setText(String.valueOf(this.resultado));

    }

    @FXML
    private void clcS(ActionEvent event) {
        actualizarPantalla("0");
    }

    //operaciones
    public void calcular(String operador) {

        if (!(lblPantalla.getText().equals(""))) {
            
            String strPantalla = lblPantalla.getText();

            if (ingresoNuevo == false) {
                
                this.numero = Float.parseFloat(strPantalla);
                
                contadorOperadores++;
                
                if (contadorOperadores == 1) {
                    this.resultado = numero;
                } else if (contadorOperadores >= 2) {
                    Operacion calc = null;
                    switch (this.operadorAnterior) {
                        case "+":
                            calc = new Suma();
                            this.resultado = calc.operar(this.resultado, this.numero);
                            break;
                        case "-":
                            calc = new Resta();
                            this.resultado = calc.operar(this.resultado, this.numero);
                            break;
                        case "*":
                            calc = new Multiplicacion();
                            this.resultado = calc.operar(this.resultado, this.numero);
                            break;
                        case "/":
                            calc = new Division();
                            this.resultado = calc.operar(this.resultado, this.numero);
                            break;

                    }
                    
                    lblPantalla.setText(String.valueOf(this.resultado));
                }// fin del else if

            }// finaliza if ingreso nuevo

            this.operadorAnterior = operador;
        }//fin if verificador de espacio vacio
        ingresoNuevo = true;
    }

}
