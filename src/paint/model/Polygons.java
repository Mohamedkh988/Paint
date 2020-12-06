package Paint.model;
import java.awt.Color;
import java.util.HashMap;

public abstract class Polygons extends Shape {
        HashMap<String , Double> hmap = new HashMap<String, Double>();
        
        public Polygons()
        {
            
        }

	float numOfSides;

	public float getNumOfSides() {
		return numOfSides;
	}

	public void setNumOfSides(float numOfSides) {
		this.numOfSides = numOfSides;
	}

}
