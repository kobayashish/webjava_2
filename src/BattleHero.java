import java.util.Scanner;
import character.EnemyBase;
import character.EnemySelect;
import character.EnemySelectHard;
import character.PlayerBase;
import character.PlayerSelect;
import character.PlayerSelectEasy;
import stage.StageBase;
import stage.StageSelectA;
import stage.StageSelectM;

/**
 * BattleHero
 */
public class BattleHero {

  public static void main(String[] args) {

    System.out.println("◇◆BattleHero◆◇\n");

    PlayerBase player = playerFactory();
    //player = new PlayerSelect();
    //player = new PlayerSelectEasy();

    EnemyBase enemy = enemyFactory();
    //enemy = new EnemySelect();
    //enemy = new EnemySelectHard();

    StageBase stage = stageFactory();
    //stage = new StageSelectA();
    //stage = new StageSelectM();


    //プレイヤー決定フラグ
    boolean playerFlg = false;

    //Loop
    while (playerFlg == false) {

      //プレイヤー作成
      stage.start(player);

      //選択メッセージ表示
      System.out.println("＜このプレイヤーで開始しますか？＞");
      System.out.println("OK！：o");
      System.out.println("NO！：n\n");
      player.playerLook(player);

      //入力待ち
      Scanner scan = new Scanner(System.in);
      String input = scan.next();

      switch (input) {

        //[ 入力が 'o']
        case "o":
          System.out.println("開始します。\n");
          playerFlg = true;
          break;

        //[ 入力が 'n' ]
        case "n":
          System.out.println("プレイヤーを変更します。\n");
          player = playerFactory();
          stage.start(player);
          break;

        //[ 入力が 上記以外 ]
        default:
          //o / n の入力促しメッセージ表示
          System.out.println("入力が不適切です。\n");
          break;
      }
    }

    boolean nextFlg = true;
    while (nextFlg == true) {

      stage = stageFactory();
      enemy = enemyFactory();

      //エネミー配置
      stage.addEnemy(enemy);

      System.out.println("＜敵と遭遇しました。＞\n");
      enemy.enemyLook(enemy);

      //入力待ち
      Scanner scan = new Scanner(System.in);
      scan.next();

      //バトル
      nextFlg = stage.battle(player, enemy);
    }


    //終了メッセージ
    System.out.println("\nおわり");
  }



  /**
   * プレイヤー能力補正決定
   */
  public static PlayerBase playerFactory() {

    int ramdamPlayer = new java.util.Random().nextInt(2);

    switch (ramdamPlayer) {

      case 0:
        //[ ノーマル ]
        return new PlayerSelect();

      case 1:
        //[ イージー ]
        return new PlayerSelectEasy();

      default:
        return new PlayerSelect();
    }
  }

  /**
   * エネミー能力補正決定
   */
  public static EnemyBase enemyFactory() {

    int ramdamEnemy = new java.util.Random().nextInt(2);

    switch (ramdamEnemy) {

      case 0:
        //[ ノーマル ]
        return new EnemySelect();

      case 1:
        //[ ハード ]
        return new EnemySelectHard();

      default:
        return new EnemySelect();
    }
  }

  /**
   * ステージ決定
   */
  public static StageBase stageFactory() {

    int ramdamStage = new java.util.Random().nextInt(2);

    switch (ramdamStage) {

      case 0:
        //[ 物理エリア ]
        return new StageSelectA();

      case 1:
        //[ 魔法エリア ]
        return new StageSelectM();

      default:
        return new StageSelectA();
    }
  }
}
