import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BadEndScene here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BadEndScene extends CutScene
{
    private int timer = 0;
    
    /**
     * Constructor for objects of class CreditScene.
     * 
     */
    public BadEndScene()
    {
        addObject(new Text("GAME OVER"), 300, 400);
    }
    
    public void act()
    {
        timer++;
        
        if (timer > 300) {
            showText("(press space to restart)", getWidth()/2, getHeight()/2);
            if (Greenfoot.isKeyDown("space")) {
                Greenfoot.setWorld(new TitleScene());
            }
        }
    }
}
