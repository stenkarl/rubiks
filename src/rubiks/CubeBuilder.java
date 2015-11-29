package rubiks;

import static rubiks.Tile.BLUE;
import static rubiks.Tile.GREEN;
import static rubiks.Tile.ORANGE;
import static rubiks.Tile.RED;
import static rubiks.Tile.WHITE;
import static rubiks.Tile.YELLOW;

public class CubeBuilder {

	public static Cube createSolvedCube() {

		Face front = new Face(BLUE);
		Face left = new Face(RED);
		Face back = new Face(GREEN);
		Face right = new Face(ORANGE);
		Face top = new Face(WHITE);
		Face bottom = new Face(YELLOW);

		Cube cube = new Cube(front, left, back, right, top, bottom);

		return cube;
	}

	public static Cube createScrambledCube() {

		Face front = new Face(ORANGE, ORANGE, WHITE, BLUE, BLUE, WHITE, RED, RED, WHITE);
		Face left = new Face(BLUE, BLUE, BLUE, RED, RED, RED, GREEN, GREEN, GREEN);
		Face back = new Face(YELLOW, RED, RED, YELLOW, GREEN, GREEN, YELLOW, ORANGE, ORANGE);
		Face right = new Face(GREEN, ORANGE, BLUE, GREEN, ORANGE, BLUE, GREEN, ORANGE, BLUE);
		Face top = new Face(WHITE, WHITE, ORANGE, WHITE, WHITE, GREEN, WHITE, WHITE, RED);
		Face bottom = new Face(YELLOW, YELLOW, ORANGE, YELLOW, YELLOW, BLUE, YELLOW, YELLOW, RED);

		Cube cube = new Cube(front, left, back, right, top, bottom);

		return cube;
	}

}
