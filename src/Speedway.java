import processing.core.PApplet;
import processing.core.PImage;

public class Speedway extends Spielelement{
    private String bildAdresse = "data/rainbow.png";
    private PImage bildSpeedway = null;

    private boolean reingefahren = false;

    Speedway(PApplet app, int PosX){
        super(app);
        setPosX(PosX);
        setPosY(-100);
        setBreite(90);
        setHoehe(40);
    }


    public void drawing(){
        if(bildSpeedway == null){
            bildSpeedway = app.loadImage(bildAdresse);
        }
        app.image(bildSpeedway,getPosX(),getPosY(),getBreite(), getHoehe());
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
