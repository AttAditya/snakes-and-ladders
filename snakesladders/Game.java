package snakesladders;

public class Game {
  public static void main(String[] args) {
    Board board = new Board(10, 10);
    Dice dice = Dice.getInstance();
    Player[] players = {
      new Player("Player 1"),
      new Player("Player 2"),
    };
    
    TurnCalculator turnCalculator = new TurnCalculator(players);
    TileCalculator tileCalculator = new TileCalculator(board);
    
    Controller controller = new Controller(
      dice,
      turnCalculator,
      tileCalculator
    );
    
    controller.startGame();
    while (controller.getGameState() == GameState.IN_PROGRESS) {
      controller.nextTurn();
    }
  }
}
