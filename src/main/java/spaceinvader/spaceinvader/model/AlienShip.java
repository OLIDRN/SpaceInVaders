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

/**
 * La classe AlienShip représente un vaisseau alien se déplaçant sur la grille du jeu
 * Space-Invaders.
 *
 * @author Romain Wallon
 *
 * @version 0.1.0
 */
public final class AlienShip extends spaceinvader.spaceinvader.model.AbstractMovable {

    /**
     * La Timeline permettant à cet alien de se déplacer seul.
     */
    private javafx.animation.Timeline timeline;

    /**
     * Crée une nouvelle instance d'AlienShip.
     *
     * @param game Le jeu de Space-Invaders dans lequel l'objet se déplace.
     * @param sprite L'image représentant l'objet.
     */
    public AlienShip(spaceinvader.spaceinvader.model.SpaceInvadersGame game, javafx.scene.image.Image sprite) {
        super(game, sprite, 1);
    }

    /**
     * Anime cet alien afin qu'il se déplace seul.
     */
    public void animate() {
        timeline = new javafx.animation.Timeline(new javafx.animation.KeyFrame(javafx.util.Duration.seconds(1), e -> game.move(this)));
        timeline.setCycleCount(javafx.animation.Animation.INDEFINITE);
        timeline.play();
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * fr.univartois.butinfo.ihm.spaceinvaders.model.AbstractMovable#decrementHealth()
     */
    @Override
    public void decrementHealth() {
        super.decrementHealth();
        if (getHealth().get() == 0) {
            game.alienIsDead();
            timeline.stop();
        }
    }

}
