package com.grupo10_150;
import com.opencsv.bean.CsvToBeanBuilder;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//Lombok
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Data
@Setter
@Getter
@NoArgsConstructor  

public class LectorCsv {
    String resuFile;
    String pronFile;
    List<PartidoBind> lineasResultados;
    List<PronosticoBind> lineasProde;
    ArrayList<Participante> participanteList;
    ArrayList<Ronda> rondaList;

    public LectorCsv(String resuFile, String pronFile) {
        this.resuFile = resuFile;
        this.pronFile = pronFile;
        this.lineasResultados = new ArrayList<>();
        this.lineasProde = new ArrayList<>();
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

    public void parsearProde() {
        List<PronosticoBind> ListaDePronosticos = null;

        try {
            // En esta primera línea definimos el archivos que va a ingresar
            ListaDePronosticos = new CsvToBeanBuilder(new FileReader(this.pronFile))
                    // con esta configuración podemos skipear la primera línea de nuestro archivo CSV
                    .withSkipLines(1)
                    // con esta configuración podemos elegir cual es el caracter que vamos a usar para delimitar
                     .withSeparator(';')
                    // Es necesario definir el tipo de dato que va a generar el objeto que estamos queriendo parsear a partir del CSV
                    .withType(PronosticoBind.class)
                    .build()
                    .parse();

        } catch (IOException e) {
        e.printStackTrace();
    }
        this.lineasProde=ListaDePronosticos;
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
        int rondaID_Ant=0;
        int rondaAux = 0;
        int rondaAnt = 0;
        int i=0; // nro de match (vienen en orden)
        rondaAux = this.lineasResultados.get(0).getNroRonda();  
        for ( PartidoBind r : this.lineasResultados) {

            // agrego el partido al array de partidos   

            if (rondaAux != r.getNroRonda()){
                rondaAnt = rondaAux;
                rondaAux = r.getNroRonda(); 
                rondaList.add(new Ronda(rondaID_Ant, rondaAnt, partidosRondaList));
                partidosRondaList = new ArrayList<Partido>(); 
            }
                i++;
                equipo1Aux = new Equipo(r.getEquipo1ID(),r.getEquipo1_nombre(),r.getEquipo1_descripcion());
                equipo2Aux = new Equipo(r.getEquipo2ID(),r.getEquipo2_nombre(),r.getEquipo2_descripcion());
                partidoAux = new Partido(r.getNroRonda(), equipo1Aux, equipo2Aux, r.getEquipo1_goles(), r.getEquipo2_goles(), i);
                partidosList.add(partidoAux);
                partidosRondaList.add(partidoAux);
                rondaAnt = rondaAux; 
                rondaID_Ant = r.getRondaID();   
                
    
        }
        setRondaList(rondaList); 
        return partidosList;
    }

   // Crear pronosticos
   public ArrayList<Pronostico> crearPronosticos(ArrayList<Partido> partidosList){
        ArrayList<Pronostico> pronosticosList = new ArrayList<Pronostico>(); 
        ArrayList<Participante> participanteList = new ArrayList<Participante>();

        Participante participanteAux=null;
        Partido matchAux = new Partido();

        boolean encontre = false;
        for (PronosticoBind pb : this.lineasProde) {
            // armo las tarjetas de los pronosticos y los agrego a la lista de pronosticos
            //incluyo el objeto paticipante, el nro de ronda, el objeto partido (match), el equipo ganador y el resultado

            // creo la listade participantes 
 
            // busco el participante en la lista y si no está lo agrego
            encontre =false;
            for (Participante p : participanteList) {
                if (p.getParticipanteID() == pb.getParticipanteID()) {
                    participanteAux = p;
                    encontre = true;
                }
            }
            if (!encontre) {
                participanteAux = new Participante(pb.getParticipanteID(), pb.getNombre(),0);
                participanteList.add(participanteAux);
            }

                
            // busco el objeto partido en la listade partidos
            for (Partido match : partidosList) {
                if (match.getEquipo1().getEquipoID() == pb.getEquipo1ID() && match.getEquipo2().getEquipoID() == pb.getEquipo2ID()) {
                    matchAux = match;
                }
            }
       
                if (pb.getGana1().equals("X")) {
                    // busco equipo1 y equipo2 en partidosList
                    pronosticosList.add(new Pronostico(participanteAux, matchAux, matchAux.getEquipo1(), ResultadoEnum.GANADOR));
                    pronosticosList.add(new Pronostico(participanteAux, matchAux, matchAux.getEquipo2(), ResultadoEnum.PERDEDOR));
                    }
        
                if (pb.getGana2().equals("X")) {
                    // busco equipo1_id en partidosList   
                        pronosticosList.add(new Pronostico(participanteAux,  matchAux, matchAux.getEquipo2(), ResultadoEnum.GANADOR));
                        pronosticosList.add(new Pronostico(participanteAux,  matchAux , matchAux.getEquipo1(), ResultadoEnum.PERDEDOR));
                    }
                
                if (pb.getEmpata().equals("X")) {
                    // busco equipo1_id en partidosList              
                        pronosticosList.add(new Pronostico(participanteAux, matchAux , matchAux.getEquipo1(), ResultadoEnum.EMPATE));               
                        pronosticosList.add(new Pronostico(participanteAux, matchAux , matchAux.getEquipo2(), ResultadoEnum.EMPATE));               
                    }
                participanteAux=null;
   
        }
        // this.participanteList = participanteList;
        setParticipanteList(participanteList);
        // System.out.println("Cantidad de pronosticos: " + pronosticosList.size());
        // System.out.println("Cantidad de participantes: " + participanteList.size());
        // System.out.println("Cantidad de partidos: " + partidosList.size());
        // for (int i = 0; i < partidosList.size(); i++) {
        //     System.out.println(partidosList.get(i).toString());
        // }          
        // for (int i = 0; i < pronosticosList.size(); i++) {
        //     System.out.println(pronosticosList.get(i).toString());
        // }   
        // for (int i = 0; i < participanteList.size(); i++) {
        //     System.out.println(participanteList.get(i).toString());
        // }   
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

        for (Pronostico pronostico : pronosticosList) {
            pronostico.getPuntos();
        }
        return this.participanteList;

    }
        
}
