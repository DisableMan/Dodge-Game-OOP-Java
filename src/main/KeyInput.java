/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *
 * @author Hieu PC
 */
// tuong tac vs ban phim
public class KeyInput extends KeyAdapter{
    
    private Handler handler;
    private boolean[] keyPush = new boolean[4];

    public KeyInput(Handler handler) {
        this.handler = handler;
        
        for (int i = 0; i < 3; i++) {
            keyPush[i] = false;
        }
    }
    
    
    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();
        
        for (int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);
            
            if(tempObject.getId()==ID.Player){
                //key event for player 1
                if(key== KeyEvent.VK_W){ tempObject.setVelY(-5);keyPush[0]=true; }
                if(key== KeyEvent.VK_S){ tempObject.setVelY(5); keyPush[1]=true; }
                if(key== KeyEvent.VK_D){ tempObject.setVelX(5); keyPush[2]=true; }
                if(key== KeyEvent.VK_A){ tempObject.setVelX(-5);keyPush[3]=true; }
                
                if(key== KeyEvent.VK_UP){ tempObject.setVelY(-5);keyPush[0]=true; }
                if(key== KeyEvent.VK_DOWN){ tempObject.setVelY(5); keyPush[1]=true; }
                if(key== KeyEvent.VK_RIGHT){ tempObject.setVelX(5); keyPush[2]=true; }
                if(key== KeyEvent.VK_LEFT){ tempObject.setVelX(-5);keyPush[3]=true; }
            }
            
            if(key == KeyEvent.VK_ESCAPE) System.exit(1);
            
        }
        
    }
    
    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode();
        for (int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);
            
            if(tempObject.getId()==ID.Player){
                //key event for player 1
                if(key== KeyEvent.VK_W) keyPush[0] = false;
                if(key== KeyEvent.VK_S) keyPush[1] = false;
                if(key== KeyEvent.VK_D) keyPush[2] = false;
                if(key== KeyEvent.VK_A) keyPush[3] = false;
                
                if(key== KeyEvent.VK_UP) keyPush[0] = false;
                if(key== KeyEvent.VK_DOWN) keyPush[1] = false;
                if(key== KeyEvent.VK_RIGHT) keyPush[2] = false;
                if(key== KeyEvent.VK_LEFT) keyPush[3] = false;
                
                if(!keyPush[0] && !keyPush[1]) tempObject.setVelY(0);
                if(!keyPush[2] && !keyPush[3]) tempObject.setVelX(0);
                
            }
            
            
        }        
    }
    
}
