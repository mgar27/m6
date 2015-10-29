/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication6;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 *
 * @author mangels
 */
public class CopiaFitxerBucle {
 

 
    public static void main(String[] args) {
        copia ("prueba1.txt","prueba.txt");
    }
 
    public static void copia (String ficheroOriginal, String ficheroCopia)
    {
        try
        {
                        // Se abre el fichero original para lectura
            FileInputStream fileInput = new FileInputStream(ficheroOriginal);
            BufferedInputStream bufferedInput = new BufferedInputStream(fileInput);
             
            // Se abre el fichero donde se hará la copia
            FileOutputStream fileOutput = new FileOutputStream (ficheroCopia);
            BufferedOutputStream bufferedOutput = new BufferedOutputStream(fileOutput);
             
            // Bucle para leer de un fichero y escribir en el otro.
            byte [] array = new byte[1000];
            
            
            int leidos = bufferedInput.read(array);
            while (leidos > 0)
            {
                bufferedOutput.write(array,0,leidos);
                leidos=bufferedInput.read(array);
            }
 
            // Cierre de los ficheros
            bufferedInput.close();
            bufferedOutput.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
    
