import processing.core.PApplet;

public class Score extends Spielelement{

    private int punkte;

    Score(PApplet app){
        super(app);
        punkte = 0;
        setPosX(50);
        setPosY(50);
    }

    public void drawing(){
        app.stroke(255);
        app.textSize(20);
        app.text("Score: "+ this.punkte, getPosX(), getPosY());
    }

    public void erhoehePunkte(){
        punkte += 1;
    }

    public int getPunkte() {
        return punkte;
    }

    public void setPunkte(int score) {
        this.punkte = score;
    }
}

