package rubiks;

import static rubiks.Direction.CLOCKWISE;

public class Face {

	private final static int NUM_ROWS = 3;

	private Tile[][] tiles = new Tile[NUM_ROWS][NUM_ROWS];

	public Face(Tile color) {
		for (Tile[] t : tiles) {
			for (int i = 0; i < NUM_ROWS; i++) {
				t[i] = color;
			}
		}
	}

	/**
	 * Build a face of mixed colors. The face is built from left to right and
	 * top to bottom.
	 */
	public Face(Tile... colors) {
		if (colors.length < NUM_ROWS * NUM_ROWS) {
			throw new IllegalArgumentException(
					"Too few colors. Can't create face with just " + colors.length + " colors.");
		}
		int index = 0;
		for (int i = 0; i < NUM_ROWS; i++) {
			for (int j = 0; j < NUM_ROWS; j++) {
				tiles[i][j] = colors[index++];
			}
		}
	}

	public Tile[] getRow(int row) {
		return tiles[row];
	}

	public Tile[] getCol(int col) {
		return new Tile[] { tiles[0][col], tiles[1][col], tiles[2][col] };
	}

	public void setRow(Tile[] newTiles, int row) {
		tiles[row] = newTiles;
	}

	public void setCol(Tile[] newTiles, int col) {
		tiles[0][col] = newTiles[0];
		tiles[1][col] = newTiles[1];
		tiles[2][col] = newTiles[2];
	}

	/**
	 * Rotate this face either CW or CCW.
	 */
	public void rotate(Direction dir) {
		Tile[][] rotated = new Tile[NUM_ROWS][NUM_ROWS];

		for (int i = 0; i < NUM_ROWS; i++) {
			for (int j = 0; j < NUM_ROWS; j++) {
				if (dir.equals(CLOCKWISE)) {
					rotated[i][j] = tiles[NUM_ROWS - 1 - j][i];
				} else {
					rotated[i][j] = tiles[j][NUM_ROWS - 1 - i];
				}
			}
		}

		tiles = rotated;
	}

	@Override
	public String toString() {
		StringBuilder b = new StringBuilder();
		for (Tile[] t : tiles) {
			for (Tile t2 : t) {
				b.append(t2);
				b.append(" ");
			}
			b.append("\n");
		}
		return b.toString();
	}

	private String pad(int strSize) {
		StringBuilder b = new StringBuilder();
		for (int i = strSize; i < 6; i++) {
			b.append(" ");
		}
		return b.toString();
	}

	public String getRowAsString(int row) {
		Tile[] t = getRow(row);

		StringBuilder b = new StringBuilder("[");
		for (int i = 0; i < t.length; i++) {
			b.append(t[i] + pad(t[i].toString().length()));
			if (i < t.length - 1) {
				b.append(" ");
			}
		}
		b.append("]");
		return b.toString();
	}

	public Tile[][] getTiles() {
		return tiles;
	}

	public Tile getMiddle() {
		return tiles[1][1];
	}

}
