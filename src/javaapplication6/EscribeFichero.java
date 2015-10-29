/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication6;

/**
 *
 * @author mangels
 */
import java.io.*;
 
public class EscribeFichero
{
    public static void main(String[] args)
    {
        FileWriter fichero = null;
        
        try
        {
            fichero = new FileWriter("prueba1.txt",true);
            
            
 
            for (int i = 0; i < 10; i++)
                fichero.write("Linea " + i);
 
        } catch (Exception e) {
            e.printStackTrace();
        }  
        
        
        
        finally {
           try {
           // Nuevamente aprovechamos el finally para 
           // asegurarnos que se cierra el fichero.
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
              System.out.println("El programa se ha roto en el bloque de cierre");
                         }
           
           
        }
      
}
}
