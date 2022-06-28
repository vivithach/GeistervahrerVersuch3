import static org.junit.Assert.assertEquals;
import org.junit.Test;
import processing.core.PApplet;

public class HerzTest {
    @Test
    public void bewegeHerzTest() {
        Herz testHerz = new Herz(new PApplet());
        testHerz.setPosY(100);
        int startPosY = testHerz.getPosY();
        int bewegeUm = 2;
        testHerz.bewegeHerz(bewegeUm);
        assertEquals(startPosY+bewegeUm,testHerz.getPosY());
    }
}
