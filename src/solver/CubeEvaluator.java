package solver;

import rubiks.Cube;
import rubiks.Face;
import rubiks.Tile;

public class CubeEvaluator {

	int facesSolved(Cube cube) {
		int count = 0;
		for (Face face : cube.getFaces()) {
			if (percentFaceSovled(face) == 1.0) {
				count++;
			}
		}
		return count;
	}

	double percentFaceSovled(Face face) {
		int count = 0;
		for (Tile[] t : face.getTiles()) {
			for (Tile t2 : t) {
				if (t2.equals(face.getMiddle())) {
					count++;
				}
			}
		}
		return count / 9.0;
	}

	double percentSolved(Cube cube) {
		double count = 0;
		for (Face face : cube.getFaces()) {
			count = count + percentFaceSovled(face);
		}
		return count / 6.0;
	}
}
