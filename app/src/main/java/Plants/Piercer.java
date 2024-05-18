package Plants;

import Position.Position;

import PlantAbility.*;
import Zombies.Zombie;
import Bullet.PiercerBullet;

import java.util.List;
import java.util.ArrayList;
import GameMap.GameMap;
import Petak.Petak;


public class Piercer extends Plant implements PlantAbility{
    
    public Piercer()
    {
        super("Piercer", 100, 100, 0, 0, 0, 0,  new Position(0, 0));   
    }
    
    public void specialSetPosition(Position newPosition) {
        super.setPos(newPosition);
        // Double the bullet damage of other plants in the same position
        doubleOtherPlantsDamage(newPosition);
    }

    private void doubleOtherPlantsDamage(Position position) {
        for (Plant plant : position.getPlants()) {
            if (plant != this) {
                plant.doubleBulletDamage();
            }
        }
    }
}