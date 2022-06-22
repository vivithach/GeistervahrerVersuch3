import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import processing.core.PApplet;

import static org.junit.Assert.*;

public class ModellTest extends TestCase {

    PApplet app;

    @Test
    public void testObjektDeleter() {
        Modell m = new Modell(app);
        m.ObjektDeleter();
        Assert.assertEquals(0, m.getGegner().size());
    }

    @Test
    public void testObjektAdder(){
        Modell m = new Modell(app);
        m.ObjektAdder();
        Assert.assertEquals(12, m.getGegner().size());
    }

//    public void testRun(){
//        Modell m = new Modell(app);
//        Lebensbalken l = new Lebensbalken(app);
//        l.setLeben(15);
//        m.RUN();
//        Assert.assertEquals();
//
//
//    }
}