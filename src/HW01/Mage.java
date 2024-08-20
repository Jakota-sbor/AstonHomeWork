package HW01;

public class Mage extends Hero {
    public Mage(String name, int startHealth, int attackMin, int attackMax) {
        super(name, startHealth, attackMin, attackMax);
    }

    @Override
    public void attackEnemy(Enemy enemy) {
        int damage = getRandomDamage() * 3;
        if (damage > 0) {
            System.out.printf("%s атакует %s используя заклинание и наносит %d урона!%n", getName(), enemy.getName(), damage);
            enemy.takeDamage(damage);
        }
        else
            System.out.printf("%s промахнулся!%n", getName());
    }

    @Override
    public void takeDamage(int damage) {
        super.takeDamage(damage * 2); // Маг получает в два раза больше урона
    }
}
