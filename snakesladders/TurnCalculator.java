package snakesladders;

import java.util.HashSet;
import java.util.Set;

public class TurnCalculator {
  private TurnNode current;
  private final Set<Player> pendingRemovals;

  public TurnCalculator(Player[] players) {
    this.pendingRemovals = new HashSet<>();
    
    TurnNode head = null;
    TurnNode tail = null;

    for (Player player : players) {
      TurnNode node = new TurnNode(player);
      
      if (tail == null) {
        head = node;
        tail = node;
        continue;
      }
      
      node.setPrev(tail);
      tail.setNext(node);

      tail = node;
      current = tail;
    }

    tail.setNext(head);
    head.setPrev(tail);
  }

  public Player getNextPlayer() {
    while (pendingRemovals.contains(current.getPlayer())) {
      pendingRemovals.remove(current.getPlayer());
      
      if (current.getNext() == current) {
        current = null;
        return null;
      }

      current.getPrev().setNext(current.getNext());
      current = current.getNext();
    }

    current = current.getNext();
    return current.getPlayer();
  }

  public void removePlayer(Player player) {
    pendingRemovals.add(player);
  }

  public boolean hasPlayers() {
    return current != null;
  }
}
