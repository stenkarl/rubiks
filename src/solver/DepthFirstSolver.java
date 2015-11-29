package solver;

import rubiks.Cube;
import rubiks.move.Move;

public class DepthFirstSolver extends AbstractTreeSolver {

	public DepthFirstSolver(Cube cube) {
		super(cube);
	}

	@Override
	protected TreeNode doSolve(TreeNode path, Cube cube) {
		Move move = path.getMove();
		move.execute(cube);
		return path.getNextDepthFirst();		
	}


}
