package com.tecsup.apaza.misincidentes;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alumno on 30/11/2017.
 */

public class IncidenteRepository {

    private static IncidenteRepository _INSTANCE = null;

    private IncidenteRepository(){}

    public static IncidenteRepository getInstance(){
        if(_INSTANCE == null)
            _INSTANCE = new IncidenteRepository();
        return _INSTANCE;
    }

    private List<Incidente> incidentes = new ArrayList<>();

    public List<Incidente> getIncidentes() {
        return this.incidentes;
    }

    public void agregarIncidente(Incidente incidente){
        this.incidentes.add(incidente);
    }
}
