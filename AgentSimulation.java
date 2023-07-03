/*
 * Sam Polyakov
 * AgentSimulation.java
 * 02/26/2023
 * Project 3
 * CS231 B
 */


import java.util.Random;
import java.util.Scanner;

public class AgentSimulation {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter landscape dimensions, number of agents, and radius (eg: 500 500 200 25): ");

        int xDim = scanner.nextInt();
        int yDim = scanner.nextInt();
        int numAgents = scanner.nextInt()/2;
        int radius = scanner.nextInt();

        Landscape scape = new Landscape(xDim, yDim);
        Random gen = new Random();

        // Creates 100 SocialAgents and 100 AntiSocialAgents
        for (int i = 0; i < numAgents; i++) {
            scape.addAgent(new SocialAgent(gen.nextDouble() * scape.getWidth(), gen.nextDouble() * scape.getHeight(), radius));
            scape.addAgent(new AntiSocialAgent(gen.nextDouble() * scape.getWidth(), gen.nextDouble() * scape.getHeight(), radius));
        }

        LandscapeDisplay display = new LandscapeDisplay(scape);

        for(int i = 0; i <300; i++){
            Thread.sleep(10);
            scape.updateAgents();
            display.repaint();
        }
    }
}
