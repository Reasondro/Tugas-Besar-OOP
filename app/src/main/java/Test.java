import GameMap.GameMap;
import Zombies.*;
import Position.Position;
import Petak.Petak;
import Plants.*;


public class Test {

    public static void main(String[] args) {
        GameMap gameMap = GameMap.getInstance();

        Peashooter peashooter = new Peashooter();
        Sunflower sunflower = new Sunflower();
        Lilypad lilypad1 = new Lilypad();
        Lilypad lilypad2 = new Lilypad();
        Snowpea snowpea = new Snowpea();

        PoleVaultingZombie poleVaultingZombie = new PoleVaultingZombie();
        DolphinRiderZombie dolphinRiderZombie = new DolphinRiderZombie();

        Position posP11 = new Position(1, 1);
        Position posP12 = new Position(1, 2);
        Position posP13 = new Position(1, 3);
        Position posP14 = new Position(1, 4);
        Position posP15 = new Position(1, 5);

        Position posP31 = new Position(3, 1);
        Position posP32 = new Position(3, 2);
        Position posP33 = new Position(3, 3);


        // gameMap.getPetak(posP11).addCreature(sunflower);
        gameMap.getPetak(posP12).addCreature(peashooter);
        gameMap.getPetak(posP13).addCreature(poleVaultingZombie);

        gameMap.getPetak(posP31).addCreature(lilypad1);
        gameMap.getPetak(posP31).addCreature(snowpea);
        gameMap.getPetak(posP32).addCreature(lilypad2);
        gameMap.getPetak(posP33).addCreature(dolphinRiderZombie);

        gameMap.printMap();

        System.out.println("After testing");
        poleVaultingZombie.checkToUseAbility();
        dolphinRiderZombie.checkToUseAbility();
        gameMap.printMap();

    
}
}
