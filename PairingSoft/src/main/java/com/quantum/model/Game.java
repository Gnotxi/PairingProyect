package com.quantum.model;

import java.util.List;

public class Game {

	private List<Team> teams;
	private List<Matchup> matchups;

	public List<Team> getTeams() {
		return teams;
	}

	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}

	public List<Matchup> getMatchups() {
		return matchups;
	}

	public void setMatchups(List<Matchup> matchups) {
		this.matchups = matchups;
	}
	

}
