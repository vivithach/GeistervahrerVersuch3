import processing.core.PApplet;
import processing.core.PImage;

public class Background extends Spielelement {
    private String HintergrundBildAdresse = "data/Hintergrund.png";

    private PImage hintergrundBild1 = null;
    private PImage hintergrundBild2 = null;

    private int PosX_hintergrundBild1;
    private int PosY_hintergrundBild1;

    private int PosX_hintergrundBild2;
    private int PosY_hintergrundBild2;


    Background(PApplet app) {
        super(app);
        setPosX_hintergrundBild1(0);
        setPosX_hintergrundBild2(0);
        setPosY_hintergrundBild1(0);
        setPosY_hintergrundBild2(600);
    }

    void drawing() {
        if(hintergrundBild1==null && hintergrundBild2 == null){
            hintergrundBild1 = app.loadImage(HintergrundBildAdresse);
            hintergrundBild2 = app.loadImage(HintergrundBildAdresse);
        }
        app.image(hintergrundBild1, PosX_hintergrundBild1, PosY_hintergrundBild1, app.width, app.height);
        app.image(hintergrundBild2, PosX_hintergrundBild2, PosY_hintergrundBild2, app.width, app.height);
    }

    void act(int speed) {
        PosY_hintergrundBild1 = PosY_hintergrundBild1 + speed;
        PosY_hintergrundBild2 = PosY_hintergrundBild2 + speed;

        if (PosY_hintergrundBild1 >= 600) {
            PosY_hintergrundBild1 = -600;
        }
        if (PosY_hintergrundBild2 >= 600) {
            PosY_hintergrundBild2 = -600;
        }
    }

    public int getPosX_hintergrundBild1() {
        return PosX_hintergrundBild1;
    }

    public void setPosX_hintergrundBild1(int posX_hintergrundBild1) {
        PosX_hintergrundBild1 = posX_hintergrundBild1;
    }

    public int getPosY_hintergrundBild1() {
        return PosY_hintergrundBild1;
    }

    public void setPosY_hintergrundBild1(int posY_hintergrundBild1) {
        PosY_hintergrundBild1 = posY_hintergrundBild1;
    }

    public int getPosX_hintergrundBild2() {
        return PosX_hintergrundBild2;
    }

    public void setPosX_hintergrundBild2(int posX_hintergrundBild2) {
        PosX_hintergrundBild2 = posX_hintergrundBild2;
    }

    public int getPosY_hintergrundBild2() {
        return PosY_hintergrundBild2;
    }

    public void setPosY_hintergrundBild2(int posY_hintergrundBild2) {
        PosY_hintergrundBild2 = posY_hintergrundBild2;
    }
}

