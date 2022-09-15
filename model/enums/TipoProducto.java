package model.enums;

public enum TipoProducto {

    PERECEDERO(0), ENVASADO(1), REFRIGERADO(2);

    private int identificador;

    TipoProducto(int identificador) {
        this.identificador = identificador;
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }
}
