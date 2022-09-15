package model.herencia;

import model.Cliente;
import model.enums.TipoPersona;

public class ClienteJuridico extends Cliente {

    private String nit;
    private String idTributaria;

    public ClienteJuridico(String nombre, String apellido, String identificacion, String direccion, String telefono,
                           TipoPersona tipoPersona, String nit, String idTributaria) {
        super(nombre, apellido, identificacion, direccion, telefono, tipoPersona);
        this.nit = nit;
        this.idTributaria = idTributaria;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getIdTributaria() {
        return idTributaria;
    }

    public void setIdTributaria(String idTributaria) {
        this.idTributaria = idTributaria;
    }
}
