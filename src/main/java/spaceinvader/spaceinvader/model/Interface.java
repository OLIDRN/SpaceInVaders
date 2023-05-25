package spaceinvader.spaceinvader.model;

public interface Interface {
    public void setSpaceInvaders(SpaceInvadersGame spaceInvader);
    public void setGameGrid(GameGrid gameGrid);
    public void addMovable(AbstractMovable movable);
    public void removeMovable(AbstractMovable movable);
    public void endGame(String message);

    public static void setScore(int score) {

    }
    public static void setLife(int life) {

    }
}