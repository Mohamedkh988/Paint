/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint.controller;

import Paint.model.Shape;
import Paint.view.MyCanvas;
import java.awt.Point;
import java.awt.event.MouseEvent;

/**
 *
 * @author omar_
 */
public class CommandClick implements Command {
Point x;


@Override
    public void execute(MouseEvent evt, Shape element) {
                     element.setPosition(evt.getPoint());

    }
    
}
