package stage;
import java.util.Scanner;
import character.EnemyBase;
import character.PlayerBase;

public class StageSelectA extends StageBase {

  public boolean battle(PlayerBase player, EnemyBase enemy) {

      System.out.println("＜戦闘開始 [物理エリア]＞");

      boolean winFlg = false;
      boolean loseFlg = false;
      int damege;

      //勝敗が決まるか、10ターン経過するまでループ
      for (int i = 1; i < 11; i++) {

        System.out.println("\n【" +i + "ターン目】");

        //Playerの攻撃
        System.out.println(player.getName() + "の攻撃");

        damege = player.getAttack() - enemy.getDefense();
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
        damege = enemy.getAttack() - player.getDefense();
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
}
