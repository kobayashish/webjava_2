import java.util.Scanner;

/**
 * BattleHero
 */
public class BattleHero {

  public static void main(String[] args) {

    System.out.println("◇◆BattleHero◆◇\n");

    BattleHero battleHero = new BattleHero();

    PlayerBase player;
    //player = new PlayerSelect();
    //player = new PlayerSelectEasy();
    //ランダム
    int ramdamPlayer = new java.util.Random().nextInt(2);

    switch (ramdamPlayer) {

      case 0:
        //[ ノーマル ]
        player = new PlayerSelect();
        break;

      case 1:
        //[ イージー ]
        player = new PlayerSelectEasy();
        break;

      default:
        player = new PlayerSelect();
        break;
    }


    EnemyBase enemy;
    //enemy = new EnemySelect();
    //enemy = new EnemySelectHard();
    //ランダム
    int ramdamEnemy = new java.util.Random().nextInt(2);

    switch (ramdamEnemy) {

      case 0:
        //[ ノーマル ]
        enemy = new EnemySelect();
        break;

      case 1:
        //[ ハード ]
        enemy = new EnemySelectHard();
        break;

      default:
        enemy = new EnemySelect();
        break;
    }

    StageBase stage;
    //stage = new StageSelectA();
    //stage = new StageSelectM();

    //ランダム
    int ramdamStage = new java.util.Random().nextInt(2);

    switch (ramdamStage) {

      case 0:
        //[ 物理エリア ]
        stage = new StageSelectA();
        break;

      case 1:
        //[ 魔法エリア ]
        stage = new StageSelectM();
        break;

      default:
        stage = new StageSelectA();
        break;
    }

    //プレイヤー作成
    stage.start(player);

    //プレイヤー決定フラグ
    boolean playerFlg = false;

    //Loop
    while (playerFlg == false) {

      //選択メッセージ表示
      System.out.println("＜このプレイヤーで開始しますか？＞");
      System.out.println("OK！：o");
      System.out.println("NO！：n\n");
      battleHero.playerLook(player);

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
          stage.start(player);
          break;

        //[ 入力が 上記以外 ]
        default:
          //o / n の入力促しメッセージ表示
          System.out.println("入力が不適切です。\n");
          break;
      }
    }

    //エネミー配置
    stage.addEnemy(enemy);

    System.out.println("＜敵と遭遇しました。＞\n");
    battleHero.enemyLook(enemy);

    //入力待ち
    Scanner scan = new Scanner(System.in);
    scan.next();

    //バトル
    stage.battle(player, enemy);

    //終了メッセージ
    System.out.println("\nおわり");
  }


  /**
   * プレイヤー能力表示
   */
  public void playerLook(PlayerBase player) {

    System.out.println("【Player】");
    System.out.println("名前:" + player.getName());
    System.out.println("体力:" + player.getHitPoint());
    System.out.println("攻撃:" + player.getAttack());
    System.out.println("魔法:" + player.getMagic());
    System.out.println("防御:" + player.getDefense());
    System.out.println("職業:" + player.getJob());
  }

  /**
   * 敵能力表示
   */
  public void enemyLook(EnemyBase enemy) {

    System.out.println("【Enemy】");
    System.out.println("名前:" + enemy.getName());
    System.out.println("体力:" + enemy.getHitPoint());
    System.out.println("攻撃:" + enemy.getAttack());
    System.out.println("魔法:" + enemy.getMagic());
    System.out.println("防御:" + enemy.getDefense());
    System.out.println("報酬:" + enemy.getReward());
  }
}
