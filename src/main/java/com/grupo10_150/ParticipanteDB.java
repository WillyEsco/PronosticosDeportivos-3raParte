package com.grupo10_150;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Data
@Setter
@Getter
@NoArgsConstructor  

public class ParticipanteDB {
    int id;
    String Apellido;
    String Nombre;
    int Puntos;

    public ParticipanteDB(int id, String apellido, String nombre, int puntos) {
        this.id = id;
        Apellido = apellido;
        Nombre = nombre;
        Puntos = puntos;
    }
}
