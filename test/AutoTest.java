import static org.junit.Assert.assertEquals;
import org.junit.Test;
import processing.core.PApplet;

import static org.junit.Assert.*;

public class AutoTest{

    PApplet app;

    @Test
    public void bewegeLinksTest() {
        Auto testAuto = new Auto(app);
        int startPosition = testAuto.getPosX();
        testAuto.setPosX(startPosition);
        testAuto.bewegeLinks();
        assertEquals(startPosition-testAuto.getBewegung(),testAuto.getPosX());
    }

    @Test
    public void bewegeLinksMitSchlüsselTest() {
        Auto testAuto = new Auto(app);
        testAuto.aendereRichtung();
        int startPosition = testAuto.getPosX();
        testAuto.setPosX(startPosition);
        testAuto.bewegeLinks();
        assertEquals(startPosition+testAuto.getBewegung(),testAuto.getPosX());
    }

    @Test
    public void bewegeRechtsTest() {
        Auto testAuto = new Auto(app);
        int startPosition = testAuto.getPosX();
        testAuto.setPosX(startPosition);
        testAuto.bewegeRechts();
        assertEquals(startPosition+testAuto.getBewegung(),testAuto.getPosX());
    }

    @Test
    public void bewegeRechtsMitSchlüsselTest() {
        Auto testAuto = new Auto(app);
        testAuto.aendereRichtung();
        int startPosition = testAuto.getPosX();
        testAuto.setPosX(startPosition);
        testAuto.bewegeRechts();
        assertEquals(startPosition-testAuto.getBewegung(),testAuto.getPosX());
    }

    @Test
    public void rechterRandTest() {
        Auto testAuto = new Auto(app);
        testAuto.setPosX(testAuto.getRandRechts());
        int startPosition = testAuto.getPosX();
        testAuto.bewegeRechts();
        assertEquals(startPosition,testAuto.getPosX());

        testAuto.setPosX(testAuto.getRandRechts()-3);
        testAuto.bewegeRechts();
        assertEquals(testAuto.getPosX(),testAuto.getRandRechts());
    }

    @Test
    public void linkerRandTest() {
        Auto testAuto = new Auto(app);
        testAuto.setPosX(testAuto.getRandLinks());
        int startPosition = testAuto.getPosX();
        testAuto.bewegeLinks();
        assertEquals(startPosition,testAuto.getPosX());

        testAuto.setPosX(testAuto.getRandRechts()+3);
        testAuto.bewegeRechts();
        assertEquals(testAuto.getPosX(),testAuto.getRandRechts());
    }

    @Test
    public void andereRichtungTest() {
        Auto testAuto = new Auto(app);
        testAuto.verkehrtherum = false;
        testAuto.aendereRichtung();
        assertEquals(testAuto.verkehrtherum,true);
        testAuto.aendereRichtung();
        assertEquals(testAuto.verkehrtherum,false);
        testAuto.aendereRichtung();
        assertEquals(testAuto.verkehrtherum,true);
    }
}