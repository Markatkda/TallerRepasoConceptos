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
import model.Producto;
import model.enums.TipoPersona;
import model.enums.TipoProducto;
import model.herencia.ClienteJuridico;
import model.herencia.ProductoEnvasado;

public class ProductoEnvasadoController {
	
	Singleton singleton = Singleton.getInstance();
    Aplicacion aplicacion;

    ObservableList<ProductoEnvasado> productosEnvasados = FXCollections.observableArrayList();
    ObservableList<TipoProducto> tiposProductos = FXCollections.observableArrayList();

    public void setAplicacion(Aplicacion aplicacion) {
        this.aplicacion = aplicacion;
        singleton.setAplicacion(aplicacion);

    }

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnEliminarEnvasado;

    @FXML
    private TableColumn<ProductoEnvasado, Double> colValorUnitEnvasado;

    @FXML
    private TableColumn<ProductoEnvasado, String> colDescripcionEnvasado;

    @FXML
    private TextField txtDescripcionEnvasado;

    @FXML
    private TextField txtValorUnitEnvasado;

    @FXML
    private Button btnSalirPestaña;

    @FXML
    private TableColumn<ProductoEnvasado, Integer> colExistenciasEnvasado;

    @FXML
    private TextField txtCodigoEnvasado;

    @FXML
    private TableColumn<ProductoEnvasado, String> colCodigoEnvasado;

    @FXML
    private Button btnActualizarEnvasado;

    @FXML
    private TableColumn<ProductoEnvasado, String> colCodAprobEnvasado;

    @FXML
    private TextField txtTempRefrigeracionEnvasado;

    @FXML
    private Button btnBuscarEnvasado;

    @FXML
    private ChoiceBox<TipoProducto> choiceBoxTipoProducto;

    @FXML
    private TextField txtNombreEnvasado;

    @FXML
    private TextField txtBuscarEnvasado;

    @FXML
    private TableColumn<ProductoEnvasado, String> colNombreEnvasado;

    @FXML
    private TableColumn<ProductoEnvasado, Double> colTempRefriEnvasado;

    @FXML
    private TextField txtCodigoAprobEnvasado;

    @FXML
    private Button btnCrearEnvasado;

    @FXML
    private TextField txtCantidadExistEnvasado;

    @FXML
    private TableView<ProductoEnvasado> tblProductoEnvasado;

    @FXML
    private Button btnLimpiarCampos;

    @FXML
    void crearEnvasado(ActionEvent event) {
    	
    	String codigo = txtCodigoEnvasado.getText();
    	String nombre = txtNombreEnvasado.getText();
    	String descripcion = txtDescripcionEnvasado.getText();
    	double valorUnitario = Double.parseDouble(txtValorUnitEnvasado.getText());
    	int cantExistencias = Integer.parseInt(txtCantidadExistEnvasado.getText());
    	TipoProducto tipoProducto = choiceBoxTipoProducto.getSelectionModel().getSelectedItem();
    	String codigoAprobacion = txtCodigoAprobEnvasado.getText();
    	double tempRefrigeracion = Double.parseDouble(txtTempRefrigeracionEnvasado.getText());
    	
    	singleton.empresa.crearProductoEnvasado(codigo, nombre, descripcion, valorUnitario, cantExistencias, tipoProducto, codigoAprobacion, tempRefrigeracion);
    
    	productosEnvasados.setAll(singleton.empresa.filtrarProductoEnvasado());
    	
    }

    @FXML
    void actualizarEnvasado(ActionEvent event) {
    	
    	String codigo = txtCodigoEnvasado.getText();
    	String nombre = txtNombreEnvasado.getText();
    	String descripcion = txtDescripcionEnvasado.getText();
    	double valorUnitario = Double.parseDouble(txtValorUnitEnvasado.getText());
    	int cantExistencias = Integer.parseInt(txtCantidadExistEnvasado.getText());
    	String codigoAprobacion = txtCodigoAprobEnvasado.getText();
    	double tempRefrigeracion = Double.parseDouble(txtTempRefrigeracionEnvasado.getText());
    	
    	singleton.empresa.actualizarProductoEnvasado(codigo, nombre, descripcion, valorUnitario, cantExistencias, codigoAprobacion, tempRefrigeracion);
    	
    	productosEnvasados.setAll(singleton.empresa.filtrarProductoEnvasado());
    	
    }

    @FXML
    void eliminarEnvasado(ActionEvent event) {
    	
    	String codigo = txtCodigoEnvasado.getText();
    	
    	singleton.empresa.eliminarProducto(codigo);
    	
    	productosEnvasados.setAll(singleton.empresa.filtrarProductoEnvasado());
    	
    	tblProductoEnvasado.refresh();
    
    }

    @FXML
    void limpiarCampos(ActionEvent event) {
    	
    	txtCodigoEnvasado.setText("");
    	txtNombreEnvasado.setText("");
    	txtDescripcionEnvasado.setText("");
    	txtValorUnitEnvasado.setText("");
    	txtCantidadExistEnvasado.setText("");
    	txtCodigoAprobEnvasado.setText("");
    	txtTempRefrigeracionEnvasado.setText("");

    }

    @FXML
    void buscarEnvasado(ActionEvent event) {
    	
    	String codigo = txtCodigoEnvasado.getText();
    	
    	Producto producto = singleton.empresa.leerProducto(codigo);
    	
    	if (producto instanceof ProductoEnvasado) {
			
    		productosEnvasados.setAll((ProductoEnvasado) producto);
    		
		}
    }

    @FXML
    void salirPestaña(ActionEvent event) {
    	
    	singleton.mostrarVentanaPrincipal("/view/Login.fxml");
    	
    }

    @FXML
    void initialize() {
    	
    	tiposProductos.setAll(TipoProducto.values());
    	
    	choiceBoxTipoProducto.setItems(tiposProductos);

    	tblProductoEnvasado.setItems(productosEnvasados);
    	
    	colCodigoEnvasado.setCellValueFactory(new PropertyValueFactory<>("codigo"));
    	colNombreEnvasado.setCellValueFactory(new PropertyValueFactory<>("nombre"));
    	colDescripcionEnvasado.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
    	colValorUnitEnvasado.setCellValueFactory(new PropertyValueFactory<>("valorUnitario"));
    	colExistenciasEnvasado.setCellValueFactory(new PropertyValueFactory<>("existencias"));
    	colCodAprobEnvasado.setCellValueFactory(new PropertyValueFactory<ProductoEnvasado, String>("codigoAprobacion"));
    	colTempRefriEnvasado.setCellValueFactory(new PropertyValueFactory<ProductoEnvasado, Double>("idTributaria"));
    	
     
    }

}
