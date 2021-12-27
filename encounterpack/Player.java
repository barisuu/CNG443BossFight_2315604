package encounterpack;

/**
 * The type Player.
 */
public abstract class Player implements IPotencyCalculator {
    private String role;
    private int entityID;
    private int healthPoints;
    private int baseDamage;

    public Player() {
    }

    /**
     * Gets entity id of player.
     *
     * @return the entity id
     */
    protected int getEntityID() {
        return entityID;
    }

    /**
     * Gets base damage of player.
     *
     * @return the base damage
     */
    protected int getBaseDamage() {
        return baseDamage;
    }

    /**
     * Gets health points of player.
     *
     * @return the health points
     */
    protected int getHealthPoints() {
        return healthPoints;
    }

    /**
     * Gets role of player.
     *
     * @return the role
     */
    protected String getRole() {
        return role;
    }

    /**
     * Sets base damage of player.
     *
     * @param baseDamage the base damage
     */
    protected void setBaseDamage(int baseDamage) {
        this.baseDamage = baseDamage;
    }

    /**
     * Sets entity id of player.
     *
     * @param entityID the entity id
     */
    protected void setEntityID(int entityID) {
        this.entityID = entityID;
    }

    /**
     * Sets health points of player.
     *
     * @param healthPoints the health points
     */
    protected void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    /**
     * Sets role of player.
     *
     * @param role the role
     */
    protected void setRole(String role) {
        this.role = role;
    }

    @Override
    public void takeDamage(int dmg) {
        if (this.getHealthPoints() <= 0) {
            System.out.println("Player is dead.Cannot attack this player.");
            return;
        } else {
            this.setHealthPoints((healthPoints) - dmg);
            System.out.println("Player " + entityID + " now has " + healthPoints + " HP");
        }
        if(this.getHealthPoints()<=0){
            System.out.println("Player is dead.");
        }
    }


    @Override
    public int dealDamage() {
        if (this.getHealthPoints() <= 0) {
            System.out.println("Player is dead.Cannot attack.");
            return 0;
        }
        else {
            System.out.println("Player is attacking for" + baseDamage);
            return baseDamage;
        }
    }
}