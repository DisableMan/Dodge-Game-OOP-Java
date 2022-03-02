/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;


public class VipProEnemy extends GameObject{
    
    private Handler handler;
    private GameObject player;
    public VipProEnemy(int x, int y,ID id, Handler handler){
        super(x, y, id);
        
        this.handler = handler;
        
        for (int i = 0; i < handler.object.size(); i++) {
            if(handler.object.get(i).getId()== ID.Player) player = handler.object.get(i);
        }
    }

    public Rectangle getBounds(){
        return new Rectangle(x, y, 16, 16);
    }

    public void tick() {
        x+=velX;
        y+=velY;
        
        float diffX = x - player.getX() - 16;
        float diffY = y - player.getY() - 16;
        
        float distance = (float) Math.sqrt( (x-player.getX())*(x-player.getX()) + (y-player.getY()) * (y-player.getY()) );
        velX =  (int) ((-1.0/distance)*diffX*2);
        velY =  (int) ((-1.0/distance)*diffY*2);

        handler.addObject(new Trail(x, y, ID.Trail, Color.yellow, 16, 16, 0.1f, handler));
    }

    public void render(Graphics g) {
        g.setColor(Color.yellow);
        g.fillRect(x, y, 16, 16);
    }
    
    
}
