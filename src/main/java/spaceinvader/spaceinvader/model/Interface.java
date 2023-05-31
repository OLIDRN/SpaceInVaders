package spaceinvader.spaceinvader.model;

public interface Interface {
    public void setSpaceInvaders(SpaceInvadersGame spaceInvader);
    public void setGameGrid(GameGrid gameGrid);
    public void addMovable(AbstractMovable movable);
    public void removeMovable(AbstractMovable movable);
    public void endGame(String message);
    public void setScore(javafx.beans.property.IntegerProperty score) ;
    public void setLife(javafx.beans.property.IntegerProperty life);
}