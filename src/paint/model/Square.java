package Paint.model;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Map;
import java.lang.Cloneable;
import static java.lang.Math.abs;

public class Square extends Polygons {


    Color fillColor;
	float Length=abs(this.position.x-this.position2.x);

    public Square() {
super();
    }

	public float getLength() {
		return Length;
	}

	public void setLength(float length) {
		this.Length = length;
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
		public void draw(Object canvas) { //taking canvas to draw on
			// TODO Auto-generated method stub
		Graphics CastedCanvas= (Graphics) canvas;
		CastedCanvas.setColor(this.color);
		CastedCanvas.fillRect(Math.min(position.x,position2.x),Math.min(position.y,position2.y),(int)this.Length,(int)this.Length);
		}
                
                 @Override
        public void setPosition2(Point position2) {
        this.position2 = position2;
        Length=abs(this.position.x-this.position2.x);
            }
	}

