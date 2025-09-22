package snakesladders;

public class Controller {
  private Board board;
  private Dice dice;
  private Player[] players;

  private int currentPlayerIndex;
  private GameState gameState;

  public Controller(
    Board board,
    Dice dice,
    Player[] players
  ) {
    this.board = board;
    this.dice = dice;
    this.players = players;
    this.currentPlayerIndex = 0;
    this.gameState = GameState.PENDING;
  }

  private void playTurn(Player player) {
    int rolled = dice.roll();

    Tile currentTile = player.getCurrentTile();
    int currentPosition = currentTile.getPosition();
    Tile nextTile = board.getTile(currentPosition + rolled);

    while (nextTile.getTeleporter() != null) {
      nextTile = nextTile.getTeleporter().getDestinationTile();
    }

    player.enterTile(nextTile);
  }

  public void nextTurn() {
    currentPlayerIndex = (currentPlayerIndex + 1) % players.length;
    playTurn(players[currentPlayerIndex]);
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
