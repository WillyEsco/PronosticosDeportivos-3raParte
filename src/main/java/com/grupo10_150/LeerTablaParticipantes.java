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

public class LeerTablaParticipantes {
    public static ArrayList<Participante> LeerPersonas() {
        Connection conexion = null;
        Statement consulta = null;
        ArrayList<ParticipanteDB> participanteDBlist = new ArrayList<ParticipanteDB>();

        try {

            // Abrir la conexión
            System.out.println("conectando a la base de datos...");

            conexion = DriverManager.getConnection(DB_URL, USER, PASS);

            // Ejecutar una consulta
            System.out.println("Creating statement...");
            consulta = conexion.createStatement();
            String sql;
            sql = "SELECT id, Apellido, Nombre, Puntos FROM prode.personas";

            //En la variable resultado obtendremos las distintas filas que nos devolvió la base
            ResultSet resultado = consulta.executeQuery(sql);

            // Obtener las distintas filas de la consulta
            while (resultado.next()) {
                // Pbtener el valor de cada columna
                int id = resultado.getInt("id");
                String Apellido = resultado.getString("Apellido");
                String Nombre = resultado.getString("Nombre");
                int Puntos = resultado.getInt("Puntos");
                ParticipanteDB participanteDB = new ParticipanteDB(id, Apellido, Nombre, Puntos);
                participanteDBlist.add(participanteDB);

                // Mostrar los valores obtenidos
                // System.out.print("ID: " + id);
                // System.out.print(", Apellido: " + Apellido);
                // System.out.print(", Apellido: " + Nombre);
                // System.out.println(", Puntos: " + Puntos);
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
        System.out.println("Fin de la lectura de la tabla Prode.Personas");
    
        ArrayList<Participante> participanteList = new ArrayList<Participante>();
        for (ParticipanteDB participanteDB : participanteDBlist) {
            ArrayList<Double> puntajes = new ArrayList<Double>();
            Participante Participante = new Participante(participanteDB.getId(), participanteDB.getApellido() + " " + participanteDB.getNombre(), puntajes);
            participanteList.add(Participante);
          }
        return participanteList; 

 }
}


