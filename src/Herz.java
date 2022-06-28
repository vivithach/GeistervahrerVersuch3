import processing.core.PApplet;
import processing.core.PImage;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Herz extends Spielelement{
    private String BildAdresse = "data/heart.png";
    private PImage BildHerz = null;

    private List<Integer> X_POSITIONEN_DER_SPUREN = Arrays.asList(40,160,280,400,520);
    private Random rand = new Random();

    Herz(PApplet app){
        super(app);
        setPosX(X_POSITIONEN_DER_SPUREN.get(rand.nextInt(X_POSITIONEN_DER_SPUREN.size())));
        setPosY(-500);
        setBreite(40);
        setHöhe(40);
    }

    public void drawing(){
        if(BildHerz == null){
            BildHerz = app.loadImage(BildAdresse);
        }
        app.image(BildHerz,getPosX(),getPosY(),getBreite(),getHöhe());
    }

    public void bewegeHerz(int speed){
        setPosY(getPosY()+speed);
    }
}
