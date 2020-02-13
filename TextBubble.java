import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TextBubble here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TextBubble extends CutSceneImage
{
    /**
     * Act - do whatever the TextBubble wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setImage(new GreenfootImage("Contr", 20, 
                                    Color.WHITE, Color.BLACK));
    }    
}
