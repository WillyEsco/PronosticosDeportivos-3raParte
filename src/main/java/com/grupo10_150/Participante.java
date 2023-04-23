package com.grupo10_150;
import lombok.AllArgsConstructor;
//Lombok
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.ArrayList;
@Data
@Setter
@Getter
@NoArgsConstructor  
@AllArgsConstructor
public class Participante {
    private int participanteID;
    private String nombre;
    // array depuntos obtenidos
    private ArrayList<Double> puntajeList;
   
    public ArrayList<Double>  calcularPuntaje(ArrayList<Pronostico> pronosticoList){
        // for each
            for (Pronostico tarjeta : pronosticoList) {
                if ( participanteID == tarjeta.getParticipante().getParticipanteID()) {
                    tarjeta.getPuntos();
            }
        }   
            return this.puntajeList;
    }
 @Override
    public String toString() { 
   // cast double a int   

    for ( int ronda = 0 ; ronda < this.puntajeList.size(); ronda++) {
        if ( ronda == 0.0) {
            System.out.println("==========================================================");
            System.out.println("NOMBRE " + nombre + " (ID: "  + participanteID +")\n") ;
            System.out.println("PUNTOS OBTENIDOS: ");
            System.out.println("Puntaje Total:     " + String.valueOf(Math.round(this.puntajeList.get(0)))  + " puntos " );
            System.out.println("==========================================================");
        } else {
            System.out.println("Ronda " + ronda + " - Puntos:  " + String.valueOf(Math.round(this.puntajeList.get(ronda))) +" puntos");
        }
       
    }
    return "";
 }

}
