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
import model.herencia.ClienteJuridico;

public class ClienteJuridicoController {
	
	Singleton singleton = Singleton.getInstance();
    Aplicacion aplicacion;

    ObservableList<ClienteJuridico> clientesJuridicos = FXCollections.observableArrayList();
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
    private TextField txtIdTribJuridico;

    @FXML
    private Button btnEliminarJuridico;

    @FXML
    private TextField txtDireccionJuridico;

    @FXML
    private ChoiceBox<TipoPersona> choiceBoxTipoCliente;

    @FXML
    private TextField txtIdentificacionJuridico;

    @FXML
    private Button btnActualizarJuridico;

    @FXML
    private Button btnSalirPestaña;

    @FXML
    private TableColumn<ClienteJuridico, String> colDireccionJuridico;

    @FXML
    private TableColumn<ClienteJuridico, String> colIdJuridico;

    @FXML
    private TextField txtApellidoJuridico;

    @FXML
    private TableColumn<ClienteJuridico, String> colNitJuridico;

    @FXML
    private TableColumn<ClienteJuridico, String> colNombreJuridico;

    @FXML
    private TextField txtTelefonoJuridico;

    @FXML
    private Button btnBuscarJuridico;

    @FXML
    private Button btnCrearJuridico;

    @FXML
    private TextField txtNitJuridico;

    @FXML
    private TableColumn<ClienteJuridico, String> colIdTribJuridico;

    @FXML
    private TextField txtNombreJuridico;

    @FXML
    private TableView<ClienteJuridico> tblClienteJuridico;

    @FXML
    private TextField txtBuscarJuridico;

    @FXML
    private TableColumn<ClienteJuridico, String> colApellidoJuridico;

    @FXML
    private TableColumn<ClienteJuridico, String> colTelefonoJuridico;

    @FXML
    private Button btnLimpiarCampos;

    @FXML
    void crearJuridico(ActionEvent event) {

    	String nombre = txtNombreJuridico.getText();
    	String apellido = txtApellidoJuridico.getText();
    	String identificacion = txtIdentificacionJuridico.getText();
    	String direccion = txtDireccionJuridico.getText();
    	String telefono = txtTelefonoJuridico.getText();
    	TipoPersona tipoPersona = choiceBoxTipoCliente.getSelectionModel().getSelectedItem();
    	String nit = txtNitJuridico.getText();
    	String idTributaria = txtIdTribJuridico.getText();
    	
    	singleton.empresa.crearClienteJuridico(nombre, apellido, identificacion, direccion, telefono, tipoPersona, nit, idTributaria);
    	
    	clientesJuridicos.setAll(singleton.empresa.filtrarClienteJuridico());
    	
    }

    @FXML
    void actualizarJuridico(ActionEvent event) {
    	
    	String nombre = txtNombreJuridico.getText();
    	String apellido = txtApellidoJuridico.getText();
    	String identificacion = txtIdentificacionJuridico.getText();
    	String direccion = txtDireccionJuridico.getText();
    	String telefono = txtTelefonoJuridico.getText();
    	String nit = txtNitJuridico.getText();
    	String idTributaria = txtIdTribJuridico.getText();
    	
    	singleton.empresa.actualizarClienteJuridico(identificacion, nombre, apellido, direccion, telefono, nit, idTributaria);

    	clientesJuridicos.setAll(singleton.empresa.filtrarClienteJuridico());
    	
    }

    @FXML
    void eliminarJuridico(ActionEvent event) {
  	
    	String identificacion = txtIdentificacionJuridico.getText();
    	
    	singleton.empresa.eliminarCliente(identificacion);
    	
    	clientesJuridicos.setAll(singleton.empresa.filtrarClienteJuridico());
    	
    	tblClienteJuridico.refresh();

    }

    @FXML
    void limpiarCampos(ActionEvent event) {

    	txtNombreJuridico.setText("");
    	txtApellidoJuridico.setText("");
    	txtIdentificacionJuridico.setText("");
    	txtDireccionJuridico.setText("");
    	txtTelefonoJuridico.setText("");
    	txtNitJuridico.setText("");
    	txtIdTribJuridico.setText("");
    	
    }

    @FXML
    void buscarJuridico(ActionEvent event) {

    	String identificacion = txtIdentificacionJuridico.getText();
    	
    	Cliente cliente = singleton.empresa.leerCliente(identificacion);
    	
    	if (cliente instanceof ClienteJuridico) {
			
    		clientesJuridicos.setAll((ClienteJuridico) cliente);
    		
		}
    	
    }
    
    @FXML
    void salirPestaña(ActionEvent event) {
    	
    	/* cierra el stage
    	 * Stage thisStage = (Stage)((Node) event.getSource()).getScene().getWindow();
    	thisStage.close();
    	 */
    	
    	singleton.mostrarVentanaPrincipal("/view/Login.fxml");
    	
    }

    @FXML
    void initialize() {
    	
    	tiposPersonas.setAll(TipoPersona.values());
    	
    	choiceBoxTipoCliente.setItems(tiposPersonas);

    	tblClienteJuridico.setItems(clientesJuridicos);
    	
    	colNombreJuridico.setCellValueFactory(new PropertyValueFactory<>("nombre"));
    	colApellidoJuridico.setCellValueFactory(new PropertyValueFactory<>("apellido"));
    	colIdJuridico.setCellValueFactory(new PropertyValueFactory<>("identificacion"));
    	colDireccionJuridico.setCellValueFactory(new PropertyValueFactory<>("direccion"));
    	colTelefonoJuridico.setCellValueFactory(new PropertyValueFactory<>("telefono"));
    	colNitJuridico.setCellValueFactory(new PropertyValueFactory<ClienteJuridico, String>("nit"));
    	colIdTribJuridico.setCellValueFactory(new PropertyValueFactory<ClienteJuridico, String>("idTributaria"));
    	
    }
}
    

