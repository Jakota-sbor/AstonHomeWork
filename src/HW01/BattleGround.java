package HW01;

public class BattleGround {
    public static void main(String[] args) {
        Hero warrior = new Warrior("Воин", 100, 0,10 );
        Hero mage = new Mage("Маг", 100,0,10);
        Hero archer = new Archer("Лучник", 100, 0,10);

        Hero[] heroes = { warrior, mage, archer };

        for(var hero : heroes) {
            System.out.printf("%s начинает приключение!%n", hero.getName());
            Enemy[] enemies = EnemyFactory();
            for (var enemy : enemies) {
                DoBattle(hero, enemy);
            }

            if (hero.isAlive())
                System.out.printf("%s выжил с %d здоровья%n%n", hero.getName(), hero.getHealth());
            else
                System.out.printf("%s пал в бою%n%n", hero.getName());
        }
    }

    public static void DoBattle(Hero hero, Enemy enemy)
    {
        while (hero.isAlive() && enemy.isAlive()) {
            if (hero.isAlive()) {
                hero.attackEnemy(enemy);
            }

            if (enemy.isAlive()) {
                enemy.attackEnemy(hero);
            }
        }
    }

    public static Enemy[] EnemyFactory() {
        Enemy normalZombie = new Zombie("Обычный зомби", 50, 0, 5);
        Enemy bigZombie = new Zombie("Большой зомби", 100, 0, 10);
        Enemy skeleton = new Skeleton("Скелет", 25, 0, 10);

        return new Enemy[] {normalZombie, bigZombie, skeleton, normalZombie, bigZombie};
    }
}
