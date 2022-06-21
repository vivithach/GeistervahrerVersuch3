import processing.core.PApplet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Modell {
    private int speed;

    private int AutoInterval;
    private float lastAddTime;


    private Background background;
    Auto Spieler;
    private ArrayList<GegenAuto> Gegner;
    private Lebensbalken Leben;
    GameScreen gameScreen;
    ScreenControll Screen;
    private ArrayList<Herz> herz;
    private ArrayList<Muenzen> muenze;
    private Score score;
    private ArrayList<Speedway> speedBlock;
    private ArrayList<Schraubenschluessel> Tool;

    private PApplet app;


    Modell(PApplet app){

        this.app = app;
        speed = 2;

        AutoInterval = 1000;
        lastAddTime = 0;
        gameScreen = GameScreen.START_SCREEN;


        Gegner = new ArrayList<>();
        herz = new ArrayList<>();
        muenze = new ArrayList<>();
        speedBlock = new ArrayList<>();
        Tool = new ArrayList<>();
        background = new Background(app);
        Spieler = new Auto(app);
        Leben = new Lebensbalken(app);
        Screen = new ScreenControll(app);
        score = new Score(app);

    }

    void startGame() {
        gameScreen=GameScreen.GAME_SCREEN;
    }

    void gameOver() {
        gameScreen=GameScreen.GAMEOVER_SCREEN;
    }

    void ObjektAdder(){
        if (app.millis()-lastAddTime > AutoInterval) {


            //Autos
            List<Integer> anzahlAutos = Arrays.asList(1,2,3,4,1,2,1,2,3,4,1,2);
            Random rand = new Random();

            for(int i = 0; i < anzahlAutos.get(rand.nextInt(anzahlAutos.size()));i++){
                Gegner.add(new GegenAuto(app));
            }

            //Herzen
            List<Integer> anzahlHerzen = Arrays.asList(1,0,0,0,0,0,0,0,0,0,0,0);
            Random rand2 = new Random();

            if(anzahlHerzen.get(rand2.nextInt(anzahlHerzen.size())) == 1){
                herz.add(new Herz(app));
            }

            //Münzen
            List<Integer> anzahlMuenzen = Arrays.asList(1,0,0,0,0,0,0,0,0,0,0,0);
            Random rand3 = new Random();

            if(anzahlMuenzen.get(rand3.nextInt(anzahlMuenzen.size())) == 0){
                muenze.add(new Muenzen(app));
            }

            //SpeedBlöcke
            List<Integer> anzahlspeedBlock = Arrays.asList(1,1,0,0,0,0,0,0,0,0,0,0);
            Random rand4 = new Random();

            if(anzahlspeedBlock.get(rand4.nextInt(anzahlspeedBlock.size())) == 1){
                speedBlock.add(new Speedway(app));
            }

            //Schraubenschlüsssel
            List<Integer> anzahlTool = Arrays.asList(1,1,0,0,0,0,0,0,0,0,0,0);
            Random rand5 = new Random();

            if(anzahlTool.get(rand5.nextInt(anzahlTool.size())) == 1){
                Tool.add(new Schraubenschluessel(app));
            }


            lastAddTime = app.millis();
        }
    }

    void ObjektDeleter(){
        //Autos
        for(int i =0; i< Gegner.size() ;i++){
            GegenAuto AktuellesAuto = Gegner.get(i);
            if(AktuellesAuto.getPosY() > 700){
                Gegner.remove(i);
            }
        }
        //Herzen
        for(int i =0; i< herz.size() ;i++){
            Herz aktuellesHerz = herz.get(i);
            if(aktuellesHerz.getPosY() > 700){
                herz.remove(i);
            }
        }
        //Münzen
        for(int i =0; i< muenze.size() ;i++){
            Muenzen aktuellesMuenze = muenze.get(i);
            if(aktuellesMuenze.getPosY()> 700){
                muenze.remove(i);
            }
        }

        //SpeeWay
        for(int i =0; i< speedBlock.size() ;i++){
            Speedway aktuellesspeedBlock = speedBlock.get(i);
            if(aktuellesspeedBlock.getPosY() > 1750){
                if(aktuellesspeedBlock.reingefahren){
                    speed = 2;
                    AutoInterval = 1000;
                    aktuellesspeedBlock.reingefahren = false;
                }
            }
        }

        //Tools
        for(int i =0; i< Tool.size() ;i++){
            Schraubenschluessel aktuellesTool = Tool.get(i);
            if(aktuellesTool.getPosY() > 700){
                Tool.remove(i);
            }
        }
    }



    void RUN(){

        //Überprüfen Leben
        if(Leben.getLeben()<= 20){
            gameOver();
        }

        //Hintergrund
        background.drawing();
        background.act(speed);

        //Objekt handler
        ObjektAdder();
        ObjektDeleter();


        //SpeedWay
        for(Speedway aktuellesspeedBlock:speedBlock){
            aktuellesspeedBlock.drawing();
            aktuellesspeedBlock.act(speed);

        }
        for(int i =0; i< speedBlock.size() ;i++){
            Speedway aktuellesspeedBlock = speedBlock.get(i);
            if(aktuellesspeedBlock.kollision(Spieler)){
                speed = 10;
                AutoInterval = 250;
                aktuellesspeedBlock.reingefahren = true;
            }
        }


        //Herzen
        for(Herz aktuellesHerz:herz){
            aktuellesHerz.drawing();
            aktuellesHerz.act(speed);
        }
        for(int i =0; i< herz.size() ;i++){
            Herz aktuellesHerz = herz.get(i);
            if(aktuellesHerz.kollision(Spieler)){
                herz.remove(i);
                Leben.plusLeben();
            }
        }

        //Münzen
        for(Muenzen aktuellesMuenze:muenze){
            aktuellesMuenze.drawing();
            aktuellesMuenze.act(speed);
        }
        for(int i =0; i< muenze.size() ;i++){
            Muenzen aktuellesMuenze = muenze.get(i);
            if(aktuellesMuenze.kollision(Spieler)){
                muenze.remove(i);
                score.erhöheScore();
            }
        }

        //Tools
        for(Schraubenschluessel aktuellesTool:Tool){
            aktuellesTool.drawing();
            aktuellesTool.act(speed);
        }
        for(int i =0; i< Tool.size() ;i++){
            Schraubenschluessel aktuellesTool = Tool.get(i);
            if(aktuellesTool.kollision(Spieler)){
                Tool.remove(i);
                //ändere Richtung
                Spieler.aendereRichtung();
            }
        }


        //Gegner
        for(GegenAuto aktuellesAuto:Gegner){
            aktuellesAuto.drawing();
            aktuellesAuto.act(speed);
            if(aktuellesAuto.kollision(Spieler)){
                Leben.minusLeben();
            }
        }

        //steuerungSpielerAuto();
        Spieler.drawing();

        Leben.drawing();
        score.drawing();

    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }
}
