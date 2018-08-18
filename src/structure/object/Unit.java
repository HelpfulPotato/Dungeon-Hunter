package structure.object;

import enums.Rotation;
import enums.State;
import enums.Tag;
import model.Game;
import prefab.Player;
import structure.basic.Attribute;
import structure.basic.GameObject;
import structure.basic.Transform;

import java.util.HashMap;

abstract public class Unit extends GameObject {
    public Unit(Tag tag, HashMap<Rotation, String[]> imagePaths, Transform transform, Attribute attribute) {
        super(tag, imagePaths, transform, attribute);
    }

    public Unit(Tag tag, String[] imagePaths, Transform transform, Attribute attribute) {
        super(tag, imagePaths, transform, attribute);
    }


    public void attack(Unit defender) {
        Game.instance().suspend(State.battle);
        int damage = this.getAttribute().getStrength();

        // calculate crit
        if (Game.rand.nextFloat() <= this.getAttribute().getCritChance()) {
            damage *= Attribute.critRate;
        }

        // lowest damage is 1
        if (damage < 1) damage = 1;

        int actualDamage = defender.takeDamage(this, damage);
    }

    public int takeDamage(Unit attacker, int damage) {
        int actualDamage = damage - this.getAttribute().getArmor();

        // calculate block
        if (Game.rand.nextFloat() <= this.getAttribute().getBlockChance()) {
            actualDamage *= (1 - this.getAttribute().getBlockRate());
        }

        // lowest damage is 1
        actualDamage = 1;


        // check if attacker has anything to do after taking damage
        attacker.afterAttack(actualDamage);

        // check if counter

        return actualDamage;
    }


    public void afterAttack(int actualDamage) {
        // if absorb
    }
}
