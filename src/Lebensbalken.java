import processing.core.PApplet;

public class Lebensbalken extends Spielelement{
    private int Leben;
    Lebensbalken(PApplet app){
        super(app);
        setPosX(20);
        setPosY(20);
        Leben = 250;
    }

    public void minusLeben(){
        Leben -=1;
    }

    public void plusLeben(){
        if(Leben < 250)
            Leben +=50;
        if(Leben > 250){
            Leben = 250;
        }
    }

    public void drawing(){
        app.stroke(255);
        app.strokeWeight(10);
        app.line(getPosX(), getPosY(), Leben,getPosY());
    }

    public int getLeben() {
        return Leben;
    }
}
