package model.enums;

public enum TipoPersona {

    NATURAL(0), JURIDICA(1);

    private int identificador;

    TipoPersona(int identificador) {
        this.identificador = identificador;
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }
}
