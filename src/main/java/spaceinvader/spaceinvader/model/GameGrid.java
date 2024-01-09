/**
 * Ce logiciel est distribué à des fins éducatives.
 *
 * Il est fourni "tel quel", sans garantie d’aucune sorte, explicite
 * ou implicite, notamment sans garantie de qualité marchande, d’adéquation
 * à un usage particulier et d’absence de contrefaçon.
 * En aucun cas, les auteurs ou titulaires du droit d’auteur ne seront
 * responsables de tout dommage, réclamation ou autre responsabilité, que ce
 * soit dans le cadre d’un contrat, d’un délit ou autre, en provenance de,
 * consécutif à ou en relation avec le logiciel ou son utilisation, ou avec
 * d’autres éléments du logiciel.
 *
 * (c) 2022-2023 Romain Wallon - Université d'Artois.
 * Tous droits réservés.
 */

package spaceinvader.spaceinvader.model;

public final class GameGrid {

    private int height;
    private int width;
    private spaceinvader.spaceinvader.model.Tile[][] tiles;

    public GameGrid(int height, int width) {
        this.width = width;
        this.height = height;
        this.tiles = new spaceinvader.spaceinvader.model.Tile[height][width];
        init();
    }

    private void init() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                tiles[i][j] = new spaceinvader.spaceinvader.model.Tile(i, j);
            }
        }
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public boolean isOnGrid(int row, int column) {
        return ((0 <= row) && (row < height))
                && ((0 <= column) && (column < width));
    }

    public spaceinvader.spaceinvader.model.Tile get(int row, int column) {
        return tiles[row][column];
    }
}
