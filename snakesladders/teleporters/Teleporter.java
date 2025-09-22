package snakesladders.teleporters;

import snakesladders.Tile;

public abstract class Teleporter {
  private Tile destinationTile;

  public Teleporter(Tile destinationTile) {
    this.destinationTile = destinationTile;
  }

  public Tile getDestinationTile() {
    return destinationTile;
  }
}
