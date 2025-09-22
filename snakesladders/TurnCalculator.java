package snakesladders;

import java.util.HashMap;
import java.util.Map;

public class TurnCalculator {
  private TurnNode current;
  private final Map<Player, TurnNode> playerNodeMap;

  public TurnCalculator(Player[] players) {
    this.playerNodeMap = new HashMap<>();
    
    TurnNode head = null;
    TurnNode tail = null;

    for (Player player : players) {
      TurnNode node = new TurnNode(player);
      playerNodeMap.put(player, node);

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
    current = current.getNext();
    return current.getPlayer();
  }

  public void removePlayer(Player player) {
    TurnNode node = playerNodeMap.get(player);
    playerNodeMap.remove(player);

    if (node.getNext() == node) {
      current = null;
      return;
    }

    node.getPrev().setNext(node.getNext());
    node.getNext().setPrev(node.getPrev());

    if (node == current) {
      current = node.getPrev();
    }
  }

  public boolean hasPlayers() {
    return current != null;
  }
}
