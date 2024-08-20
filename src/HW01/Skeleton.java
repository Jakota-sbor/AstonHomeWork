package HW01;

public class Skeleton extends Enemy {
    public Skeleton(String name, int startHealth, int attackMin, int attackMax) {
        super(name, startHealth, attackMin, attackMax);
    }

    @Override
    public void attackEnemy(Hero enemy) {
        int damage = getRandomDamage();
        if (damage > 0) {
            System.out.printf("%s колотит костями %s и наносит %d урона!%n", getName(), enemy.getName(), damage);
            enemy.takeDamage(damage);
        }
        else
            System.out.printf("%s промахнулся!%n", getName());
    }

    @Override
    public void takeDamage(int damage) {
        if (Math.random() <= 0.1) { // Скелет с шансом 10% может увернуться от удара
            System.out.printf("%s увернулся от удара!%n", getName());
        } else
            super.takeDamage(damage);
    }
}
