package com.tecsup.apaza.misincidentes;

import java.util.Date;

/**
 * Created by Julio Cesar on 29/11/2017.
 */

public class Incidente {

    private Integer id;
    private String nivel;
    private Date fecha;
    private String mensaje;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }


    @Override
    public String toString() {
        return "Incidente{" +
                "id=" + id +
                ", nivel='" + nivel + '\'' +
                ", fecha=" + fecha +
                ", mensaje='" + mensaje + '\'' +
                '}';
    }


}
