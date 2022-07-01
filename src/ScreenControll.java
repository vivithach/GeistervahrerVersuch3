import processing.core.PApplet;

public class ScreenControll {

    private PApplet app;

    public ScreenControll(PApplet app) {
        this.app = app;
    }

    public void initScreen() {
        app.background(236, 240, 241);
        app.textAlign(app.CENTER);
        app.fill(52, 73, 94);
        app.textSize(70);
        app.text("Auto-Spiel", app.width/2, app.height/2);
        app.textSize(15);
        app.text("Click to start", app.width/2, app.height-30);
    }
    public void gameOverScreen(int Score) {
        app.background(44, 62, 80);
        app.textAlign(app.CENTER);
        app.fill(236, 240, 241);
        app.textSize(75);
        app.text("Game Over!", app.width/2, app.height/2 -75);
        app.textSize(25);
        app.text("Your Score", app.width/2, app.height/2 );
        app.textSize(100);
        app.text(Score,app.width/2, app.height/2 + 120);
    }
}
