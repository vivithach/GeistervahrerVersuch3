import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import processing.core.PApplet;


public class LebensbalkenTest extends TestCase {

    PApplet app;

    @Test
    public void testMinusLeben() {
        Lebensbalken l = new Lebensbalken(app);
        l.minusLeben();
        Assert.assertEquals(249, l.getLeben());
    }

    @Test
    public void testPlusLeben() {
        Lebensbalken l = new Lebensbalken(app);
        l.setLeben(180);
        l.plusLeben();
        Assert.assertEquals(230, l.getLeben());

    }
}