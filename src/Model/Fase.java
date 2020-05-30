package Model;

import javax.swing.*;
import java.awt.*;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class Fase extends JPanel implements ActionListener {
    private Timer timer;
    private Image fundo;
    private Player player;
    private List<Enemy> enemy;
    private boolean inGame;

    public Fase(){
        setFocusable(true);
        setDoubleBuffered(true);
        ImageIcon ref = new ImageIcon("res\\deathstar.jpeg");
        fundo = ref.getImage();
        player = new Player();
        player.load();
        addKeyListener(new TecladoAdapter());
        timer = new Timer(5, this);
        timer.start();
        enemyInit();
        inGame = true;
    }
    public void enemyInit(){
        int cordenadas [] = new int[40];
        enemy = new ArrayList<Enemy>();
        for (int i = 0; i< cordenadas.length; i++ ){
            int x  = (int)(Math.random() * 8000+1024);
            int y =  (int)(Math.random() * 650+30);
            enemy.add(new Enemy(x,y));

        }
    }
    public void paint(Graphics g){
        Graphics2D graficos = (Graphics2D) g;
        if (inGame == true){
            graficos.drawImage(fundo, 0, 0, null);
            graficos.drawImage(player.getImagem(), player.getX(), player.getY(), this);
            List <Tiro> shoot = player.getShoot();
            for (int i=0; i< shoot.size(); i++){
                Tiro s = shoot.get(i);
                s.load();
                graficos.drawImage(s.getImagem(), s.getX(), s.getY(), this);
            }
            for (int j=0; j< enemy.size(); j++) {
                Enemy in =enemy.get(j);
                in.load();
                graficos.drawImage(in.getImagem(), in.getX(), in.getY(), this);
        }

        }
        else{
            ImageIcon gameOver = new ImageIcon("res/gameover.png");
            graficos.drawImage(gameOver.getImage(),0, 0, null);
        }
            g.dispose();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        player.update();
        List <Tiro> shoot = player.getShoot();
            for (int i=0; i< shoot.size(); i++){
                Tiro s = shoot.get(i);
                if (s.isVisivel()){
                    s.update();
                }
                else {
                    shoot.remove(i);
                }
            }
        for (int j=0; j< enemy.size(); j++) {
        Enemy in  = enemy.get(j);
            if (in.isVisivel()){
            in.update();
        }
        else {
            enemy.remove(j);
        }
        }
            Colision();
            repaint();
    }
    public void Colision() {
        Rectangle formaNave = player.getBounds();
        Rectangle formaEnemy;
        Rectangle formaTiro;
        for (int i = 0; i < enemy.size(); i++) {
            Enemy tempEnemy = enemy.get(i);
            formaEnemy = tempEnemy.getBounds();
            if (formaNave.intersects(formaEnemy)) {
                player.setVisivel(false);
                tempEnemy.setVisivel(false);
                inGame = false;
            }
        }
        List<Tiro> shoot = player.getShoot();
        for (int j = 0; j < shoot.size(); j++) {
            Tiro tempShoot = shoot.get(j);
            formaTiro = tempShoot.getBounds();
            for (int o = 0; o < enemy.size(); o++) {
                Enemy tempEnemy = enemy.get(o);
                formaEnemy = tempEnemy.getBounds();
                if(formaTiro.intersects(formaEnemy)){
                    tempEnemy.setVisivel(false);
                    tempShoot.setVisivel(false);
                }
            }
        }
    }

    private class TecladoAdapter extends KeyAdapter
    { @Override
        public void keyPressed(KeyEvent e) {
            player.keyPressed(e);
        }
        @Override
        public void keyReleased(KeyEvent e ){
            player.keyRelease(e);
        }
    }

}

