package controller;

import java.net.URL;
import java.util.ResourceBundle;

import application.Aplicacion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class LoginController {
	
	Singleton singleton = Singleton.getInstance();
    Aplicacion aplicacion;


    public void setAplicacion(Aplicacion aplicacion) {
        this.aplicacion = aplicacion;
        singleton.setAplicacion(aplicacion);

    }
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnAbrirCrudEnvasado;

    @FXML
    private Button btnAbrirCrudJuridico;

    @FXML
    private Button btnAbrirCrudNatural;

    @FXML
    private Button btnAbrirCrudPerecedero;

    @FXML
    private Button btnAbrirCrudRefrigerado;

    @FXML
    void abrirCrudNatural(ActionEvent event) {

    	singleton.mostrarPanelNatural("/view/ClienteNatural.fxml");
    	
    }

    @FXML
    void abrirCrudJuridico(ActionEvent event) {

    	singleton.mostrarPanelJuridico("/view/ClienteJuridico.fxml");
    	
    }

    @FXML
    void abrirCrudPerecedero(ActionEvent event) {
    	
    	singleton.mostrarPanelPerecedero("/view/ProductoPerecedero.fxml");

    }

    @FXML
    void abrirCrudRefrigerado(ActionEvent event) {
    	
    	singleton.mostrarPanelRefrigerado("/view/ProductoRefrigerado.fxml");

    }

    @FXML
    void abrirCrudEnvasado(ActionEvent event) {
    	
    	singleton.mostrarPanelEnvasado("/view/ProductoEnvasado.fxml");

    }

    @FXML
    void initialize() {
        assert btnAbrirCrudEnvasado != null : "fx:id=\"btnAbrirCrudEnvasado\" was not injected: check your FXML file 'Login.fxml'.";
        assert btnAbrirCrudJuridico != null : "fx:id=\"btnAbrirCrudJuridico\" was not injected: check your FXML file 'Login.fxml'.";
        assert btnAbrirCrudNatural != null : "fx:id=\"btnAbrirCrudNatural\" was not injected: check your FXML file 'Login.fxml'.";
        assert btnAbrirCrudPerecedero != null : "fx:id=\"btnAbrirCrudPerecedero\" was not injected: check your FXML file 'Login.fxml'.";
        assert btnAbrirCrudRefrigerado != null : "fx:id=\"btnAbrirCrudRefrigerado\" was not injected: check your FXML file 'Login.fxml'.";

    }

}
