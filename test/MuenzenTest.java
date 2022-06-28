import static org.junit.Assert.assertEquals;
import org.junit.Test;
import processing.core.PApplet;

import static org.junit.Assert.*;
public class MuenzenTest {
    @Test
    public void actTest() {
        Muenzen testMuenzen = new Muenzen(new PApplet());
        testMuenzen.setPosY(100);
        testMuenzen.act(2);
        assertEquals(testMuenzen.getPosY(),102);
    }
}
