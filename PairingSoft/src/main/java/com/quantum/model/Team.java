package com.quantum.model;

import java.util.List;

public class Team {

	private List<Player> players;
	private String nombreEquipo;
	private double eloEquipo;

	public Team() {};
	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	public String getNombreEquipo() {
		return nombreEquipo;
	}

	public void setNombreEquipo(String nombreEquipo) {
		this.nombreEquipo = nombreEquipo;
	}

	public double getEloEquipo() {
		return eloEquipo;
	}

	public void setEloEquipo(double eloEquipo) {
		this.eloEquipo = eloEquipo;
	}

}
