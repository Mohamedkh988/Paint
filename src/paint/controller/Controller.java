package Paint.controller;

//import paint.control.*;
import Paint.model.Circle;
import Paint.model.Elliptical;
import Paint.model.Line;
import Paint.model.Rectangle;
import java.awt.Component;
import java.util.List;
import Paint.model.Shape;
import Paint.model.Square;
import Paint.model.Triangle;
import Paint.view.MyCanvas;
import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.text.Document;
import javax.xml.bind.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import paint.view.view;

import java.io.File;
import java.io.FileOutputStream;
import java.text.Format;
import java.util.ArrayList;
import javax.swing.event.DocumentListener;
import javax.swing.event.UndoableEditListener;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Position;
import javax.swing.text.Segment;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import jdk.internal.org.xml.sax.SAXException;
import org.jdom2.JDOMException;
import org.jdom2.Namespace;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.XMLOutputter;
import org.json.simple.parser.ParseException;
import org.w3c.dom.Attr;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
//import org.w3c.dom.Document;
//import org.w3c.dom.Element;


public class Controller implements DrawingEngine {
    //CommandClick click;
    //CommandRelease release;
    private static Controller uniqueController;
    private Controller(){  };
    //private Save save=null;
    public static Controller getController()
    {
        if (uniqueController==null)
            uniqueController= new Controller();
        return uniqueController;
    }
    MyCanvas canvas;  //canvas passed by view to model then returned

    public void setCanvas(MyCanvas canvas) {
        this.canvas = canvas;
    }

    @Override
    public void refresh(Object canvas) {
        this.canvas.paintComponent(this.canvas.getGraphics());

    }

    @Override
    public void addShape(Shape shape) {
        this.canvas.getShapesList().add(shape);

    }

    @Override
    public void removeShape(Shape shape) {
        // TODO Auto-generated method stub

        canvas.remove(shape.index);

    }

    @Override
    public void updateShape(Shape oldShape, Shape newShape) {
        // TODO Auto-generated method stub

    }

    @Override
    public Shape[] getShapes() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void undo() {
        // TODO Auto-generated method stub
        //canvas.remove(index); //last index of shapes added 	
    }

    @Override
    public void redo() {
        // TODO Auto-generated method stub

    }

    @Override
    public void save(String path) {
        if (path.endsWith(".xml"))
        saveXML(path);
        else if(path.endsWith(".json"))
            SaveJson(path);
        }

    @Override
    public void load(String path) {
            
        if (path.endsWith(".json"))
            try {
                loadJSON(path);
        } catch (IOException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        else if (path.endsWith(".xml"))
            try {
                loadXML(path);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JDOMException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        else JOptionPane.showMessageDialog(null, "Please select JSON or XML file");
        return;
        

    }

   /* @Override
    public void load(String path) {
        // TODO Auto-generated method stub

    }*/

    @Override
    public List<Class<? extends Shape>> getSupportedShapes() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void installPluginShape(String jarPath) {
        // TODO Auto-generated method stub

    }

    public Shape factory(String type) {
        Shape s = new Shape();
        if (type.equals("circle")) {
            return new Circle();
        }
        else if (type.equals("elliptical")) {
            return new Elliptical();
        }
        else if (type.equals("line")) {
            return new Line();
        }
        else if (type.equals("rectangle")) {
            return new Rectangle();
        }
        else if (type.equals("square")) {
            return new Square();
        }
        else if (type.equals("triangle")) {
            return new Triangle();
        } 
        else {
            return null;
        }
    }
    
    private void loadJSON(String path) throws FileNotFoundException, IOException, ParseException
    {
       JSONParser parser = new JSONParser();
        //ArrayList listOfShapes=new ArrayList<>();
        //ArrayList shapesNames=new ArrayList<>();
        File file=new File(path);
                    try {
                        Object obj = parser.parse(new FileReader(file));
                        JSONObject shapes= (JSONObject) obj;
                        for (Object shapeKey:shapes.keySet())
                        {
                            Shape s=null;
                            Point position1 = new Point(0,0);
                            Point position2= new Point(0,0);
                            int red,blue,green;
                            String shapeskey=(String)shapeKey;
                            JSONObject shapeJSONObject=(JSONObject) shapes.get(shapeskey);
                            if(shapeJSONObject.get("type").equals("circle"))
                               s=new Circle();
                            else if(shapeJSONObject.get("type").equals("elliptical"))
                               s=new Elliptical();
                            else if(shapeJSONObject.get("type").equals("triangle"))
                               s=new Triangle();
                            else if(shapeJSONObject.get("type").equals("rectangle"))
                               s=new Rectangle();
                            else if(shapeJSONObject.get("type").equals("square"))
                               s=new Square();
                            else if(shapeJSONObject.get("type").equals("line"))
                               s=new Line();
                            position1.x=Integer.parseInt((String) shapeJSONObject.get("x1"));
                            System.out.println(shapeJSONObject.get("x1"));
                            position1.y=Integer.parseInt((String) shapeJSONObject.get("y1"));
                            position2.x=Integer.parseInt((String) shapeJSONObject.get("x2"));
                            position2.y=Integer.parseInt((String) shapeJSONObject.get("y2"));
                            green=Integer.parseInt((String) shapeJSONObject.get("green"));
                            blue=Integer.parseInt((String) shapeJSONObject.get("blue"));
                            red=Integer.parseInt((String) shapeJSONObject.get("red"));
                            s.setPosition(position1);
                            s.setPosition2(position2);
                            Color c=new Color(red,green,blue);
                            s.setColor(c);
                            canvas.getShapesList().add(s);
                        }
                        } catch (FileNotFoundException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            } catch (org.json.simple.parser.ParseException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void loadXML(String path) throws ParserConfigurationException, JDOMException, IOException
    {
        SAXBuilder builder = new SAXBuilder();
        try{
        org.jdom2.Document xmlReader = builder.build(new File(path));
         org.jdom2.Element root = xmlReader.getRootElement();
            Shape shape;
            for (org.jdom2.Element element : root.getChildren()){
                System.out.println(element.getAttributeValue("type"));
                 shape = factory((String)element.getAttributeValue("type"));
                 System.out.println(element.getName());
                int red,green,blue;
                Point position1=new Point(0,0);
                Point position2=new Point(0,0);
                position1.x=Integer.parseInt(element.getChildText("x1"));
                position1.y=Integer.parseInt(element.getChildText("y1"));
                position2.x=Integer.parseInt(element.getChildText("x2"));
                position2.y=Integer.parseInt(element.getChildText("y2"));
                red=Integer.parseInt(element.getChildText("red"));
                green=Integer.parseInt(element.getChildText("green"));
                blue=Integer.parseInt(element.getChildText("blue"));
                System.out.println(blue);
                Color c= new Color(red,green,blue);
                System.out.println(c);
                shape.setColor(c);
                shape.setPosition(position1);
                shape.setPosition2(position2);
                canvas.getShapesList().add(shape);}}
                catch (JDOMException e) {
        }
        catch (IOException e) {
            // TODO Auto-generated catch block

        }
            
      /* File fXmlFile = new File(path);
	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	Document doc = dBuilder.parse(fXmlFile); 
        doc.getDocumentElement().normalize();
        NodeList nList = doc.getElementsByTagName("shape");
        for (int temp = 0; temp < nList.getLength(); temp++){
            Node nNode = nList.item(temp);
            Element eElement = (Element) nNode;
            String Type=eElement.getAttribute("type");
            Shape x=factory(Type);
            x.setPosition(eElement.getElementsByTagName("position1").item(0).getTextContent());
            x.setColor(eElement.getElementsByTagName("color").item(0).getTextContent());
            x.setPosition2(eElement.getElementsByTagName("position2").item(0).getTextContent());
         canvas.getShapesList().add(x);   
        }*/
        /*org.jdom2.Document jdomDoc;
        try {
            //we can create JDOM Document from DOM, SAX and STAX Parser Builder classes
            jdomDoc = useDOMParser(path);
            Element root = jdomDoc.getRootElement();
            List<Element> empListElements = root.getChildren("shape");
            for (Element empElement : empListElements) {
                Shape s = Factory(empElement.getAttributeValue("type"));
                Point position1 = new Point(0,0);
                Point position2 = new Point(0,0);
                int red,blue,green;
                position1.x=Integer.parseInt((String)empElement.getAttributeValue("x1"));
                position1.y=Integer.parseInt((String)empElement.getAttributeValue("y1"));
                position2.x=Integer.parseInt((String)empElement.getAttributeValue("x2"));
                position2.y=Integer.parseInt((String)empElement.getAttributeValue("y2"));
                red=Integer.parseInt((String)empElement.getAttributeValue("red"));
                green=Integer.parseInt((String)empElement.getAttributeValue("green"));
                blue=Integer.parseInt((String)empElement.getAttributeValue("blue"));
                Color c = new Color(red,green,blue);
                s.setColor(c);
                s.setPosition(position1);
                s.setPosition2(position2);
                canvas.getShapesList().add(s);
                
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        
        
    }
    
    public void saveXML(String path)
    {
        try{
       org.jdom2.Document doc = new org.jdom2.Document();
       org.jdom2.Element root = new org.jdom2.Element("shapesList");
       //doc.setRootElement(new org.jdom2.Element("shapes",  Namespace.getNamespace("https://www.journaldev.com/shapes")) {});
       doc.setRootElement(root);
       for(Shape s : canvas.getShapesList())
       {
           org.jdom2.Element shape=new org.jdom2.Element("shape") ;
           if(s instanceof Circle)
           shape.setAttribute("type","circle");
           else if(s instanceof Triangle)
           shape.setAttribute("type","triangle");
           else if(s instanceof Elliptical)
           shape.setAttribute("type","elliptical");
           else if(s instanceof Rectangle)
           shape.setAttribute("type","rectangle");
           else if(s instanceof Square)
           shape.setAttribute("type","square");
           else if(s instanceof Line)
           shape.setAttribute("type","line");
           shape.addContent(new org.jdom2.Element("x1").setText(""+s.getPosition().x));
           shape.addContent(new org.jdom2.Element("y1").setText(""+s.getPosition().y));
           shape.addContent(new org.jdom2.Element("x2").setText(""+s.getPosition2().x));
           shape.addContent(new org.jdom2.Element("y2").setText(""+s.getPosition2().y));
           shape.addContent(new org.jdom2.Element("red").setText(""+s.getColor().getRed()));
           shape.addContent(new org.jdom2.Element("green").setText(""+s.getColor().getGreen()));
           shape.addContent(new org.jdom2.Element("blue").setText(""+s.getColor().getBlue()));
           doc.getRootElement().addContent(shape);
       }
       XMLOutputter xmlOutput = new XMLOutputter(org.jdom2.output.Format.getPrettyFormat());
           xmlOutput.output(doc, new FileOutputStream(new File(path)));
          }
          catch (Exception e){
           e.printStackTrace();
       }
    }
    
    
    /*private static org.jdom2.Document useDOMParser(String fileName)
            throws ParserConfigurationException, SAXException, IOException {
        //creating DOM Document
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(new File(fileName));
        DOMBuilder domBuilder = new DOMBuilder();
        return domBuilder.build(doc);

    }*/
    
    
    
    void SaveJson(String path){
        int counter =0;
        JSONObject shapesList = new JSONObject();
                       for  (Shape shape: canvas.getShapesList()) {
                           JSONObject element = new JSONObject();
                           if(shape instanceof Circle)
                           {
                               element.put("type", "circle");
                              
                           }
                           else if (shape instanceof Elliptical)
                           {
                               element.put("type", "elliptical");
                               
                           }
                           else if (shape instanceof Line)
                           {
                               element.put("type", "line");
                               
                           }
                           else if (shape instanceof Square)
                           {
                               element.put("type", "square");
                               
                           }
			   else if (shape instanceof Rectangle)
                           {
                               element.put("type", "rectangle");
                               
                           }
                           if(shape instanceof Triangle)
                           {
                               element.put("type", "triangle");
                               
                           }
                            element.put("x1", ""+shape.getPosition().x);
                            element.put("y1", ""+shape.getPosition().y);
                            element.put("x2", ""+shape.getPosition2().x);
                            element.put("y2", ""+shape.getPosition2().y);
                            //element.put("Color", shape.getColor());
                            element.put("blue",""+shape.getColor().getBlue());
                            element.put("red",""+shape.getColor().getRed());
                            element.put("green",""+shape.getColor().getGreen());
                            //element.put("FillColor", shape.getFillColor());
                            shapesList.put(counter,element);
                            counter++;
		}
                try (FileWriter file = new FileWriter(path)) {
 
                    file.write(shapesList.toJSONString());
                    file.flush();

                } catch (IOException e) {
                    e.printStackTrace();
        }
    }
}
