package com.cricketscoremanagement.CricketView;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import com.cricketscoremanagement.dto.GetInput;
import com.cricketscoremanagement.dto.Player;
import com.cricketscoremanagement.dto.Teleporter;

import firstbatting.FirstMatchView;
import secondbatting.SecondMatchView;

public class CricketView implements CricketViewCallBack {

	private Scanner scanner = new Scanner(System.in);
	private CricketViewControllerCall cricketcontroller;

	public CricketView() {
		cricketcontroller = new CricketController(this);
	}

	public static void main(String[] args) {
		CricketView cricketView = new CricketView();
		cricketView.begining();
	}

	private void begining() {
		System.out.println("\nWelcome to Cricket Championship");

		while (true) {
			System.out.println("\n1)Start Game \n2)Exit");

			int input = GetInput.getInt();
			

			if (input == 1) {
				startGame();
			} else if (input == 2) {
				break;
			} else {
				System.out.println("\nImproper input ");
			}

		}
		System.out.println("\n\tThank You");

	}

	private void startGame() {
		while (true) {

			int over = cricketcontroller.getOver();
			String team1 = cricketcontroller.getTeam1name();
			String team2 = cricketcontroller.getTeam2name();

			print(over, team1, team2);

			System.out.println("\n -> Start Game <-");
			System.out.println("\n1)Modify Game \n2)Show Players \n3)Enter Game \n4)Go back ");
			int input = GetInput.getInt();

			if (input == 1) {
				modifyGame();
			} else if (input == 2) {
				showPlayers();
			} else if (input == 3) {
				enterGame();
			} else if (input == 4) {
				break;
			} else {
				System.out.println("Improper input ");
			}

		}

	}

	private void showPlayers() {
		List<Player> team1 = cricketcontroller.getTeam1Players();
		List<Player> team2 = cricketcontroller.getTeam2Players();

		System.out.println(" ------------------------------------------------------");
		System.out.printf(" |    %-20s |     %-20s | \n", cricketcontroller.getTeam1name(),
				cricketcontroller.getTeam2name());
		System.out.println(" ------------------------------------------------------");

		for (int i = 0; i < team1.size(); i++) {
			System.out.printf(" |    %-20s |     %-20s | \n", team1.get(i).getName(), team2.get(i).getName());
		}
		System.out.println(" ------------------------------------------------------");

	}

	private void print(int over, String team1, String team2) {
		System.out.println("+----------------+----------------+-----------------+");
		System.out.printf("| %9s      | %9s      | %9s       |\n", "Over", "Team 1", "Team 2");
		System.out.println("+----------------+----------------+-----------------+");
		System.out.printf("| %9d      | %9s      | %9s       |\n", over, team1, team2);
		System.out.println("+----------------+----------------+-----------------+");
	}

	private void enterGame() {
		System.out.print("\n" + cricketcontroller.getTeam1name() + " select H or T : ");
		char toss = scanner.next().toUpperCase().charAt(0);

		char res = cricketcontroller.getTossRes("HT");
		if (toss == res) {
			System.out.println("Toss Win By " + cricketcontroller.getTeam1name());
		} else {
			System.out.println("Toss Win By " + cricketcontroller.getTeam2name());
			cricketcontroller.swapTeams();
		}
		Teleporter firstmatch = new FirstMatchView();
		firstmatch.caller();

		cricketcontroller.SetScoreBoard();

		Teleporter secondmatch = new SecondMatchView();
		secondmatch.caller();

		printresult();

		String winner = cricketcontroller.getWinningStatus();

		System.out.println("\n\nWinning Team : " + winner);

		System.out.println("\nThank you");
		System.exit(0);
	}

	private void printresult() {
		List<Player> team1 = cricketcontroller.getTeam1Players();

		System.out.println(" -----------------------------------------" + cricketcontroller.getTeam1name()
				+ " ----------------------------------------");
		System.out.printf(" |    %-20s |     %-20s |     %-10s |     %-10s | \n", "Name", "Individual scores", "Status",
				"Wickets");
		System.out.println(" ----------------------------------------------------------------------------------------");

		for (int i = 0; i < team1.size(); i++) {
			Player p = team1.get(i);

			System.out.printf(" |    %-20s |     %-20s |     %-10s |     %-10s | \n", p.getName(),
					p.getIndevidual_score(), p.getStatus(), p.getNumberofWickets());
		}
		System.out.println(" ----------------------------------------------------------------------------------------");

		List<Player> team2 = cricketcontroller.getTeam2Players();

		System.out.println(" -----------------------------------------" + cricketcontroller.getTeam2name()
				+ " ----------------------------------------");
		System.out.printf(" |    %-20s |     %-20s |     %-10s |     %-10s | \n", "Name", "Individual scores", "Status",
				"Wickets");
		System.out.println(" ----------------------------------------------------------------------------------------");

		for (int i = 0; i < team1.size(); i++) {
			Player p = team2.get(i);

			System.out.printf(" |    %-20s |     %-20s |     %-10s |     %-10s | \n", p.getName(),
					p.getIndevidual_score(), p.getStatus(), p.getNumberofWickets());
		}
		System.out.println(" ----------------------------------------------------------------------------------------");
	}

	private void modifyGame() {
		System.out.println("\n -> Modify Game <-");

		while (true) {
			System.out.println(
					"\n1)Set Team Name \n2)Set Team1 Players name \n3)Set Team2 Players name \n4)Set Overs \n5)Go Back");

			int input = GetInput.getInt();

			if (input == 1) {
				setTeamName();
			} else if (input == 2) {
				setTeam1PlayerName();
			} else if (input == 3) {
				setTeam2PlayerName();
			} else if (input == 4) {
				setOvers();
			} else if (input == 5) {
				break;
			} else {
				System.out.println("Improper input ");
			}
		}

	}

	private void setOvers() {
		int overs = GetInput.getInt("Required no of overs");

		cricketcontroller.setOvers(overs);

		System.out.println("Over Set Successfully ");
	}

	private void setTeamName() {

		System.out.print("\nEnter Team 1 Name : ");
		String team1 = scanner.nextLine();

		System.out.print("\nEnter Team 2 Name : ");
		String team2 = scanner.nextLine();

		cricketcontroller.setTeamName(team1, team2);
		System.out.println("\nTeam names changed successfully ");
	}

	private void setTeam1PlayerName() {

		List<String> names = new LinkedList<>();

		for (int i = 0; i < 11; i++) {
			System.out.print("\nEnter Player " + (i + 1) + " name :");
			String name = scanner.nextLine();
			names.add(name);
		}

		cricketcontroller.setTeam1PlayerName(names);
		System.out.println("\nTeam 1 player names changed successfully ");
	}

	private void setTeam2PlayerName() {

		List<String> names = new LinkedList<>();

		for (int i = 0; i < 11; i++) {
			System.out.print("\nEnter Player " + (i + 1) + " name :");
			String name = scanner.nextLine();
			names.add(name);
		}

		cricketcontroller.setTeam2PlayerName(names);
		System.out.println("\nTeam 2 player names changed successfully ");
	}

}
