package HW01;
import java.util.Random;

public abstract class Hero extends Creature {
    private String name;// вероятность промаха

    public Hero(String name, int startHealth, int attackMin, int attackMax) {
        super(startHealth,attackMin,attackMax);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void takeDamage(int damage) {
        setHealth(getHealth() - damage);
        if (getHealth() > 0)
            System.out.printf("%s получил %d урона, осталось здоровья: %d%n", getName(), damage, getHealth());
        else
            System.out.printf("%s получил %d урона и умер%n", getName(), damage);
    }

    public abstract void attackEnemy(Enemy enemy);
}
