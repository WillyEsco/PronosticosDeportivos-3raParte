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


public class LectorCsv {
    String resuFile;
    List<PartidoBind> lineasResultados;
    ArrayList<Participante> participanteList;
    ArrayList<Ronda> rondaList;

    public LectorCsv(String resuFile) {
        this.resuFile = resuFile;
        this.lineasResultados = new ArrayList<>();
        this.rondaList = new ArrayList<>();
    }
    public void parsearResultados() {

        List<PartidoBind> ListaDeResultados = null;

        try {
            // En esta primera línea definimos el archivos que va a ingresar
            ListaDeResultados = new CsvToBeanBuilder(new FileReader(this.resuFile))
                    // con esta configuración podemos skipear la primera línea de nuestro archivo CSV
                    .withSkipLines(1)
                    // con esta configuración podemos elegir cual es el caracter que vamos a usar para delimitar
                    .withSeparator(';')
                    // Es necesario definir el tipo de dato que va a generar el objeto que estamos queriendo parsear a partir del CSV
                    .withType(PartidoBind.class)
                    .build()
                    .parse();

        } catch (IOException e) {
        e.printStackTrace();
        }
        this.lineasResultados=ListaDeResultados;
        }


// Crear resultados de partidos
    public ArrayList<Partido> crearResultados() {
        ArrayList<Partido> partidosList = new ArrayList<Partido>();
        ArrayList<Partido> partidosRondaList = new ArrayList<Partido>();
        ArrayList<Ronda> rondaList = new ArrayList<Ronda>();

        Equipo equipo1Aux;
        Equipo equipo2Aux;
        Partido partidoAux;
        partidosRondaList = new ArrayList<Partido>(); 
 
        int ronda = 0;
        int i=0; // nro de match (vienen en orden)
        ronda = this.lineasResultados.get(0).getNroRonda();  

        for ( PartidoBind r : this.lineasResultados) {

            // agrego el partido al array de partidos   
            if (ronda != r.getNroRonda()){

                ronda = r.getNroRonda(); 
                rondaList.add(new Ronda(r.getRondaID(), r.getNroRonda(), partidosRondaList));
                partidosRondaList = new ArrayList<Partido>(); 
            }

                i++;
                equipo1Aux = new Equipo(r.getEquipo1ID(),r.getEquipo1_nombre(),r.getEquipo1_descripcion());
                equipo2Aux = new Equipo(r.getEquipo2ID(),r.getEquipo2_nombre(),r.getEquipo2_descripcion());
                partidoAux = new Partido(r.getNroRonda(), equipo1Aux, equipo2Aux, r.getEquipo1_goles(), r.getEquipo2_goles(), i);
                partidosList.add(partidoAux);
                partidosRondaList.add(partidoAux);        
        }
        setRondaList(rondaList); 
        return partidosList;
    }

   // Crear pronosticos
   public ArrayList<Pronostico> crearPronosticos(ArrayList<Partido> partidosList, Map<String, Integer> parametros){
        ArrayList<Pronostico> pronosticosList = new ArrayList<Pronostico>(); 
        ArrayList<Participante> participanteList = new ArrayList<Participante>();
        ArrayList<Double> puntajeList = new ArrayList<Double>();
        ArrayList<PronosticoDB> pronosticoDBlist = new ArrayList<PronosticoDB>();
        Participante participanteAux=null;
        Partido partido = new Partido();
        boolean encontre = false;

        //
        participanteList =  LeerTablaParticipantes.LeerPersonas();
        pronosticoDBlist =  LeerTablaPronostico.LeerPronostico();
        for (PronosticoDB pb : pronosticoDBlist) {

            //incluyo el objeto paticipante, el nro de ronda, el objeto partido (match), el equipo ganador y el resultado
            // creo la listade participantes            
            // busco el participante en la lista y si no está lo agrego

            encontre = false;
                for (Participante p : participanteList) {
                    if (p.getParticipanteID() == pb.getParticipanteID()) {
                        participanteAux = p;
                        encontre = true;
                    }
                }

                if (!encontre) {
                    puntajeList = new ArrayList<Double>();
                    participanteAux = new Participante(pb.getParticipanteID(), pb.getNombre(),puntajeList);
                    participanteList.add(participanteAux);
                }

                
                // busco el objeto partido en la listade partidos
                for (Partido match : partidosList) {
                    if (match.getEquipo1().getEquipoID() == pb.getEquipo1ID() && match.getEquipo2().getEquipoID() == pb.getEquipo2ID()) {
                        partido = match;
                    }
                }
       
                if (pb.getGana1().equals("X")) {
                    // busco equipo1 y equipo2 en partidosList
                    pronosticosList.add(new Pronostico(participanteAux, partido, partido.getEquipo1(), ResultadoEnum.GANADOR, parametros));
                    pronosticosList.add(new Pronostico(participanteAux, partido, partido.getEquipo2(), ResultadoEnum.PERDEDOR, parametros));

                }
        
                if (pb.getGana2().equals("X")) {
                    // busco equipo1_id en partidosList   
                        pronosticosList.add(new Pronostico(participanteAux,  partido, partido.getEquipo2(), ResultadoEnum.GANADOR, parametros));
                        pronosticosList.add(new Pronostico(participanteAux,  partido , partido.getEquipo1(), ResultadoEnum.PERDEDOR, parametros));                   
                    }
                
                if (pb.getEmpata().equals("X")) {
                    // busco equipo1_id en partidosList              
                       pronosticosList.add(new Pronostico(participanteAux, partido , partido.getEquipo1(), ResultadoEnum.EMPATE, parametros));   
                            // indice = pronosticosList.size()-1;
                            // pronosticosList.get(indice).getPuntos();      
                       pronosticosList.add(new Pronostico(participanteAux, partido , partido.getEquipo2(), ResultadoEnum.EMPATE, parametros));                            
                            // indice = pronosticosList.size()-1;
                            // pronosticosList.get(indice).getPuntos();                     
                    }

  
        
        }
        setParticipanteList(participanteList);
        return pronosticosList;
    }
   

   public ArrayList<Participante> getParticipanteList(){
         return this.participanteList;
    }
    public void setParticipanteList(ArrayList<Participante> participanteList){
        this.participanteList = participanteList;
    }
    public ArrayList<Participante> procesoParticipantes(ArrayList <Pronostico> pronosticosList){
        // recorro tarjetas de pronosticos y voy sumando puntos a los participantes
        ArrayList<Participante> listaApostadores ;
        listaApostadores = this.getParticipanteList();

        for ( Participante participante : this.getParticipanteList()) {
            for (Pronostico pronostico : pronosticosList) {
                if (pronostico.getParticipanteID() == participante.getParticipanteID()) {
                    //participante.setPuntos(pronostico.getPuntos());
                    pronostico.getPuntos();
                }
                
            }
        }   

        this.setParticipanteList(listaApostadores);
        return this.participanteList;

    }

        
}