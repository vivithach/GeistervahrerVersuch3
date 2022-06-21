public class Score extends Spielelement{

    private int score;

    Score(){
        score = 0;
        setPosX(50);
        setPosY(50);
    }

    void drawing(){
        stroke(255);
        textSize(20);
        text("Score: "+ this.score, getPosX(), getPosY());
    }

    void erhöheScore(){
        score += 1;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}

