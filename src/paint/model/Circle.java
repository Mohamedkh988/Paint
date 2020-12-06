package Paint.model;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import static java.lang.Math.abs;

public class Circle extends Elliptical {



	float radius=(float) Math.hypot(this.position.x-this.position2.x, this.position.y-this.position2.y);

    public Circle() {
        super();    }


	public float getRadius() {
		return radius;
	}


	public void setRadius(float radius) {
		this.radius = radius;
	}

     @Override
	public void draw(Object canvas) {
		Graphics CastedCanvas= (Graphics) canvas;
		CastedCanvas.setColor(this.color);
		CastedCanvas.fillOval(Math.min(position.x,position2.x),Math.min(position.y,position2.y),(int) radius,(int) radius);
				
	}
        
        @Override
        public void setPosition2(Point position2) {
        this.position2 = position2;
        radius=(float) Math.hypot(this.position.x-this.position2.x, this.position.y-this.position2.y);
    }

}
