package Paint.model;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Map;
import java.lang.Cloneable;
import static java.lang.Math.abs;

public class Triangle extends Polygons {

	int[] x=new int [3];

	int[] y=new int [3];
    
	
	

    Color fillColor;

    public Triangle() {
        super();
    }
	

	@Override
	public void setPosition(Point position) {
		// TODO Auto-generated method stub
		this.position=position;
	}
        @Override
        public void setPosition2(Point position2) {
        this.position2 = position2;
        x[0]=(position2.x+position.x)/2;
        x[1]=position.x;
        x[2]=position2.x;
        y[0]=position.y;         
        y[1]=position2.y;
        y[2]= position2.y;
                }

	@Override
	public Point getPosition() {
		// TODO Auto-generated method stub
		return this.position;
	}

	@Override
	public void setProperties(Map<String, Double> properties) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Map<String, Double> getProperties() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setColor(Color color) {
		// TODO Auto-generated method stub
		this.color=color;
	}

	@Override
	public Color getColor() {
		// TODO Auto-generated method stub
		return this.color;
	}

	@Override
	public void setFillColor(Color color) {
		// TODO Auto-generated method stub
		this.fillColor=color;
	}

	@Override
	public Color getFillColor() {
		// TODO Auto-generated method stub
		return this.fillColor;
	}

	@Override
	public void draw(Object canvas) {
		Graphics CastedCanvas= (Graphics) canvas;
		CastedCanvas.setColor(this.color);
		CastedCanvas.fillPolygon(x, y, 3);

	}

}
