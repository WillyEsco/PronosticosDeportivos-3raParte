package com.grupo10_150;

public class Pronostico {
    private Participante participante;
    private Partido partido;
    private Equipo equipo;
    private ResultadoEnum resultadoPronosticado;

    public Pronostico(Participante participante, Partido partido, Equipo equipo, ResultadoEnum resultadoPronosticado) {
        this.participante = participante;
        this.partido = partido;
        this.equipo = equipo;
        this.resultadoPronosticado = resultadoPronosticado;
    }
  //  public double getPuntos() {
        public void  getPuntos() {
        double puntos = 0;
        if (partido.getGana() == 0 && this.resultadoPronosticado == ResultadoEnum.EMPATE){
            puntos = 0.5;
        }
        if (partido.getGana() == this.equipo.getEquipoID() && this.resultadoPronosticado == ResultadoEnum.GANADOR){
            puntos = 0.5;
        }
        if (partido.getGana() != this.equipo.getEquipoID() && this.resultadoPronosticado == ResultadoEnum.PERDEDOR
            && partido.getGana() != 0){
            puntos = 0.5;
        }
       

        this.participante.setPuntosObtenidos(this.participante.getPuntosObtenidos() + puntos);
        // System.out.println(this.toString());
        // System.out.println("Tajeta obtuvo: " + puntos);
        // System.out.println("Total hasta ahora: " + this.participante.getPuntosObtenidos());

        }

        
    public String getParticipante() {
            return this.participante.getNombre();
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

