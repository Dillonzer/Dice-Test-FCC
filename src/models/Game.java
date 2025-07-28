package models;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Data
public class Game {
	@Setter(AccessLevel.NONE)
	private List<Die> dice = new ArrayList<>();
	@Setter(AccessLevel.NONE)
	private int totalScore;

	public Game(int numberOfDice) {
		while (dice.size() < numberOfDice) {
			dice.add(new Die());
		}
	}

	public void RollDice() {
		int diceToRemove = 0;
		List<Integer> diceTotals = new ArrayList<>();

		for (Die die : dice) {
			die.Roll();
			if (die.getRollValue() == 3) {
				diceToRemove++;
				continue;
			}

			diceTotals.add(die.getRollValue());
		}

		CalculateTotals(diceToRemove, diceTotals);
	}

	public void CalculateTotals(int diceToRemove, List<Integer> diceTotals) {
		boolean diceBeenRemoved = diceToRemove > 0;
		int currentLowestDice = 0;

		while (diceToRemove > 0) {
			dice.removeFirst();
			diceToRemove--;
		}

		if (diceBeenRemoved) {
			return;
		}

		for (Integer diceValue : diceTotals) {
			if (diceValue > currentLowestDice) {
				currentLowestDice = diceValue;
			}
		}

		totalScore += currentLowestDice;

		dice.removeFirst();
	}

	public boolean isOngoing() {
		return !dice.isEmpty();
	}


}
