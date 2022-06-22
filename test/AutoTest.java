import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import processing.core.PApplet;

import static org.junit.Assert.*;

public class AutoTest extends TestCase {

    PApplet app;

    @Test
    public void testBewegeLinks() {
        Auto a = new Auto(app);
        Spielelement s = new Spielelement(app);
        s.setPosX(2);
        a.bewegeLinks();
        Assert.assertEquals(25,s.getPosX());
    }
}