package rubiks.move;

import java.util.ArrayList;
import java.util.List;

import rubiks.Cube;

public class MoveBuilder {

	public static List<Move> createMoves() {
		List<Move> moves = new ArrayList<>();

		createTopMoves(moves);
		createBottomMoves(moves);
		createLeftMoves(moves);
		createRightMoves(moves);
		createFrontMoves(moves);
		createBackMoves(moves);

		return moves;
	}

	private static void createTopMoves(List<Move> moves) {
		Move topCW = new TopOrBottomMove() {

			@Override
			public void execute(Cube cube) {
				moveTopOrBottomCW(cube, 0, cube.getTop());
			}
		};

		Move topCCW = new TopOrBottomMove() {

			@Override
			public void execute(Cube cube) {
				moveTopOrBottomCW(cube, 0, cube.getTop());
				moveTopOrBottomCW(cube, 0, cube.getTop());
				moveTopOrBottomCW(cube, 0, cube.getTop());
			}
		};

		topCW.setInverse(topCCW);
		topCCW.setInverse(topCW);

		moves.add(topCW);
		moves.add(topCCW);
	}

	private static void createBottomMoves(List<Move> moves) {
		Move bottomCW = new TopOrBottomMove() {

			@Override
			public void execute(Cube cube) {
				moveTopOrBottomCW(cube, 2, cube.getBottom());
			}
		};

		Move bottomCCW = new TopOrBottomMove() {

			@Override
			public void execute(Cube cube) {
				moveTopOrBottomCW(cube, 2, cube.getBottom());
				moveTopOrBottomCW(cube, 2, cube.getBottom());
				moveTopOrBottomCW(cube, 2, cube.getBottom());
			}
		};

		bottomCW.setInverse(bottomCCW);
		bottomCCW.setInverse(bottomCW);

		moves.add(bottomCW);
		moves.add(bottomCCW);
	}

	private static void createLeftMoves(List<Move> moves) {
		Move leftCW = new LeftOrRightMove() {

			@Override
			public void execute(Cube cube) {
				moveLeftOrRightCW(cube, 0, cube.getLeft());
			}
		};

		Move leftCCW = new LeftOrRightMove() {

			@Override
			public void execute(Cube cube) {
				moveLeftOrRightCW(cube, 0, cube.getLeft());
				moveLeftOrRightCW(cube, 0, cube.getLeft());
				moveLeftOrRightCW(cube, 0, cube.getLeft());
			}
		};

		leftCW.setInverse(leftCCW);
		leftCCW.setInverse(leftCW);

		moves.add(leftCW);
		moves.add(leftCCW);
	}

	private static void createRightMoves(List<Move> moves) {
		Move rightCW = new LeftOrRightMove() {

			@Override
			public void execute(Cube cube) {
				moveLeftOrRightCW(cube, 2, cube.getRight());
			}
		};

		Move rightCCW = new LeftOrRightMove() {

			@Override
			public void execute(Cube cube) {
				moveLeftOrRightCW(cube, 2, cube.getRight());
				moveLeftOrRightCW(cube, 2, cube.getRight());
				moveLeftOrRightCW(cube, 2, cube.getRight());
			}
		};

		rightCW.setInverse(rightCCW);
		rightCCW.setInverse(rightCW);

		moves.add(rightCW);
		moves.add(rightCCW);
	}

	private static void createFrontMoves(List<Move> moves) {
		Move frontCW = new FrontOrBackMove() {

			@Override
			public void execute(Cube cube) {
				moveFrontClockwise(cube);
			}
		};

		Move frontCCW = new FrontOrBackMove() {

			@Override
			public void execute(Cube cube) {
				moveFrontClockwise(cube);
				moveFrontClockwise(cube);
				moveFrontClockwise(cube);
			}
		};

		frontCW.setInverse(frontCCW);
		frontCCW.setInverse(frontCW);

		moves.add(frontCW);
		moves.add(frontCCW);
	}

	private static void createBackMoves(List<Move> moves) {
		Move backCW = new FrontOrBackMove() {

			@Override
			public void execute(Cube cube) {
				moveBackClockwise(cube);

			}
		};

		Move backCCW = new FrontOrBackMove() {

			@Override
			public void execute(Cube cube) {
				moveBackClockwise(cube);
				moveBackClockwise(cube);
				moveBackClockwise(cube);
			}
		};

		backCW.setInverse(backCCW);
		backCCW.setInverse(backCW);

		moves.add(backCW);
		moves.add(backCCW);
	}

}
