import processing.core.PApplet;
import processing.core.PImage;

public class Muenzen extends Spielelement{
    private String bildAdresse = "data/coin.png";
    private PImage bildMuenzen = null;

    Muenzen(PApplet app, int PosX){
        super(app);
        setPosX(PosX);
        setPosY(-50);
        setBreite(40);
        setHoehe(40);
    }

    public void drawing(){
        if(bildMuenzen == null){
            bildMuenzen = app.loadImage(bildAdresse);
        }
        app.image(bildMuenzen,getPosX(),getPosY(),getBreite(), getHoehe());
    }

    public void bewegeMuenzen(int speed){
        setPosY(getPosY()+speed);
    }
}
