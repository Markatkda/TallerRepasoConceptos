package model.herencia;

import model.Producto;
import model.enums.TipoProducto;

public class ProductoEnvasado extends Producto {

    private String codigoAprobacion;
    private double tempRefrigeracion;

    public ProductoEnvasado(String codigo, String nombre, String descripcion, double valorUnitario, int cantExistencias,
                            TipoProducto tipoProducto, String codigoAprobacion, double tempRefrigeracion) {
        super(codigo, nombre, descripcion, valorUnitario, cantExistencias, tipoProducto);
        this.codigoAprobacion = codigoAprobacion;
        this.tempRefrigeracion = tempRefrigeracion;
    }

    public String getCodigoAprobacion() {
        return codigoAprobacion;
    }

    public void setCodigoAprobacion(String codigoAprobacion) {
        this.codigoAprobacion = codigoAprobacion;
    }

    public double getTempRefrigeracion() {
        return tempRefrigeracion;
    }

    public void setTempRefrigeracion(double tempRefrigeracion) {
        this.tempRefrigeracion = tempRefrigeracion;
    }
}
