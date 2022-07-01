import processing.core.PApplet;

public class Spiel extends PApplet {

    private Modell modell;

    public void settings() {
        size(600, 600);
    }

    public void setup(){
        modell = new Modell(this);
    }

    public void draw(){

        if (modell.gameScreen == GameScreen.START_SCREEN) {
            modell.screen.initScreen();
        } else if (modell.gameScreen == GameScreen.GAME_SCREEN) {
            modell.RUN();
            steuerungSpielerAuto();
        } else if (modell.gameScreen == GameScreen.GAMEOVER_SCREEN) {
            modell.screen.gameOverScreen(modell.score.getScore());
        }
    }

    public void steuerungSpielerAuto() {
        if (keyPressed) {
            if (key == 'a' || keyCode == LEFT) {
                modell.spieler.bewegeAutoNachLinks();
            }
            else if ((key == 'b' || keyCode == RIGHT))
            {
                modell.spieler.bewegeAutoNachRechts();
            }
        }
    }


    public void mousePressed() {
        if (modell.gameScreen==GameScreen.START_SCREEN) {
            modell.startGame();
        }
    }


    public static void main(String[] args) {
        String[] params = {"Processing Spiel"};
        PApplet.runSketch(params, new Spiel());
    }
}

