package com.proyecto2_base;

import org.neo4j.driver.*;
import static org.neo4j.driver.Values.parameters;

import java.util.ArrayList;
import java.util.List;


public final class Recomendaciones {
	Driver driver;
	String text = "";
	
    public Recomendaciones(String url, String usuario, String clave){
        driver = GraphDatabase.driver(url, AuthTokens.basic(usuario, clave));
    }
    

    
    public List<String> recomendarConActor(String nombre)
    {
        try ( Session session = driver.session() )
        {
            return session.readTransaction( tx -> {
                List<String> names = new ArrayList<>();
                Result result = tx.run( "MATCH (user:Persona {nombre: $x})-[:leGusta]->(actor:Actor) -[:actuoEn]->(movie:Pelicula) <-[:actuoEn]-(coActor:Actor) return (coActor.nombre)", parameters("x", nombre));
                while ( result.hasNext() )
                {
                    names.add( result.next().get( 0 ).asString() );
                }
                return names;
            } );
        }
    }
    
    public List<String> peliculasActor(String nombre)
    {
        try ( Session session = driver.session() )
        {
            return session.readTransaction( tx -> {
                List<String> names = new ArrayList<>();
                Result result = tx.run( "match (n:Actor {nombre:$x})-[:actuoEn]->(a:Pelicula) return a.nombre", parameters("x", nombre));
                while ( result.hasNext() )
                {
                    names.add( result.next().get( 0 ).asString() );
                }
                return names;
            } );
        }
    }
    
    

}
