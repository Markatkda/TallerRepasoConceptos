package model;

import model.enums.PaisOrigen;
import model.enums.TipoPersona;
import model.enums.TipoProducto;
import model.herencia.*;

import java.util.ArrayList;

public class Empresa {
	
	/**
	 * Atributos
	 */
    private String nombre;

    private ArrayList<Cliente> listaClientes;
    private ArrayList<Producto> listaProductos;
    private ArrayList<Factura> listaFacturas;
    
    /**
     * Constructores
     * @param nombre
     * @param listaClientes
     * @param listaProductos
     * @param listaFacturas
     */
    public Empresa(String nombre, ArrayList<Cliente> listaClientes, ArrayList<Producto> listaProductos,
                   ArrayList<Factura> listaFacturas) {
        this.nombre = nombre;
        this.listaClientes = listaClientes;
        this.listaProductos = listaProductos;
        this.listaFacturas = listaFacturas;
    }

    public Empresa() {

    	this.listaClientes = new ArrayList<Cliente>();
    	this.listaFacturas = new ArrayList<Factura>();
    	this.listaProductos = new ArrayList<Producto>();
    	
    }

    /**
     * Getters y setters
     * @return
     */
   
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(ArrayList<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public ArrayList<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(ArrayList<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public ArrayList<Factura> getListaFacturas() {
        return listaFacturas;
    }

    public void setListaFacturas(ArrayList<Factura> listaFacturas) {
        this.listaFacturas = listaFacturas;
    }

    //CRUD CLIENTE

    //create
    
    /**
     * Metodo que crea un cliente natural
     * @param nombre
     * @param apellido
     * @param identificacion
     * @param direccion
     * @param telefono
     * @param tipoPersona
     * @param email
     * @param fechaNacimiento
     */
    public void crearClienteNatural(String nombre, String apellido, String identificacion, String direccion,
                                    String telefono, TipoPersona tipoPersona, String email, String fechaNacimiento) {

    	if (tipoPersona == null) throw new NullPointerException("Tipo de persona nulo");

        if (tipoPersona == TipoPersona.NATURAL) {

            if (verificarNoVacio(nombre, apellido, identificacion, direccion, telefono, email, fechaNacimiento)) {

                Cliente clienteNatural = new ClienteNatural(nombre, apellido, identificacion, direccion, telefono,
                        tipoPersona, email, fechaNacimiento);

                this.listaClientes.add(clienteNatural);
            }

        } else {
            System.out.println("El cliente no es natural.");
        }

    }
    
    /**
     * Metodo que crea un cliente juridico
     * @param nombre
     * @param apellido
     * @param identificacion
     * @param direccion
     * @param telefono
     * @param tipoPersona
     * @param nit
     * @param idTributaria
     */
    public void crearClienteJuridico(String nombre, String apellido, String identificacion, String direccion,
                                     String telefono, TipoPersona tipoPersona, String nit, String idTributaria) {

        if (tipoPersona == null) throw new NullPointerException("Tipo de persona nulo");

        if (tipoPersona == TipoPersona.JURIDICA) {

            if (verificarNoVacio(nombre, apellido, identificacion, direccion, telefono, nit, idTributaria)) {

                Cliente clienteJuridico = new ClienteJuridico(nombre, apellido, identificacion, direccion, telefono,
                        tipoPersona, nit, idTributaria);

                this.listaClientes.add(clienteJuridico);
            }
            
        } else {
            System.out.println("EL cliente no es juridico.");
        }
    }
   
    /**
     * Metodo que filtra los clientes naturales de la lista de clientes
     * @return
     */
    public ArrayList<ClienteNatural> filtrarClienteNatural(){
    	
    	ArrayList<ClienteNatural> listaNaturales = new ArrayList<ClienteNatural>();
    	
    	for (Cliente cliente : listaClientes) {
    		
    		if (cliente instanceof ClienteNatural) {
    			listaNaturales.add((ClienteNatural) cliente);
				
			}
			
		}
    	
		return listaNaturales;
    	
    	
    }

    /**
     * Metodo que filtra los clientes juridicos de la lista de clientes
     * @return
     */
    public ArrayList<ClienteJuridico> filtrarClienteJuridico(){
    	
    	ArrayList<ClienteJuridico> listaJuridicos = new ArrayList<ClienteJuridico>();
    	
    	for (Cliente cliente : listaClientes) {
    		
    		if (cliente instanceof ClienteJuridico) {
    			listaJuridicos.add((ClienteJuridico) cliente);
				
			}
			
		}
    	
		return listaJuridicos;
    	
    	
    }
    
    

    //read

    /**
     * Metodo que busca un cliente
     * @param identificacion
     * @return
     */
    public Cliente leerCliente(String identificacion) {

        if (verificarNoVacio(identificacion)) {
            for (Cliente cliente : listaClientes
            ) {

                if (cliente.getIdentificacion().equals(identificacion)) {
                    return cliente;
                }
            }
        }

        return null;

    }

    //uptade

    /**
     * Metodo que actualiza un cliente natural
     * @param identificacion
     * @param nuevoNombre
     * @param nuevoApellido
     * @param nuevoDireccion
     * @param nuevoTelefono
     * @param nuevoEmail
     * @param nuevoFechaNacimiento
     */
    public void actualizarClienteNatural(String identificacion, String nuevoNombre, String nuevoApellido,
                                         String nuevoDireccion, String nuevoTelefono, String nuevoEmail,
                                         String nuevoFechaNacimiento) {

        if (verificarNoVacio(identificacion)) {

            for (Cliente cliente : listaClientes
            ) {

                if (cliente.getTipoPersona() == TipoPersona.NATURAL) {

                    if (verificarNoVacio(nuevoNombre)) {
                        cliente.setNombre(nuevoNombre);
                    }

                    if (verificarNoVacio(nuevoApellido)) {
                        cliente.setApellido(nuevoApellido);
                    }

                    if (verificarNoVacio(nuevoDireccion)) {
                        cliente.setDireccion(nuevoDireccion);
                    }

                    if (verificarNoVacio(nuevoTelefono)) {
                        cliente.setTelefono(nuevoTelefono);
                    }

                    if (verificarNoVacio(nuevoEmail)) {
                        ((ClienteNatural) cliente).setEmail(nuevoEmail);
                    }

                    if (verificarNoVacio(nuevoFechaNacimiento)) {
                        ((ClienteNatural) cliente).setFechaNacimiento(nuevoFechaNacimiento);
                    }
                }
            }
        }

    }

    /**
     * Metodo que actualiza un cliente juridico
     * @param identificacion
     * @param nuevoNombre
     * @param nuevoApellido
     * @param nuevoDireccion
     * @param nuevoTelefono
     * @param nuevoNit
     * @param nuevoIdTributaria
     */
    public void actualizarClienteJuridico(String identificacion, String nuevoNombre, String nuevoApellido,
                                          String nuevoDireccion, String nuevoTelefono, String nuevoNit,
                                          String nuevoIdTributaria) {

        if (verificarNoVacio(identificacion)) {

            for (Cliente cliente : listaClientes
            ) {

                if (cliente.getTipoPersona() == TipoPersona.JURIDICA) {

                    if (verificarNoVacio(nuevoNombre)) {
                        cliente.setNombre(nuevoNombre);
                    }

                    if (verificarNoVacio(nuevoApellido)) {
                        cliente.setApellido(nuevoApellido);
                    }

                    if (verificarNoVacio(nuevoDireccion)) {
                        cliente.setDireccion(nuevoDireccion);
                    }

                    if (verificarNoVacio(nuevoTelefono)) {
                        cliente.setTelefono(nuevoTelefono);
                    }

                    if (verificarNoVacio(nuevoNit)) {
                        ((ClienteJuridico) cliente).setNit(nuevoNit);
                    }

                    if (verificarNoVacio(nuevoIdTributaria)) {
                        ((ClienteJuridico) cliente).setIdTributaria(nuevoIdTributaria);
                    }
                }
            }
        }

    }

    //delete

    /**
     * Metodo que elimina un cliente por su identificacion
     * @param identificacion
     * @return
     */
    public boolean eliminarCliente(String identificacion) {

        if (verificarNoVacio(identificacion)) {

            for (Cliente cliente : listaClientes
            ) {

                if (cliente.getIdentificacion().equals(identificacion)) {
                    listaClientes.remove(cliente);
                    return true;
                }
            }
        }
        return false;
    }
    

    //CRUD PRODUCTO
    
    //crear
    
    /**
     * Metodo que crea un producto perecedero
     * @param codigo
     * @param nombre
     * @param descripcion
     * @param valorUnitario
     * @param cantExistencias
     * @param tipoProducto
     * @param fechaVencimiento
     */
    public void crearProductoPerecedero(String codigo, String nombre, String descripcion, double valorUnitario,
                                        int cantExistencias, TipoProducto tipoProducto, String fechaVencimiento) {

        if (tipoProducto == null) throw new NullPointerException("Tipo de producto nulo");

        if (tipoProducto == TipoProducto.PERECEDERO) {

            if (verificarNoVacio(codigo, nombre, descripcion, fechaVencimiento) && verificarNoNegativo(valorUnitario,
                    cantExistencias)) {

                Producto productoPerecedero = new ProductoPerecedero(codigo, nombre, descripcion, valorUnitario,
                        cantExistencias, tipoProducto, fechaVencimiento);

                this.listaProductos.add(productoPerecedero);
            }

        } else {
            System.out.println("El producto no es perecedero.");
        }

    }
    
    
    /**
     * Metodo que crea un producto envasado
     * @param codigo
     * @param nombre
     * @param descripcion
     * @param valorUnitario
     * @param cantExistencias
     * @param tipoProducto
     * @param codigoAprobacion
     * @param tempRefrigeracion
     */
    public void crearProductoEnvasado(String codigo, String nombre, String descripcion, double valorUnitario,
                                      int cantExistencias, TipoProducto tipoProducto, String codigoAprobacion,
                                      double tempRefrigeracion) {

        if (tipoProducto == null) throw new NullPointerException("Tipo de producto nulo");

        if (tipoProducto == TipoProducto.ENVASADO) {

            if (verificarNoVacio(codigo, nombre, descripcion, codigoAprobacion) && verificarNoNegativo(valorUnitario,
                    tempRefrigeracion, cantExistencias)) {

                Producto productoEnvasado = new ProductoEnvasado(codigo, nombre, descripcion, valorUnitario,
                        cantExistencias, tipoProducto, codigoAprobacion, tempRefrigeracion);

                this.listaProductos.add(productoEnvasado);
            }

        } else {
            System.out.println("El producto no es envasado.");
        }

    }

    /**
     * Metodo que crea un producto refrigerado
     * @param codigo
     * @param nombre
     * @param descripcion
     * @param valorUnitario
     * @param cantExistencias
     * @param tipoProducto
     * @param fechaEnvasado
     * @param pesoEnvase
     * @param paisOrigen
     */
    public void crearProductoRefrigerado(String codigo, String nombre, String descripcion, double valorUnitario,
                                         int cantExistencias, TipoProducto tipoProducto, String fechaEnvasado, double pesoEnvase,
                                         PaisOrigen paisOrigen) {

        if (tipoProducto == null) throw new NullPointerException("Tipo de producto nulo");

        if (tipoProducto == TipoProducto.REFRIGERADO) {

            if (verificarNoVacio(codigo, nombre, descripcion, fechaEnvasado) && verificarNoNegativo(valorUnitario,
                    pesoEnvase, cantExistencias) && paisOrigen != null) {

                Producto productoRefrigerado = new ProductoRefrigerado(codigo, nombre, descripcion, valorUnitario,
                        cantExistencias, tipoProducto, fechaEnvasado, pesoEnvase, paisOrigen);

                this.listaProductos.add(productoRefrigerado);
            }

        } else {
            System.out.println("El producto no es refrigerado.");
        }

    }

    //filtrar
    
    /**
     * Metodo que filtra los productos perecederos de la lista de productos
     * @return
     */
    public ArrayList<ProductoPerecedero> filtrarProductoPerecedero(){
    	
    	ArrayList<ProductoPerecedero> listaPerecederos = new ArrayList<ProductoPerecedero>();
    	
    	for (Producto producto : listaProductos) {
    		
    		if (producto instanceof ProductoPerecedero) {
    			listaPerecederos.add((ProductoPerecedero) producto);
				
			}
			
		}
    	
		return listaPerecederos;
    	
    }
    
    /**
     * Metodo que filtra los productos envasados de la lista de productos
     * @return
     */
    public ArrayList<ProductoEnvasado> filtrarProductoEnvasado(){
    	
    	ArrayList<ProductoEnvasado> listaEnvasados = new ArrayList<ProductoEnvasado>();
    	
    	for (Producto producto : listaProductos) {
    		
    		if (producto instanceof ProductoEnvasado) {
    			listaEnvasados.add((ProductoEnvasado) producto);
				
			}
			
		}
    	
		return listaEnvasados;
    	
    }
    
    /**
     * Metodo que filtra los productos refrigerados de la lista de productos
     * @return
     */
    public ArrayList<ProductoRefrigerado> filtrarProductoRefrigerado(){
    	
    	ArrayList<ProductoRefrigerado> listaRefrigerados = new ArrayList<ProductoRefrigerado>();
    	
    	for (Producto producto : listaProductos) {
    		
    		if (producto instanceof ProductoRefrigerado) {
    			listaRefrigerados.add((ProductoRefrigerado) producto);
				
			}
			
		}
    	
		return listaRefrigerados;
    	
    }
    
    
    //read

    /**
     * metodo que busca un producto
     * @param codigo
     * @return
     */
    public Producto leerProducto(String codigo) {

        if (verificarNoVacio(codigo)) {
            for (Producto producto : listaProductos
            ) {

                if (producto.getCodigo().equals(codigo)) {
                    return producto;
                }
            }
        }

        return null;

    }

    //uptade
    
    /**
     * Metodo que actualiza un producto perecedero
     * @param codigo
     * @param nuevoNombre
     * @param nuevoDescripcion
     * @param nuevoValorUnitario
     * @param nuevoCantExistencias
     * @param nuevoFechaVencimiento
     */
    public void actualizarProductoPerecedero(String codigo, String nuevoNombre, String nuevoDescripcion,
                                             double nuevoValorUnitario, int nuevoCantExistencias,
                                             String nuevoFechaVencimiento) {

        if (verificarNoVacio(codigo)) {

            for (Producto producto : listaProductos
            ) {

                if (producto.getTipoProducto() == TipoProducto.PERECEDERO) {

                    if (verificarNoVacio(nuevoNombre)) {
                        producto.setNombre(nuevoNombre);
                    }

                    if (verificarNoVacio(nuevoDescripcion)) {
                        producto.setDescripcion(nuevoDescripcion);
                    }

                    if (nuevoValorUnitario >= 0) {
                        producto.setValorUnitario(nuevoValorUnitario);
                    }

                    if (nuevoCantExistencias >= 0) {
                        producto.setCantExistencias(nuevoCantExistencias);
                    }

                    if (verificarNoVacio(nuevoFechaVencimiento)) {
                        ((ProductoPerecedero) producto).setFechaVencimiento(nuevoFechaVencimiento);
                    }
                }
            }
        }
    }

    /**
     * Metodo que actualiza un producto envasado
     * @param codigo
     * @param nuevoNombre
     * @param nuevoDescripcion
     * @param nuevoValorUnitario
     * @param nuevoCantExistencias
     * @param nuevoCodigoAprobacion
     * @param nuevoTempRefrigeracion
     */
    public void actualizarProductoEnvasado(String codigo, String nuevoNombre, String nuevoDescripcion,
                                           double nuevoValorUnitario, int nuevoCantExistencias,
                                           String nuevoCodigoAprobacion, double nuevoTempRefrigeracion) {
        if (verificarNoVacio(codigo)) {

            for (Producto producto : listaProductos
            ) {

                if (producto.getTipoProducto() == TipoProducto.ENVASADO) {

                    if (verificarNoVacio(nuevoNombre)) {
                        producto.setNombre(nuevoNombre);
                    }

                    if (verificarNoVacio(nuevoDescripcion)) {
                        producto.setDescripcion(nuevoDescripcion);
                    }

                    if (nuevoValorUnitario >= 0) {
                        producto.setValorUnitario(nuevoValorUnitario);
                    }

                    if (nuevoCantExistencias >= 0) {
                        producto.setCantExistencias(nuevoCantExistencias);
                    }

                    if (verificarNoVacio(nuevoCodigoAprobacion)) {
                        ((ProductoEnvasado) producto).setCodigoAprobacion(nuevoCodigoAprobacion);
                    }

                    if (nuevoTempRefrigeracion >= 0) {
                        ((ProductoEnvasado) producto).setTempRefrigeracion(nuevoTempRefrigeracion);
                    }
                }
            }
        }
    }

    /**
     * Metodo que actualiza un producto rrefrigerado
     * @param codigo
     * @param nuevoNombre
     * @param nuevoDescripcion
     * @param nuevoValorUnitario
     * @param nuevoCantExistencias
     * @param nuevoFechaEnvasado
     * @param nuevoPesoEnvase
     */
    public void actualizarProductoRefrigerado(String codigo, String nuevoNombre, String nuevoDescripcion,
                                              double nuevoValorUnitario, int nuevoCantExistencias,
                                              String nuevoFechaEnvasado, double nuevoPesoEnvase) {
        if (verificarNoVacio(codigo)) {

            for (Producto producto : listaProductos
            ) {

                if (producto.getTipoProducto() == TipoProducto.REFRIGERADO) {

                    if (verificarNoVacio(nuevoNombre)) {
                        producto.setNombre(nuevoNombre);
                    }

                    if (verificarNoVacio(nuevoDescripcion)) {
                        producto.setDescripcion(nuevoDescripcion);
                    }

                    if (nuevoValorUnitario >= 0) {
                        producto.setValorUnitario(nuevoValorUnitario);
                    }

                    if (nuevoCantExistencias >= 0) {
                        producto.setCantExistencias(nuevoCantExistencias);
                    }

                    if (verificarNoVacio(nuevoFechaEnvasado)) {
                        ((ProductoRefrigerado) producto).setFechaEnvasado(nuevoFechaEnvasado);
                    }

                    if (nuevoPesoEnvase > 0) {
                        ((ProductoRefrigerado) producto).setPesoEnvase(nuevoPesoEnvase);
                    }
                }
            }
        }
    }

    //delete

    /**
     * metodo que elimina un producto por su codigo
     * @param codigo
     * @return
     */
    public boolean eliminarProducto(String codigo) {

        if (verificarNoVacio(codigo)) {

            for (Producto producto : listaProductos
            ) {

                if (producto.getCodigo().equals(codigo)) {
                    listaProductos.remove(producto);
                    return true;
                }
            }
        }
        return false;
    }


    //------------------------------------------------------------------------------------------------------------------

    //usages
    
    //falta que cuando se actualice, se valide que el tipo de cliente no cambie
    //falta validar que dos clientes juridicos no pueden tener la misma identificacion
    
    public boolean verificarNoVacio (String one, String two, String three, String four, String five, String six,
                                   String seven){
        if (one.equals("") || one == null || two.equals("") || two == null || three.equals("") || three == null ||
                four.equals("") || four == null || five.equals("") || five == null || six.equals("") || six == null ||
                seven.equals("") || seven == null){

            return false;
        }
        return true;
    }

    @SuppressWarnings("null")
	public boolean verificarNoVacio (String one){

        if (one != null || !one.equals("")){

            return true;
        }
        return false;
    }

    public boolean verificarNoVacio (String one, String two, String three, String four){

        if (one.equals("") || one == null || two.equals("") || two == null || three.equals("") || three == null ||
                four.equals("") || four == null){

            return true;
        }
        return false;
    }

    public boolean verificarNoNegativo (double a, double b, int c){

        if (a < 1 || b < 0 || c < 0){

            return true;
        }
        return false;
    }

    public boolean verificarNoNegativo (double a, int b){

        if (a < 1 || b < 0){

            return true;
        }
        return false;
    }

}
