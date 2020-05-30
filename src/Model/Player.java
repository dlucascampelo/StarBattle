package Model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;


public class Player {
    private int x,y;
    private int dx, dy;
    private Image imagem;
    private int alt, larg;
    private List <Tiro> shoot;
    private boolean isVisivel;

    public Player(){
        this.x = 100;
        this.y = 100;
        shoot = new ArrayList<Tiro>();
        isVisivel = true;

    }
    public void load(){
        ImageIcon ref = new ImageIcon("res/spaceship.png");
        imagem = ref.getImage();
        alt = imagem.getHeight(null);
        larg = imagem.getWidth(null);
    }
    public void update() {
        x += dx;
        y += dy;
    }
    public void shootS(){
        this.shoot.add(new Tiro(x + (larg/2), y + (alt /2)));
    }
    public Rectangle getBounds(){
        return new Rectangle(x,y,larg,alt);

    }
    public void keyPressed(KeyEvent tecla) {
        int codigo = tecla.getKeyCode();

        if (codigo == KeyEvent.VK_SPACE) {
            shootS();
        }

        if (codigo == KeyEvent.VK_UP) {
            dy = -3;
        }
        if (codigo == KeyEvent.VK_DOWN) {
            dy = 3;
        }
        if (codigo == KeyEvent.VK_LEFT) {
            dx = -3;
        }
        if (codigo == KeyEvent.VK_RIGHT) {
            dx = 3;
        }
    }
    public void keyRelease(KeyEvent tecla) {
            int codigo = tecla.getKeyCode();

            if (codigo == KeyEvent.VK_UP) {
                dy = 0;
            }
            if (codigo == KeyEvent.VK_DOWN) {
                dy = 0;
            }
            if (codigo == KeyEvent.VK_LEFT) {
                dx = 0;
            }
            if (codigo == KeyEvent.VK_RIGHT) {
                dx = 0;
            }
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

    public boolean isVisivel() {
        return isVisivel;
    }

    public void setVisivel(boolean visivel) {
        isVisivel = visivel;
    }

    public  List<Tiro> getShoot() {
        return shoot;
    }
}

