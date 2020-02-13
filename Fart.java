import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Fart here.
 * 
 * @author Foaad 
 * @version (a version number or a date)
 */
public class Fart  extends AnimatedActor
{
    private int countDown = 40;
    private int size = 0;

    public Fart()
    {
        super("fart_shot",".png",9);
    }
    /**
     * Act - do whatever the Fart wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {   
        super.act();
        countDown--;
        TP t = (TP) getOneIntersectingObject(TP.class);
        if (t != null)
        {
            getWorld().removeObject(t);
        }
        if (countDown <= 0){
            getWorld().removeObject(this);
        }
    }
}
