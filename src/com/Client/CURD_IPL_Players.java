package com.Client;

import java.util.List;
import java.util.Scanner;

import com.Controller.PlayerController;
import com.entity.Player;

public class CURD_IPL_Players {

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		PlayerController controller = new PlayerController();
		List<Player> allplayer = controller.getAllPlayer();
		int ch;

		while (true) {
			System.out.println(
					"\n1. Show All Players\n2. Show Players by Team\n3. Insert Player Data\n4. Update Player Data\n5. Delete Player Data\n6. Exit\n\n# Enter Choice: ");
			ch = sc.nextInt();
			sc.nextLine(); // Consume the newline character

			switch (ch) {
			case 1:
				for (Player player : allplayer) {
					System.out.println(player);
				}
				break;
			case 2:
				System.out.println("Enter team name: ");
				String tname = sc.nextLine();
				List<Player> teamplayer = controller.getTeamPlayer(tname);
				System.out.println("\nAll '" + tname + "' Players: ");
				for (Player player : teamplayer) {
					System.out.println(player);
				}
				break;
			case 3:

				controller.insertPlayer();

				break;
			case 4:
				controller.updatePlayer();
				break;
			case 5:
				controller.deletePlayerData();
				break;
			case 6:
				System.out.println("Exiting...");
				System.exit(0);
				break;
			default:
				System.out.println("Enter Valid Choice");
				break;
			}
			sc.close();
		}

	}
}
