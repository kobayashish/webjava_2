package character;

public class PlayerSelectEasy extends PlayerBase {

  private String name;
//  private int hitPoint;
  private int attack;
  private int magic;
  private int defense;
  private String job;

  @Override
  public void setName(String name) {
    this.name = name + "+";
  }
/**
  @Override
  public void setHitPoint(int hitPoint) {
    this.hitPoint = hitPoint;
  }
*/
  @Override
  public void setAttack(int attack) {
    this.attack = attack * 2;
  }

  @Override
  public void setMagic(int magic) {
    this.magic = magic * 2;
  }

  @Override
  public void setDefense(int defense) {
    this.defense = defense * 2;
  }

  @Override
  public void setJob(String job) {
    this.job = job + "+";
  }

  @Override
  public String getName() {
    return this.name;
  }
/**
  @Override
  public int getHitPoint() {
    return this.hitPoint;
  }
*/
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
  public String getJob() {
    return this.job;
  }

}
