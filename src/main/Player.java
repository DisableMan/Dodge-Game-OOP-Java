/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Player extends GameObject{
    
    
    Random r = new Random();
    Handler handler;
    public Player(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
        
    }
    
    public Rectangle getBounds(){
        return new Rectangle(x, y, 20, 20);
    }
    
    public void tick(){
        x+= velX;
        y+= velY;
        
        // giới hạn 2 bên 
        x = Game.clamp( x, 0, Game.WIDTH-47);
        // giới hạn trên dưới
        y = Game.clamp( y, 0, Game.HEIGHT-70);
        
        handler.addObject(new Trail(x, y, ID.Trail, new Color(153, 255, 102),32, 32, 0.2f, handler));
        
        collision();
                
    }
    // va phải vật cản
    private void collision(){
        for (int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);
            if(tempObject.getId() == ID.BasicEnemy || tempObject.getId() == ID.VipEnemy || tempObject.getId() == ID.VipProEnemy ){
                if(getBounds().intersects(tempObject.getBounds())){
                    HUD.HEALTH -= 2;
                }
            }
        }
    }
    
    public void render(Graphics g){
        
        g.setColor(new Color(153, 255, 102));
        g.fillRect(x, y, 32, 32);
               
    }
    
    
}
