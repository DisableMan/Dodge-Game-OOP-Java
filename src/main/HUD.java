/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Hieu PC
 */
public class HUD {
    // Thanh máu
    public static int HEALTH = 100;
    // Điểm
    private int score = 0;
    
    private int level = 0;
    
    public void tick(){
        HEALTH = Game.clamp(HEALTH, 0, 100);
        score++;
    }
    
    public void render(Graphics g){
        g.setColor(Color.DARK_GRAY);
        g.fillRect(15, 15, 200, 32);
        g.setColor(Color.getHSBColor( (1f * HEALTH) / 360, 1f, 1f));
        g.fillRect(15, 15, (HEALTH*2), 32);
        g.setColor(Color.white);
        g.drawRect(15, 15, 200, 32);
        g.setColor(Color.yellow);
        g.drawString("Score: "+ score, 15,64);
        g.setColor(Color.red);
        g.drawString(HEALTH+"%", 100, 35);
        g.setColor(Color.PINK);
        g.drawString("Level: "+ level, 15,80);

        
        
    }

//    public void score(int score){
//        this.score = score;
//    }
    
    public int getScore(){
        return score;
    }
    
    public void setScore(int score){
        this.score = score;
    }
    
//    public void level(int level){
//        this.level = level;
//    }
    
    public int getLevel(){
        return level;
    }
    
    public void setLevel(int level){
        this.level = level;
    }
    
}
