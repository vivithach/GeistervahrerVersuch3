import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import processing.core.PApplet;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ModellTest extends TestCase {

    PApplet app;

    @Test
    public void testObjektDeleterGegner() {
        Modell m = new Modell(app);
        ArrayList<Object> Gegner = new ArrayList<>();
        Gegner.add(new GegenAuto(app));
        Gegner.add(new GegenAuto(app));
        m.ObjektDeleter();
        Assert.assertEquals(1, m.getGegner().size());
    }

    @Test
   public void testObjektDeleterHerz() {
       Modell m = new Modell(app);
       ArrayList<Object> Herzen = new ArrayList<>();
       Herzen.add(new Herz(app));
       Herzen.add(new Herz(app));
       m.ObjektDeleter();
       Assert.assertEquals(1, m.getHerz().size());
    }

    @Test
    public void testObjektDeleterMuenze() {
        Modell m = new Modell(app);
        ArrayList<Object> Muenzen = new ArrayList<>();
        Muenzen.add(new Muenzen(app));
        Muenzen.add(new Muenzen(app));
        m.ObjektDeleter();
        Assert.assertEquals(1, m.getMuenze().size());
    }

    @Test
    public void testObjektDeleterSpeedblock() {
        Modell m = new Modell(app);
        ArrayList<Object> Speedbloecke = new ArrayList<>();
        Speedbloecke.add(new Speedway(app));
        Speedbloecke.add(new Speedway(app));
        m.ObjektDeleter();
        Assert.assertEquals(1, m.getSpeedBlock().size());
    }

    @Test
    public void testObjektDeleterTool() {
        Modell m = new Modell(app);
        ArrayList<Object> Tools = new ArrayList<>();
        Tools.add(new Schraubenschluessel(app));
        Tools.add(new Schraubenschluessel(app));
        m.ObjektDeleter();
        Assert.assertEquals(1, m.getTool().size());
    }

//    public void testRun(){
//        Modell m = new Modell(app);
//        Speedway aktuellesspeedBlock = m.speedBlock.get(i);
//    }

//    @Test
//    public void testObjektAdderGegner(){
//        Modell m = new Modell(app);
//        m.ObjektAdder();
//        Assert.assertEquals(12, m.getGegner().size());
//    }
//
//    public void testObjektAdderHerz(){
//        Modell m = new Modell(app);
//        m.ObjektAdder();
//        Assert.assertEquals(12, m.getHerz().size());
//    }
//
//
//    public void testObjektAdderMuenze(){
//        Modell m = new Modell(app);
//        m.ObjektAdder();
//        Assert.assertEquals(12, m.getMuenze().size());
//    }
//
//
//    public void testObjektAdderSpeedblock(){
//        Modell m = new Modell(app);
//        m.ObjektAdder();
//        Assert.assertEquals(12, m.getSpeedBlock().size());
//    }
//
//
//    public void testObjektAdderTool(){
//        Modell m = new Modell(app);
//        m.ObjektAdder();
//        Assert.assertEquals(12, m.getTool().size());
//    }



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