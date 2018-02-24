package stage;
import character.EnemyBase;
import character.PlayerBase;

public abstract class StageBase {

  public void start(PlayerBase player) {

    String nameP;
    int hitPointP;
    int attackP;
    int magicP;
    int defenseP;
    String jobP;

    //ランダム
    int ramdamPlayer = new java.util.Random().nextInt(2);

    switch (ramdamPlayer) {

      case 0:
        //[ A ]
        nameP = "よこわA";
        hitPointP = 400;
        attackP = 25;
        magicP = 10;
        defenseP = 5;
        jobP = "戦士";
        break;

      case 1:
        //[ B ]
        nameP = "よこわB";
        hitPointP = 400;
        attackP = 10;
        magicP = 30;
        defenseP = 5;
        jobP = "魔術師";
        break;

      default:
        nameP = "よこわA";
        hitPointP = 400;
        attackP = 25;
        magicP = 10;
        defenseP = 5;
        jobP = "戦士";
        break;
    }

    player.setName(nameP);
    player.setHitPoint(hitPointP);
    player.setAttack(attackP);
    player.setMagic(magicP);
    player.setDefense(defenseP);
    player.setJob(jobP);

  }

  public void addEnemy(EnemyBase enemy) {

    String nameE;
    int hitPointE;
    int attackE;
    int magicE;
    int defenseE;
    int rewardE;

    //ランダム
    int ramdamEnemy = new java.util.Random().nextInt(3);

    switch (ramdamEnemy) {

      case 0:
        //[ A ]
        nameE = "敵A";
        hitPointE = 150;
        attackE =  50;
        magicE = 5;
        defenseE = 5;
        rewardE = 20;
        break;

      case 1:
        //[ B ]
        nameE = "敵B";
        hitPointE = 80;
        attackE = 15;
        magicE = 15;
        defenseE = 20;
        rewardE = 15;
        break;

      case 2:
        //[ C ]
        nameE = "敵C";
        hitPointE = 100;
        attackE = 10;
        magicE = 40;
        defenseE = 5;
        rewardE = 30;
        break;

      default:
        nameE = "敵A";
        hitPointE = 150;
        attackE =  50;
        magicE = 5;
        defenseE = 5;
        rewardE = 20;
        break;
    }

    enemy.setName(nameE);
    enemy.setHitPoint(hitPointE);
    enemy.setAttack(attackE);
    enemy.setMagic(magicE);
    enemy.setDefense(defenseE);
    enemy.setReward(rewardE);

  }

  public abstract boolean battle(PlayerBase player, EnemyBase enemy);

}
