package rubiks.move;

import static rubiks.Direction.CLOCKWISE;

import rubiks.Cube;
import rubiks.Tile;

public abstract class FrontOrBackMove extends Move {

	/**
	 * Clients should call this to move the front face of the cube clockwise a
	 * quarter turn.
	 * 
	 */
	public void moveFrontClockwise(Cube cube) {
		Tile[] currentTop = cube.getTop().getRow(2);
		Tile[] currentRight = cube.getRight().getCol(0);
		Tile[] currentBottom = cube.getBottom().getRow(0);
		Tile[] currentLeft = cube.getLeft().getCol(2);

		cube.getTop().setRow(reverse(currentLeft), 2);
		cube.getRight().setCol(currentTop, 0);
		cube.getBottom().setRow(reverse(currentRight), 0);
		cube.getLeft().setCol(currentBottom, 2);

		cube.getFront().rotate(CLOCKWISE);
	}

	/**
	 * Clients should call this to move the back face of the cube clockwise a
	 * quarter turn.
	 */
	public void moveBackClockwise(Cube cube) {
		Tile[] currentTop = cube.getTop().getRow(0);
		Tile[] currentRight = cube.getLeft().getCol(0);
		Tile[] currentBottom = cube.getBottom().getRow(2);
		Tile[] currentLeft = cube.getRight().getCol(2);

		cube.getTop().setRow(currentLeft, 0);
		cube.getLeft().setCol(reverse(currentTop), 0);
		cube.getBottom().setRow(currentRight, 2);
		cube.getRight().setCol(reverse(currentBottom), 2);

		cube.getBack().rotate(CLOCKWISE);
	}

	/**
	 * Convenience method for reversing a row or col tile array. The original
	 * array is untouched.
	 * 
	 * @param array
	 * @return
	 */
	protected Tile[] reverse(Tile[] array) {
		return new Tile[] { array[2], array[1], array[0] };
	}

}
