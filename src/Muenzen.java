import processing.core.PApplet;
import processing.core.PImage;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Muenzen extends Spielelement{
    private String BildAdresse = "data/coin.png";
    private PImage BildMuenzen = null;

    List<Integer> X_POSITIONEN_DER_SPUREN = Arrays.asList(40,160,280,400,520);
    Random rand = new Random();

    Muenzen(PApplet app){
        super(app);
        setPosX(X_POSITIONEN_DER_SPUREN.get(rand.nextInt(X_POSITIONEN_DER_SPUREN.size())));
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
