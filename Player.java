import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    private int y_max = 300;
    private int vy = 0;
    private int frame_num = 0;
    
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // make him look like he's walking
        if (getY() != y_max) {
            vy += 1;
        }
        else {
            vy = 0;
            if (Greenfoot.isKeyDown("up")) {
                vy -= 15;
            }
        }
        setLocation(getX(), Math.min(getY() + vy, y_max));
        
        if (Greenfoot.isKeyDown("left") or Greenfoot.isKeyDown("right")) {
            wobble();
        }
    }
    
    private void act() {
        int i = 0;
    }
}
