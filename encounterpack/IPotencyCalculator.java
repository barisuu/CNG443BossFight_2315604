package encounterpack;

/**
 * The interface Potency calculator.
 */
public interface IPotencyCalculator {
    /**
     * Deal damage int used in player and enemy.
     *
     * @return the int
     */
    int dealDamage();

    /**
     * Take damage used in player and enemy.
     *
     * @param dmg the dmg
     */
    void takeDamage(int dmg);
}
