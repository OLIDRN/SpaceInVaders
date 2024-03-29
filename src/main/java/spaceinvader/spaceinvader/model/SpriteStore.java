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

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import javafx.scene.image.Image;

/**
 * La classe SpriteStore permet de charger les différentes images utilisées dans les
 * sprites une et une seule fois pendant l'exécution du programme.
 *
 * @author Romain Wallon
 *
 * @version 0.1.0
 */
public final class SpriteStore {

    private String theme;

    /**
     * La {@link Map} permettant de conserver en cache les différents sprites déjà
     * chargés.
     */
    private final java.util.Map<String, javafx.scene.image.Image> spriteCache = new java.util.HashMap<>();

    /**
     * Charge l'image d'un sprite donné par son identifiant.
     *
     * @param identifier L'identifiant du sprite à charger.
     *
     * @return L'image chargée.
     */

    public SpriteStore(String theme) {
        this.theme = theme;
    }
    public javafx.scene.image.Image createSprite(String identifier) {
        // On commence par regarder si l'image a déjà été chargée.
        javafx.scene.image.Image cached = spriteCache.get(identifier);
        if (cached != null) {
            return cached;
        }

        // On charge maintenant l'image, et on la met en cache.
        javafx.scene.image.Image image = loadImage(identifier);
        spriteCache.put(identifier, image);
        return image;
    }

    /**
     * Charge une image donnée par son nom.
     *
     * @param name Le nom de l'image à charger.
     *
     * @return L'image ayant le nom donné.
     *
     * @throws NoSuchElementException S'il n'existe pas d'image ayant le nom donné.
     */
    private javafx.scene.image.Image loadImage(String name) {
        try {
            java.net.URL urlImage = getClass().getResource("/spaceinvader/spaceinvader/" + theme + "/" + name + ".png");
            return new javafx.scene.image.Image(urlImage.toExternalForm(), 50, 50, true, true);

        } catch (NullPointerException | IllegalArgumentException e) {
            throw new java.util.NoSuchElementException("Could not load image " + name, e);
        }
    }

}
