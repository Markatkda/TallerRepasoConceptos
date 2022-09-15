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
import model.enums.TipoProducto;
import model.herencia.ProductoPerecedero;

public class ProductoPerecederoController {
	
	Singleton singleton = Singleton.getInstance();
    Aplicacion aplicacion;
    
    ObservableList<ProductoPerecedero> productosPerecederos = FXCollections.observableArrayList();
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
    private TableColumn<ProductoPerecedero, String> colDescripcionPerecedero;

    @FXML
    private TableView<ProductoPerecedero> tblProductoPerecedero;

    @FXML
    private Button btnSalirPestaña;

    @FXML
    private TextField txtFechaVencPerecedero;

    @FXML
    private TableColumn<ProductoPerecedero, String> colFechaVencPerecedero;

    @FXML
    private TextField txtNombrePerecedero;

    @FXML
    private TableColumn<ProductoPerecedero, Double> colValorUnitPerecedero;

    @FXML
    private TextField txtValorUnitPerecedero;

    @FXML
    private TextField txtCantidadExistPerecedero;

    @FXML
    private TextField txtCodigoPerecedero;

    @FXML
    private TextField txtBuscarPerecedero;

    @FXML
    private ChoiceBox<TipoProducto> choiceBoxTipoProducto;

    @FXML
    private Button btnCrearPerecedero;

    @FXML
    private Button btnEliminarPerecedero;

    @FXML
    private TextField txtDescripcionPerecedero;

    @FXML
    private TableColumn<ProductoPerecedero, String> colNombrePerecedero;

    @FXML
    private Button btnBuscarPerecedero;

    @FXML
    private Button btnActualizarPerecedero;

    @FXML
    private Button btnLimpiarCampos;

    @FXML
    private TableColumn<ProductoPerecedero, String> colCodigoPerecedero;

    @FXML
    private TableColumn<ProductoPerecedero, Integer> colExistenciasPerecedero;
    
    @FXML
    void crearPerecedero(ActionEvent event) {
    	
    	String codigo = txtCodigoPerecedero.getText();
    	String nombre = txtNombrePerecedero.getText();
    	String descripcion = txtDescripcionPerecedero.getText();
    	double valorUnitario = Double.parseDouble(txtValorUnitPerecedero.getText());
    	int cantExistencias = Integer.parseInt(txtCantidadExistPerecedero.getText());
    	TipoProducto tipoProducto = choiceBoxTipoProducto.getSelectionModel().getSelectedItem();
    	String fechaVencimiento = txtFechaVencPerecedero.getText();
    	
    	singleton.empresa.crearProductoPerecedero(codigo, nombre, descripcion, valorUnitario, cantExistencias, tipoProducto, fechaVencimiento);
    
    	productosPerecederos.setAll(singleton.empresa.filtrarProductoPerecedero());

    }

    @FXML
    void actualizarPerecedero(ActionEvent event) {
    	
    	String codigo = txtCodigoPerecedero.getText();
    	String nombre = txtNombrePerecedero.getText();
    	String descripcion = txtDescripcionPerecedero.getText();
    	double valorUnitario = Double.parseDouble(txtValorUnitPerecedero.getText());
    	int cantExistencias = Integer.parseInt(txtCantidadExistPerecedero.getText());
    	String fechaVencimiento = txtFechaVencPerecedero.getText();

    	singleton.empresa.actualizarProductoPerecedero(codigo, nombre, descripcion, valorUnitario, cantExistencias, fechaVencimiento);
    	
    	productosPerecederos.setAll(singleton.empresa.filtrarProductoPerecedero());
    	
    }

    @FXML
    void eliminarPerecedero(ActionEvent event) {
    	
    	String codigo = txtCodigoPerecedero.getText();
    	
    	singleton.empresa.eliminarProducto(codigo);
    	
    	productosPerecederos.setAll(singleton.empresa.filtrarProductoPerecedero());
    	
    	tblProductoPerecedero.refresh();
    	


    }

    @FXML
    void limpiarCampos(ActionEvent event) {
    	
    	txtCodigoPerecedero.setText("");
    	txtNombrePerecedero.setText("");
    	txtDescripcionPerecedero.setText("");
    	txtValorUnitPerecedero.setText("");
    	txtCantidadExistPerecedero.setText("");
    	txtFechaVencPerecedero.setText("");

    }

    @FXML
    void buscarPerecedero(ActionEvent event) {
    	
    	String codigo = txtCodigoPerecedero.getText();
    	
    	Producto producto = singleton.empresa.leerProducto(codigo);
    	
    	if (producto instanceof ProductoPerecedero) {
			
    		productosPerecederos.setAll((ProductoPerecedero) producto);
    		
		}
    }

    @FXML
    void salirPestaña(ActionEvent event) {
    	
    	/*
    	 * Stage thisStage = (Stage)((Node) event.getSource()).getScene().getWindow();
    	thisStage.close();
    	 */
    	
    	singleton.mostrarVentanaPrincipal("/view/Login.fxml");
    	
    }
    
    @FXML
    void initialize() {
    	
    	tiposProductos.setAll(TipoProducto.values());
    	
    	choiceBoxTipoProducto.setItems(tiposProductos);

    	tblProductoPerecedero.setItems(productosPerecederos);
    	
    	colCodigoPerecedero.setCellValueFactory(new PropertyValueFactory<>("codigo"));
    	colNombrePerecedero.setCellValueFactory(new PropertyValueFactory<>("nombre"));
    	colDescripcionPerecedero.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
    	colValorUnitPerecedero.setCellValueFactory(new PropertyValueFactory<>("valorUnitario"));
    	colExistenciasPerecedero.setCellValueFactory(new PropertyValueFactory<>("existencias"));
    	colFechaVencPerecedero.setCellValueFactory(new PropertyValueFactory<>("fechaVencimiento"));
       
    }

}
