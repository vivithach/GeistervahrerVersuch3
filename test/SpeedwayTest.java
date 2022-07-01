import static org.junit.Assert.assertEquals;
import org.junit.Test;
import processing.core.PApplet;

public class SpeedwayTest {
    @Test
    public void actTest() {
        Speedway testSpeedway = new Speedway(new PApplet(), 15);
        testSpeedway.setPosY(100);
        int startPosY = testSpeedway.getPosY();
        int bewegeUm = 2;
        testSpeedway.bewegeSpeedway(bewegeUm);
        assertEquals(startPosY+bewegeUm,testSpeedway.getPosY());
    }
}

