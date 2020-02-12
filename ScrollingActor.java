import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * This class contains the scrolling actor. This actor will always be in the middle of the screen and the objects around him will be moved.
 * You shouldn't change the code of this class because that will probably cause problems in the scrolling system.
 */
public abstract class ScrollingActor extends Thing
{
    private boolean scrollingCenter;
    
    public ScrollingActor() {
        scrollingCenter = true;
    }
    public ScrollingActor(boolean scrollingCenter) {
        this.scrollingCenter = scrollingCenter;
    }
    
    public final void addedToWorld(World world) {
        if (scrollingCenter) {
            List<ScrollingActor> scrollingActors = getWorld().getObjects(ScrollingActor.class);
            if (scrollingActors != null && !scrollingActors.isEmpty()) {
                for (ScrollingActor scrollingActor : scrollingActors) {
                    if (!scrollingActor.equals(this)) {
                        scrollingActor.setScrollingCenter(false);
                    }
                }
            }
        }
    }
    
    /**
     * An extended setLocation method.
     * You should not change this method. That would cause problems in the programm.
     * 
     * @param x
     *      The new x location of the actor.
     * 
     * @param y
     *      The new x location of the actor.
     */
    public final void setLocation(int x, int y) {
        super.setLocation(x, y);
        if (scrollingCenter) {
            getWorld().resetPlayersPosition(this);
        }
    }

    /**
     * An extended setLocation method which uses double values for the coordinates and doesn't always reset the players position.
     * You should not change this method. That would cause problems in the programm.
     * 
     * @param x
     *      The new x location of the actor.
     * 
     * @param y
     *      The new x location of the actor.
     * 
     * @param resetPosition
     *      If you don't want to reset the players position this value has to be false.
     */
    public final void setLocation(int x, int y, boolean resetPosition) {
        super.setLocation(x, y);
        if (scrollingCenter && resetPosition) {
            getWorld().resetPlayersPosition(this);
        }
    }
    
    public final boolean isScrollingCenter() {
        return scrollingCenter;
    }
    public final void setScrollingCenter(boolean scrollingCenter) {
        this.scrollingCenter = scrollingCenter;
    }
}