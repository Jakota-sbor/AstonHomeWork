package HW01;

public class Archer extends Hero {
    public Archer(String name, int startHealth, int attackMin, int attackMax) {
        super(name, startHealth, attackMin, attackMax);
    }

    @Override
    public void attackEnemy(Enemy enemy) {
        int damage = getRandomDamage() * 2;
        if (damage > 0) {
            System.out.printf("%s атакует %s используя лук и наносит %d урона!%n", getName(), enemy.getName(), damage);
            enemy.takeDamage(damage);
        }
        else
            System.out.printf("%s промахнулся!%n", getName());
    }

    @Override
    public void takeDamage(int damage) {
        super.takeDamage(damage); // Лучник получает урона без изменений
    }
}
