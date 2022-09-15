package model;

public class DetalleFactura {

	/**
	 * atributos
	 */
    private int cantProdVendidos;
    private double subtotal;

    /**
     * constructor
     * @param cantProdVendidos
     * @param subtotal
     */
    public DetalleFactura(int cantProdVendidos, double subtotal) {
        this.cantProdVendidos = cantProdVendidos;
        this.subtotal = subtotal;
    }

    /**
     * getters y setters
     * @return
     */
    public int getCantProdVendidos() {
        return cantProdVendidos;
    }

    public void setCantProdVendidos(int cantProdVendidos) {
        this.cantProdVendidos = cantProdVendidos;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    /**
     * metodo to string
     */
	@Override
	public String toString() {
		return "DetalleFactura [cantProdVendidos=" + cantProdVendidos + ", subtotal=" + subtotal + "]";
	}
    
}
