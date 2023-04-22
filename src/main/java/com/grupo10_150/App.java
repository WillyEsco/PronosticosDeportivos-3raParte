package com.grupo10_150;

import java.lang.ref.Cleaner;

/**
 * Pronosticos Deportivos
 *    GRUPO 10 - 150
 */

import java.util.ArrayList;


public class App {

    public static  void main(String[] args) throws Exception {
        //tomar los archivos a leer desde args();
        String resuFile;
        String pronFile;        
        if (args.length == 2) {
            if (args[0] == "resultados.cvs" ){
                resuFile = args[0];
                pronFile = args[1];           
            } else {
                resuFile = args[1];
                pronFile = args[0];
            }

        }else{
            // System.out.print("\033[H\033[2J");
            // System.out.println("================================================");  
            // System.out.println("                SIN ARGUMENTOS");  
            // System.out.println("================================================");  
            // System.out.println("**    Alguno de los archivos no se declaran   **");
            // System.out.println("** Por lo tanto toman los archivos de muestra **");
            // System.out.println("**         desde:  src\\test\\resources         **");
            // System.out.println("************************************************");
             resuFile = ".\\src\\test\\resources\\resultados.csv";
             pronFile= ".\\src\\test\\resources\\pronostico.csv";
        }
            System.out.println("===========================================================");  
            System.out.println("                       P R O D E");  
            System.out.println("===========================================================");  
       LectorCsv lectorCsv = new LectorCsv(resuFile,pronFile);

       //Obtengo todas las líneas del archivo CSV
       lectorCsv.parsearResultados();
       lectorCsv.parsearProde();

       ArrayList <Partido> partidosList = lectorCsv.crearResultados();
       ArrayList <Pronostico> pronosticosList = lectorCsv.crearPronosticos(partidosList);
       
        // Calculo los puntos
       
     //   ArrayList <Participante> participantesList = lectorCsv.procesoParticipantes(pronosticosList);
            System.out.println("\nCant. de participantes: " + lectorCsv.getParticipanteList().size());
            // proceso los participantes y acumulo los puntos de cada ronda
            for (Participante p : lectorCsv.getParticipanteList()){    
                p.calcularPuntaje(pronosticosList);
                System.out.println("==========================================================");
                System.out.println(p.toString());
                System.out.println("==========================================================");
            }

    }
}
    

