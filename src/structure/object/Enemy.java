package structure.object;

import model.Game;
import prefab.Player;
import structure.basic.Attribute;
import structure.basic.GameObject;
import enums.Tag;
import structure.basic.Transform;

abstract public class Enemy extends GameObject {
    public Enemy(String[] imagePaths, Transform transform, Attribute attribute) {
        super(Tag.enemy, imagePaths, transform, attribute);
    }

    public void takeDamage(Player player, int damage) {
        int actualDamage = damage - this.getAttribute().getArmor();

        // calculate block
        if (Game.rand.nextFloat() <= this.getAttribute().getBlockChance()) {
            actualDamage *= (1 - this.getAttribute().getBlockRate());
        }

        // lowest damage is 1
        actualDamage = 1;


        //

    }

    public void attack(Player player) {

    }
}
