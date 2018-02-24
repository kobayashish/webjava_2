package character;

public abstract class PlayerBase extends Character {

  public abstract void setJob(String job);
  public abstract String getJob();

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
}
