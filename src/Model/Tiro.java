package Model;

import javax.swing.*;
import java.awt.*;

public class Tiro {
    private Image imagem;
    private int x,y;
    private int larg, alt;
    private boolean isVisivel;
    private static final int largura = 938;
    private static int vel = 2;

    public Tiro (int x, int y){
        this.x = x;
        this.y = y;
        isVisivel = true;
    }
    public void load(){
        ImageIcon ref = new ImageIcon("res/shoot.png");
        imagem = ref.getImage();
        this.larg = imagem.getWidth(null);
        this.alt = imagem.getHeight(null);
    }
    public void update(){
        this.x += vel;
            if (this.x > largura){
                isVisivel = false;
            }
    }
    public Rectangle getBounds(){
        return new Rectangle(x,y,larg,alt);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isVisivel() {
        return isVisivel;
    }

    public void setVisivel(boolean visivel) {
        isVisivel = visivel;
    }

    public static int getVel() {
        return vel;
    }

    public static void setVel(int vel) {
        Tiro.vel = vel;
    }

    public Image getImagem() {
        return imagem;
    }
}
