import processing.core.PApplet;

public class Score extends Spielelement{

    private int score;

    Score(PApplet app){
        super(app);
        score = 0;
        setPosX(50);
        setPosY(50);
    }

    public void drawing(){
        app.stroke(255);
        app.textSize(20);
        app.text("Score: "+ this.score, getPosX(), getPosY());
    }

    public void erhöheScore(){
        score += 1;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}

