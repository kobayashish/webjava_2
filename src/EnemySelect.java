
public class EnemySelect extends EnemyBase {

  private String name;
  private int hitPoint;
  private int attack;
  private int magic;
  private int defense;
  private int reward;

  @Override
  public void setName(String name) {
    this.name = name;
  }

  @Override
  public void setHitPoint(int hitPoint) {
    this.hitPoint = hitPoint;
  }

  @Override
  public void setAttack(int attack) {
    this.attack = attack;
  }

  @Override
  public void setMagic(int magic) {
    this.magic = magic;
  }

  @Override
  public void setDefense(int defense) {
    this.defense = defense;
  }

  @Override
  public void setReward(int reward) {
    this.reward = reward;
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public int getHitPoint() {
    return this.hitPoint;
  }

  @Override
  public int getAttack() {
    return this.attack;
  }

  @Override
  public int getMagic() {
    return this.magic;
  }

  @Override
  public int getDefense() {
    return this.defense;
  }

  @Override
  public int getReward() {
    return this.reward;
  }

}
