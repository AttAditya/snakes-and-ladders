package snakesladders;

public class Player {
  private Tile currentTile;

  public void enterTile(Tile tile) {
    currentTile.removeOccupant(this);
    this.currentTile = tile;
  }
}
