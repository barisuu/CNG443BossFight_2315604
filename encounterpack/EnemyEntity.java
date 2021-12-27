package encounterpack;

/**
 * The type Enemy entity.
 */
public class EnemyEntity implements IPotencyCalculator {
    private int entityID;
    private int healthPoints;
    private int baseDamage;

    /**
     * Instantiates a new Enemy entity.
     *
     * @param entityID     the entity id
     * @param healthPoints the health points
     * @param baseDamage   the base damage
     */
    public EnemyEntity(int entityID, int healthPoints, int baseDamage) {
        this.entityID = entityID;
        this.healthPoints = healthPoints;
        this.baseDamage = baseDamage;
        this.setEntityID(4);
    }

    /**
     * Gets health points of enemy.
     *
     * @return the health points
     */
    protected int getHealthPoints() {
        return healthPoints;
    }

    /**
     * Gets base damage of enemy.
     *
     * @return the base damage
     */
    protected int getBaseDamage() {
        return baseDamage;
    }

    /**
     * Gets entity id of enemy.
     *
     * @return the entity id
     */
    protected int getEntityID() {
        return entityID;
    }

    /**
     * Sets health points of enemy.
     *
     * @param healthPoints the health points
     */
    protected void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    /**
     * Sets entity id of enemy.
     *
     * @param entityID the entity id
     */
    protected void setEntityID(int entityID) {
        this.entityID = entityID;
    }

    /**
     * Sets base damage of enemy.
     *
     * @param baseDamage the base damage
     */
    protected void setBaseDamage(int baseDamage) {
        this.baseDamage = baseDamage;
    }

    @Override
    public int dealDamage() {
      //  System.out.println("Enemy is attacking for" + baseDamage);
        return baseDamage;
    }

    @Override
    public void takeDamage(int dmg) {
        this.healthPoints-=dmg;
        System.out.println("Enemy " + entityID + " now has" + healthPoints + " HP");
        if(this.getHealthPoints()<=0){
            System.out.println("Enemy is dead!");
        }
    }
}