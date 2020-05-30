package Model;

import javax.swing.*;
import java.awt.*;

public class Enemy {
    private Image imagem;
    private int x, y;
    private int larg, alt;
    private boolean isVisivel;
    private static final int largura = 938;
    private static int vel = 2;

    public Enemy(int x, int y) {
        this.x = x;
        this.y = y;
        isVisivel = true;
    }

    public void load() {
        ImageIcon ref = new ImageIcon("res/enemy.png");
        imagem = ref.getImage();
        this.larg = imagem.getWidth(null);
        this.alt = imagem.getHeight(null);
    }

    public void update() {
        this.x -= vel;
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

    public Image getImagem() {
        return imagem;
    }

    public boolean isVisivel(){
        return isVisivel;
    }
    public void setVisivel (boolean isVisivel) {
        this.isVisivel = isVisivel;
    }
}