public class Plate {
private static int countEat;

    public int getMAX_COUNT_EAT() {
        return MAX_COUNT_EAT;
    }

    private final int MAX_COUNT_EAT = 1000;

    public int getCountEat() {
        return countEat;
    }

    public void setCountEat(int countEat) {
        this.countEat = countEat;
    }

    public  void run (int countEat) {
       while (countEat <= getMAX_COUNT_EAT()) {
           setCountEat(countEat++);
       }

        System.out.println("Тарелка наполнена");
    }

}
