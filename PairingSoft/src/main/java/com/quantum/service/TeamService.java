package com.quantum.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.quantum.model.Game;
import com.quantum.model.Player;
import com.quantum.model.Team;
@Service
public interface TeamService {
	
	public Game newGame();

	public Team newteam ();
	
	public Player newPlayer();
	
	public String nombreAleatorio();
	
	public String apellidoAleatorio();

	public String nombreEquipoAleatorio();
	
	public String tipoJugadorAleatorio();
	
	public double calculaelo(int rapidez, int ingenio, String tipoJugador);
	
	public double calculaeloequipo(List<Player> lstPlayers);

	public List<Player> mejoresJugadores(Game game);
	
}
