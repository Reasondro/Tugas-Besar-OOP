package Zombies;

import Creature.Creature;
import GameMap.GameMap;
import Petak.Petak;
import Plants.Plant;

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

    private Petak petakInFront;
    private boolean abilityUsed;
    private int originalAttackDamage;

    public DoubleAttackZombie(){
        super("Double Attack Zombie", 150, 100, 1, 1,false,  new Position(0, 0));
        this.abilityUsed = false;
        this.originalAttackDamage = getAttackDamage();
    }

    public Petak getPetakInFront()
    {
        return petakInFront;
    }

    public void setPetakInFront(Petak petakInFront)
    {
        this.petakInFront = petakInFront;
    }

   public boolean isPlantInFront()
    {
        setPetakInFront(GameMap.getInstance().getPetakInFrontOfZombie(this));
        
        for(Creature c : petakInFront.getCreatures())
        {
            if(c instanceof Plant)
            {
                return true;
            }
        }
        return false;
    }
    @Override
    public void useAbility() {
            int currentAttackDamage = getAttackDamage();
            setAttackDamage(currentAttackDamage * 2); // Menggandakan attack damage
            abilityUsed = true;
    }


    @Override
    public void checkToUseAbility() {
        if ( isPlantInFront() && !abilityUsed) {

            useAbility();
            //? dibawah sini seelsai make ability.
            setAttackDamage(originalAttackDamage);
        }

    }
}