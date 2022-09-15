package model;

import model.enums.TipoPersona;

public class Cliente {

	/**
	 * atributos
	 */
    private String nombre;
    private String apellido;
    private String identificacion;
    private String direccion;
    private String telefono;

    private TipoPersona tipoPersona;

    /**
     * constructor
     * @param nombre
     * @param apellido
     * @param identificacion
     * @param direccion
     * @param telefono
     * @param tipoPersona
     */
    public Cliente(String nombre, String apellido, String identificacion, String direccion, String telefono,
                   TipoPersona tipoPersona) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.identificacion = identificacion;
        this.direccion = direccion;
        this.telefono = telefono;
        this.tipoPersona = tipoPersona;
    }

    /**
     * getters y setters
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public TipoPersona getTipoPersona() {
        return tipoPersona;
    }

    public void setTipoPersona(TipoPersona tipoPersona) {
        this.tipoPersona = tipoPersona;
    }

    /**
     * metodo to string
     */
	@Override
	public String toString() {
		return "Cliente [nombre=" + nombre + ", apellido=" + apellido + ", identificacion=" + identificacion
				+ ", direccion=" + direccion + ", telefono=" + telefono + ", tipoPersona=" + tipoPersona + "]";
	}
    

}
