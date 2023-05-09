package quang.dev;

import java.util.List;

import quang.dev.model.Shape;

public interface IManager  {
	void add(Shape shape);
	void remove(Shape shape);
	List<Shape> all();
	void sort();
	Shape findMaxChuVi();
	
}
