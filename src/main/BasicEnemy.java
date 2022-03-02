/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import main.Handler;
import main.ID;


public class BasicEnemy extends GameObject{
    
    private Handler handler;
    
    public BasicEnemy(int x, int y,ID id, Handler handler){
        super(x, y, id);
        
        this.handler = handler;
        
        velX = 4;
        velY = 4;
        
    }
    
    public Rectangle getBounds(){
        return new Rectangle(x, y, 16, 16);
    }

    public void tick() {
        x+=velX;
        y+=velY;
        
        if(y <= 0 || y >= Game.HEIGHT-55) velY *=-1;
        if(x <= 0 || x >= Game.WIDTH-40) velX *=-1;
        handler.addObject(new Trail(x, y, ID.Trail, Color.pink, 4, 4, 0.033f, handler));
    }

    public void render(Graphics g) {
        g.setColor(Color.red);
        g.fillRect(x, y, 16, 16);
    }
    
    
}
