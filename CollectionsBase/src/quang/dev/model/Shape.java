package quang.dev.model;

public abstract class Shape implements Comparable<Shape> {
	public abstract double chuVi();
	public abstract double dienTich();
	
	@Override
	public int compareTo(Shape o) {
		// TODO Auto-generated method stub
		if(this.chuVi() > o.chuVi())
			return 1;
		if(this.chuVi() < o.chuVi())
			return -1;
		return 0;
	}
}
