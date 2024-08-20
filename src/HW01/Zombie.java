package HW01;

public class Zombie extends Enemy {
    public Zombie(String name, int startHealth, int attackMin, int attackMax) {
        super(name, startHealth, attackMin, attackMax);
    }

    @Override
    public void attackEnemy(Hero enemy) {
        int damage = getRandomDamage();
        if (damage > 0) {
            System.out.printf("%s кусает %s и наносит %d урона!%n", getName(), enemy.getName(), damage);
            enemy.takeDamage(damage);
        }
        else
            System.out.printf("%s промахнулся!%n", getName());
    }

    @Override
    public void takeDamage(int damage) {
        super.takeDamage(damage);
        if (!isAlive() && Math.random() <= 0.1) { // Зомби воскресает с шансом 10%
            setHealth(startHealth);
            System.out.printf("Зомби воскресает с %d единиц здоровья!%n", getHealth());
        }
    }
}
