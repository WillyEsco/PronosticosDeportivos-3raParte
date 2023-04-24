package com.grupo10_150;
import com.opencsv.bean.CsvBindByPosition;
 
//Lombok
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Data
@Setter
@Getter
@NoArgsConstructor  

public class PartidoBind {
    @CsvBindByPosition(position = 0) 
    private int rondaID;    
    @CsvBindByPosition(position = 1) 
    private int nroRonda; 
    @CsvBindByPosition(position = 2) 
    private int equipo1ID; 
    @CsvBindByPosition(position = 3)
    private String equipo1_nombre;
    @CsvBindByPosition(position = 4)
    private String equipo1_descripcion;
    @CsvBindByPosition(position = 5)
    private int equipo1_goles;
    @CsvBindByPosition(position = 6)
    private int equipo2_goles;
    @CsvBindByPosition(position = 7)
    private int equipo2ID;   
    @CsvBindByPosition(position = 8)
    private String equipo2_nombre;
    @CsvBindByPosition(position = 9)
    private String equipo2_descripcion;
}