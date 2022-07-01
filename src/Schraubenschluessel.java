import processing.core.PApplet;
import processing.core.PImage;

public class Schraubenschluessel extends Spielelement{
    private String BildAdresse = "data/Schraubenschlüssel.png";
    private PImage BildSchraubenschluessel = null;

    Schraubenschluessel(PApplet app, int PosX){
        super(app);
        setPosX(PosX);
        setPosY(-100);
        setBreite(90);
        setHoehe(40);
    }

    public void drawing(){
        if(BildSchraubenschluessel == null){
            BildSchraubenschluessel = app.loadImage(BildAdresse);
        }
        app.image(BildSchraubenschluessel,getPosX(),getPosY(),getBreite(), getHoehe());
    }

    public void bewegeSchraubenschluessel(int speed){
        setPosY(getPosY()+speed*5);
    }


}
