/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.Random;

/**
 *
 * @author Hieu PC
 */
public class Spawn {
    private Handler handler;
    private HUD hud;
    private Random r = new Random();
    
    private int scoreKeep = 0;
    private int dem =0;
    public Spawn(Handler handler, HUD hud) {
        this.handler = handler;
        this.hud = hud;
    }
    
    public void tick(){
        scoreKeep++;
        if(scoreKeep>=200){
            scoreKeep = 0;
            hud.setLevel(hud.getLevel()+1);
            dem = hud.getLevel();
            if(dem<4){
                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.BasicEnemy,handler));
            }
            if(dem==4){
                handler.addObject(new VipEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.VipEnemy,handler));
            }
            if(dem==5){
                handler.addObject(new VipEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.VipEnemy,handler));
            }
            if(dem == 8) {
                handler.addObject(new VipProEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.VipProEnemy,handler));
            }
//            if(dem == 10){
//                handler.addObject(new VipProEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.VipProEnemy,handler));
//            }
            if(dem == 11){
                handler.addObject(new VipEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.VipEnemy,handler));
            }
            if(dem>11&&dem<20){
                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.BasicEnemy,handler));
            }
        }
    }
}
