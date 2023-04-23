package com.grupo10_150;

//Lombok
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Data
@Setter
@Getter
@NoArgsConstructor


public class PronosticoDB {
    private int participanteID;   
    private String nombre;   
    private int equipo1ID;
    private String gana1; 
    private String empata;
    private String gana2;
    private int equipo2ID;   

    public PronosticoDB(int participanteID, String nombre, int equipo1ID, String gana1, String empata, String gana2, int equipo2ID) {
        this.participanteID = participanteID;
        this.nombre = nombre;
        this.equipo1ID = equipo1ID;
        this.gana1 = gana1;
        this.empata = empata;
        this.gana2 = gana2;
        this.equipo2ID = equipo2ID;
    }
}

