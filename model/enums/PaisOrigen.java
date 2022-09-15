package model.enums;

public enum PaisOrigen {

    COLOMBIA(0), ARGENTINA(1), CHILE(2), ECUADOR(3), PERU(4);

    private int identificador;

    PaisOrigen(int identificador) {
        this.identificador = identificador;
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }
}
