import static org.junit.Assert.assertEquals;
import org.junit.Test;
import processing.core.PApplet;

public class SchraubenschluesselTest {
    @Test
    public void actTest() {
        Schraubenschluessel testSchraubenschluessel = new Schraubenschluessel(new PApplet());
        testSchraubenschluessel.setPosY(100);
        testSchraubenschluessel.act(2);
        assertEquals(testSchraubenschluessel.getPosY(),110);
    }
}
