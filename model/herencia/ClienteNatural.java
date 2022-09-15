package model.herencia;

import model.Cliente;
import model.enums.TipoPersona;

public class ClienteNatural extends Cliente {

    private String email;
    private String fechaNacimiento;

    public ClienteNatural(String nombre, String apellido, String identificacion, String direccion, String telefono,
                          TipoPersona tipoPersona, String email, String fechaNacimiento) {
        super(nombre, apellido, identificacion, direccion, telefono, tipoPersona);
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
}
