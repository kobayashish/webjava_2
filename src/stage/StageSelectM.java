package stage;
import character.EnemyBase;
import character.PlayerBase;

public class StageSelectM extends StageBase {

  /**
   * ダメージ計算 [プレイヤーの攻撃]
   */
  public int battlePlayer(PlayerBase player, EnemyBase enemy) {

    int damege = player.getMagic() - enemy.getDefense();

    return damege;
  }

  /**
   * ダメージ計算 [エネミーの攻撃]
   */
  public int battleEnemy(PlayerBase player, EnemyBase enemy) {

    int damege = enemy.getMagic() - player.getDefense();

    return damege;
  }
}
