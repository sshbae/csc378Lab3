import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends ScrollingActor
{
    private int yMax = 300;
    private int vy = 0;
    private int wobbleDegree = 5;
    private int wobbleCounter = 0;
    
    private int collisionThrowDirectionX=0;
    private int collesionThrowDirectionY=0;
    private int collisionThrowDistance=0;
    private int collisionForce=5;
    
    GreenfootImage reg = new GreenfootImage("tile000.png");
    GreenfootImage stunned = new GreenfootImage("tile031.png");
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
        
        if (Greenfoot.isKeyDown("left")) {
            setLocation(getX() - 3, getY());
            wobble();
            setRotation(0);
        }
        if (Greenfoot.isKeyDown("right")) {
            setLocation(getX() + 3, getY());
            wobble();
            setRotation(0);
        }
        
        if(collisionThrowDistance > 0)
        {  
            setLocation(getX()-collisionThrowDirectionX*collisionForce,getY()+1);
            collisionThrowDistance--;
        }
        else 
        {
                
            TP t = (TP) getOneIntersectingObject(TP.class);
            if (t != null)
            {
                setImage(stunned);//Greenfoot.playSound("punch.wav");
                if (t.getX() < getX())
                    collisionThrowDirectionX = -1;
                else
                    collisionThrowDirectionX = 1;
            collisionThrowDistance=20;
            }
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
