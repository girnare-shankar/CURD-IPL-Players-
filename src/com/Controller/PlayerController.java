package com.Controller;

import java.util.List;

import com.Servise.PlayerServise;
import com.entity.Player;

public class PlayerController {

	PlayerServise servise = null;

	public List<Player> getAllPlayer() {
		servise = new PlayerServise();
		List<Player> allplayer = servise.getAllPlayer();
		return allplayer;
	}

	public List<Player> getTeamPlayer(String tname) {
		servise = new PlayerServise();
		List<Player> allcskplayer = servise.getTeamPlayer(tname);
		return allcskplayer;
	}

	public void insertPlayer() {
		servise = new PlayerServise();
		servise.insertPlayer();
	}

	public void updatePlayer() {
		servise = new PlayerServise();
		servise.updatePlayer();

	}

	public void deletePlayerData() {
		servise = new PlayerServise();
		servise.deletePlayerData();

	}

}
