package com.grupo10_150;

import java.sql.*;
import java.util.ArrayList;
import static conexion.sql.ConectorSQL.DB_URL;
import static conexion.sql.ConectorSQL.USER;
import static conexion.sql.ConectorSQL.PASS;

//Lombok
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@Getter
@Setter

public class LeerTablaPronostico {
    public static ArrayList<PronosticoDB> LeerPronostico() {
        Connection conexion = null;
        Statement consulta = null;
        ArrayList<PronosticoDB> pronosticoDBlist = new ArrayList<PronosticoDB>();

        try {

            // Abrir la conexión
            System.out.println("conectando a la base de datos...");
            conexion = DriverManager.getConnection(DB_URL, USER, PASS);

            // Ejecutar una consulta
            System.out.println("Creating statement...");
            consulta = conexion.createStatement();
            String sql;
            sql = "SELECT participanteID, equipo1ID, gana1, empata, gana2, equipo2ID  FROM prode.pronostico";

            //En la variable resultado obtendremos las distintas filas que nos devolvió la base
            ResultSet resultado = consulta.executeQuery(sql);

            // Obtener las distintas filas de la consulta
            while (resultado.next()) {
                
                // Pbtener el valor de cada columna
                int participanteID = resultado.getInt("participanteID");
                int equipo1ID = resultado.getInt("equipo1ID");
                String gana1 = resultado.getString("gana1");
                if  (gana1 == null) {
                     gana1 = " ";
                }
                String empata = resultado.getString("empata");   
                if (empata == null) {
                    empata = " ";
                }            
                String gana2 = resultado.getString("gana2");
                if (gana2 == null) {
                    gana2 = " ";
                }
                int equipo2ID = resultado.getInt("equipo2ID");

                PronosticoDB pronosticoDB = new PronosticoDB(participanteID, "" ,equipo1ID, gana1, empata, gana2, equipo2ID);
                pronosticoDBlist.add(pronosticoDB);

                // Mostrar los valores obtenidos
                // System.out.print("participanteID: " + participanteID);
                // System.out.print(", equipo1ID: " + equipo1ID);
                // System.out.print(", gana1: " + gana1);
                // System.out.println(", empata: " + empata);
                // System.out.println(", equipo2ID: " + equipo2ID);
            }
            // Esto se utiliza par cerrar la conexión con la base de datos
            resultado.close();
            consulta.close();
            conexion.close();
         //   ArrayList<Participante> participanteList = new ArrayList<Participante>();
          //  participanteList = ArmarParticipanteList(participanteDBlist);
            
        } catch (SQLException se) {
            // Execpción ante problemas de conexión
            se.printStackTrace();
        } finally {
            // Esta sentencia es para que ante un problema con la base igual se cierren las conexiones
            try {
                if (consulta != null)
                    consulta.close();
            } catch (SQLException se2) {
            } try {
                if (conexion != null)
                    conexion.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        System.out.println("Fin de la lectura de la tabla Prode.Pronostico");
        return pronosticoDBlist; 
 }
}


