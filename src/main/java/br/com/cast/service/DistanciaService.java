package br.com.cast.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.cast.model.Distancia;

import com.google.gson.Gson;

@Path("/distancia")
public class DistanciaService {

	public static final double RAIO_TERRA = 6378.1;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/calcularDistancia/{latitude1}/{longitude1}/{latitude2}/{longitude2}")
	public String calcularDistanciaKm(@PathParam("latitude1") double latitudeP1,@PathParam("longitude1") double longitudeP1,
	@PathParam("latitude2") double latitudeP2,@PathParam("longitude2") double longitudeP2) {
		 
		Distancia distancia = new Distancia();
		double latitudePontos = Math.toRadians(latitudeP2 - latitudeP1);
	    double longitudePontos = Math.toRadians(longitudeP2 - longitudeP1);
	    latitudeP1 = Math.toRadians(latitudeP1);
	    latitudeP2 = Math.toRadians(latitudeP2);
	     
	    double valorHaversine = Math.sin(latitudePontos / 2) * Math.sin(latitudePontos / 2) + Math.sin(longitudePontos / 2) * Math.sin(longitudePontos / 2) * Math.cos(latitudeP1) * Math.cos(latitudeP2);
	    distancia.setDistancia(RAIO_TERRA * 2 * Math.asin(Math.sqrt(valorHaversine)));
	    return new Gson().toJson(distancia);
	}
}
