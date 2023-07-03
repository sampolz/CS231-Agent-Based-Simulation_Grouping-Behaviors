/*
 * Sam Polyakov
 * Agent.java
 * 02/26/2023
 * Project 3
 * CS231 B
 */

import java.awt.Graphics;

public abstract class Agent{
    public double xPos;
    public double yPos;
    public Agent(double x0, double y0){
        //a constructor that sets the position.
        xPos = x0;
        yPos = y0;
    }

    public double getX(){
        //returns the x pos
        return xPos;
    }

    public double getY(){
        // returns the y pos
        return yPos;
    } 

    public void setX( double newX ){
        // sets the x pos
        xPos = newX;
    }

    public void setY( double newY ){
        // sets the y pos
        yPos = newY;
    }

    public String toString(){
        // returns a String containing the x and y positions
        return("(" + xPos + ", " + yPos + ")");
    }

    public abstract void updateState(Landscape scape);

    public abstract void draw(Graphics g);



}
