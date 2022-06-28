import static org.junit.Assert.assertEquals;
import org.junit.Test;
import processing.core.PApplet;

public class GegenAutoTest {

    @Test
    public void actTest() {
        GegenAuto testAuto = new GegenAuto(new PApplet());
        testAuto.setPosY(100);
        testAuto.act(2);
        assertEquals(testAuto.getPosY(),104);
    }
}
