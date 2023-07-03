/*
 * Sam Polyakov
 * Landscape.java
 * 02/26/2023
 * Project 3
 * CS231 B
 */

import java.awt.Graphics;

public class Landscape {
    int width;
    int height;
    private LinkedList<Agent> agents;

    public Landscape(int w, int h){
        //a constructor that sets the width and height fields, and initializes the agent list.
        width = w;
        height = h;
        agents = new LinkedList<Agent>();
    }

    public int getHeight(){
        //returns the height.
        return height;
    }

    public int getWidth(){
        //returns the width.
        return width;
    }

    public void addAgent( Agent a ){
        // inserts an agent at the beginning of its list of agents.
        agents.add(a);
    }

    public String toString(){
        //returns a String representing the Landscape
        return "Number of agents: " + agents.size();
    }

    public LinkedList<Agent> getNeighbors(double x0, double y0, double radius){
        // returns a list of the Agents within radius distance of the location x0, y0.
        LinkedList<Agent> neighbors = new LinkedList<Agent>();
        for (Agent a : agents) {
            double xCor = a.getX();
            double yCor = a.getY();
            double distance = Math.sqrt(Math.pow(xCor - x0, 2) + Math.pow(yCor - y0, 2));
            if (distance <= radius) {
                neighbors.add(a);
            }
        }
        return neighbors;
    }

    public void draw(Graphics g){
        //Calls the draw method of all the agents on the Landscape.
        for (Agent a : agents) {
            a.draw(g);
        }
    }

    public void updateAgents(){
        // updates the state of each agent
        for(Agent a : agents){
            a.updateState(this);
        }
    }

}
