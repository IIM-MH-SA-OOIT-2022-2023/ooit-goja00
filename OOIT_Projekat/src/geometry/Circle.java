package geometry;

import java.awt.Graphics;

public class Circle extends Shape {

	protected Point center;
	protected int radius;
	
	public double area() {
		return radius*radius*Math.PI;
	}
	
	public double circumference() {
		return radius*2*Math.PI;
	}
	
	public Circle() {
		
	}
	
	public Circle(Point center, int radius) {
		this.center = center;
		this.radius = radius;
	}
	
	public Circle(Point center, int radius, boolean selected) {
		this(center,radius);
		this.selected = selected;
	}
	
	public boolean contains(int x, int y) {
		return (center.distance(x,y)<= radius);
	}
	
	public boolean contains(Point p) {
		return contains(p.getX(), p.getY());
	}
	
	@Override
	public String toString() {
		return "Center: " + center + ", radius: " + radius;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Circle) {
			Circle temp = (Circle)obj;
			if(this.center.equals(temp.getCenter()) &&
					this.radius == temp.getRadius()) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public void draw(Graphics g) {
		g.drawOval(center.getX()-radius, center.getY()-radius,
				radius*2, radius*2);
	}
	
	@Override
	public void moveTo(int x, int y) {
		center.moveTo(x, y);
		
		
	}

	@Override
	public void moveBy(int byX, int byY) {
		center.moveBy(byX, byY);
		
	}
	
	@Override
	public int compareTo(Object o) {
		if(o instanceof Circle) {
			Circle temp = (Circle)o;
			return ((int)(this.area() - temp.area()));
		}
		return 0;
	}
	
	public Point getCenter() {
		return center;
	}
	public void setCenter(Point center) {
		this.center = center;
	}
	public int getRadius() {
		return radius;
	}
	public void setRadius(int radius) throws Exception {
		if(radius ==0 || radius<0) {
			throw new Exception("Unet je los radius");
		}else {
			this.radius = radius;
		}
	}

	
}
