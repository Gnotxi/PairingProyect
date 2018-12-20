package com.quantum.service;

import java.rmi.server.UID;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.quantum.model.Game;
import com.quantum.model.Matchup;
import com.quantum.model.Player;
import com.quantum.model.Team;

@Service
public class TeamServiceImpl implements TeamService{

	private final String names = "Joe, Albert, Maverick, Jessy, Dobby";
	private final String apellidos = "Smith, Shell, Rash, Varin, Glodde";
	private final String nombresEquipos = "Glorius, Semper fidelis, Damers, Flammers, Sejtur";
	private final String tipoJugador = "Carry, Coach";
	private static Random rnd = new Random();
	
	
	@Override
	public Game newGame() {
		Game game = new Game();
		List<Team> myList = new ArrayList<>();
		List<Matchup> matchuplist = new ArrayList<>();
		for (int i = 0; i < 20; i++) {
			myList.add(newteam());
		}
		game.setTeams(ordenaEquiposPorElo(myList));
		
		for (int i = 0; i < 20; i++) {
			matchuplist.add(new Matchup(ordenaEquiposPorElo(myList).get(i), ordenaEquiposPorElo(myList).get(i+1)));
			i++;
		}		
		game.setMatchups(matchuplist);
		return game;
	}
	
	
	@Override
	public Team newteam() {
		Team team = new Team();
		List<Player> myList = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			myList.add(newPlayer());
		}
		team.setPlayers(ordenaJugadoresPorElo(myList));
		team.setNombreEquipo(nombreEquipoAleatorio());
		team.setEloEquipo(calculaeloequipo(myList));
		return team;
	}

	@Override
	public Player newPlayer() {
		Player player = new Player();
		player.setNombre(nombreAleatorio());
		player.setApellido(apellidoAleatorio());
		player.setIngenio(rnd.nextInt(35));
		player.setRapidez(rnd.nextInt(35));
		player.setTipoJugador(tipoJugadorAleatorio());
		player.setEloJugador(calculaelo(player.getRapidez(), player.getIngenio(), player.getTipoJugador()));
		player.setId(new UID());
		return player;
	}

	@Override
	public String nombreAleatorio() {
		String[] arr = names.split(",");
		return arr[rnd.nextInt(4)];
	}

	@Override
	public String apellidoAleatorio() {
		String[] arr = apellidos.split(",");
		return arr[rnd.nextInt(4)];
	}

	@Override
	public String nombreEquipoAleatorio() {
		String[] arr = nombresEquipos.split(",");
		return arr[rnd.nextInt(4)].concat(nombreAleatorio().concat(" Team"));
	}

	@Override
	public String tipoJugadorAleatorio() {
		String[] arr = tipoJugador.split(",");
		return arr[rnd.nextInt(2)];
	}

	@Override
	public double calculaelo(int rapidez, int ingenio, String tpjugador) {
		double elo = 0;
		if (tpjugador.equals(tipoJugador.substring(0))) {
			//rapidez*2+ingenio*0.5
			elo = rapidez*2+ingenio*0.5;

		} else {
			//ingenio*3+rapidez*0.2
			elo = ingenio*3+rapidez*0.2;
		}
		return elo;
	}


	@Override
	public double calculaeloequipo(List<Player> lstPlayers) {
		double eloTotalEquipo = 0;
			for (Player p:lstPlayers)
			{
				eloTotalEquipo = eloTotalEquipo+p.getEloJugador();
				
			}
		return eloTotalEquipo;
	}

	public List<Player> ordenaJugadoresPorElo(List<Player> listaJugadores){
		listaJugadores.sort(Comparator.comparingDouble(Player::getEloJugador)
                .reversed());
		return listaJugadores;}
	
	public List<Team> ordenaEquiposPorElo(List<Team> listaEquipos){
		listaEquipos.sort(Comparator.comparingDouble(Team::getEloEquipo)
                .reversed());
		return listaEquipos;}
	
	public List<Player> mejoresJugadores(Game game){
		List<Player> lstPlayers = new ArrayList<Player>();
		for (Team t : game.getTeams()) {
			for (Player p : t.getPlayers()) {
				lstPlayers.add(p);
			}
		}
		lstPlayers.sort(Comparator.comparingDouble(Player::getEloJugador)
                .reversed());
		return lstPlayers.subList(0, 5);}
}
