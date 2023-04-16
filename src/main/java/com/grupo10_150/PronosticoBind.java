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

public class PronosticoBind {
    @CsvBindByPosition(position = 0)
    private int participanteID;   
    @CsvBindByPosition(position = 1)
    private String nombre;   
    @CsvBindByPosition(position = 2)
    private int equipo1ID;
    @CsvBindByPosition(position = 3)
    private String gana1; 
    @CsvBindByPosition(position = 4)
    private String empata;
    @CsvBindByPosition(position = 5)
    private String gana2;
    @CsvBindByPosition(position = 6)
    private int equipo2ID;   
}

