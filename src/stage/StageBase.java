package stage;
import java.util.Scanner;
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

  public boolean battle(PlayerBase player, EnemyBase enemy) {

    System.out.println("＜戦闘開始＞");

    boolean winFlg = false;
    boolean loseFlg = false;
    int damege;

    //勝敗が決まるか、10ターン経過するまでループ
    for (int i = 1; i < 11; i++) {

      System.out.println("\n【" +i + "ターン目】");

      //Playerの攻撃
      System.out.println(player.getName() + "の攻撃");

      damege = battlePlayer(player, enemy);
      if (damege < 0) {
        damege = new java.util.Random().nextInt(3);
      } else {
        damege = damege + new java.util.Random().nextInt(3);
      }

      enemy.setHitPoint(enemy.getHitPoint() - damege);
      System.out.println(enemy.getName() + "に" + damege + "のダメージ");
      if (enemy.getHitPoint() < 0) {
        winFlg = true;
        break;
      }

      //Enemyの攻撃
      System.out.println(enemy.getName() + "の攻撃");
      damege = battleEnemy(player, enemy);
      if (damege < 0) {
        damege = new java.util.Random().nextInt(3);
      } else {
        damege = damege + new java.util.Random().nextInt(3);
      }
      player.setHitPoint(player.getHitPoint() - damege);
      System.out.println(player.getName() + "に" + damege + "のダメージ");
      if (player.getHitPoint() < 0) {
        loseFlg = true;
        break;
      }
    }

    System.out.println("\n【戦闘結果】");
    if (winFlg == true) {
      System.out.println(enemy.getName() + "を倒しました。");
      player.setHitPoint(player.getHitPoint() + enemy.getReward());
      System.out.println(player.getName() + "はドロップアイテムで体力を" + enemy.getReward() + "回復した。\n");
      player.playerLook(player);
    } else if (loseFlg == true) {
      System.out.println(player.getName() + "は力尽きました。\n");
      enemy.enemyLook(enemy);
      return false;
    } else {
      System.out.println("決着はつきませんでした。\n");
      player.playerLook(player);
      enemy.enemyLook(enemy);
    }

    boolean goFlg = false;

    while (goFlg == false) {

      //選択メッセージ表示
      System.out.println("\n＜先へ進みますか？＞");
      System.out.println("OK！：o");
      System.out.println("NO！：n\n");

      //入力待ち
      Scanner scan = new Scanner(System.in);
      String input = scan.next();

      switch (input) {

        //[ 入力が 'o']
        case "o":
          System.out.println("先へ進みます。\n");
          goFlg = true;
          break;

        //[ 入力が 'n' ]
        case "n":
          System.out.println("帰ります。\n");
          return false;

        //[ 入力が 上記以外 ]
        default:
          //o / n の入力促しメッセージ表示
          System.out.println("入力が不適切です。\n");
          break;
      }
    }

    return true;
  }

  public abstract int battlePlayer(PlayerBase player, EnemyBase enemy);

  public abstract int battleEnemy(PlayerBase player, EnemyBase enemy);
}
