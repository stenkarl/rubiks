package rubiks;

import java.util.ArrayList;
import java.util.List;

public class Cube {

	private Face front;
	private Face left;
	private Face back;
	private Face right;
	private Face top;
	private Face bottom;

	private List<Face> faces = new ArrayList<Face>();

	public Cube(Face front, Face left, Face back, Face right, Face top, Face bottom) {
		this.front = front;
		this.left = left;
		this.back = back;
		this.right = right;
		this.top = top;
		this.bottom = bottom;

		faces.add(front);
		faces.add(left);
		faces.add(right);
		faces.add(back);
		faces.add(top);
		faces.add(bottom);
	}

	@Override
	public String toString() {
		StringBuilder b = new StringBuilder("==== Cube ====       [ Top  ]\n");
		b.append("               [Left][Front ][Right][Back]\n");
		b.append("                     [Bottom]\n");
		b.append("\n");

		b.append(getPaddedFace(top));
		for (int i = 0; i < 3; i++) {
			b.append(left.getRowAsString(i) + " ");
			b.append(front.getRowAsString(i) + " ");
			b.append(right.getRowAsString(i) + " ");
			b.append(back.getRowAsString(i) + "\n");

		}
		b.append(getPaddedFace(bottom));

		return b.toString();
	}

	private String getPaddedFace(Face f) {
		String padding = "                       ";
		StringBuilder b = new StringBuilder();
		for (int i = 0; i < 3; i++) {
			b.append(padding + f.getRowAsString(i) + "\n");
		}
		return b.toString();
	}

	public List<Face> getFaces() {
		return faces;
	}

	public Face getFront() {
		return front;
	}

	public Face getLeft() {
		return left;
	}

	public Face getBack() {
		return back;
	}

	public Face getRight() {
		return right;
	}

	public Face getTop() {
		return top;
	}

	public Face getBottom() {
		return bottom;
	}

}
