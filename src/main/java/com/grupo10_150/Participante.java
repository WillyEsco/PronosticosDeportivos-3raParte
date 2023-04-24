package com.grupo10_150;
import lombok.AllArgsConstructor;
//Lombok
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.ArrayList;
import java.util.*;
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

    public String imprimirTarjeta(Map<String, Integer> parametros) { 
   // cast double a int   
        Long  total_puntos_imprimir = Math.round(this.puntajeList.get(0));
        int extras_ronda = (puntajeList.size() - 1 ) * (parametros.get("PUNTOS_GANAR"));
    for ( int ronda = 0 ; ronda < this.puntajeList.size(); ronda++) {
        if ( ronda == 0.0) {
            System.out.println("==========================================================");
            System.out.println("NOMBRE " + nombre + " (ID: "  + participanteID +")\n") ;
      
           // String.valueOf(Math.round(this.puntajeList.get(0)))
        } else {
            System.out.println("Ronda " + ronda + " - Puntos:  " + String.valueOf(Math.round(this.puntajeList.get(ronda))) +" puntos");
        }
     }
        if ( extras_ronda == total_puntos_imprimir ) {
           System.out.println("Gana puntos extra por acertar ronda completa");
            System.out.println("==========================================================");
            total_puntos_imprimir = total_puntos_imprimir + parametros.get("PUNTOS_EXTRAS_RONDA");
        }
        System.out.println("PUNTOS OBTENIDOS: ");
        System.out.println("Puntaje Total:     " + String.valueOf(total_puntos_imprimir)  + " puntos " );
        System.out.println("==========================================================");
    
    return "";
 }

}
