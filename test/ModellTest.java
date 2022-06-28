import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import processing.core.PApplet;

import static org.junit.Assert.*;

public class ModellTest extends TestCase {

    PApplet app;

    @Test
    public void testObjektDeleterGegner() {
        Modell m = new Modell(app);
        m.ObjektDeleter();
        Assert.assertEquals(0, m.getGegner().size());
    }

    @Test
    public void testObjektAdderGegner(){
        Modell m = new Modell(app);
        m.ObjektAdder();
        Assert.assertEquals(12, m.getGegner().size());
    }

    public void testObjektDeleterHerz() {
        Modell m = new Modell(app);
        m.ObjektDeleter();
        Assert.assertEquals(0, m.getHerz().size());
    }

    public void testObjektAdderHerz(){
        Modell m = new Modell(app);
        m.ObjektAdder();
        Assert.assertEquals(12, m.getHerz().size());
    }

    public void testObjektDeleterMuenze() {
        Modell m = new Modell(app);
        m.ObjektDeleter();
        Assert.assertEquals(0, m.getMuenze().size());
    }

    public void testObjektAdderMuenze(){
        Modell m = new Modell(app);
        m.ObjektAdder();
        Assert.assertEquals(12, m.getMuenze().size());
    }

    public void testObjektDeleterSpeedblock() {
        Modell m = new Modell(app);
        m.ObjektDeleter();
        Assert.assertEquals(0, m.getSpeedBlock().size());
    }

    public void testObjektAdderSpeedblock(){
        Modell m = new Modell(app);
        m.ObjektAdder();
        Assert.assertEquals(12, m.getSpeedBlock().size());
    }

    public void testObjektDeleterTool() {
        Modell m = new Modell(app);
        m.ObjektDeleter();
        Assert.assertEquals(0, m.getTool().size());
    }

    public void testObjektAdderTool(){
        Modell m = new Modell(app);
        m.ObjektAdder();
        Assert.assertEquals(12, m.getTool().size());
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