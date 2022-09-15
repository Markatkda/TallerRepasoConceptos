package application;

import controller.ClienteJuridicoController;
import controller.ClienteNaturalController;
import controller.LoginController;
import controller.ProductoEnvasadoController;
import controller.ProductoPerecederoController;
import controller.ProductoRefrigeradoController;
import controller.Singleton;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Aplicacion extends Application {

	public Singleton singleton = Singleton.getInstance();
	
    private Stage primaryStage;
    private Stage secundaryStage = new Stage();
    
    public static void main(String[] args) {
    	
		launch(args);
	}
    

    @Override
    public void start(Stage primaryStage) throws Exception {
    	
    	singleton.setAplicacion(this);
    	
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Login");
        mostrarVentanaPrincipal("/view/Login.fxml");

    }

    public void mostrarVentanaPrincipal(String ruta) {

        try {
        	
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Aplicacion.class.getResource(ruta));

            AnchorPane rootLayout = (AnchorPane)loader.load();
            LoginController loginController = loader.getController();
            loginController.setAplicacion(this);

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
            
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void mostrarPanelNatural(String ruta) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Aplicacion.class.getResource(ruta));

			AnchorPane rootLayout = (AnchorPane)loader.load();
			ClienteNaturalController clienteNaturalController = loader.getController();
			clienteNaturalController.setAplicacion(this);
			
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    
    public void mostrarPanelJuridico(String ruta) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Aplicacion.class.getResource(ruta));

			AnchorPane rootLayout = (AnchorPane)loader.load();
			ClienteJuridicoController clienteJuridicoController = loader.getController();
			clienteJuridicoController.setAplicacion(this);
			
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    
    public void mostrarPanelPerecedero(String ruta) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Aplicacion.class.getResource(ruta));

			AnchorPane rootLayout = (AnchorPane)loader.load();
			ProductoPerecederoController productoPerecederoController = loader.getController();
			productoPerecederoController.setAplicacion(this);
			
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    
    public void mostrarPanelRefrigerado(String ruta) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Aplicacion.class.getResource(ruta));

			AnchorPane rootLayout = (AnchorPane)loader.load();
			ProductoRefrigeradoController productoRefrigeradoController = loader.getController();
			productoRefrigeradoController.setAplicacion(this);
			
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    
    public void mostrarPanelEnvasado(String ruta) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Aplicacion.class.getResource(ruta));

			AnchorPane rootLayout = (AnchorPane)loader.load();
			ProductoEnvasadoController productoEnvasadoController = loader.getController();
			productoEnvasadoController.setAplicacion(this);
			
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
		
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
   
    
}
