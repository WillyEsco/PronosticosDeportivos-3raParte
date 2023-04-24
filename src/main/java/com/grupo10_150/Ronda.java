package com.grupo10_150;
 
import java.util.ArrayList;


/**
 *
 * @author Willy
 */
//Lombok
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Data
@Setter
@Getter
@NoArgsConstructor  

public class Ronda {
    private int rondaID;
    private int nro;
    private ArrayList<Partido> partidosRonda;
    private int cantPartidos;

    public Ronda(int rondaID, int nro, ArrayList<Partido> partidosRonda) {
        this.rondaID = rondaID;
        this.nro = nro;
        this.partidosRonda = partidosRonda;
    }

    public int getCantPartidos(){
        return this.partidosRonda.size();
    }
}
