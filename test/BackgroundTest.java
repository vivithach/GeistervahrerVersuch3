import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;
import processing.core.PApplet;

public class BackgroundTest {

    @Test
    public void bewegeHintergrund1Test() {
        Background testBackground = new Background(new PApplet());
        int bewege = 2;
        int startPosition = testBackground.getPosY_hintergrundBild1();
        testBackground.bewegeHintergrund(2);
        assertEquals(startPosition + bewege, testBackground.getPosY_hintergrundBild1());
    }

    @Test
    public void bewegeHintergrund2Test() {
        Background testBackground = new Background(new PApplet());
        int bewege = 2;
        testBackground.setPosY_hintergrundBild2(100);
        int startPosition = testBackground.getPosY_hintergrundBild2();
        testBackground.bewegeHintergrund(2);
        assertEquals(startPosition + bewege, testBackground.getPosY_hintergrundBild2());
    }

    @Test
    public void holeHintergrund1ZurückTest() {
        Background testBackground = new Background(new PApplet());
        int bewege = 2;
        testBackground.setPosY_hintergrundBild1(600);
        int startPosition = testBackground.getPosY_hintergrundBild1();
        testBackground.bewegeHintergrund(2);
        assertEquals(-600, testBackground.getPosY_hintergrundBild1());
    }

    @Test
    public void holeHintergrund2ZurückTest() {
        Background testBackground = new Background(new PApplet());
        int bewege = 2;
        testBackground.setPosY_hintergrundBild2(600);
        int startPosition = testBackground.getPosY_hintergrundBild2();
        testBackground.bewegeHintergrund(2);
        assertEquals(-600, testBackground.getPosY_hintergrundBild2());
    }
}
