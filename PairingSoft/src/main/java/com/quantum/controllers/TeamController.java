package com.quantum.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.quantum.model.Game;
import com.quantum.model.Player;
import com.quantum.model.Team;
import com.quantum.service.TeamService;

@Controller
@ComponentScan(value = "com.quantum.service")
public class TeamController {

	List<Player> lstPlayers = new ArrayList<Player>();

	List<Team> teams = new ArrayList<Team>();
	@Autowired
	TeamService ts;

	@PostConstruct
	public void init() throws Exception {
		teams.add(ts.newteam());
	}

	@GetMapping
	public String index() {
		return "redirect:/index";
	}

	@GetMapping("/index")
	public String welcome(Model model) {
		model.addAttribute("teams", ts.newteam());
		return "index.html";
	}

	@GetMapping("/all")
	public String showAll(Model model) {
		model.addAttribute("game", ts.newGame());
		return "player/matchups";
	}

	@GetMapping("/best5p")
	public String showAsll(Model model) {
		Game g = ts.newGame();
		model.addAttribute("players", ts.mejoresJugadores(g));
		return "player/best5Players";
	}

	@GetMapping("/bestplayers")
	public String bestplayers(Model model) {
		model.addAttribute("game", ts.newGame());
		return "player/allPlayers";
	}

}
