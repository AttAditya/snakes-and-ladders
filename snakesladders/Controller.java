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

  private void updatePlayerStats(Player player) {
    if (!player.getCurrentTile().isLastTile()) return;
    
    player.setPlayStatus(PlayStatus.COMPLETED);
    turnCalculator.removePlayer(player);
  }

  private void checkGameCompletion() {
    if (turnCalculator.hasPlayers()) return;
    this.gameState = GameState.COMPLETED;
  }

  public void nextTurn() {
    Player player = turnCalculator.getNextPlayer();
    
    playTurn(player);
    updatePlayerStats(player);

    checkGameCompletion();
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
