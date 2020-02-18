import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Text here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Text extends CutSceneImage
{
    public Text(String s)
    {
        GreenfootImage i = new GreenfootImage(s, 16, Color.BLACK, Color.WHITE);
        setImage(i);
    }
    
    /**
     * Act - do whatever the Text wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setLocation(getX(), getY() - 2);
    }    
}
