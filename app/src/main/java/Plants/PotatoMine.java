package Plants;

import Position.Position;

import PlantAbility.*;
import Zombies.Zombie;

import java.util.List;
import java.util.ArrayList;

public class PotatoMine extends Plant implements PlantAbility{

    private boolean isReady = false;
    private List<Zombie> targets = new ArrayList<>();
    
    public PotatoMine()
    {
        super("PotatoMine", 25, 400, 180, 1, -1, 0,  new Position(0, 0)); // masih tentatif damage dia berapa
    }
    
    @Override
    public void refreshCreature() {
        super.refreshCreature();
        if (!isReady) {
            if (getCooldown() == 0) {
                isReady = true;
                System.out.println("PotatoMine is ready to explode!");
            }
        }
    }

    public void setTargets(List<Zombie> targets)
    {
        this.targets = targets;
    }

    public void addTarget(Zombie z)
    {
        targets.add(z);
    }

    public void removeTarget(Zombie z)
    {
        targets.remove(z);
    }

    // Override method from Plant class to handle using the ability
    @Override
        public void useAbility() {
        if (isReady) {
            for (Zombie z : targets) {
                z.reduceHealth(z.getHealth()); // Menghabiskan health zombie (Instant kill)
            }
            // Set health of PotatoMine to 0 (Menghilangkan PotatoMine)
            setHealth(0);
            System.out.println("PotatoMine explodes and vanishes!");
        } else {
            System.out.println("PotatoMine is not ready yet!");
        }
    }

    @Override   
    public void checkToUseAbility(){}

}

/* jadi disini aku add variabel boolean isReady yang 
menandakan apakah PotatoMine sudah siap untuk meledak atau belum. 
Waktu siapnya diatur pas pertama kali dia ditanam dgn nilai cooldown pd konstruktornya. 
Setelah itu, dalam setiap pembaruan (refreshCreature()), bakal diperiksa apakah 
PotatoMine sudah siap atau belum. Kalau sudah, 
dia akan meledak dan mengurangi hp zombie di depannya (yg jd target). 
Setelah meledak, hp PotatoMine diatur jadi 0 yang show kalau dia udh ga aktif lagi
*/

