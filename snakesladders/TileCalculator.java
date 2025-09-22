package snakesladders;

public class TileCalculator {
  private final Board board;

  public TileCalculator(Board board) {
    this.board = board;
  }

  public Tile getNextTile(Player player, int rolled) {
    if (player.getCurrentTile() == null) return board.getTile(1);

    int currentPosition = player.getCurrentTile().getPosition();
    Tile nextTile = board.getTile(currentPosition + rolled);
    
    if (nextTile == null)
      return null;

    while (nextTile.getTeleporter() != null) {
      nextTile = nextTile.getTeleporter().getDestinationTile();
    }

    return nextTile;
  }
}
