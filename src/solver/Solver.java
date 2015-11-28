package solver;

import java.util.List;
import java.util.Random;

import rubiks.Cube;
import rubiks.move.Move;
import rubiks.move.MoveBuilder;

public class Solver {

	private Cube cube;
	private List<Move> moves;

	public Solver(Cube cube) {
		this.cube = cube;
		moves = MoveBuilder.createMoves();
	}

	public void solve() {
		System.out.println("Starting to solve: " + cube);
		CubeEvaluator eval = new CubeEvaluator();

		int numMoves = 0;
		double percentSolved = 0.0;
		while (eval.facesSolved(cube) < 2) {
			Move move = pickRandomMove();
			move.execute(cube);
			numMoves++;
			if (percentSolved > eval.percentSolved(cube)) {
				move.getInverse().execute(cube);
			}

		}
		System.out.println("Solved after " + numMoves + " moves");
		System.out.println(cube);
	}

	private Move pickRandomMove() {
		return moves.get(new Random().nextInt(moves.size()));
	}

}
