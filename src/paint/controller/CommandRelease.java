/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint.controller;

import Paint.model.Shape;
import java.awt.Point;
import java.awt.event.MouseEvent;

/**
 *
 * @author omar_
 */
public class CommandRelease implements Command {

    @Override
    public void execute(MouseEvent evt, Shape element) {
                     element.setPosition2(evt.getPoint());
    }


    }
    

