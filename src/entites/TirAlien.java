package entites;

import jeu.Main;
import ressource.Audio;
import ressource.Chrono;
import ressource.Constantes;

import javax.swing.*;
import java.awt.*;
import java.util.Random;


public class TirAlien extends Entite{

    Random hasard = new Random();

    public TirAlien(int[] tabPositionAlien){
        super.xPos = tabPositionAlien[0] + Constantes.LARGEUR_ALIEN/2 - 1;
        super.yPos = tabPositionAlien[1] + Constantes.HAUTEUR_ALIEN;
        super.largeur = Constantes.LARGEUR_TIR_ALIEN;
        super.hauteur = Constantes.HAUTEUR_TIR_ALIEN;
        super.deplacementx = 0;
        super.deplacementy = Constantes.DY_TIR_ALIEN;

        super.strImg1 = "/images/tirAlien1.png";
        super.strImg2 = "/images/tirAlien2.png";
        super.strImg3 = "";

        if (hasard.nextInt(2) == 0) {
            super.icone = new ImageIcon(getClass().getResource(super.strImg1));
        }else{
            super.icone = new ImageIcon(getClass().getResource(super.strImg2));
        }
        super.img = this.icone.getImage();
    }

    public  int deplacementTirAlien(){
        if (Chrono.compteTours % 4 == 0){
            if (this.yPos < 600) {
                this.yPos = this.yPos + Constantes.DY_TIR_ALIEN;
            }
        }
        return yPos;
    }

    public void dessinTirAlien(Graphics g){
        g.drawImage(this.img, this.xPos, this.deplacementTirAlien(), null);
    }

    public boolean tirAlienAHauteurDeChateau(){
        if (this.yPos < Constantes.Y_POS_CHATEAU + Constantes.HAUTEUR_CHATEAU &&
        this.yPos + this.hauteur > Constantes.Y_POS_CHATEAU){
            return true;
        }else{
            return false;
        }
    }

    private int chateauProche() {
        int numeroChateau = -1;
        int colonne = -1;
        while (numeroChateau == -1 && colonne < 4) {
            colonne++;
            if(this.xPos + this.largeur - 1 > Constantes.MARGE_FENETRE + Constantes.X_POS_INIT_CHATEAU + colonne *
                    (Constantes.LARGEUR_CHATEAU + Constantes.ECART_CHATEAU)
                    && this.xPos + 1< Constantes.MARGE_FENETRE + Constantes.X_POS_INIT_CHATEAU + Constantes.LARGEUR_CHATEAU + colonne *
                    (Constantes.LARGEUR_CHATEAU + Constantes.ECART_CHATEAU)) {
                numeroChateau = colonne;
            }
        }
        return numeroChateau;
    }

    private int abscisseContactTirAlienChateau(Chateau chateau) {
        int xPosTirAlien = -1;
        if(this.xPos + this.largeur > chateau.getxPos() && this.xPos < chateau.getxPos() + Constantes.LARGEUR_CHATEAU){
            xPosTirAlien = this.xPos;
        }
        return xPosTirAlien;
    }

    public int[] tirAlienToucheChateau() {
        int[] tabRep = {-1, -1};
        if(this.tirAlienAHauteurDeChateau() == true) {
            tabRep[0] = this.chateauProche();
            if(tabRep[0] != -1) {
                tabRep[1] = this.abscisseContactTirAlienChateau(Main.scene.tabChateaux[tabRep[0]]);
            }
        }
        return tabRep;
    }

    public void tirAlienDetruitChateau(Chateau tabChateaux[]) {
        int[] tab = this.tirAlienToucheChateau();
        if(tab[0] != -1) {
            if(tabChateaux[tab[0]].trouveBriqueHaut(tabChateaux[tab[0]].trouveColonneChateau(tab[1])) != -1
            && tabChateaux[tab[0]].trouveBriqueHaut(tabChateaux[tab[0]].trouveColonneChateau(tab[1])) != 27) {
                tabChateaux[tab[0]].casseBriquesHaut(tab[1]);
                this.yPos = 700;
            }
        }
    }

    public boolean toucheVaisseau(Vaisseau vaisseau){
        if (this.yPos < vaisseau.getyPos() + vaisseau.getHauteur() && this.yPos + this.hauteur > vaisseau.getyPos()
        && this.xPos + this.largeur > vaisseau.getxPos() && this.xPos < vaisseau.getxPos() + vaisseau.getLargeur()){
            this.yPos = 700;
            Audio.playSound("/sons/sonDestructionVaisseau.wav");
            return true;
        }else{
            return false;
        }
    }
}
