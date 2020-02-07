import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class Fly here.
 * 
 * @author Foaad Khosmood
 * @version (a version number or a date)
 */
public class Fly  extends AnimatedActor
{
    private int waitBetween=0;
    private int angleFlyDuration=0;
    private static int ANGLE_FLY_MAX=50;
    
    
    public Fly()
    {
        super("fly",".png",9);
    }
    /**
     * Act - do whatever the Fly wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        int x,y;
        super.act();
        
        List players = getNeighbours(20+((MyWorld) getWorld()).getLevel()*10, false, Player.class);
        
        if (players.isEmpty() || waitBetween > 0) //normal movement
        {
            if (super.directionL)
                move(-1.0);
            else
                move(1.0);
         }
         else if (waitBetween < 1) //go toward the Player
         {
             Player player = (Player) players.get(0);
             if (player.getX() < getX())
             {
                 if (!super.directionL)
                    {
                        waitBetween = 40;
                        turn();
                    }
                    
                 move(-1.0);
             }
             else
             {
                 if(super.directionL)
                    {
                        waitBetween = 40;
                        turn();
                    }
                    
                 move(1.0);
              }
              
              if(player.getY() > getY())
                setLocation(getX(),getY()+2);
              else
                setLocation(getX(),getY()-2);
              
              //detect nearby debris
         }
         
         
         if (waitBetween > 0)
            waitBetween --;
        
         //actual player collision  
         Player s = (Player) getOneIntersectingObject(Player.class);
         if (s != null)
         {
            waitBetween = 100;
            setRotation(15);
            angleFlyDuration = 10;
        }
        //Sonar Charge detection
        SonarCharge sc = (SonarCharge) getOneIntersectingObject(SonarCharge.class);
            if (sc != null)
            {
                if (sc.getX() > getX())
                    x = getX() - 10;
                else
                    x = getX() + 10;
                    
                if (sc.getY() > getY())
                    y = getY() - 10;
                else
                    y = getY() + 10;
                
                
                setLocation(x,y);
            }
        
         
        //edge detection
        if (atWorldEdge()) {
           turn(); move();
           if (getY() < 2)
                setLocation(getX(),5);
           if (getY() > getWorld().getHeight()-2)
                setLocation(getX(),getWorld().getHeight()-5);
        }
        
        //angle fly code
        if (getRotation() != 0)
        {
            angleFlyDuration--;
            if(angleFlyDuration <= 0)
                setRotation(0);
        }
        else
            if (Greenfoot.getRandomNumber(1000) > 995)
                {
                    angleFlyDuration=ANGLE_FLY_MAX;
                    if(Greenfoot.getRandomNumber(2) == 0)
                        turn(30+Greenfoot.getRandomNumber(30));
                    else
                        turn(-30-Greenfoot.getRandomNumber(30));
                }
    }    
}

