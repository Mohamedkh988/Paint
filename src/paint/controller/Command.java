/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint.controller;

import Paint.model.Shape;


/**
 *
 * @author omar_
 */
public interface Command {
    public void execute(java.awt.event.MouseEvent evt,Shape element);
    
}
