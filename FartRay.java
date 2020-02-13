import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class FartRay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FartRay extends ScrollingActor
{
    /**
     * Act - do whatever the FartRay wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        super.act();
        if(isTouching(Player.class)){
          Player p = (Player) getOneIntersectingObject(Player.class);
          setLocation(p.getX()+30,p.getY()-10);
        }
    }    
}
