import processing.core.PApplet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Modell {

    private int spielgeschwindigkeit;
    private int hinzufuegeIntervall;
    private float lastAddTime;
    private Background hintergrund;
    private Lebensbalken leben;
    Score score;
    private PApplet app;

    SpielerAuto spieler;
    ArrayList<GegnerAuto> gegnerAutos;
    ArrayList<Herz> herzItems;
    ArrayList<Muenzen> muenzItems;
    ArrayList<Speedway> speedwayItems;
    ArrayList<Schraubenschluessel> schraubenschluesselItems;

    ScreenControll screen;
    GameScreen gameScreen;
    
    Modell(PApplet app){
        this.app = app;
        spielgeschwindigkeit = 2;

        hinzufuegeIntervall = 1000;
        lastAddTime = 0;
        gameScreen = GameScreen.START_SCREEN;
        
        gegnerAutos = new ArrayList<>();
        herzItems = new ArrayList<>();
        muenzItems = new ArrayList<>();
        speedwayItems = new ArrayList<>();
        schraubenschluesselItems = new ArrayList<>();
        hintergrund = new Background(app);
        spieler = new SpielerAuto(app);
        leben = new Lebensbalken(app);
        screen = new ScreenControll(app);
        score = new Score(app);
    }
    
    public void startGame() {
        gameScreen=GameScreen.GAME_SCREEN;
    }

    public void gameOver() {
        gameScreen=GameScreen.GAMEOVER_SCREEN;
    }

    public int erzeugeRandomZahl(String Liste) {

        List<Integer> liste = null;

        if(Liste == "anzahlGegnerAutos"){
            liste = Arrays.asList(1,2,3,4,1,2,1,2,3,4,1,2);
        }
        if(Liste == "anszahlItems"){
            liste = Arrays.asList(1,0,0,0,0,0,0,0,0,0,0,0);
        }
        if(Liste == "fahrbahnPositionGegner"){
            liste = Arrays.asList(25,145, 265, 385, 505);
        }
        if(Liste == "fahrbahnPositionHerzMuenzen"){
            liste = Arrays.asList(40,160,280,400,520);
        }
        if(Liste == "fahrbahnPositionSchraubenschluesselSpeedway"){
            liste = Arrays.asList(15,135,255,375,495);
        }

        Random rand = new Random();
        int anzahl = liste.get(rand.nextInt(liste.size()));
        return anzahl;
    }

    public void hinzufuegeGegnerautos(int anzahlObjekte) {
        for(int i = 0; i < anzahlObjekte; i++){
            gegnerAutos.add(new GegnerAuto(app, erzeugeRandomZahl("fahrbahnPositionGegner")));
        }
    }

    public void loescheGegnerAutos() {
        for (int i = 0; i < gegnerAutos.size(); i++) {
            GegnerAuto AktuellesAuto = gegnerAutos.get(i);
            if (AktuellesAuto.getPosY() > 700) {
                gegnerAutos.remove(i);
            }
        }
    }

    public void ueberpruefeKollisionMitGegnerAuto() {
        for(GegnerAuto aktuellesAuto: gegnerAutos){
            aktuellesAuto.drawing();
            aktuellesAuto.bewegeGegnerAuto(spielgeschwindigkeit);
            if(aktuellesAuto.kollision(spieler)){
                leben.minusLeben();
            }
        }
    }
    

    public void hinzufuegeHerzItems(int anzahlObjekte) {
        if(anzahlObjekte == 1){
            herzItems.add(new Herz(app, erzeugeRandomZahl("fahrbahnPositionHerzMuenzen")));
        }
    }

    public void loescheHerzItems() {
        for (int i = 0; i < herzItems.size(); i++) {
            Herz aktuellesHerz = herzItems.get(i);
            if (aktuellesHerz.getPosY() > 700) {
                herzItems.remove(i);
            }
        }
    }

    public void ueberpruefeKollisionMitHerzItem() {
        for(int i = 0; i< herzItems.size() ; i++){
            Herz aktuellesHerz = herzItems.get(i);
            if(aktuellesHerz.kollision(spieler)){
                herzItems.remove(i);
                leben.plusLeben();
            }
        }
    }
    
    public void hinzufuegeMuenzItems(int anzahlObjekte) {
        if(anzahlObjekte == 0){
            muenzItems.add(new Muenzen(app, erzeugeRandomZahl("fahrbahnPositionHerzMuenzen")));
        }
    }

    public void loescheMuenzItems() {
        for(int i = 0; i< muenzItems.size() ; i++){
            Muenzen aktuellesMuenze = muenzItems.get(i);
            if(aktuellesMuenze.getPosY()> 700){
                muenzItems.remove(i);
            }
        }
    }

    public void ueberpruefeKollisionMitMuenzItem() {
        for(int i = 0; i< muenzItems.size() ; i++){
            Muenzen aktuellesMuenze = muenzItems.get(i);
            if(aktuellesMuenze.kollision(spieler)){
                muenzItems.remove(i);
                score.erhoehePunkte();
            }
        }
    }

    
    public void hinzufuegeSpeedwayItems(int anzahlObjekte) {
        if(anzahlObjekte == 1){
            speedwayItems.add(new Speedway(app, erzeugeRandomZahl("fahrbahnPositionSchraubenschluesselSpeedway")));
        }
    }

    public void loescheSpeedwayItems() {
        for (int i = 0; i < speedwayItems.size(); i++) {
            Speedway aktuellesspeedBlock = speedwayItems.get(i);
            if (aktuellesspeedBlock.getPosY() > 1750) {
                if (aktuellesspeedBlock.isReingefahren()) {
                    spielgeschwindigkeit = 2;
                    hinzufuegeIntervall = 1000;
                    aktuellesspeedBlock.setReingefahren(false);
                }
                speedwayItems.remove(i);
            }
        }
    }
    

    public void ueberpruefeKollisionMitSpeedwayItem() {
        for(int i = 0; i< speedwayItems.size() ; i++){
            Speedway aktuellesspeedBlock = speedwayItems.get(i);
            if(aktuellesspeedBlock.kollision(spieler)){
                spielgeschwindigkeit = 10;
                hinzufuegeIntervall = 250;
                aktuellesspeedBlock.setReingefahren(true);
            }
        }
    }
    
    
    public void hinzufuegeSchraubenschuesselItems(int anzahlObjekte) {
        if(anzahlObjekte == 1){
            schraubenschluesselItems.add(new Schraubenschluessel(app, erzeugeRandomZahl("fahrbahnPositionSchraubenschluesselSpeedway")));
        }
    }

    public void loescheSchraubenschluesselItems() {
        for (int i = 0; i < schraubenschluesselItems.size(); i++) {
            Schraubenschluessel aktuellesTool = schraubenschluesselItems.get(i);
            if (aktuellesTool.getPosY() > 700) {
                schraubenschluesselItems.remove(i);
            }
        }
    }

    public void ueberpruefeKollisionMitSchraubenschluesselItem() {
        for(int i = 0; i< schraubenschluesselItems.size() ; i++){
            Schraubenschluessel aktuellesTool = schraubenschluesselItems.get(i);
            if(aktuellesTool.kollision(spieler)){
                schraubenschluesselItems.remove(i);
                spieler.aendereSteuerung();
            }
        }
    }

    
    public void hinzufuegeObjekte(){
        if (app.millis()-lastAddTime > hinzufuegeIntervall) {
            hinzufuegeGegnerautos(erzeugeRandomZahl("anzahlGegnerAutos"));
            hinzufuegeHerzItems(erzeugeRandomZahl("anszahlItems"));
            hinzufuegeMuenzItems(erzeugeRandomZahl("anszahlItems"));
            hinzufuegeSpeedwayItems(erzeugeRandomZahl("anszahlItems"));
            hinzufuegeSchraubenschuesselItems(erzeugeRandomZahl("anszahlItems"));
            lastAddTime = app.millis();
        }
    }

    public void loescheObjekte(){
        loescheGegnerAutos();
        loescheSpeedwayItems();
        loescheHerzItems();
        loescheMuenzItems();
        loescheSchraubenschluesselItems();
    }

    public void aktualiesiereZustandItems() {
        for(Speedway aktuellesspeedBlock: speedwayItems){
            aktuellesspeedBlock.drawing();
            aktuellesspeedBlock.bewegeSpeedway(spielgeschwindigkeit);
        }
        for(Herz aktuellesHerz: herzItems){
            aktuellesHerz.drawing();
            aktuellesHerz.bewegeHerz(spielgeschwindigkeit);
        }
        for(Muenzen aktuellesMuenze: muenzItems){
            aktuellesMuenze.drawing();
            aktuellesMuenze.bewegeMuenzen(spielgeschwindigkeit);
        }
        for(Schraubenschluessel aktuellesTool: schraubenschluesselItems){
            aktuellesTool.drawing();
            aktuellesTool.bewegeSchraubenschluessel(spielgeschwindigkeit);
        }
    }
    
    public void ueberpruefeKollisionMitObjekt() {
        ueberpruefeKollisionMitSpeedwayItem();
        ueberpruefeKollisionMitHerzItem();
        ueberpruefeKollisionMitMuenzItem();
        ueberpruefeKollisionMitSchraubenschluesselItem();
        ueberpruefeKollisionMitGegnerAuto();
    }
    
    public void RUN(){
        ueberpruefeLeben();
        aktualisiereHintergrund();
        hinzufuegeObjekte();
        loescheObjekte();
        aktualiesiereZustandItems();
        ueberpruefeKollisionMitObjekt();
        spieler.drawing();
        leben.drawing();
        score.drawing();
    }

    public void ueberpruefeLeben() {
        if(leben.getLeben()<= 20){
            gameOver();
        }
    }

    public void aktualisiereHintergrund() {
        hintergrund.drawing();
        hintergrund.bewegeHintergrund(spielgeschwindigkeit);
    }
}
