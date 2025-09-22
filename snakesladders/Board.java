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

    tiles[rows - 1][cols - 1].setLastTile(true);
  }

  public Tile getTile(int position) {
    if (position < 1 || position > rows * cols) return null;

    int row = (position - 1) / cols;
    int col = (position - 1) % cols;
    
    return tiles[row][col];
  }
}
