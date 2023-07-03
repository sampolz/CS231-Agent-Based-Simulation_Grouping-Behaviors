/*
 * Sam Polyakov
 * SocialAgent.java
 * 02/26/2023
 * Project 3
 * CS231 B
 */

import java.awt.Graphics;
import java.awt.Color;
import java.util.Random;

public class SocialAgent extends Agent{
    boolean moved;
    int R;
    

    public SocialAgent(double x0, double y0, int radius) {
        // The constructor, which calls the super class constructor and sets the radius field.
        super( x0, y0 );
        R = radius;
    }

    public void setRadius(int radius){
        // sets the cell's radius of sensitivity to the value of radius.
        R = radius;
    }

    public int getRadius(){
        // returns the cell's radius of sensitivity.
        return R;
    }

    public void draw(Graphics g){
        // draws a circle of radius 5 (i.e. it fits in a 10x10 box) at the Agent's location. 
        // If the agent moved during the last updateState, it is drawn with a lighter shade of blue, otherwise a darker shade of blue.
        if(!moved){ 
            g.setColor(new Color(0, 0, 255));
        }

        else{ 
            g.setColor(new Color(125, 125, 255));
        }
    
        g.fillOval((int) getX(), (int) getY(), 5, 5);
    }

    public void updateState(Landscape scape){
        // updates the state of the social agent
        Random rand = new Random();
        LinkedList<Agent> neighbors = scape.getNeighbors(this.getX(), this.getY(), this.getRadius());

        if (neighbors.size() < 4){
            // I did nextInt like this because it was only letting me put in one parameter for nextInt for some reason
            double newXPos = xPos + rand.nextInt(10 - (-10)) + -10;
            double newYPos = yPos + rand.nextInt(10 - (-10)) + -10;

            if(newXPos < 0){
                newXPos = 0;
            }
            if(newXPos > scape.getWidth()){
                newXPos = scape.getWidth();
            }
            if(newYPos < 0){
                newYPos = 0;
            }
            if(newYPos > scape.getHeight()){
                newYPos = scape.getHeight();
            }

            this.setX(newXPos);
            this.setY(newYPos);
            moved = true;
        }
        else{
            moved = false;
        }
    }


}