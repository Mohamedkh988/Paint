package Paint.model;
import java.awt.Color;
import java.awt.Point;
import java.awt.Point;
import java.util.Map;

public  class Shape implements ShapeInterface ,Cloneable  {
Point position=new Point(50,50);
Point position2=new Point (120,200);
public int index;
Color color;
Map<String, Double> properties;
	
        	public Shape() {
        this.color = Color.BLUE;
                }
@Override
	public Object clone()throws CloneNotSupportedException{  // cloning object of this type
		return super.clone();  
		}   

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public Point getPosition2() {
        return position2;
    }

    public void setPosition2(Point position2) {
        this.position2 = position2;
    }

    @Override
    public void setPosition(Point position) {
       this.position=position;
    }

    @Override
    public Point getPosition() {
        return position;
    }

    @Override
    public void setProperties(Map<String, Double> properties) {
        this.properties=properties; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Map<String, Double> getProperties() {
        return properties;
    }

    @Override
    public void setColor(Color color) {
        this.color=color;
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public void setFillColor(Color color) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Color getFillColor() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void draw(Object canvas) {
        
    }

}
