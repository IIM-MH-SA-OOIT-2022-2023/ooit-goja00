package geometry;

import java.awt.Graphics;

public class Donut extends Circle {

	private int innerRadius;
	
	public Donut() {
		super();
	}
	
	public Donut(Point center, int radius,int innerRadius) {
		super(center,radius);
		this.innerRadius = innerRadius;
	}
	
	public Donut(Point center, int radius,int innerRadius, boolean selected) {
		this(center,radius,innerRadius);
		this.selected = selected;
	}

	@Override
	public double area() {
		return super.area() - innerRadius*innerRadius*Math.PI;
	}
	
	@Override
	public String toString() {
		return super.toString() + ", inner radius: " + innerRadius;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Donut) {
			Donut temp = (Donut)obj;
			if(this.center.equals(temp.getCenter()) &&
					this.radius == temp.getRadius() &&
					this.innerRadius == temp.getInnerRadius()) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public boolean contains(int x, int y) {
		return super.contains(x, y) &&
				this.center.distance(x, y)>=innerRadius;
	}
	
	@Override
	public void draw(Graphics g) {
		super.draw(g);
		g.drawOval(center.getX()-innerRadius, center.getY()-innerRadius,
				innerRadius*2, innerRadius*2);
	}
	
	public boolean contains(Point p) {
		return contains(p.getX(),p.getY());
	}

	public int getInnerRadius() {
		return innerRadius;
	}
	public void setInnerRadius(int innerRadius) {
		this.innerRadius = innerRadius;
	}
	
	
}
