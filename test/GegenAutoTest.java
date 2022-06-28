import static org.junit.Assert.assertEquals;
import org.junit.Test;
import processing.core.PApplet;

public class GegenAutoTest {

    @Test
    public void actTest() {
        GegnerAuto testAuto = new GegnerAuto(new PApplet());
        testAuto.setPosY(100);
        testAuto.bewegeGegnerAuto(2);
        assertEquals(testAuto.getPosY(),104);
    }
}
