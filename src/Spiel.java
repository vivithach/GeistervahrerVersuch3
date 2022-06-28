import processing.core.PApplet;


public class Spiel extends PApplet {

    Modell modell;


    public void settings() {
        size(600, 600);
    }

    public void setup(){
        modell = new Modell(this);
    }
    public void draw(){
        if (modell.gameScreen == GameScreen.START_SCREEN) {
            modell.Screen.initScreen();
        } else if (modell.gameScreen == GameScreen.GAME_SCREEN) {
            modell.RUN();
            steuerungSpielerAuto();
        } else if (modell.gameScreen == GameScreen.GAMEOVER_SCREEN) {
            modell.Screen.initScreen();
        }
    }

    void steuerungSpielerAuto() {
        if (keyPressed) {
            if (key == 'a' || keyCode == LEFT) {
                modell.Spieler.bewegeAutoNachLinks();
            }
            else if ((key == 'b' || keyCode == RIGHT))
            {
                modell.Spieler.bewegeAutoNachRechts();
            }
        }
    }



    public void mousePressed() {
        if (modell.gameScreen==GameScreen.START_SCREEN) {
            modell.startGame();
        }
        if (modell.gameScreen==GameScreen.GAMEOVER_SCREEN) {
            //restart();
        }
    }


    public static void main(String[] args) {
        String[] params = {"Processing Spiel"};
        PApplet.runSketch(params, new Spiel());
    }
}

