package solver;

import java.util.List;

import rubiks.Cube;
import rubiks.move.Move;
import rubiks.move.MoveBuilder;

public abstract class AbstractTreeSolver implements Solver {
	
	private Cube cube;
	private List<Move> moves;

	public AbstractTreeSolver(Cube cube) {
		this.cube = cube;
		moves = MoveBuilder.createMoves();
	}

	@Override
	public void solve() {
		System.out.println("Starting to solve: \n" + cube);
		CubeEvaluator eval = new CubeEvaluator();

		int numMoves = 0;
		TreeNode path = new TreeNode(cube, moves.get(0), moves, null);
		long startTime = System.currentTimeMillis();
		while (eval.facesSolved(cube) < 4) {
			path = doSolve(path, cube);
			numMoves++;
		}
		long elapsed = System.currentTimeMillis() - startTime;
		System.out.println("Solved after " + numMoves + " tries. Elapsed time: " + (elapsed / 1000) + " sec");
		System.out.println(path);
		System.out.println(cube);
	}
	
	protected abstract TreeNode doSolve(TreeNode path, Cube cube);

}
