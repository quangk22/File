package quang.dev;

import java.util.Comparator;

import quang.dev.model.Shape;

public class ShapeComperator implements Comparator<Shape> {

	@Override
	public int compare(Shape o1, Shape o2) {
		// TODO Auto-generated method stub
		if(o1.chuVi() > o2.chuVi())
			return 1;
		if(o1.chuVi() < o2.chuVi())
			return -1;
		return 0;
	}

}
