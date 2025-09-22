package snakesladders;

public class TurnNode {
  private Player player;
  private TurnNode next;
  private TurnNode prev;

  public TurnNode(Player player) {
    this.player = player;
    this.next = null;
    this.prev = null;
  }

  public Player getPlayer() {
    return player;
  }

  public TurnNode getNext() {
    return next;
  }

  public void setNext(TurnNode next) {
    this.next = next;
  }

  public TurnNode getPrev() {
    return prev;
  }

  public void setPrev(TurnNode prev) {
    this.prev = prev;
  }
}
