package Paint.model;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Map;
import java.lang.Cloneable;
import static java.lang.Math.abs;
public class Elliptical extends Shape {



	float major=(float) (abs(this.position.x-this.position2.x));
	float minor=(float) (abs(this.position.y-this.position2.y));
        Color fillColor;

    public Elliptical() {
super();    }
	public void setMajor(float major) {
		this.major = major;
	}

	public void setMinor(float minor) {
		this.minor = minor;
	}
	

	public float getMajor() {
		return major;
	}

	public float getMinor() {
		return minor;
	}

	@Override
	public void setPosition(Point position) {
		// TODO Auto-generated method stub
		this.position=position;
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
        public void setPosition2(Point position2) {
        this.position2 = position2;
        major=(float) (abs(this.position.x-this.position2.x));
	minor=(float) (abs(this.position.y-this.position2.y));
        }


	@Override
	public void draw(Object canvas) {
		Graphics CastedCanvas= (Graphics) canvas;
		CastedCanvas.setColor(this.color);
		CastedCanvas.fillOval(Math.min(position.x,position2.x),Math.min(position.y,position2.y),(int) major,(int) minor);
				
	}

}
