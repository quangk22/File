package quang.dev;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import quang.dev.model.Shape;

public class Manager implements IManager{
	List<Shape> shapeList = new ArrayList<>() ;
	@Override
	public void add(Shape shape) {
		// TODO Auto-generated method stub
		shapeList.add(shape);
	}

	@Override
	public void remove(Shape shape) {
		// TODO Auto-generated method stub
		for (int i = 0; i < shapeList.size(); i++) {
			if(shapeList.get(i) == shape)
				shapeList.remove(i);
		}
	}

	@Override
	public void sort() {
		// TODO Auto-generated method stub
//		Collections.sort(shapeList, new ShapeComperator());
		Collections.sort(shapeList);
	}

	@Override
	public Shape findMaxChuVi() {
		// TODO Auto-generated method stub
        Shape maxShape = null;
        double maxChuVi = 0;
        for (Shape shape : shapeList) {
            double chuVi = shape.chuVi();
            if (chuVi > maxChuVi) {
                maxChuVi = chuVi;
                maxShape = shape;
            }
        }
        return maxShape;
    }

	@Override
	public List<Shape> all() {
		// TODO Auto-generated method stub
		return shapeList;
	}

}
