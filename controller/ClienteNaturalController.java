package controller;

import java.net.URL;
import java.util.ResourceBundle;

import application.Aplicacion;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Cliente;
import model.enums.TipoPersona;
import model.herencia.ClienteNatural;

public class ClienteNaturalController {
	
	Singleton singleton = Singleton.getInstance();
    Aplicacion aplicacion;

    ObservableList<ClienteNatural> clientesNaturales = FXCollections.observableArrayList();
    ObservableList<TipoPersona> tiposPersonas = FXCollections.observableArrayList();

    public void setAplicacion(Aplicacion aplicacion) {
        this.aplicacion = aplicacion;
        singleton.setAplicacion(aplicacion);

    }

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtIdentificacionNatural;

    @FXML
    private TableColumn<ClienteNatural, String> colNombreNatural;

    @FXML
    private TableColumn<ClienteNatural, String> colApellidoNatural;

    @FXML
    private TextField txtBuscarNatural;

    @FXML
    private ChoiceBox<TipoPersona> choiceBoxTipoCliente;

    @FXML
    private Button btnEliminarNatural;

    @FXML
    private Button btnSalirPestaña;

    @FXML
    private TextField txtNombreNatural;

    @FXML
    private TextField txtApellidoNatural;

    @FXML
    private Button btnCrearNatural;

    @FXML
    private TableColumn<ClienteNatural, String> colTelefonoNatural;

    @FXML
    private TableColumn<ClienteNatural, String> colDireccionNatural;

    @FXML
    private TextField txtEmailNatural;

    @FXML
    private TextField txtDireccionNatural;

    @FXML
    private TextField txtTelefonoNatural;

    @FXML
    private Button btnActualizarNatural;

    @FXML
    private TextField txtFechaNacimNatural;

    @FXML
    private TableColumn<ClienteNatural, String> colFechaNacNatural;

    @FXML
    private TableColumn<ClienteNatural, String> colIdNatural;

    @FXML
    private TableView<ClienteNatural> tblClienteNatural;

    @FXML
    private TableColumn<ClienteNatural, String> colEmailNatural;

    @FXML
    private Button btnBuscarNatural;

    @FXML
    private Button btnLimpiarCampos;

    @FXML
    void crearNatural(ActionEvent event) {
    	
    	String nombre = txtNombreNatural.getText();
    	String apellido = txtApellidoNatural.getText();
    	String identificacion = txtIdentificacionNatural.getText();
    	String direccion = txtDireccionNatural.getText();
    	String telefono = txtTelefonoNatural.getText();
    	TipoPersona tipoPersona = choiceBoxTipoCliente.getSelectionModel().getSelectedItem();
    	String email = txtEmailNatural.getText();
    	String fechaNacimiento = txtFechaNacimNatural.getText();
    	
    	singleton.empresa.crearClienteNatural(nombre, apellido, identificacion, direccion, telefono, tipoPersona, email, fechaNacimiento);
    	
    	clientesNaturales.setAll(singleton.empresa.filtrarClienteNatural());
    	tblClienteNatural.refresh();


    }

    @FXML
    void actualizarNatural(ActionEvent event) {

    	String nombre = txtNombreNatural.getText();
    	String apellido = txtApellidoNatural.getText();
    	String identificacion = txtIdentificacionNatural.getText();
    	String direccion = txtDireccionNatural.getText();
    	String telefono = txtTelefonoNatural.getText();
    	String email = txtEmailNatural.getText();
    	String fechaNacimiento = txtFechaNacimNatural.getText();
    	
    	singleton.empresa.actualizarClienteNatural(identificacion, nombre, apellido, direccion, telefono, email, fechaNacimiento);
    	
    	clientesNaturales.setAll(singleton.empresa.filtrarClienteNatural());
    	
    }

    @FXML
    void eliminarNatural(ActionEvent event) {

    	String identificacion = txtIdentificacionNatural.getText();
    	
    	singleton.empresa.eliminarCliente(identificacion);
    	clientesNaturales.setAll(singleton.empresa.filtrarClienteNatural());
    	tblClienteNatural.refresh();
    }

    @FXML
    void limpiarCampos(ActionEvent event) {
    	
    	txtNombreNatural.setText("");
    	txtApellidoNatural.setText("");
    	txtIdentificacionNatural.setText("");
    	txtDireccionNatural.setText("");
    	txtTelefonoNatural.setText("");
    	txtEmailNatural.setText("");
    	txtFechaNacimNatural.setText("");
    	
    }

    @FXML
    void buscarNatural(ActionEvent event) {
    	
    	String identificacion = txtIdentificacionNatural.getText();
    	
    	Cliente cliente = singleton.empresa.leerCliente(identificacion);
    	
    	if (cliente instanceof ClienteNatural) {
			
    		clientesNaturales.setAll((ClienteNatural) cliente);
    		
		}
    }

    @FXML
    void salirPestaña(ActionEvent event) {
    	
    	singleton.mostrarVentanaPrincipal("/view/Login.fxml");

    }

    @FXML
    void initialize() {
       
    	tiposPersonas.setAll(TipoPersona.values());
    	
    	choiceBoxTipoCliente.setItems(tiposPersonas);

    	tblClienteNatural.setItems(clientesNaturales);
    	
    	colNombreNatural.setCellValueFactory(new PropertyValueFactory<>("nombre"));
    	colApellidoNatural.setCellValueFactory(new PropertyValueFactory<>("apellido"));
    	colIdNatural.setCellValueFactory(new PropertyValueFactory<>("identificacion"));
    	colDireccionNatural.setCellValueFactory(new PropertyValueFactory<>("direccion"));
    	colTelefonoNatural.setCellValueFactory(new PropertyValueFactory<>("telefono"));
    	colEmailNatural.setCellValueFactory(new PropertyValueFactory<ClienteNatural, String>("email"));
    	colFechaNacNatural.setCellValueFactory(new PropertyValueFactory<ClienteNatural, String>("fechaNacimiento"));
    	
    }
}
