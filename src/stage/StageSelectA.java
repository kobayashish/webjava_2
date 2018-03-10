package stage;
import character.EnemyBase;
import character.PlayerBase;

public class StageSelectA extends StageBase {

  /**
   * ダメージ計算 [プレイヤーの攻撃]
   */
  public int battlePlayer(PlayerBase player, EnemyBase enemy) {

    int damege = player.getAttack() - enemy.getDefense();

    return damege;
  }

  /**
   * ダメージ計算 [エネミーの攻撃]
   */
  public int battleEnemy(PlayerBase player, EnemyBase enemy) {

    int damege = enemy.getAttack() - player.getDefense();

    return damege;
  }
}
