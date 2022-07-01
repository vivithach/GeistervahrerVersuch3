import processing.core.PApplet;
import processing.core.PImage;

public class Speedway extends Spielelement{
    private String BildAdresse = "data/rainbow.png";
    private PImage BildSpeedway = null;

    private boolean reingefahren = false;

    Speedway(PApplet app, int PosX){
        super(app);
        setPosX(PosX);
        setPosY(-100);
        setBreite(90);
        setHöhe(40);
    }


    public void drawing(){
        if(BildSpeedway == null){
            BildSpeedway = app.loadImage(BildAdresse);
        }
        app.image(BildSpeedway,getPosX(),getPosY(),getBreite(),getHöhe());
    }

    public void bewegeSpeedway(int speed){
        setPosY(getPosY()+speed);
    }

    public boolean isReingefahren() {
        return reingefahren;
    }

    public void setReingefahren(boolean reingefahren) {
        this.reingefahren = reingefahren;
    }
}
