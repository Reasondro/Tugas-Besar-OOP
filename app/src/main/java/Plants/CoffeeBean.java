package Plants;

import Position.Position;

public class CoffeeBean extends Plant{
    
    public CoffeeBean()
    {
        super("Coffee Bean", 100, 100, 0, 0, 0, 0,  new Position(0, 0));   
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
