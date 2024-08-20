package HW01;

public class Warrior extends Hero {
    public Warrior(String name, int startHealth, int attackMin, int attackMax) {
        super(name, startHealth, attackMin, attackMax);
    }

    @Override
    public void attackEnemy(Enemy enemy) {
        int damage = getRandomDamage();
        if (damage > 0) {
            System.out.printf("%s атакует %s используя меч и наносит %d урона!%n", getName(), enemy.getName(), damage);
            enemy.takeDamage(damage);
        }
        else
            System.out.printf("%s промахнулся!%n", getName());
    }

    @Override
    public void takeDamage(int damage) {
        int blockedDamage = damage / 2;
        int dealDamage = damage - blockedDamage;
        super.takeDamage(dealDamage); // Воин получает в два раза меньше урона
        System.out.printf("(%d урона было заблокировано)%n", blockedDamage);
    }
}
