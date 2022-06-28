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

