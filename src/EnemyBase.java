
public abstract class EnemyBase extends Character {

  private String name;
  private int hitPoint;
  private int attack;
  private int magic;
  private int defense;
  private int reward;

  public void setName(String name) {
    this.name = name;
  }

  public void setHitPoint(int hitPoint) {
    this.hitPoint = hitPoint;
  }

  public void setAttack(int attack) {
    this.attack = attack;
  }

  public void setMagic(int magic) {
    this.magic = magic;
  }

  public void setDefense(int defense) {
    this.defense = defense;
  }

  public void setReward(int reward) {
    this.reward = reward;
  }

  public String getName() {
    return this.name;
  }

  public int getHitPoint() {
    return this.hitPoint;
  }

  public int getAttack() {
    return this.attack;
  }

  public int getMagic() {
    return this.magic;
  }

  public int getDefense() {
    return this.defense;
  }

  public int getReward() {
    return this.reward;
  }

}

/**
public abstract class EnemyBase implements Character {

  public abstract void setName(String name);

  public abstract void setHitPoint(int hitPoint);

  public abstract void setAttack(int attack);

  public abstract void setMagic(int magic);

  public abstract void setDefense(int defense);

  public abstract void setReward(int reward);

  public abstract String getName();

  public abstract int getHitPoint();

  public abstract int getAttack();

  public abstract int getMagic();

  public abstract int getDefense();

  public abstract int getReward();
}
*/
