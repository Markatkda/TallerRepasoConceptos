package model;

import java.util.ArrayList;

public class Factura {

	/**
	 * atributos
	 */
    private String codigo;
    private String fecha;
    private double total;
    private double iva;

    private ArrayList<DetalleFactura> listaDetalleFactura;
    private Cliente cliente;

    /**
     * constructor
     * @param codigo
     * @param fecha
     * @param total
     * @param iva
     */
    public Factura(String codigo, String fecha, double total, double iva) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.total = total;
        this.iva = iva;
    }

    /**
     * getters y setters
     * @return
     */
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public ArrayList<DetalleFactura> getListaDetalleFactura() {
        return listaDetalleFactura;
    }

    public void setListaDetalleFactura(ArrayList<DetalleFactura> listaDetalleFactura) {
        this.listaDetalleFactura = listaDetalleFactura;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * metodo to string
     */
	@Override
	public String toString() {
		return "Factura [codigo=" + codigo + ", fecha=" + fecha + ", total=" + total + ", iva=" + iva
				+ ", listaDetalleFactura=" + listaDetalleFactura + ", cliente=" + cliente + "]";
	}
    
}
