/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.awt.Graphics;
import java.util.LinkedList;
// Xu ly
public class Handler {
    LinkedList<GameObject> object = new LinkedList<GameObject>();
    public void tick(){
        for(int i=0; i< object.size(); i++){
            GameObject tempObject = object.get(i);
            tempObject.tick();
        }
    }
    public void render(Graphics g){
        for(int i=0; i< object.size(); i++){
            GameObject tempObject = object.get(i);
            tempObject.render(g);
        }
    }
    public void addObject(GameObject object){
        this.object.add(object);
    }
    public void removeObject(GameObject object){
        this.object.remove(object);
    }
    
    public void clearEnemies() {
        for (int i = 0; i < this.object.size(); i++) {
            GameObject tempObject = this.object.get(i);
            if (tempObject.getId() != ID.Player) {
                this.removeObject(tempObject);
                i--;
            }else{
                object.clear();
                if(Game.gameState != Game.STATE.End )
                    addObject(new Player(tempObject.getX(),tempObject.getY(),
                    ID.Player,this));
            }
        }
        
    }
}
