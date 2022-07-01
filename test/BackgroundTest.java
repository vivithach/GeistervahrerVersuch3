import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;
import processing.core.PApplet;

public class BackgroundTest {

    @Test
    public void bewegeHintergrund1Test() {
        Background testBackground = new Background(new PApplet());
        int bewegeUm = 2;
        int startPosition = testBackground.getPosY_hintergrundbild1();
        testBackground.bewegeHintergrund(2);
        assertEquals(startPosition + bewegeUm, testBackground.getPosY_hintergrundbild1());
    }

    @Test
    public void bewegeHintergrund2Test() {
        Background testBackground = new Background(new PApplet());
        int bewegeUm = 2;
        testBackground.setPosY_hintergrundbild2(100);
        int startPosition = testBackground.getPosY_hintergrundbild2();
        testBackground.bewegeHintergrund(2);
        assertEquals(startPosition + bewegeUm, testBackground.getPosY_hintergrundbild2());
    }

    @Test
    public void holeHintergrund1ZurückTest() {
        Background testBackground = new Background(new PApplet());
        int bewegeUm = 2;
        testBackground.setPosY_hintergrundbild1(600);
        int startPosition = testBackground.getPosY_hintergrundbild1();
        testBackground.bewegeHintergrund(2);
        assertEquals(-600, testBackground.getPosY_hintergrundbild1());
    }

    @Test
    public void holeHintergrund2ZurückTest() {
        Background testBackground = new Background(new PApplet());
        int bewegeUm = 2;
        testBackground.setPosY_hintergrundbild2(600);
        int startPosition = testBackground.getPosY_hintergrundbild2();
        testBackground.bewegeHintergrund(2);
        assertEquals(-600, testBackground.getPosY_hintergrundbild2());
    }
}
