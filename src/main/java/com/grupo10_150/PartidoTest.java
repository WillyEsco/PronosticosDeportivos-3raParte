package com.grupo10_150;
import com.grupo10_150.Equipo;
import com.grupo10_150.Partido;
import org.junit.Assert.assertEquals;
import org.junit.*;
import java.util.ArrayList;
import java.util.*;
import java.util.HashMap;
import java.util.Map;
import java.util.List;


public class PartidoTest {

    // test para getGana()

   @Test 
   public void testGetGana() {
        // Arrange
        // Creo un partido
        Equipo equipo1 = new Equipo(1, "Argentina", "Seleccionado");
        Equipo equipo2 = new Equipo(2, "Arabia Saudita", "Seleccionado");
        Partido partido = new Partido(1,equipo1, equipo2 ,1,2,1);

        // Act
        // Obtengo el ganador
        int ganador = partido.getGana();
        // Assert
        // Verifico que el ganador sea correcto
        Assert.assertEquals(2, ganador);
    }

}
