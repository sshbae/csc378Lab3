import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    private int yMax = 300;
    private int vy = 0;
    private int wobbleDegree = 5;
    private int wobbleCounter = 0;
    
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (getY() != yMax) {
            vy += 1;
        }
        else {
            vy = 0;
            if (Greenfoot.isKeyDown("up")) {
                vy -= 15;
            }
        }
        setLocation(getX(), Math.min(getY() + vy, yMax));
        
        if (Greenfoot.isKeyDown("left") || Greenfoot.isKeyDown("right")) {
            wobble();
            setRotation(0);
        }
    }
    
    private void wobble() {
        if (wobbleCounter == 5) {
            wobbleDegree *= -1;
            setRotation(wobbleDegree);
            wobbleCounter = 0;
        }
        else {
            wobbleCounter += 1;
        }
    }
}
