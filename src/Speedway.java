import processing.core.PApplet;
import processing.core.PImage;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Speedway extends Spielelement{
    private String BildAdresse = "data/rainbow.png";
    private PImage BildSpeedway = null;

    List<Integer> X_POSITIONEN_DER_SPUREN = Arrays.asList(15,135,255,375,495);
    Random rand = new Random();

    private boolean reingefahren = false;

    Speedway(PApplet app){
        super(app);
        setPosX(X_POSITIONEN_DER_SPUREN.get(rand.nextInt(X_POSITIONEN_DER_SPUREN.size())));
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
