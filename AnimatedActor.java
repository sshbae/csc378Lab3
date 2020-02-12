import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The AnimatedActor class serves as a superclass for other, more specific
 * Actor classes. It provides a mechanism to give actors an animated image.
 * 
 * ...more here.. image names
 * 
 * @author mik
 * @version 1.0
 */
public class AnimatedActor extends Mover
{
    private GreenfootImage[] imagesR;
    private GreenfootImage[] imagesL;
    private int currentImage = 0;
    private int imageBuffer = 3;
    
    public boolean animateBuffer() 
    {
        if (imageBuffer < 1)
        {
            imageBuffer = 5;
            return true;
        }
        else
            imageBuffer--;
            
        return false;
    }
    
    public AnimatedActor(String basename, String suffix, int noOfImages)
    {
        imagesR = new GreenfootImage[noOfImages];
        imagesL = new GreenfootImage[noOfImages];
        
        for(int i=0; i < noOfImages; i++) {
            imagesL[i] = new GreenfootImage(basename + 'L' + i + suffix);
            imagesR[i] = new GreenfootImage(imagesL[i]);
            imagesR[i].mirrorHorizontally();
//            imagesR[i] = new GreenfootImage(basename + 'R' + i + suffix);
        }
        
        setImage(imagesL[currentImage]);
    }
    
    /**
     * Act - do whatever the AnimatedActor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (animateBuffer())
            currentImage = (currentImage + 1) % imagesL.length;
            
        if (super.directionL)
            setImage(imagesL[currentImage]);
        else
            setImage(imagesR[currentImage]);
    }
}

