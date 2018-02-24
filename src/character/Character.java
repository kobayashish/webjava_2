package character;

public abstract class Character {

  private String name;
  private int hitPoint;
  private int attack;
  private int magic;
  private int defense;

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
}
