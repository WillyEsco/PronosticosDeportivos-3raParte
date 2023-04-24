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

public class ControlBind {
    @CsvBindByPosition(position = 0) 
    private int puntosGanar;    
    @CsvBindByPosition(position = 1) 
    private int puntosEmpate; 
    @CsvBindByPosition(position = 2) 
    private int puntosPerder; 
    @CsvBindByPosition(position = 3)
    private int extrasRonda;
    @CsvBindByPosition(position = 4)
    private int extrasFase;
    @CsvBindByPosition(position = 5)
    private int faseCantRondas;
}