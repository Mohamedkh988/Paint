package Paint.model;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Map;
import java.lang.Cloneable;

public class Line extends Shape {





Color fillColor=super.color;

    /**
     *
     */
    public Line(){
super();
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
	public void draw(Object canvas) {
		// TODO Auto-generated method stub
		Graphics CastedCanvas= (Graphics) canvas;
		CastedCanvas.setColor(this.color);
		CastedCanvas.drawLine(position.x, position.y, position2.x, position2.y);
	}

}
