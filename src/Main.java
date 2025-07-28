import models.Game;
import models.GameStats;

public class Main {
	public static void main(String[] args) {
		GameStats statistics = new GameStats(10000);

		statistics.startSimulation();
		for (int i = 0; i < statistics.getAmountOfIterations(); i++) {
			Game game = new Game(6);
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
