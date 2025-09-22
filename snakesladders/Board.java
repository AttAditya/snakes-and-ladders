package snakesladders;

public class Board {
  private final Tile[][] tiles;
  private final int rows;
  private final int cols;

  public Board(int rows, int cols) {
    this.rows = rows;
    this.cols = cols;
    this.tiles = new Tile[rows][cols];

    for (int row = 0; row < rows; row++) {
      for (int col = 0; col < cols; col++) {
        int position = (row * cols) + col + 1;
        tiles[row][col] = new Tile(position);
      }
    }
  }

  public Tile getTile(int position) {
    if (1 > position || position > rows * cols) {
      throw new IllegalArgumentException(
        "Invalid tile position"
      );
    }

    int row = (position - 1) / cols;
    int col = (position - 1) % cols;
    
    return tiles[row][col];
  }
}
