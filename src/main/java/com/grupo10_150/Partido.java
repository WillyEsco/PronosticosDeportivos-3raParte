package com.grupo10_150;


public class Partido {
    private int rondaNro;
    private Equipo equipo1;
    private Equipo equipo2;
    private int golesEquipo1;
    private int golesEquipo2;
    private int matchNro; 

    public Partido(int  rondaNro,Equipo equipoUno, Equipo equipoDos, int goles1, int goles2,  int matchNro) {
        this.rondaNro = rondaNro;
        this.equipo1 = equipoUno;
        this.equipo2 = equipoDos;
        this.golesEquipo1 = goles1;
        this.golesEquipo2 = goles2; 
        this.matchNro = matchNro;
    }
    public Partido(){
    }
    public int getGana() {

        if (this.golesEquipo1 > this.golesEquipo2) {
            return this.equipo1.getEquipoID();
        }
        if (this.golesEquipo1 < this.golesEquipo2) {
            return this.equipo2.getEquipoID();
        } 
           return 0;
        
    }
    
    public int getMatchNro() {
        return this.matchNro;
    }
    public int getRondaNro() {
        return this.rondaNro;
    }
    public Equipo getEquipo1() {
        return this.equipo1;
    }
    public Equipo getEquipo2() {
        return this.equipo2;
    }
    public int getGolesEquipo1() {
        return this.golesEquipo1;
    }
    public int getGolesEquipo2() {
        return this.golesEquipo2;
    }
    public void setGolesEquipo1(int goles) {
        this.golesEquipo1 = goles;
    }
    public void setGolesEquipo2(int goles) {
        this.golesEquipo2 = goles;
    }
    public void setEquipo1(Equipo equipo) {
        this.equipo1 = equipo;
    }
    public void setEquipo2(Equipo equipo) {
        this.equipo2 = equipo;
    }
    public void setMatchNro(int nro) {
        this.matchNro = nro;
    }

    public void setRondaNro(int rondaNro) {
        this.rondaNro = rondaNro;
    }

    public String toString() {
        return "Partido [rondaNro=" + rondaNro + ", equipo1=" + equipo1 + ", equipo2=" + equipo2 + ", golesEquipo1="
                + golesEquipo1 + ", golesEquipo2=" + golesEquipo2 + ", matchNro=" + matchNro + "]";
    }

    
}