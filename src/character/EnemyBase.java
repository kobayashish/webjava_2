package character;

public abstract class EnemyBase extends Character {

  public abstract void setReward(int reward);
  public abstract int getReward();

  /**
   * エネミー能力表示
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
