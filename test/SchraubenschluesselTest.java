import static org.junit.Assert.assertEquals;
import org.junit.Test;
import processing.core.PApplet;

public class SchraubenschluesselTest {
    @Test
    public void bewegeSchraubenschluesselTest() {
        Schraubenschluessel testSchraubenschluessel = new Schraubenschluessel(new PApplet(), 15);
        testSchraubenschluessel.setPosY(100);
        int startPosY = testSchraubenschluessel.getPosY();
        int bewegeUm = 2;
        testSchraubenschluessel.bewegeSchraubenschluessel(bewegeUm);
        assertEquals(startPosY+bewegeUm*5,testSchraubenschluessel.getPosY());
    }
}
