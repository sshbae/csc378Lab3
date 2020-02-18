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
    GreenfootImage stunned = new GreenfootImage("tile010.png");
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (((MyWorld)getWorld()).getTotalXMovement() > 1000) {
            Greenfoot.setWorld(new CreditScene());
        }
        
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
            setImage(reg);                
            TP t = (TP) getOneIntersectingObject(TP.class);
            if (t != null)
            {
                setImage(stunned);//Greenfoot.playSound("punch.wav");
                if (t.getX() < getX())
                    collisionThrowDirectionX = -1;
                else
                    collisionThrowDirectionX = 1;
            collisionThrowDistance=20;
            ((MyWorld)getWorld()).downLife();
            }
            Fly f = (Fly) getOneIntersectingObject(Fly.class);
            if (f != null){
            if (!f.dead)
            {
                if (getY() < f.getY() - 50 && Math.abs(getX()- f.getX()) < 70)
                    f.died=true;
                else{
                    setImage(stunned);//Greenfoot.playSound("punch.wav");
                    if (f.getX() < getX())
                        collisionThrowDirectionX = -1;
                    else
                        collisionThrowDirectionX = 1;
                    collisionThrowDistance=10;
                    ((MyWorld)getWorld()).downLife();
                }
            }
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
