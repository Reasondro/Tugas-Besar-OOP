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
    private int originalAttackDamage;

    public DoubleAttackZombie(){
        super("Double Attack Zombie", 150, 100, 1, 1,false,  new Position(0, 0));
        this.abilityUsed = false;
        this.originalAttackDamage = getAttackDamage();
    }

    @Override
    public void useAbility() {
            int currentAttackDamage = getAttackDamage();
            setAttackDamage(currentAttackDamage * 2); // Menggandakan attack damage
            abilityUsed = true;
    }


    @Override
    public void checkToUseAbility() {
        if (!abilityUsed) {
            GameMap gameMap = GameMap.getInstance();
            Petak inFrontOfZombie = gameMap.getPetakInFrontOfZombie(this);

            if (inFrontOfZombie != null && !inFrontOfZombie.getPlants().isEmpty()) {
                useAbility();
            }
        }
        else{
            setAttackDamage(originalAttackDamage);
            abilityUsed = false;
        }
    }
}
