package geometry;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;

public class PnlDrawing extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private ArrayList<Shape> shapes = new ArrayList<Shape>();
	
	
	public void setShapes(ArrayList<Shape> shapes) {
		this.shapes = shapes;
		
	}

	public PnlDrawing() 
	{
		
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		for(Shape s: shapes) {

			if(s.isSelected())
			{
			g.setColor(s.getC());
			s.draw(g);
			}
			else {
				s.draw(g);
			}
			
		}
				
	}
	
	public ArrayList<Shape> getShapes(){
		return shapes;
	}

	
	
}
