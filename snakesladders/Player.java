package snakesladders;

public class Player {
  private Tile currentTile;
  private PlayStatus playStatus;
  private String name;

  public Player(String name) {
    this.currentTile = null;
    this.playStatus = PlayStatus.NOT_STARTED;
    this.name = name;
  }

  public Tile getCurrentTile() {
    return currentTile;
  }

  public String getName() {
    return name;
  }

  public PlayStatus getPlayStatus() {
    return playStatus;
  }

  public void setPlayStatus(PlayStatus playStatus) {
    this.playStatus = playStatus;
  }

  public void enterTile(Tile tile) {
    if (this.currentTile != null)
      currentTile.removeOccupant(this);

    this.currentTile = tile;
  }
}
