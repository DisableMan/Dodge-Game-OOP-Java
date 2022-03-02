/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;


public class VipEnemy extends GameObject{
    
    private Handler handler;
    
    public VipEnemy(int x, int y,ID id, Handler handler){
        super(x, y, id);
        
        this.handler = handler;
        
        velX = 4;
        velY = 7;
        
    }

    public Rectangle getBounds(){
        return new Rectangle(x, y, 16, 16);
    }

    public void tick() {
        x+=velX;
        y+=velY;
        
        if(y <= 0 || y >= Game.HEIGHT-55) velY *=-1;
        if(x <= 0 || x >= Game.WIDTH-40) velX *=-1;
        handler.addObject(new Trail(x, y, ID.Trail, Color.cyan, 5, 5, 0.1f, handler));
    }

    public void render(Graphics g) {
        g.setColor(Color.blue);
        g.fillRect(x, y, 10, 10);
    }
    
    
}
