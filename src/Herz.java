import processing.core.PApplet;
import processing.core.PImage;

public class Herz extends Spielelement{
    private String bildAdresse = "data/heart.png";
    private PImage bildHerz = null;

    Herz(PApplet app, int PosX){
        super(app);
        setPosX(PosX);
        setPosY(-500);
        setBreite(40);
        setHoehe(40);
    }

    public void drawing(){
        if(bildHerz == null){
            bildHerz = app.loadImage(bildAdresse);
        }
        app.image(bildHerz,getPosX(),getPosY(),getBreite(), getHoehe());
    }

    public void bewegeHerz(int speed){
        setPosY(getPosY()+speed);
    }
}
