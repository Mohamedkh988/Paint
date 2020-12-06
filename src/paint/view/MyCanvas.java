package Paint.view;

import Paint.model.Shape;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;

public class MyCanvas extends JPanel {
	protected ArrayList<Shape> ShapesList;
        private static MyCanvas uniqueMyCanvas;
     
        public static MyCanvas getCanvas()
    {
        if (uniqueMyCanvas==null)
            uniqueMyCanvas= new MyCanvas();
        return uniqueMyCanvas;
    }
	private MyCanvas() {
		this.ShapesList = new ArrayList<>();
		
	}
        /*public MyCanvas() {
		this.ShapesList = new ArrayList<>();
		
	}*/

	public ArrayList<Shape> getShapesList() {
		return ShapesList;
	}

        @Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for  (Shape todraw: ShapesList) {
			 todraw.draw(g);
                         System.out.println(todraw.getPosition()+"/////"+todraw.getPosition2());
		}
		
		
	}
		
		
	}
	
	
	
	

