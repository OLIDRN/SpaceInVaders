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

package spaceinvader.spaceinvader;

import javafx.scene.image.Image;

/**
 * La classe AbstractMovable est la classe parente des différents objets mobiles pouvant
 * se déplacer dans le jeu Space-Invaders.
 *
 * @author Romain Wallon
 *
 * @version 0.1.0
 */
public abstract class AbstractMovable {

    /**
     * Le jeu Space-Invaders, dans lequel cet objet mobile se déplace.
     */
    protected final SpaceInvadersGame game;

    /**
     * La ligne où se trouve cet objet mobile.
     */
    private int row;

    /**
     * La colonne où se trouve cet objet mobile.
     */
    private int column;

    /**
     * L'image représentant cet objet mobile.
     */
    private final javafx.scene.image.Image sprite;

    /**
     * Les points de vie restants pour cet objet mobile.
     */
    private int health;

    /**
     * Crée une nouvelle instance d'AbstractMovable.
     *
     * @param game Le jeu de Space-Invaders dans lequel l'objet se déplace.
     * @param sprite L'image représentant l'objet.
     * @param initialHealth Les points de vie initiaux de l'objet.
     */
    protected AbstractMovable(SpaceInvadersGame game, javafx.scene.image.Image sprite, int initialHealth) {
        this.game = game;
        this.sprite = sprite;
        this.health = initialHealth;
    }

    /**
     * Donne la ligne où se trouve cet objet mobile.
     *
     * @return La ligne où se trouve cet objet mobile.
     */
    public int getRow() {
        return row;
    }

    /**
     * Donne la colonne où se trouve cet objet mobile.
     *
     * @return La colonne où se trouve cet objet mobile.
     */
    public int getColumn() {
        return column;
    }

    /**
     * Modifie la position de cet objet mobile.
     *
     * @param row La ligne où se trouve maintenant cet objet mobile.
     * @param column La colonne où se trouve maintenant cet objet mobile.
     */
    public void setPosition(int row, int column) {
        this.row = row;
        this.column = column;
    }

    /**
     * Donne l'image représentant cet objet mobile.
     *
     * @return L'image représentant cet objet mobile.
     */
    public javafx.scene.image.Image getSprite() {
        return sprite;
    }

    /**
     * Donne les points de vie restants pour cet objet mobile.
     *
     * @return Les points de vie restants pour cet objet mobile.
     */
    public int getHealth() {
        return health;
    }

    /**
     * Augmente les points de vie de cet objet mobile.
     */
    public void incrementHealth() {
        health++;
    }

    /**
     * Diminue les points de vie de cet objet mobile.
     */
    public void decrementHealth() {
        health--;
        if (health == 0) {
            game.removeMovable(this);
        }
    }

}
