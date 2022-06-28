import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import processing.core.PApplet;

import static java.nio.file.Files.size;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import processing.core.PApplet;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ModellTest{
    PApplet app;

    @Test
    public void testHerzDeleter() {
        Modell m = new Modell(app);
        m.herz.add(new Herz(app));
        m.herz.add(new Herz(app));
        m.herz.add(new Herz(app));

        assertEquals(3,m.herz.size());

        Herz AktuellesHerz = m.herz.get(0);
        AktuellesHerz.setPosY(800);
        m.HerzDeleter();
        assertEquals(2,m.herz.size());
    }

    @Test
    public void testMuenzDeleter() {
        Modell m = new Modell(app);
        m.muenze.add(new Muenzen(app));
        m.muenze.add(new Muenzen(app));
        m.muenze.add(new Muenzen(app));

        assertEquals(3,m.muenze.size());

        Muenzen AktuelleMuenze = m.muenze.get(0);
        AktuelleMuenze.setPosY(800);
        m.MuenzDeleter();
        assertEquals(2,m.muenze.size());

    }

    @Test
    public void testToolDeleter() {
        Modell m = new Modell(app);
        m.Tool.add(new Schraubenschluessel(app));
        m.Tool.add(new Schraubenschluessel(app));
        m.Tool.add(new Schraubenschluessel(app));

        assertEquals(3,m.Tool.size());

        Schraubenschluessel AktuellerSchraubenschlüssel = m.Tool.get(0);
        AktuellerSchraubenschlüssel.setPosY(800);
        m.ToolDeleter();
        assertEquals(2,m.Tool.size());
    }

    @Test
    public void AutoDeleterTest() {
        Modell testModell = new Modell(app);
        testModell.Gegner.add(new GegenAuto(app));
        testModell.Gegner.add(new GegenAuto(app));
        testModell.Gegner.add(new GegenAuto(app));

        assertEquals(3,testModell.Gegner.size());

        GegenAuto AktuellesAuto = testModell.Gegner.get(0);
        AktuellesAuto.setPosY(600);
        testModell.AutoDeleter();
        assertEquals(3,testModell.Gegner.size());

        GegenAuto AktuellesAuto2 = testModell.Gegner.get(0);
        AktuellesAuto2.setPosY(800);
        testModell.AutoDeleter();
        assertEquals(2,testModell.Gegner.size());

        testModell.AutoDeleter();
        assertEquals(2,testModell.Gegner.size());

        GegenAuto AktuellesAuto3 = testModell.Gegner.get(0);
        AktuellesAuto3.setPosY(800);
        testModell.AutoDeleter();
        assertEquals(1,testModell.Gegner.size());
    }
}

