package com.quantum.model;

import java.rmi.server.UID;

public class Player {

	private UID id;
	private String nombre;
	private String apellido;
	private int ingenio;
	private int rapidez;
	private String tipoJugador;
	private double eloJugador;

	public Player() {}
	
	public Player(String nombre, String apellido, int ingenio, int rapidez, String tipoJugador, double eloJugador) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.ingenio = ingenio;
		this.rapidez = rapidez;
		this.tipoJugador = tipoJugador;
		this.eloJugador = eloJugador;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getIngenio() {
		return ingenio;
	}

	public void setIngenio(int ingenio) {
		this.ingenio = ingenio;
	}

	public int getRapidez() {
		return rapidez;
	}

	public void setRapidez(int rapidez) {
		this.rapidez = rapidez;
	}

	public String getTipoJugador() {
		return tipoJugador;
	}

	public void setTipoJugador(String tipoJugador) {
		this.tipoJugador = tipoJugador;
	}
	
	public double getEloJugador() {
		return eloJugador;
	}

	public void setEloJugador(double eloJugador) {
		this.eloJugador = eloJugador;
	}

	public UID getId() {
		return id;
	}

	public void setId(UID id) {
		this.id = id;
	}
	
}
