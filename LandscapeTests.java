/*
 * Sam Polyakov
 * LandscapeTests.java
 * 02/26/2023
 * Project 3
 * CS231 B
 */

 public class LandscapeTests {
    public static void main(String[] args) {
        /**
         * Testing getHeight() method
         */
        {
            Landscape landscape = new Landscape(10, 20);
            // set up
            int expectedHeight = 20;
            int actualHeight = landscape.getHeight();

            // verify
            assert expectedHeight == actualHeight: "Error in Landscape :: getHeight()";
        }

        /**
         * Testing getWidth() method
         */
        {
            Landscape landscape = new Landscape(10, 20);
            // set up
            int expectedWidth = 20;
            int actualWidth = landscape.getHeight();

            // verify
            assert expectedWidth == actualWidth : "Error in Landscape :: getWidth()";
        }

        /**
         * Testing addAgent() method
         */
        {
            // Set up
            Landscape scape = new Landscape(10, 20);
            SocialAgent agent = new SocialAgent(0.0, 0.0, 5);
            scape.addAgent(agent);

            // Test
            assert scape != null : "Error in Landscape.java :: addAgent()";
        }

        /**
         * Testing toString() method
         */
        {
            Landscape landscape = new Landscape(10, 20);
            SocialAgent agent1 = new SocialAgent(5.0, 10.0, 4);
            SocialAgent agent2 = new SocialAgent(3.0, 7.0, 3);
            landscape.addAgent(agent1);
            landscape.addAgent(agent2);
            String expectedString = "2";
            String actualString = landscape.toString();
            assert expectedString == actualString : "Error in Landscape :: toString()";
        }

        /**
         * Testing getNeighbors method
         */
        {
            Landscape landscape = new Landscape(100, 100);
            SocialAgent agent1 = new SocialAgent(50, 50, 5);
            SocialAgent agent2 = new SocialAgent(60, 60, 3);
            SocialAgent agent3 = new SocialAgent(70, 70, 2);
            landscape.addAgent(agent1);
            landscape.addAgent(agent2);
            landscape.addAgent(agent3);

            LinkedList<Agent> neighbors1 = landscape.getNeighbors(50, 50, 15);
            if (neighbors1 == null) {
                System.out.println("Error in Landscape.java :: neighbors() method");
            }

            LinkedList<Agent> neighbors2 = landscape.getNeighbors(50, 50, 25);
            if (neighbors2 == null) {
                System.out.println("Error in Landscape.java :: neighbors() method");
            }

            LinkedList<Agent> neighbors3 = landscape.getNeighbors(60, 60, 5);
            if (neighbors3 == null) {
                System.out.println("Error in Landscape.java :: neighbors() method");
            }
        }
    }
}