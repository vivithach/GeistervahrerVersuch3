public class Lebensbalken extends Spielelement{
    private int Leben;
    Lebensbalken(){
        setPosX(20);
        setPosY(20);
        Leben = 250;
    }

    public void minusLeben(){
        Leben -=1;
    }

    public void plusLeben(){
        if(Leben < 250)
            Leben +=50;
        if(Leben > 250){
            Leben = 250;
        }
    }

    public void drawing(){
        stroke(255);
        strokeWeight(10);
        line(getPosX(), getPosY(), Leben,getPosY());
    }

    public int getLeben() {
        return Leben;
    }
}
