import processing.core.PApplet;
import processing.core.PImage;

public class Muenzen extends Spielelement{
    private String BildAdresse = "data/coin.png";
    private PImage BildMuenzen = null;

    Muenzen(PApplet app, int PosX){
        super(app);
        setPosX(PosX);
        setPosY(-50);
        setBreite(40);
        setHöhe(40);
    }

    public void drawing(){
        if(BildMuenzen == null){
            BildMuenzen = app.loadImage(BildAdresse);
        }
        app.image(BildMuenzen,getPosX(),getPosY(),getBreite(),getHöhe());
    }

    public void bewegeMuenzen(int speed){
        setPosY(getPosY()+speed);
    }
}
