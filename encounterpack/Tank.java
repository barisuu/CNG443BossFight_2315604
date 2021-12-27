package encounterpack;

/**
 * The type Tank.
 */
public class Tank extends Player{
    private int defense;

    /**
     * Instantiates a new Tank.
     *
     * @param hp      the hp
     * @param dmg     the dmg
     * @param role    the role
     * @param defense the defense
     */
    Tank(int hp,int dmg,String role,int defense) {
        this.setHealthPoints(hp);
        this.setBaseDamage(dmg);
        this.setRole(role);
        this.setDefense(defense);
        this.setEntityID(1);
    }

    private void setDefense(int defense) {
        this.defense = defense;
    }

    private int getDefense() {
        return defense;
    }

    @Override
    public void takeDamage(int dmg) {
        if(this.getHealthPoints()<=0){
            System.out.println("Player is dead.Cannot attack this player.");
            return;
        }
        this.setHealthPoints(this.getHealthPoints()-(dmg-defense));
        System.out.println(this.getRole() + " " + " now has" + this.getHealthPoints() + " HP");
        if(this.getHealthPoints()<=0){
            System.out.println(this.getRole() + " is dead.");
        }
    }
}
