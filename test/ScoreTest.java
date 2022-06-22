import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import processing.core.PApplet;

import static org.junit.Assert.*;

public class ScoreTest  extends TestCase {

    private PApplet app;

    @Test
    public void testErhöheScore() {
        Score s = new Score(app);
        s.erhöheScore();
        Assert.assertEquals(1, s.getScore());

    }
}