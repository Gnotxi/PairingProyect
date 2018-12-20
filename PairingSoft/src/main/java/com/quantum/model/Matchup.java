package com.quantum.model;

public class Matchup {

	Team equipoLocal;
	Team equipoVisitante;
	
	public Matchup(Team equipoLocal, Team equipoVisitante) {
		this.equipoLocal=equipoLocal;
		this.equipoVisitante=equipoVisitante;
	}
	public Team getEquipoLocal() {
		return equipoLocal;
	}
	public void setEquipoLocal(Team equipoLocal) {
		this.equipoLocal = equipoLocal;
	}
	public Team getEquipoVisitante() {
		return equipoVisitante;
	}
	public void setEquipoVisitante(Team equipoVisitante) {
		this.equipoVisitante = equipoVisitante;
	}
	
}
