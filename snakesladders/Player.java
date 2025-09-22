package snakesladders;

public class Player {
  private Tile currentTile;

  public Tile getCurrentTile() {
    return currentTile;
  }

  public void enterTile(Tile tile) {
    currentTile.removeOccupant(this);
    this.currentTile = tile;
  }
}
