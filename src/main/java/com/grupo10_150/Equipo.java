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
public class Equipo {
    private int equipoID;
    private String nombre;
    private String descripcion;

    public Equipo(int equipoID, String nombre, String descripcion) {
        this.equipoID = equipoID;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
  
}
