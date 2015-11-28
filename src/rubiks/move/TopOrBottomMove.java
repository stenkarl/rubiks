package rubiks.move;

import static rubiks.Direction.CLOCKWISE;
import static rubiks.Direction.COUNTER_CLOCKWISE;

import rubiks.Cube;
import rubiks.Face;
import rubiks.Tile;

public abstract class TopOrBottomMove extends Move {

	/**
	 * Helper method for moving the top or bottom.
	 */
	protected void moveTopOrBottomCW(Cube cube, int index, Face topOrBottom) {
		Tile[] currentFront = cube.getFront().getRow(index);
		Tile[] currentLeft = cube.getLeft().getRow(index);
		Tile[] currentRight = cube.getRight().getRow(index);
		Tile[] currentBack = cube.getBack().getRow(index);

		cube.getLeft().setRow(currentFront, index);
		cube.getBack().setRow(currentLeft, index);
		cube.getRight().setRow(currentBack, index);
		cube.getFront().setRow(currentRight, index);
		topOrBottom.rotate(topOrBottom.equals(cube.getTop()) ? CLOCKWISE : COUNTER_CLOCKWISE);
	}

}
