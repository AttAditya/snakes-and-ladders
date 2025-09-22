package snakesladders;

public class Dice {
  private static Dice instance;
  private Dice() {
    if (instance != null) {
      throw new IllegalStateException("Already instantiated");
    }

    instance = this;
  }

  public static Dice getInstance() {
    if (instance == null) new Dice();
    return instance;
  }

  public int roll() {
    return (int) (Math.random() * 6) + 1;
  }
}
