package Tutorials;

import java.util.ArrayList;

public class DotComBust {

	private GameHelper helper = new GameHelper();
	private ArrayList<DotCom> dotComList = new ArrayList<DotCom>();
	private int numOfGuesses = 0;

	public void setUpGame() {
		DotCom one = new DotCom();
		one.setName("Pets.com");

		DotCom two = new DotCom();
		two.setName("eToys.com");

		DotCom three = new DotCom();
		three.setName("Go2.com");

		dotComList.add(one);
		dotComList.add(two);
		dotComList.add(three);

		System.out.println("Your goal is to sink three dot coms.");
		System.out.println("Pets.com, eToys.com, Go2.com");
		System.out.println("Try to sink all of them in th fewest amount of guesses");

		for (DotCom dotComToSet : dotComList) {
			ArrayList<String> newLocation = helper.placeDotCom(3);
			dotComToSet.setLocationCells(newLocation);
		}
	}

	public void startPlaying() {
		while (!dotComList.isEmpty()) {
			String userGuess = helper.getUserInput("Enter a guess");
			checkUserGuess(userGuess);
		}
	}

	public void checkUserGuess(String userGuess) {
		numOfGuesses++;
		String result = "miss";

		for (DotCom dotComToTest : dotComList) {
			result = dotComToTest.checkYourself(userGuess);

			if (result.equals("hit")) {
				break;
			}

			if (result.equals("kill")) {
				break;
			}
		}

		System.out.println(result);
	}

	public void finishGame() {
		System.out.println("Game over");

		if (numOfGuesses <= 18) {
			System.out.println("It only took you " + numOfGuesses + "to sink all of the ships!");
			System.out.println("Congratulations");
		} else {
			System.out.println("It took you too long. It took you " + numOfGuesses + " to sink all of the ships!");
			System.out.println("You aren't good at this game, huh?");
		}
	}

	public static void main(String[] args) {
		DotComBust game = new DotComBust();
		game.setUpGame();
		game.startPlaying();

	}
}
