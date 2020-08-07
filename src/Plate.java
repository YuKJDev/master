public class Plate {
private int food;
  public int getCount() {
        return food;
    }

    public void setCount(int food) {
        this.food = food;
    }

    public Plate(int food) {
        this.food = food;
    }
    public  void descreaseFood (int count) {
      this.food -= count;

    }
    public String info () {
      String info;
      info = "Еда: " + food;
      return  info;
    }

}
