import static org.junit.Assert.assertEquals;
import org.junit.Test;
import processing.core.PApplet;

public class GegnerAutoTest {

    @Test
    public void bewegeGegnerAutoTest() {
        GegnerAuto testAuto = new GegnerAuto(new PApplet(),25);
        testAuto.setPosY(100);
        int startPosY = testAuto.getPosY();
        int bewegeUm = 2;
        testAuto.bewegeGegnerAuto(bewegeUm);
        assertEquals(startPosY+bewegeUm*2,testAuto.getPosY());
    }
}
