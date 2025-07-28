package models;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Data
public class GameStats {
	@Setter(AccessLevel.NONE)
	private int amountOfIterations;
	@Setter(AccessLevel.NONE)
	private int numberOfDice;
	@Setter(AccessLevel.NONE)
	private Map<Integer, Double> averages = new HashMap<>();
	@Setter(AccessLevel.NONE)
	private Map<Integer, Integer> rollOccurrences = new HashMap<>();
	@Setter(AccessLevel.NONE)
	private long startTime;
	@Setter(AccessLevel.NONE)
	private long endTime;
	@Setter(AccessLevel.NONE)
	private long durationOfSimulation;

	public GameStats(int amountOfIterations, int diceCount) {
		this.amountOfIterations = amountOfIterations;
		this.numberOfDice = diceCount;
	}

	public void startSimulation() {
		startTime = System.currentTimeMillis();
	}

	public void endSimulation() {
		endTime = System.currentTimeMillis();
		durationOfSimulation = endTime - startTime;
	}

	public void inputTotalsFromGame(Game game) {
		rollOccurrences.put(game.getTotalScore(), rollOccurrences.getOrDefault(game.getTotalScore(), 0) + 1);
		averages.put(game.getTotalScore(), averages.getOrDefault(game.getTotalScore(), 0.0) + 1);
	}

	public void calculateStatistics() {
		averages.replaceAll((k, v) -> v / amountOfIterations);
	}

	public void outputSimulationStatistics() {
		System.out.println("Number of simulations was " + amountOfIterations + " using " + numberOfDice + " dice.");
		averages.forEach((k, v) -> System.out.println("Total " + k + " occurs " + v + " occurred " + rollOccurrences.get(k) + " times."));
		System.out.println("Total duration: " + durationOfSimulation + "ms");
	}

}
