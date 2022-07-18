/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.carlosalvarez.system;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;


/**
 *
 * @author Carlos Adolfo Alvarez Crúz
 * @date 15 abr 2021
 * @time 15:37:27
 * Código técnico: IN5BV
 */
public class Principal extends Application{

    public static void main(String[] args) {
        System.out.println("**Indicacion para el porcentaje**");
        System.out.println("Primero escribimos el numero el cual le queremos saber el porcentaje * el porcentaje");
        System.out.println("Ejemplo: 85*10% = 8.5 ");
        launch(args);
    }
    
    @Override
    
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../view/FXMLCalculadoraView.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}

