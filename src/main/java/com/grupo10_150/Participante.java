package com.grupo10_150;
import lombok.AllArgsConstructor;
//Lombok
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Data
@Setter
@Getter
@NoArgsConstructor  
@AllArgsConstructor
public class Participante {
    int participanteID;
    String nombre;
    double puntosObtenidos;
    
@Override
public  String toString() {
    return  "id participante: " + participanteID +" Nombre " + nombre  + ", Puntos Obtenidos = " + Double.valueOf(puntosObtenidos).intValue();
}

}
