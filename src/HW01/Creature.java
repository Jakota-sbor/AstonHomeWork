package HW01;

import java.util.Random;

public abstract class Creature implements IMortal {
    protected final int startHealth;
    private final int attackMin;
    private final int attackMax;
    private int currentHealth;

    private static final Random rnd = new Random();

    public Creature(int startHealth, int attackMin, int attackMax) {
        this.startHealth = startHealth;
        this.attackMin = attackMin;
        this.attackMax = attackMax;
        this.currentHealth = this.startHealth;
    }

    public int getHealth() {
        return currentHealth;
    }

    public void setHealth(int value) {
        if (value > 0)
            currentHealth = value;
        else
            currentHealth = 0;
    }

    public boolean isAlive()
    {
        return currentHealth > 0;
    }

    public int getRandomDamage() {
        if (attackMax - attackMin > 0)
            return rnd.nextInt(attackMax - attackMin) + attackMin;
        else
            return 0;
    }

    public abstract void takeDamage(int damage);
}
