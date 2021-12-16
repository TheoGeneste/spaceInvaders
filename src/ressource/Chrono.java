package ressource;
import jeu.Main;

public class Chrono implements Runnable{
    private final int PAUSE=5; // Temps d'attentes en millisecondes
    public static int compteTours= 0;

    @Override
    public void run(){
        while (Main.jeu == true){
            compteTours++;
            Main.scene.repaint();
            try {
                Thread.sleep(PAUSE);//Temps de pause
            }catch (InterruptedException e){}
        }
    }
}
