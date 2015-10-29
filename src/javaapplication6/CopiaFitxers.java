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
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;
 
public class CopiaFitxers {
 
    public static void main(String[] args) {
        
        Scanner fitxer1 = new Scanner(System.in);
        Scanner fitxer2 = new Scanner(System.in);
        System.out.println( "Indica nom del fitxer a fer còpia:");
        String f1=fitxer1.nextLine();
        System.out.println("Escriu nom del fitxer al que es copiarà: ");
        String f2=fitxer2.nextLine();
        
        copia (f1,f2);
    }
 
    public static void copia (String fitxOriginal, String fitxCopia)
    {
        try
        {
                        // Obrim fitxer pral. per copia
            FileInputStream fileInput = new FileInputStream(fitxOriginal);
            BufferedInputStream bufferedInput = new BufferedInputStream(fileInput);
             
            // Obrim fitxer on copiarem
            FileOutputStream fileOutput = new FileOutputStream (fitxCopia);
            BufferedOutputStream bufferedOutput = new BufferedOutputStream(fileOutput);
             
            // Bucle per llegir d'un fitxer i llegir a un altre
            byte [] array = new byte[1000];
            int leidos = bufferedInput.read(array);
            while (leidos > 0)
            {
                bufferedOutput.write(array,0,leidos);
                leidos=bufferedInput.read(array);
            }
 
            // Tanquem buffers
            bufferedInput.close();
            bufferedOutput.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}