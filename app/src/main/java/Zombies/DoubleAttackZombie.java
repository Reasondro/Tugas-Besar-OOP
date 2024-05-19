package Zombies;

import GameMap.GameMap;
import Petak.Petak;

// import java.util.List;

// import GameMap.GameMap;
// import Petak.Petak;
// import Plants.Plant;
// import GameMap.GameMap;
// import Petak.Petak;
import Position.Position;
import ZombieAbility.*;

// Kekuatannya dikali 2 aja
// Tapi cm bisa dipake sekali
// Kekuatannya dipake kalo depannya ada taneman

public class DoubleAttackZombie extends Zombie implements ZombieAbility{

    private boolean abilityUsed;
    
    public DoubleAttackZombie(){
        super("Double Attack Zombie", 150, 100, 1, 1,false,  new Position(0, 0));
    }

    @Override
    public void useAbility() {
        if (!abilityUsed) {
            int currentAttackDamage = getAttackDamage();
            setAttackDamage(currentAttackDamage * 2); // Menggandakan attack damage
            abilityUsed = true; 
        }
    }

    @Override 
    public void checkToUseAbility() {
        if (!abilityUsed) {
            GameMap gameMap = GameMap.getInstance();
            // Position currentPosition = this.getPos();
            Petak inFrontOfZombie = gameMap.getPetakInFrontOfZombie(this);

            if (!inFrontOfZombie.getPlants().isEmpty()) {
                useAbility(); 
            }
        }
    }
}
