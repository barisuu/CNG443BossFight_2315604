package encounterpack;

/**
 * The type Healer.
 */
public class Healer extends Player {
    private int mind;

    /**
     * Instantiates a new Healer.
     *
     * @param hp   the hp
     * @param dmg  the dmg
     * @param role the role
     * @param mind the mind
     */
    public Healer(int hp,int dmg,String role,int mind) {
        this.setHealthPoints(hp);
        this.setBaseDamage(dmg);
        this.setRole(role);
        this.setMind(mind);
        this.setEntityID(3);
    }

    private int getMind() {
        return mind;
    }

    private void setMind(int mind) {
        this.mind = mind;
    }

    /**
     * Returns mind attribute to be used in healing.
     *
     * @return the int
     */
    protected int heal(){
        /*

        Initially used to stop healer from healing when dead. Later moved this function to playerHeal method in EncounterManager

        if(this.getHealthPoints()<=0){
            System.out.println("Healer is dead. Cannot heal.");
            return 0;
        }
        else{
            return (mind+10);
        }*/

        return (mind+10);
    }
}
