package model.herencia;

import model.Producto;
import model.enums.PaisOrigen;
import model.enums.TipoProducto;

public class ProductoRefrigerado extends Producto {

    private String fechaEnvasado;
    private double pesoEnvase;

    private PaisOrigen paisOrigen;

    public ProductoRefrigerado(String codigo, String nombre, String descripcion, double valorUnitario,
                               int cantExistencias, TipoProducto tipoProducto, String fechaEnvasado, double pesoEnvase,
                               PaisOrigen paisOrigen) {
        super(codigo, nombre, descripcion, valorUnitario, cantExistencias, tipoProducto);
        this.fechaEnvasado = fechaEnvasado;
        this.pesoEnvase = pesoEnvase;
        this.paisOrigen = paisOrigen;
    }

    public String getFechaEnvasado() {
        return fechaEnvasado;
    }

    public void setFechaEnvasado(String fechaEnvasado) {
        this.fechaEnvasado = fechaEnvasado;
    }

    public double getPesoEnvase() {
        return pesoEnvase;
    }

    public void setPesoEnvase(double pesoEnvase) {
        this.pesoEnvase = pesoEnvase;
    }

    public PaisOrigen getPaisOrigen() {
        return paisOrigen;
    }

    public void setPaisOrigen(PaisOrigen paisOrigen) {
        this.paisOrigen = paisOrigen;
    }
}
