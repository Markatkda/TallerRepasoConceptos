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
import model.Producto;
import model.enums.PaisOrigen;
import model.enums.TipoProducto;
import model.herencia.ProductoRefrigerado;

public class ProductoRefrigeradoController {

	Singleton singleton = Singleton.getInstance();
    Aplicacion aplicacion;

    ObservableList<ProductoRefrigerado> productosRefrigerados = FXCollections.observableArrayList();
    ObservableList<TipoProducto> tiposProductos = FXCollections.observableArrayList();
    ObservableList<PaisOrigen> paisesOrigen = FXCollections.observableArrayList();

    public void setAplicacion(Aplicacion aplicacion) {
        this.aplicacion = aplicacion;
        singleton.setAplicacion(aplicacion);

    }

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ChoiceBox<PaisOrigen> choiceBoxPaisOrigen;

    @FXML
    private TextField txtValorUnitRefrigerado;

    @FXML
    private TextField txtNombreRefrigerado;

    @FXML
    private TextField txtCantidadExistRefrigerado;

    @FXML
    private TextField txtBuscarRefrigerado;

    @FXML
    private TextField txtFechaEnvRefrigerado;

    @FXML
    private TextField txtCodigoRefrigerado;

    @FXML
    private Button btnEliminarRefrigerado;

    @FXML
    private ChoiceBox<TipoProducto> choiceBoxTipoProducto;

    @FXML
    private TableColumn<ProductoRefrigerado, Integer> colExistenciasRefrigerado;

    @FXML
    private TableColumn<ProductoRefrigerado, Double> colValorUnitRefrigerado;

    @FXML
    private Button btnLimpiarCampos;

    @FXML
    private TextField txtPesoEnvRefrigerado;

    @FXML
    private Button btnSalirPestaña;

    @FXML
    private Button btnCrearRefrigerado;

    @FXML
    private TableColumn<ProductoRefrigerado, String> colFechaEnvaRefrigerado;

    @FXML
    private Button btnBuscarRefrigerado;

    @FXML
    private TableColumn<ProductoRefrigerado, String> colPaisOrigenRefrigerado;

    @FXML
    private TableView<ProductoRefrigerado> tblProductoRefrigerado;

    @FXML
    private TableColumn<ProductoRefrigerado, String> colCodigoRefrigerado;

    @FXML
    private TextField txtDescripcionRefrigerado;

    @FXML
    private TableColumn<ProductoRefrigerado, String> colDescripcionRefrigerado;

    @FXML
    private TableColumn<ProductoRefrigerado, String> colNombreRefrigerado;

    @FXML
    private TableColumn<ProductoRefrigerado, Double> colPesoRefrigerado;

    @FXML
    private Button btnActualizarRefrigerado;

    @FXML
    void crearRefrigerado(ActionEvent event) {
    	
    	String codigo = txtCodigoRefrigerado.getText();
    	String nombre = txtNombreRefrigerado.getText();
    	String descripcion = txtDescripcionRefrigerado.getText();
    	double valorUnitario = Double.parseDouble(txtValorUnitRefrigerado.getText());
    	int cantExistencias = Integer.parseInt(txtCantidadExistRefrigerado.getText());
    	TipoProducto tipoProducto = choiceBoxTipoProducto.getSelectionModel().getSelectedItem();
    	String fechaEnvasado = txtFechaEnvRefrigerado.getText();
    	double peso = Double.parseDouble(txtPesoEnvRefrigerado.getText());
    	PaisOrigen paisOrigen = choiceBoxPaisOrigen.getSelectionModel().getSelectedItem();
    	
    	singleton.empresa.crearProductoRefrigerado(codigo, nombre, descripcion, valorUnitario, cantExistencias, tipoProducto, fechaEnvasado, peso, paisOrigen);
    
    	productosRefrigerados.setAll(singleton.empresa.filtrarProductoRefrigerado());

    }

    @FXML
    void actualizarRefrigerado(ActionEvent event) {
    	
    	String codigo = txtCodigoRefrigerado.getText();
    	String nombre = txtNombreRefrigerado.getText();
    	String descripcion = txtDescripcionRefrigerado.getText();
    	double valorUnitario = Double.parseDouble(txtValorUnitRefrigerado.getText());
    	int cantExistencias = Integer.parseInt(txtCantidadExistRefrigerado.getText());
    	String fechaEnvasado = txtFechaEnvRefrigerado.getText();
    	double peso = Double.parseDouble(txtPesoEnvRefrigerado.getText());
    	
    	singleton.empresa.actualizarProductoRefrigerado(codigo, nombre, descripcion, valorUnitario, cantExistencias, fechaEnvasado, peso);;
    	
    	productosRefrigerados.setAll(singleton.empresa.filtrarProductoRefrigerado());

    }

    @FXML
    void eliminarRefrigerado(ActionEvent event) {
    	
    	String codigo = txtCodigoRefrigerado.getText();
    	
    	singleton.empresa.eliminarProducto(codigo);
    	
    	productosRefrigerados.setAll(singleton.empresa.filtrarProductoRefrigerado());
    	
    	tblProductoRefrigerado.refresh();
    	

    }

    @FXML
    void limpiarCampos(ActionEvent event) {
    	
    	txtCodigoRefrigerado.setText("");
    	txtNombreRefrigerado.setText("");
    	txtDescripcionRefrigerado.setText("");
    	txtValorUnitRefrigerado.setText("");
    	txtCantidadExistRefrigerado.setText("");
    	txtFechaEnvRefrigerado.setText("");
    	txtPesoEnvRefrigerado.setText("");

    }

    @FXML
    void buscarRefrigerado(ActionEvent event) {
    	
    	String codigo = txtCodigoRefrigerado.getText();
    	
    	Producto producto = singleton.empresa.leerProducto(codigo);
    	
    	if (producto instanceof ProductoRefrigerado) {
			
    		productosRefrigerados.setAll((ProductoRefrigerado) producto);
    		
		}
    }

    @FXML
    void salirPestaña(ActionEvent event) {
    	
    	singleton.mostrarVentanaPrincipal("/view/Login.fxml");

    }

    @FXML
    void initialize() {
    	
    	tiposProductos.setAll(TipoProducto.values());
    	paisesOrigen.setAll(PaisOrigen.values());
    	
    	choiceBoxTipoProducto.setItems(tiposProductos);
    	choiceBoxPaisOrigen.setItems(paisesOrigen);

    	tblProductoRefrigerado.setItems(productosRefrigerados);
    	
    	colCodigoRefrigerado.setCellValueFactory(new PropertyValueFactory<>("codigo"));
    	colNombreRefrigerado.setCellValueFactory(new PropertyValueFactory<>("nombre"));
    	colDescripcionRefrigerado.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
    	colValorUnitRefrigerado.setCellValueFactory(new PropertyValueFactory<>("valorUnitario"));
    	colExistenciasRefrigerado.setCellValueFactory(new PropertyValueFactory<>("existencias"));
    	colFechaEnvaRefrigerado.setCellValueFactory(new PropertyValueFactory<>("fechaEnvasado"));
    	colPesoRefrigerado.setCellValueFactory(new PropertyValueFactory<ProductoRefrigerado, Double>("peso"));
    	colPaisOrigenRefrigerado.setCellValueFactory(new PropertyValueFactory<ProductoRefrigerado, String>("paisOrigen"));
    	
    	
    }
}
