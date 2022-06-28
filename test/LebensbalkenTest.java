import static org.junit.Assert.assertEquals;
import org.junit.Test;
import processing.core.PApplet;

public class LebensbalkenTest {

    private PApplet app;

    @Test
    public void MinusLebenTest() {
        Lebensbalken aktuellesLeben = new Lebensbalken(app);
        int startLeben = aktuellesLeben.getLeben();
        aktuellesLeben.minusLeben();
        assertEquals(startLeben-1, aktuellesLeben.getLeben());
    }

    @Test
    public void PlusLebenTest() {
        Lebensbalken aktuellesLeben = new Lebensbalken(app);
        aktuellesLeben.setLeben(180);
        int startLeben = aktuellesLeben.getLeben();
        aktuellesLeben.plusLeben();
        assertEquals(startLeben+50, aktuellesLeben.getLeben());
    }

    @Test
    public void LebenUntergrenzeTest() {
        Lebensbalken aktuellesLeben = new Lebensbalken(app);
        aktuellesLeben.setLeben(0);
        int startLeben = aktuellesLeben.getLeben();
        aktuellesLeben.minusLeben();
        assertEquals(startLeben, aktuellesLeben.getLeben());
    }

    @Test
    public void LebenObergrenzeTest() {
        Lebensbalken aktuellesLeben = new Lebensbalken(app);
        aktuellesLeben.setLeben(250);
        int startLeben2 = aktuellesLeben.getLeben();
        aktuellesLeben.plusLeben();
        assertEquals(startLeben2, aktuellesLeben.getLeben());
    }
}
