/*
 * Sam Polyakov
 * SocialAgentTests.java
 * 02/26/2023
 * Project 3
 * CS231 B
 */


 public class SocialAgentTests {
    public static void main(String[] args) {
        /**
         * Tests the setRadius method
         */
        {
            //Set up
            Landscape scape = new Landscape(10, 20);
            SocialAgent agent = new SocialAgent(0.0, 0.0, 5);

            //Verify
            System.out.println(agent.getRadius() + "== 3");

            //Test
            assert agent.getRadius() == 3 : "Error in SocialAgent::setRadius()";
        }

        /**
         * Tests the getRadius method
         */
            Landscape scape = new Landscape(10, 20);
            SocialAgent agent1 = new SocialAgent(0.0, 0.0, 8);
            SocialAgent agent2 = new SocialAgent(0.0, 0.0, 5);

            //Verify
            System.out.println(agent1.getRadius() + " == 8");
            System.out.println(agent2.getRadius() + " == 5");

            //Test
            assert agent1.getRadius() == 8 : "Error in SocialAgent::getRadius()";
            assert agent2.getRadius() == 5 : "Error in SocialAgent::getRadius()";

        /**
         * Tests the updateState method
         */
        {
            //Set up
            Landscape scape = new Landscape(100, 100);
            SocialAgent a = new SocialAgent(50, 50, 10);
            scape.addAgent(a);
        
            // Check that agent is moved if it has less than 4 neighbors
            a.updateState(scape);
            boolean iniState = a.moved;
            // System.out.println(a.moved);
        
            // Check that agent is not moved if it has 4 or more neighbors
            SocialAgent b = new SocialAgent(60, 50, 10);
            SocialAgent c = new SocialAgent(40, 50, 10);
            SocialAgent d = new SocialAgent(50, 60, 10);
            SocialAgent e = new SocialAgent(50, 40, 10);
            scape.addAgent(b);
            scape.addAgent(c);
            scape.addAgent(d);
            scape.addAgent(e);
            a.updateState(scape);
            boolean finState = a.moved;
            // System.out.println(a.moved);
            

            //Verify
            System.out.println("Initial State" + iniState);
            System.out.println("Final State" + finState);


            //Test
           assert finState == iniState: "Error in SocialAgent::updateState().";
        }
    }
}