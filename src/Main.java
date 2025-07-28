import models.Game;
import models.GameStats;

public class Main {
	private final static int ITERATIONS = 10000;
	private final static int DICE_COUNT = 6;

	public static void main(String[] args) {
		GameStats statistics = new GameStats(ITERATIONS);

		statistics.startSimulation();
		for (int i = 0; i < statistics.getAmountOfIterations(); i++) {
			Game game = new Game(DICE_COUNT);
			while (game.isGameOngoing()) {
				game.RollDice();
			}

			statistics.inputTotalsFromGame(game);
		}
		statistics.endSimulation();

		statistics.calculateStatistics();
		statistics.outputSimulationStatistics();
	}
}
