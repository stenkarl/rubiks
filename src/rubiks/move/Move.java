package rubiks.move;

import rubiks.Cube;

public abstract class Move {

	private Move inverse;

	public abstract void execute(Cube cube);

	void setInverse(Move inv) {
		inverse = inv;
	}

	public Move getInverse() {
		return inverse;
	}

}
