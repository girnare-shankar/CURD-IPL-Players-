package com.Servise;

import java.util.ArrayList;
import java.util.List;

import com.Dao.PlayerDao;
import com.entity.Player;

public class PlayerServise {

	PlayerDao dao = null;

	public List<Player> getAllPlayer() {
		dao = new PlayerDao();
		List<Player> allplayer = dao.getAllPlayer();

		return allplayer;
	}

	public List<Player> getTeamPlayer(String tname) {
		dao = new PlayerDao();
		List<Player> allplayer = dao.getAllPlayer();
		List<Player> allcskplayer = new ArrayList<Player>();

		for (Player player : allplayer) {
			if (player.getTname().equalsIgnoreCase(tname)) {
				allcskplayer.add(player);
			}
		}

		return allcskplayer;
	}

	public void insertPlayer() {
		dao = new PlayerDao();
		dao.insertPlayerData();
	}

	public void updatePlayer() {
		dao = new PlayerDao();
		dao.updatePlayer();

	}

	public void deletePlayerData() {
		dao = new PlayerDao();
		dao.deletePlayerData();

	}
}
