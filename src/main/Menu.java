/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import static main.Game.HEIGHT;
import main.Game.STATE;
import static main.Game.WIDTH;

/**
 *
 * @author Hieu PC
 */
public class Menu extends MouseAdapter{
    private Game game;
    private Handler handler;
    private Random r = new Random();
    private HUD hud;
    public Menu(Game game, Handler handler, HUD hud){
        this.game = game;
        this.handler = handler;
        this.hud = hud;
    }
    
    public void mousePressed(MouseEvent e){
        int mx = e.getX();
        int my = e.getY();
        
        if(game.gameState == STATE.Menu){
            // nut Start
            if(mouseOver(mx, my, 210, 150, 200, 64)){
                game.gameState = STATE.Game;
                handler.addObject(new Player(WIDTH/2-32,HEIGHT/2-32 , ID.Player, handler));
                handler.clearEnemies();
                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.BasicEnemy,handler));
            }


            //nut Quit
            if(mouseOver(mx, my, 210, 250, 200, 64)){
                System.exit(1);
            }
        }
       
        if(game.gameState == STATE.End){
            // nut Choi lai
            if(mouseOver(mx, my, 210, 250, 200, 64)){
                game.gameState = STATE.Game;
                hud.setScore(0);
                hud.setLevel(0);
                handler.addObject(new Player(WIDTH/2-32,HEIGHT/2-32 , ID.Player, handler));
                handler.clearEnemies();
                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.BasicEnemy,handler));
            }
        }
        
    }
    
    public void mouseReleased(MouseEvent e){
        
    }
    
    // chọn vị trí click chuột
    private boolean mouseOver(int mx ,int my, int x, int y, int width, int height){
        if(mx>x && mx < x + width){
            if(my>y&&my<y+height){
                return true;
            }else return false;
        }else return false;
    }
    
    public void tick(){
        
    }
    
    public void render(Graphics g){
        if(game.gameState==STATE.Menu){
            Font f = new Font("",2,40);
            Font f2 = new Font("",1,40);
            g.setFont(f2);
            g.setColor(Color.GREEN);
            g.drawString("Menu", 255, 70);

            g.setFont(f);
            g.setColor(Color.yellow);
            g.drawRect(210, 150, 200, 64);
            g.drawString("Chơi!", 260, 200);

            g.setColor(Color.cyan);
            g.drawRect(210, 250, 200, 64);
            g.drawString("Nghỉ!", 260, 300);
            
            Font f3 = new Font("",1,14);
            g.setFont(f3);
            g.setColor(Color.white);
            g.drawString("Sử dụng W A S D để di chuyển( hoặc 4 phím mũi tên ) ",150,430);
           
            
            
        }
        else if(game.gameState==STATE.End){
            Font f = new Font("",2,40);
            Font f2 = new Font("",1,40);
            Font f3 = new Font("",1,20);
            
            g.setFont(f2);
            g.setColor(Color.red);
            g.drawString("Game Over!", 210, 70);

            g.setFont(f3);
            g.setColor(Color.white);
            g.drawString("Điểm của bạn: "+ hud.getScore(), 225,200);
            
            g.setFont(f2);
            g.drawRect(210, 250, 200, 64);
            g.drawString("Chơi lại!", 235, 300);
            
           
        }
//        g.setColor(Color.white);
//        g.drawRect(210, 350, 200, 64);
//        g.drawString("Quit", 260, 400);
    }
}
