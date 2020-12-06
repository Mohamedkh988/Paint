/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint.controller;

import Paint.model.Line;
import Paint.model.Shape;
import java.awt.Color;
import java.awt.Point;
import java.io.*;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;
import org.jdom2.*;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import paint.model.*;
/**
 *
 * @author omar_
 */
public class SaveXML extends Save {

    @Override
    void save(String path, ArrayList<Shape> shapes) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    void saveXML(String path, ArrayList <Shape> shapes) {
          try{
       Document doc = new Document();
       doc.setRootElement(new Element("shapes",  Namespace.getNamespace("https://www.journaldev.com/shapes")) {});
       for(Shape s : shapes)
       {
           Element shape=new Element("shape") ;
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
           shape.addContent(new Element("x1").setText(""+s.getPosition().x));
           shape.addContent(new Element("y1").setText(""+s.getPosition().y));
           shape.addContent(new Element("x2").setText(""+s.getPosition2().x));
           shape.addContent(new Element("y2").setText(""+s.getPosition2().y));
           shape.addContent(new Element("red").setText(""+s.getColor().getRed()));
           shape.addContent(new Element("green").setText(""+s.getColor().getGreen()));
           shape.addContent(new Element("blue").setText(""+s.getColor().getBlue()));
           doc.getRootElement().addContent(shape);
       }
          }
          catch (Exception e){
           e.printStackTrace();
       }
          }
    }
    

