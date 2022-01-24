public class Plate {
private int countEat;
private final int MAX_COUNT_EAT = 100;

    public int getCountEat() {
        return countEat;
    }

    public void setCountEat(int countEat) {
        this.countEat = countEat;
    }

    public  void run (int countEat) {
       while (countEat <= MAX_COUNT_EAT) {
           setCountEat(countEat++);
       }

        System.out.println("Тарелка наполнена");
    }

}
