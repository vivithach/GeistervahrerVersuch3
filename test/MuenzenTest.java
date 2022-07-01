import static org.junit.Assert.assertEquals;
import org.junit.Test;
import processing.core.PApplet;

public class MuenzenTest {
    @Test
    public void bewegeMuenzenTest() {
        Muenzen testMuenzen = new Muenzen(new PApplet(),25);
        testMuenzen.setPosY(100);
        int startPosY = testMuenzen.getPosY();
        int bewegeUm = 2;
        testMuenzen.bewegeMuenzen(bewegeUm);
        assertEquals(startPosY+bewegeUm,testMuenzen.getPosY());
    }
}
