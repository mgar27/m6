package javaapplication6;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mangels
 */
public class TestAgenda{
	   public static void main(String[] args) throws IOException{
	      Agenda a1 = new Agenda("Roser", 10, "García");
	      Agenda a2 = new Agenda("Joan", 20, "Vazquez");
	      
	      try{
	         FileOutputStream fs = new FileOutputStream("agenda.ser",true);//Creamos el archivo
	         ObjectOutputStream os = new ObjectOutputStream(fs);//Esta clase tiene el método writeObject() que necesitamos
	         os.writeObject(a1);//El método writeObject() serializa el objeto y lo escribe en el archivo
	         os.writeObject(a2);
	         os.close();//Hay que cerrar siempre el archivo
	      }catch(FileNotFoundException e){
	         e.printStackTrace();
	      }catch(IOException e){
	         e.printStackTrace();
	      }
	      try{
	         FileInputStream fis = new FileInputStream("agenda.ser");
	         ObjectInputStream ois = new ObjectInputStream(fis);
	         
	         a1 = (Agenda) ois.readObject();//El método readObject() recupera el objeto
	         a2 = (Agenda) ois.readObject();
	         
	         ois.close();
	      }catch(FileNotFoundException e){
	         e.printStackTrace();
	      }catch(IOException e){
	         e.printStackTrace();
	      }catch(ClassNotFoundException e){
	         e.printStackTrace();
	      }
	       
	      System.out.println(a1);
	      
	      System.out.println(a2);
	      //System.out.println((a1.getP_Apellido()+a2.getP_Apellido()));
	   }
	}
@SuppressWarnings("serial")
class Agenda implements Serializable{
	   private String nombre;
	   private int p_Apellido;
	   private String s_Apellido;
	    /*getters y setters*/
	   public String getNombre(){
	      return nombre;
	   }
	   public void setNombre(String nombre){
	      this.nombre = nombre;
	   }
	   public int getP_Apellido(){
	      return p_Apellido;
	   }
	   public void setP_Apellido(int p_Apellido){
	      this.p_Apellido = p_Apellido;
	   }
	   public String getS_Apellido(){
	      return s_Apellido;
	   }
	   public void setS_Apellido(String s_Apellido){
	      this.s_Apellido = s_Apellido;
	   }
	   public Agenda(String nombre, int p_Apellido, String s_Apellido){
	      super();
	      this.nombre = nombre;
	      this.p_Apellido = p_Apellido;
	      this.s_Apellido = s_Apellido;
	   }
	   public String toString(){
	         return( getNombre() + " " + getP_Apellido() + " " + getS_Apellido());
	      }
	}
