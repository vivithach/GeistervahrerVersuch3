import processing.core.PApplet;

public class ScreenControll extends PApplet {
    void initScreen() {
        background(236, 240, 241);
        textAlign(CENTER);
        fill(52, 73, 94);
        textSize(70);
        text("Auto-Spiel", width/2, height/2);
        textSize(15);
        text("Click to start", width/2, height-30);
    }
    void gameOverScreen() {
        background(44, 62, 80);
        textAlign(CENTER);
        fill(236, 240, 241);
        textSize(12);
        text("Your Score", width/2, height/2 - 120);
        textSize(130);
        textSize(15);
        text("Click to Restart", width/2, height-30);
    }
}
