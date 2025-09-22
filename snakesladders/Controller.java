package snakesladders;

public class Controller {
  private Dice dice;
  private TurnCalculator turnCalculator;
  private TileCalculator tileCalculator;
  private GameState gameState;

  public Controller(
    Dice dice,
    TurnCalculator turnCalculator,
    TileCalculator tileCalculator
  ) {
    this.dice = dice;
    this.turnCalculator = turnCalculator;
    this.tileCalculator = tileCalculator;
    this.gameState = GameState.PENDING;
  }

  private void playTurn(Player player) {
    int rolled = dice.roll();
    Tile nextTile = tileCalculator.getNextTile(player, rolled);
    if (nextTile != null) player.enterTile(nextTile);
  }

  public void nextTurn() {
    Player player = turnCalculator.getNextPlayer();
    
    if (player == null) {
      this.gameState = GameState.COMPLETED;
      return;
    }

    playTurn(player);
    if (player.getCurrentTile().getPosition() == 100) {
      player.setPlayStatus(PlayStatus.COMPLETED);
      turnCalculator.removePlayer(player);
    }
  }

  public void startGame() {
    if (gameState != GameState.PENDING) {
      throw new IllegalStateException("Game already started");
    }

    this.gameState = GameState.IN_PROGRESS;
  }

  public GameState getGameState() {
    return gameState;
  }
}
