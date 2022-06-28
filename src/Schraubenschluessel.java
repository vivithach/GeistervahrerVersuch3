import processing.core.PApplet;
import processing.core.PImage;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Schraubenschluessel extends Spielelement{
    private String BildAdresse = "data/Schraubenschlüssel.png";
    private PImage BildSchraubenschluessel = null;

    List<Integer> X_POSITIONEN_DER_SPUREN = Arrays.asList(15,135,255,375,495);
    Random rand = new Random();

    Schraubenschluessel(PApplet app){
        super(app);
        setPosX(X_POSITIONEN_DER_SPUREN.get(rand.nextInt(X_POSITIONEN_DER_SPUREN.size())));
        setPosY(-100);
        setBreite(90);
        setHöhe(40);
    }

    public void drawing(){
        if(BildSchraubenschluessel == null){
            BildSchraubenschluessel = app.loadImage(BildAdresse);
        }
        app.image(BildSchraubenschluessel,getPosX(),getPosY(),getBreite(),getHöhe());
    }

    public void bewegeSchraubenschluessel(int speed){
        setPosY(getPosY()+speed*5);
    }


}
