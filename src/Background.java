import processing.core.PApplet;
import processing.core.PImage;

public class Background extends Spielelement {
    String image_path = "data/Hintergrund.png";

    PImage background1;
    PImage background2;
    private boolean geladen = false;
    private int background1_x = 0;
    private int background1_y = 0;

    private int background2_x = 0;
    private int background2_y = 600;

    Background(PApplet app) {
        super(app);

    }

    void drawing() {
        if(geladen == false){
            background1 = app.loadImage(image_path);
            background2 = app.loadImage(image_path);
            geladen = true;
        }

        app.image(background1, background1_x, background1_y, app.width, app.height);
        app.image(background2, background2_x, background2_y, app.width, app.height);
    }

    void act(int speed) {
        background1_y = background1_y + speed;
        background2_y = background2_y + speed;

        if (background1_y >= 600) {
            background1_y = -600;
        }
        if (background2_y >= 600) {
            background2_y = -600;
        }

    }
}

