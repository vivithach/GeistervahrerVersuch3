import processing.core.PApplet;
import processing.core.PImage;

public class GegnerAuto extends Spielelement{
    private String BildAdresse = "data/Gegner.png";
    private PImage GegnerBild = null;

    GegnerAuto(PApplet app, int PosX){
        super(app);
        setPosX(PosX);
        setPosY(-400);
        setBreite(60);
        setHoehe(100);
    }

    public void drawing(){
        if(GegnerBild == null){
            GegnerBild = app.loadImage(BildAdresse);
        }
        app.image(GegnerBild,getPosX(),getPosY(),getBreite(), getHoehe());
    }

    public void bewegeGegnerAuto(int speed){
        setPosY(getPosY()+(speed*2));
    }
}
