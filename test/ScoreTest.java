import static org.junit.Assert.assertEquals;
import org.junit.Test;
import processing.core.PApplet;

public class ScoreTest{

    private PApplet app;

    @Test
    public void erhoeheScoreTest() {
        Score testScore = new Score(app);
        testScore.setPunkte(1);
        int startScore = testScore.getPunkte();
        testScore.erhoehePunkte();
        assertEquals(startScore+1, testScore.getPunkte());
    }
}