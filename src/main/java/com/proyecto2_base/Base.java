package com.proyecto2_base;

import org.neo4j.driver.*;
import static org.neo4j.driver.Values.parameters;

public final class Base {
    Driver driver;
    public Base(String url, String usuario, String clave){
        driver = GraphDatabase.driver(url, AuthTokens.basic(usuario, clave));
    }

    public void agregarPelicula(String nombre){
        try(Session session = driver.session()){
            session.writeTransaction(tx -> tx.run ("MERGE (a:Pelicula {nombre: $x}) ", parameters("x", nombre)));
        }
    }
    
    public void eliminarPelicula(String nombre){
        try(Session session = driver.session()){
            session.writeTransaction(tx -> tx.run ("MATCH (n:Pelicula {nombre: $x}) DETACH DELETE n", parameters("x", nombre)));
        }
    }
    
    public void agregarActor(String nombre){
        try(Session session = driver.session()){
            session.writeTransaction(tx -> tx.run ("MERGE (a:Actor {nombre: $x}) ", parameters("x", nombre)));
        }
    }
    
    
    public void eliminarActor(String nombre){
        try(Session session = driver.session()){
            session.writeTransaction(tx -> tx.run ("MATCH (n:Actor {nombre: $x}) DETACH DELETE n", parameters("x", nombre)));
        }
    }
    
    public void agregarPersona(String nombre){
        try(Session session = driver.session()){
            session.writeTransaction(tx -> tx.run ("MERGE (a:Persona {nombre: $x}) ", parameters("x", nombre)));
        }
    }
    
    public void eliminarPersona(String nombre){
        try(Session session = driver.session()){
            session.writeTransaction(tx -> tx.run ("MATCH (n:Persona {nombre: $x}) DETACH DELETE n", parameters("x", nombre)));
        }
    }
    
    public void actuoEn(String actor, String pelicula) {
    	try(Session session = driver.session()){
            session.writeTransaction(tx -> tx.run ("MATCH (a:Actor),(b:Pelicula) WHERE a.nombre= $x AND b.nombre= $y CREATE (a)-[r:actuoEn]->(b) RETURN type(r)", parameters("x", actor, "y",pelicula)));
        }
    }
    
    public void leGusta(String persona, String actor) {
    	try(Session session = driver.session()){
            session.writeTransaction(tx -> tx.run ("MATCH (a:Persona),(b:Actor) WHERE a.nombre= $x AND b.nombre= $y CREATE (a)-[r:leGusta]->(b) RETURN type(r)", parameters("x", persona, "y",actor)));
        }
    }
    
    public void esAmigo(String persona, String persona2) {
    	try(Session session = driver.session()){
            session.writeTransaction(tx -> tx.run ("MATCH (a:Persona),(b:Persona) WHERE a.nombre= $x AND b.nombre= $y CREATE (a)-[r:esAmigoDe]->(b) RETURN type(r)", parameters("x", persona, "y",persona2)));
        }
    }

    public void cerrar(){
        driver.close();
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    
}
