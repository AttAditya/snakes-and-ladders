package snakesladders;

import java.util.HashSet;
import java.util.Set;

import snakesladders.teleporters.Teleporter;

public class Tile {
  private final int position;
  private Teleporter teleporter;
  private final Set<Player> occupants;

  public Tile(int position) {
    this.position = position;
    this.occupants = new HashSet<>();
  }

  public void setTeleporter(Teleporter teleporter) {
    this.teleporter = teleporter;
  }

  public int getPosition() {
    return position;
  }

  public Teleporter getTeleporter() {
    return teleporter;
  }

  public Set<Player> getOccupants() {
    return new HashSet<>(occupants);
  }

  public void addOccupant(Player occupant) {
    occupants.add(occupant);
    occupant.enterTile(this);
  }

  public void removeOccupant(Player occupant) {
    occupants.remove(occupant);
  }
}
