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
    SpielerAuto Spieler;
    ArrayList<GegnerAuto> Gegner;
    private Lebensbalken Leben;
    GameScreen gameScreen;
    ScreenControll Screen;
    ArrayList<Herz> herz;
    ArrayList<Muenzen> muenze;
    private Score score;
    ArrayList<Speedway> speedBlock;
    ArrayList<Schraubenschluessel> Tool;

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
        Spieler = new SpielerAuto(app);
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
                Gegner.add(new GegnerAuto(app));
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

            addSchraubenschluessel();


            lastAddTime = app.millis();
        }
    }

    private void addSchraubenschluessel() {
        List<Integer> anzahlTool = Arrays.asList(1,1,0,0,0,0,0,0,0,0,0,0);
        Random rand5 = new Random();

        if(anzahlTool.get(rand5.nextInt(anzahlTool.size())) == 1){
            Tool.add(new Schraubenschluessel(app));
        }
    }

    void AutoDeleter() {
        for (int i = 0; i < Gegner.size(); i++) {
            GegnerAuto AktuellesAuto = Gegner.get(i);
            if (AktuellesAuto.getPosY() > 700) {
                Gegner.remove(i);
            }
        }
    }

    void SpeedwayDeleter() {
        for (int i = 0; i < speedBlock.size(); i++) {
            Speedway aktuellesspeedBlock = speedBlock.get(i);
            if (aktuellesspeedBlock.getPosY() > 1750) {
                if (aktuellesspeedBlock.isReingefahren()) {
                    speed = 2;
                    AutoInterval = 1000;
                    aktuellesspeedBlock.setReingefahren(false);
                }
                speedBlock.remove(i);
            }
        }
    }

    void HerzDeleter() {
        for (int i = 0; i < herz.size(); i++) {
            Herz aktuellesHerz = herz.get(i);
            if (aktuellesHerz.getPosY() > 700) {
                herz.remove(i);
            }
        }
    }

    void MuenzDeleter() {
        for(int i =0; i< muenze.size() ;i++){
            Muenzen aktuellesMuenze = muenze.get(i);
            if(aktuellesMuenze.getPosY()> 700){
                muenze.remove(i);
            }
        }
    }

    void ToolDeleter() {
        for (int i = 0; i < Tool.size(); i++) {
            Schraubenschluessel aktuellesTool = Tool.get(i);
            if (aktuellesTool.getPosY() > 700) {
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
        background.bewegeHintergrund(speed);

        //Objekt handler
        ObjektAdder();
        AutoDeleter();
        HerzDeleter();
        ToolDeleter();
        MuenzDeleter();
        SpeedwayDeleter();


        //SpeedWay
        for(Speedway aktuellesspeedBlock:speedBlock){
            aktuellesspeedBlock.drawing();
            aktuellesspeedBlock.bewegeSpeedway(speed);

        }
        for(int i =0; i< speedBlock.size() ;i++){
            Speedway aktuellesspeedBlock = speedBlock.get(i);
            if(aktuellesspeedBlock.kollision(Spieler)){
                speed = 10;
                AutoInterval = 250;
                aktuellesspeedBlock.setReingefahren(true);
            }
        }


        //Herzen
        for(Herz aktuellesHerz:herz){
            aktuellesHerz.drawing();
            aktuellesHerz.bewegeHerz(speed);
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
            aktuellesMuenze.bewegeMuenzen(speed);
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
            aktuellesTool.bewegeSchraubenschluessel(speed);
        }
        for(int i =0; i< Tool.size() ;i++){
            Schraubenschluessel aktuellesTool = Tool.get(i);
            if(aktuellesTool.kollision(Spieler)){
                Tool.remove(i);
                //ändere Richtung
                Spieler.aendereSteuerung();
            }
        }


        //Gegner
        for(GegnerAuto aktuellesAuto:Gegner){
            aktuellesAuto.drawing();
            aktuellesAuto.bewegeGegnerAuto(speed);
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


    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
