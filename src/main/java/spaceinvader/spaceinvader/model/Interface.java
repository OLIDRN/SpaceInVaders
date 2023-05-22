package spaceinvader.spaceinvader.model;

public interface Interface {
    public void setSpaceInvader(SpaceInvadersGame spaceInvader);
    public void setGameGrid(GameGrid gameGrid);
    public void addMovable(AbstractMovable movable);
    public void removeMovable(AbstractMovable movable);
    public void endGame(String message);
}