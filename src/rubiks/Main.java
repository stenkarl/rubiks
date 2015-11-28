package rubiks;

import java.util.List;

import rubiks.move.Move;
import rubiks.move.MoveBuilder;

public class Main {

	public static void testMoves() {
		Cube cube = CubeBuilder.createSolvedCube();
		System.out.println(cube);

		List<Move> moves = MoveBuilder.createMoves();

		/*
		 * 0 topCW, 1 topCCW, 2 bottomCW, 3 bottomCCW, 4 leftCW, 5 leftCCW, 6
		 * rightCW, 7 rightCCW, 8 frontCW, 9 frontCCW, 10 backCW, 11 backCCW
		 */

		moves.get(4).execute(cube);
		// moves.get(1).getInverse().execute(cube);

		System.out.println(cube);

	}

	public static void main(String[] args) {
		testMoves();

		// Solver solver = new Solver(CubeBuilder.createScrambledCube());

		// solver.solve();

	}

}
