package solver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import rubiks.Cube;
import rubiks.move.Move;

public class TreeNode {
	
	private final static int MAX_DEPTH = 20; // turns out all rubiks configs can be solved in 20 moves or less.
	
	private List<Move> moves;
	private Move move;
	private int index = -1;
	private TreeNode parent;
	private Cube cube;
	
	TreeNode(Cube cube, Move move, List<Move> moves, TreeNode parent) {
		this.moves = moves;
		this.move = move;
		this.parent = parent;
		this.cube = cube;
	}
	
	TreeNode getNext() {
		if (size() > MAX_DEPTH || getNextIndex() == -1) {
			move.getInverse().execute(cube); // if we went too far, back out the move and point back to the parent's next
			return parent.getNext();
		}
		//System.out.println("next index " + index);
		return new TreeNode(cube, moves.get(index), moves, this);
	}
	
	Move getMove() {
		return move;
	}
	
	TreeNode getParent() {
		return parent;
	}
	
	private int getNextIndex() {
		index++;
		if (index >= moves.size()) {
			index = -1;
		}
		return index;
	}
	
	int size() {
		if (parent == null) {
			return 1;
		}
		return 1 + parent.size();
	}
	
	void createString(List<Move> list) {
		list.add(move);
		if (parent != null) {
			parent.createString(list);
		}
	}
	
	@Override
	public String toString() {
		List<Move> list = new ArrayList<>();
		createString(list);
		
		Collections.reverse(list);
		StringBuilder b = new StringBuilder("Path [");
		for (int i = 0; i < list.size(); i++) {
			b.append(list.get(i).toString());
			if (i < list.size()-1) {
				b.append("->");
			}
		}
		b.append("]");
		
		return b.toString();
	}

}
