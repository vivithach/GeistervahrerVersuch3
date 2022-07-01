import processing.core.PApplet;

public class Lebensbalken extends Spielelement {
    private int leben;

    Lebensbalken(PApplet app) {
        super(app);
        setPosX(20);
        setPosY(20);
        leben = 250;
    }

    public void drawing() {
        app.stroke(255);
        app.strokeWeight(10);
        app.line(getPosX(), getPosY(), leben, getPosY());
    }

    public void minusLeben() {
        if(leben > 0) {
            leben -= 1;
        }
        if(leben <= 0){
            leben = 0;
        }
    }

    public void plusLeben() {
        if (leben < 250) {
            leben += 50;
        }
        if (leben > 250) {
            leben = 250;
        }
    }
    public int getLeben() {
        return leben;
    }

    public void setLeben(int leben) {
        this.leben = leben;
    }
}
