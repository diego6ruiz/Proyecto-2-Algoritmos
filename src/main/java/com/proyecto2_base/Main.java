package com.proyecto2_base;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        Base base = new Base("bolt://localhost:7687", "neo4j", "12345");  //cambiar los numeros de localhost dependiendo de la base
        Recomendaciones recom = new Recomendaciones("bolt://localhost:7687", "neo4j", "12345");
        
        int x=0;
        int y=0;
        String texto="";
        String texto2="";
        
        System.out.println ("-----------------------------------------------------------------");
        System.out.println ("Seccion de Emergencias de Hospital");
        System.out.println ("Ingrese que desea hacer");
        System.out.println ("1. Agregar un elemento");
        System.out.println ("2. Eliminar un elemento");
        System.out.println ("3. Crear una relacion entre elementos");
        System.out.println ("4. Recomendacion en base a actores");
        System.out.println ("5. Listar peliculas de un actor");
        System.out.println ("6. Salir");
          
       x=scanner.nextInt();
       scanner.nextLine();
       while(x!=6){
       if (x==1){
    	   
           
           System.out.println ("Ingrese que desea agregar");
           System.out.println ("1. Pelicula");
           System.out.println ("2. Actor");
           System.out.println ("3. Usuario");
           
           y=scanner.nextInt();
           scanner.nextLine();
    	   
           System.out.println ("Ingrese el nombre");
           texto=scanner.nextLine();
           if (y==1){
        	   base.agregarPelicula(texto);        	   
           }
           else if (y==2){
        	   base.agregarActor(texto);        	   
           }
           else if (y==3){
        	   base.agregarPersona(texto);
           }    	   
       }
       else if (x==2){
    	   
           
           System.out.println ("Ingrese que desea eliminar");
           System.out.println ("1. Pelicula");
           System.out.println ("2. Actor");
           System.out.println ("3. Usuario");
           
           y=scanner.nextInt();
           scanner.nextLine();
           
           System.out.println ("Ingrese el nombre");
           texto=scanner.nextLine();
           if (y==1){
        	   base.eliminarPelicula(texto);        	   
           }
           else if (y==2){
        	   base.eliminarActor(texto);        	   
           }
           else if (y==3){
        	   base.eliminarPersona(texto);
           }    
       }
       else if(x==3){
    	   y=scanner.nextInt();
           scanner.nextLine();
           
           System.out.println ("Ingrese que relacion desea agregar");
           System.out.println ("1. Actor de una pelicula");
           System.out.println ("2. Amistad entre ususarios");
           System.out.println ("3. Usuario gusta de un actor");
    	   
           
           if (y==1){
        	   System.out.println ("Ingrese el actor");
        	   texto=scanner.nextLine();
        	   System.out.println ("Ingrese la pelicula");
        	   texto2=scanner.nextLine();
        	   
        	   base.actuoEn(texto, texto2);        	   
           }
           else if (y==2){
        	   System.out.println ("Ingrese el usuario no.1");
        	   texto=scanner.nextLine();
        	   System.out.println ("Ingrese el usuario no.2");
        	   texto2=scanner.nextLine();
        	   
        	   base.esAmigo(texto, texto2);        	   
           }
           else if (y==3){
        	   System.out.println ("Ingrese el usuario");
        	   texto=scanner.nextLine();
        	   System.out.println ("Ingrese al actor");
        	   texto2=scanner.nextLine();
        	   
        	   base.leGusta(texto, texto2); 
           }    
       }
       else if (x==4){
    	   System.out.println ("Ingrese el usuario en base al cual realizar la busqueda");
    	   texto=scanner.nextLine();
    	   
    	   List<String> names = new ArrayList<>();
    	   
    	   names = recom.recomendarConActor(texto);
    	   for(int i = 0; i < names.size(); i++) {
               System.out.println(names.get(i));
           }
           
       }
       else if (x==5){
    	   System.out.println ("Ingrese el actor en base al cual realizar la busqueda");
    	   texto=scanner.nextLine();
    	   
    	   List<String> pelis = new ArrayList<>();
    	   pelis = recom.peliculasActor(texto);
    	   for(int i = 0; i < pelis.size(); i++) {
               System.out.println(pelis.get(i));
           }
    	   
    	   
       }
       
       
       System.out.println ("Ingrese que desea hacer");
       System.out.println ("1. Agregar un elemento");
       System.out.println ("2. Eliminar un elemento");
       System.out.println ("3. Crear una relacion entre elementos");
       System.out.println ("4. Recomendacion en base a actores");
       System.out.println ("5. Recomendacion en base a lo que les gusta a mis amigos");
       System.out.println ("6. Salir");
       
       x=scanner.nextInt();
       scanner.nextLine();
       }
        
        base.cerrar();
    }

}
