/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint.controller;

import Paint.model.Shape;
import java.util.ArrayList;

/**
 *
 * @author omar_
 */
public abstract class Save {
    
    abstract void save(String path, ArrayList<Shape> shapes);
    
}
