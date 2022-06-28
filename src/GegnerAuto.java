import processing.core.PApplet;
import processing.core.PImage;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class GegnerAuto extends Spielelement{
    private String BildAdresse = "data/Gegner.png";
    private PImage GegnerBild = null;

    private List<Integer> X_POSITIONEN_DER_SPUREN = Arrays.asList(25,145, 265, 385, 505);
    private Random rand = new Random();


    GegnerAuto(PApplet app){
        super(app);
        setPosX(X_POSITIONEN_DER_SPUREN.get(rand.nextInt(X_POSITIONEN_DER_SPUREN.size())));
        setPosY(-400);
        setBreite(60);
        setHöhe(100);
    }

    void drawing(){
        if(GegnerBild == null){
            GegnerBild = app.loadImage(BildAdresse);
        }
        app.image(GegnerBild,getPosX(),getPosY(),getBreite(),getHöhe());
    }

    void bewegeGegnerAuto(int speed){
        setPosY(getPosY()+(speed*2));
    }
}
