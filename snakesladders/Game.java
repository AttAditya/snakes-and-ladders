package snakesladders;

public class Game {
  public static void main(String[] args) {
    Board board = new Board(10, 10);
    Dice dice = Dice.getInstance();
    Player[] players = {
      new Player(),
      new Player(),
    };

    Controller controller = new Controller(board, dice, players);
    controller.startGame();
    
    while (controller.getGameState() == GameState.IN_PROGRESS) {
      controller.nextTurn();
    }
  }
}
