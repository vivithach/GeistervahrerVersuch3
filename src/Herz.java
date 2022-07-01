import processing.core.PApplet;
import processing.core.PImage;

public class Herz extends Spielelement{
    private String BildAdresse = "data/heart.png";
    private PImage BildHerz = null;

    Herz(PApplet app, int PosX){
        super(app);
        setPosX(PosX);
        setPosY(-500);
        setBreite(40);
        setHöhe(40);
    }

    public void drawing(){
        if(BildHerz == null){
            BildHerz = app.loadImage(BildAdresse);
        }
        app.image(BildHerz,getPosX(),getPosY(),getBreite(),getHöhe());
    }

    public void bewegeHerz(int speed){
        setPosY(getPosY()+speed);
    }
}
