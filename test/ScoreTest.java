import static org.junit.Assert.assertEquals;
import org.junit.Test;
import processing.core.PApplet;

public class ScoreTest{

    private PApplet app;

    @Test
    public void erhoeheScoreTest() {
        Score testScore = new Score(app);
        testScore.setScore(1);
        int startScore = testScore.getScore();
        testScore.erhöheScore();
        assertEquals(startScore+1, testScore.getScore());
    }
}