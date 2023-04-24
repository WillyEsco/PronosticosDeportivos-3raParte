package com.grupo10_150;
import com.opencsv.bean.CsvToBeanBuilder;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.*;

//Lombok
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@Getter
@Setter

public class LectorControlCsv {
    String controlFile;
    List<ControlBind> listaDeParametros;
    public int PUNTOS_GANAR ;
    public int PUNTOS_EMPATE;
    public int PUNTOS_PERDER;
    public int PUNTOS_EXTRAS_RONDA;
    public int PUNTOS_EXTRAS_FASE;
    public int FASE_CANT_RONDAS;


    public   LectorControlCsv (String controlFile) {
        this.controlFile = controlFile;
        this.listaDeParametros = new ArrayList<>();
        this.PUNTOS_GANAR = 0;
        this.PUNTOS_EMPATE = 0;
        this.PUNTOS_PERDER = 0;
        this.PUNTOS_EXTRAS_RONDA = 0;
        this.PUNTOS_EXTRAS_FASE = 0;
        this.FASE_CANT_RONDAS = 0;
    }

    public Map<String, Integer> parsearControlFile() {
        List<ControlBind> listaDeParametros = null;
        try {
            // En esta primera línea definimos el archivos que va a ingresar
            listaDeParametros = new CsvToBeanBuilder(new FileReader(this.controlFile))
                    // con esta configuración podemos skipear la primera línea de nuestro archivo CSV
                    .withSkipLines(1)
                    // con esta configuración podemos elegir cual es el caracter que vamos a usar para delimitar
                    .withSeparator(';')
                    // Es necesario definir el tipo de dato que va a generar el objeto que estamos queriendo parsear a partir del CSV
                    .withType(ControlBind.class)
                    .build()
                    .parse();

        } catch (IOException e) {
        e.printStackTrace();
        }
        // setListaDeParametros(ListaDeParametros); 
        this.listaDeParametros = listaDeParametros;
        this.PUNTOS_GANAR = listaDeParametros.get(0).getPuntosGanar();
        this.PUNTOS_EMPATE = listaDeParametros.get(0).getPuntosEmpate();
        this.PUNTOS_PERDER = listaDeParametros.get(0).getPuntosPerder();
        this.PUNTOS_EXTRAS_RONDA = listaDeParametros.get(0).getExtrasRonda();
        this.PUNTOS_EXTRAS_FASE = listaDeParametros.get(0).getExtrasFase();
        this.FASE_CANT_RONDAS = listaDeParametros.get(0).getFaseCantRondas();
        Map<String, Integer> parametros = new HashMap<String, Integer>();
        parametros.put("PUNTOS_GANAR", this.PUNTOS_GANAR);
        parametros.put("PUNTOS_EMPATE", this.PUNTOS_EMPATE);
        parametros.put("PUNTOS_PERDER", this.PUNTOS_PERDER);
        parametros.put("PUNTOS_EXTRAS_RONDA", this.PUNTOS_EXTRAS_RONDA);
        parametros.put("PUNTOS_EXTRAS_FASE", this.PUNTOS_EXTRAS_FASE);
        parametros.put("FASE_CANT_RONDAS", this.FASE_CANT_RONDAS);
        return parametros;

        }
}
