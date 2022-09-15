package model.herencia;

import model.Producto;
import model.enums.TipoProducto;

public class ProductoPerecedero extends Producto {

    private String fechaVencimiento;

    public ProductoPerecedero(String codigo, String nombre, String descripcion, double valorUnitario,
                              int cantExistencias, TipoProducto tipoProducto, String fechaVencimiento) {
        super(codigo, nombre, descripcion, valorUnitario, cantExistencias, tipoProducto);
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }
}
