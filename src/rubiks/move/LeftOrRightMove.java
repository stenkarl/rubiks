package rubiks.move;

import static rubiks.Direction.CLOCKWISE;

import rubiks.Cube;
import rubiks.Face;
import rubiks.Tile;

public abstract class LeftOrRightMove extends Move {

	/**
	 * Helper method for moving the left or right.
	 */
	protected void moveLeftOrRightCW(Cube cube, int index, Face leftOrRight) {
		Tile[] currentTop = cube.getTop().getCol(index);
		Tile[] currentBack = cube.getBack().getCol(leftOrRight == cube.getLeft() ? 2 : 0);
		Tile[] currentBottom = cube.getBottom().getCol(index);
		Tile[] currentFront = cube.getFront().getCol(index);

		cube.getBack().setCol(currentTop, leftOrRight == cube.getLeft() ? 2 : 0);
		cube.getBottom().setCol(currentBack, index);
		cube.getFront().setCol(currentBottom, index);
		cube.getTop().setCol(currentFront, index);
		leftOrRight.rotate(CLOCKWISE);
	}

}
