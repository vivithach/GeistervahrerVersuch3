import static org.junit.Assert.assertEquals;
import org.junit.Test;
import processing.core.PApplet;

import static org.junit.Assert.*;
public class HerzTest {
    @Test
    public void actTest() {
        Herz testHerz = new Herz(new PApplet());
        testHerz.setPosY(100);
        testHerz.act(2);
        assertEquals(testHerz.getPosY(),102);
    }
}
