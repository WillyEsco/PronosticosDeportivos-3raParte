package com.grupo10_150;

import java.util.ArrayList;
import java.util.*;	


public class Pronostico {
    private Participante participante;
    private Partido partido;
    private Equipo equipo;
    private ResultadoEnum resultadoPronosticado;
    private Map<String, Integer> parametros = new HashMap<String, Integer>();

    public Pronostico(Participante participante, Partido partido, Equipo equipo, ResultadoEnum resultadoPronosticado, Map<String, Integer> parametros) {
        this.participante = participante;
        this.partido = partido;
        this.equipo = equipo;
        this.resultadoPronosticado = resultadoPronosticado;
        this.parametros = parametros;
    }
  //  public double getPuntos() {
        public void  getPuntos() {
        double puntos = 0;
        // if (partido.getGana() == this.equipo.getEquipoID()) { 
        //     if (this.resultadoPronosticado == ResultadoEnum.GANADOR) {
        //         puntos = puntos + (parametros.get("PUNTOS_GANAR") * 0.5);
        //     }             
        // }

        if (partido.getGana() == 0 && this.resultadoPronosticado == ResultadoEnum.EMPATE){
            puntos = puntos + (parametros.get("PUNTOS_EMPATE") * 0.5);
        }
        if (partido.getGana() == this.equipo.getEquipoID() && this.resultadoPronosticado == ResultadoEnum.GANADOR){
            puntos = puntos + (parametros.get("PUNTOS_GANAR") * 0.5);
        }
        if (partido.getGana() != this.equipo.getEquipoID() && this.resultadoPronosticado == ResultadoEnum.PERDEDOR
            && partido.getGana() != 0){
                puntos = puntos + (parametros.get("PUNTOS_PERDER") * 0.5);
        }
        
        ArrayList<Double> arrayPuntos = this.participante.getPuntajeList();


        if (arrayPuntos.size() == 0 ) {
            //genero el elemento 0 en el arrayque tendrá la suma de los puntos totales de las rondas
            arrayPuntos.add(0, 0.0);
        }
        if (arrayPuntos.size() == this.partido.getRondaNro() ) {
            // preparo el contador para sumar la ronda uno en el elemento uno del array
            arrayPuntos.add(partido.getRondaNro(), 0.0);
        }


        arrayPuntos.set(partido.getRondaNro(), arrayPuntos.get(this.partido.getRondaNro()) + puntos);
        arrayPuntos.set(0, arrayPuntos.get(0) + puntos);


   
        this.getParticipante().setPuntajeList(arrayPuntos);
 
        }

        
    public Participante getParticipante() {
        return this.participante;
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }
    public Participante getParticipanteObj() {
        return this.participante;
    }
    
    public int getParticipanteID() {
        return this.participante.getParticipanteID();
    }

    public Partido getPartido() {
        return this.partido;
    }
    public Equipo getEquipo() {
        return this.equipo;
    }
    public ResultadoEnum getResultadoPronosticado() {
        return this.resultadoPronosticado;
    } 
    public void setResultadoPronosticado(ResultadoEnum resultadoPronosticado) {
        this.resultadoPronosticado = resultadoPronosticado;
    }
    public String  toString() {
        return "Participante: " + this.participante.getNombre() + " Partido: " + this.partido.getMatchNro() + " Equipo: " + this.equipo.getNombre() + " Resultado: " + this.resultadoPronosticado;

    }
    
}

