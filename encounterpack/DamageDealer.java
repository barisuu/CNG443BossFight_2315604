package encounterpack;

/**
 * The type Damage dealer.
 */
public class DamageDealer extends Player {
    private int intelligence;


    /**
     * Instantiates a new Damage dealer.
     *
     * @param hp           the hp
     * @param dmg          the dmg
     * @param role         the role
     * @param intelligence the intelligence
     */
    public DamageDealer(int hp, int dmg, String role, int intelligence) {
        this.setHealthPoints(hp);
        this.setBaseDamage(dmg);
        this.setRole(role);
        this.setIntelligence(intelligence);
        this.setEntityID(2);
    }

    private int getIntelligence() {
        return intelligence;
    }

    private void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    @Override
    public int dealDamage() {
        if (this.getHealthPoints() <= 0) {
            System.out.println("Player is dead.Cannot attack.");
            return 0;
        }
        else {
            System.out.println(this.getRole() + " is attacking for" + (this.getBaseDamage() + intelligence));
            return (this.getBaseDamage() + intelligence);
        }
    }
}
