import static org.junit.Assert.assertEquals;
import org.junit.Test;
import processing.core.PApplet;

public class SpeedwayTest {
    @Test
    public void actTest() {
        Speedway testSpeedway = new Speedway(new PApplet());
        testSpeedway.setPosY(100);
        testSpeedway.act(2);
        assertEquals(testSpeedway.getPosY(),102);
    }
}

