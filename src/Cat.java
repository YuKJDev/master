import java.util.Scanner;
import java.util.Timer;

public class Cat extends  Animals {
    private  final int MAX_RUN_LENGTH = 200;
    private  final double MAX_JUMP_HEIGTH = 2;
    private  final int MIN_RUN_LENGTH = -200;
    private  final double MIN_JUMP_HEIGTH = -3;
    private boolean hungry; // Если Истина, то кот голоден.

    public void setHungry(boolean hungry) {
        this.hungry = hungry;
    }


    public Cat(String name, boolean hungry) {
        super(name);
        this.hungry = hungry;

    }

    public boolean isHungry() {
        return hungry;
    }

    @Override
    void run(int length) {
       if (length >= 0 && length <= MAX_RUN_LENGTH) {
           System.out.println(String.format("Кот/кошка [%s] бежит ", getName()));
           System.out.println("run: true");

       }
       if (length == 0) {
           System.out.println(String.format("Кот/кошка [%s] стоит ", getName()));
           System.out.println("run: false");
       }
       if (length < 0) {
           System.out.println(String.format("Кот/кошка [%s] пятится ", getName()));
           System.out.println("run: true");
       }
       if (length >= MAX_RUN_LENGTH) {
           System.out.println(String.format("Кот/кошка [%s] прибежал[а] ", getName()));
           System.out.println("run: false");
       }

    }


    @Override
    void jump(double height) {
        if (height >= 0 && height <= MAX_JUMP_HEIGTH) {
            System.out.println(String.format("Кот/кошка [%s] прыгнул[а] ", getName()));
            System.out.println("jump: true");
        }
        if (height == 0) {
            System.out.println(String.format("Кот/кошка [%s] стоит ", getName()));
            System.out.println("jump: false");
        }
        if (height < 0) {
            System.out.print(String.format("Кот/кошка [%s] спрыгнул[а] ", getName()));
            if (height < -2) System.out.println(" и разбился[-лась] к чертям");
            else System.out.println();
            System.out.println("jump: true");
        }
        if (height > MAX_RUN_LENGTH) {
            System.out.println(String.format("Кот/кошка [%s] не может прыгнуть на высоту %d ", getName(), height));
            System.out.println("jump: false");
        }


    }


    // покормим наших котов
    @Override
    public void eat() {
     do {
          if (isHungry()) {
              System.out.println(String.format("%s поел. ", getName()));
              setHungry(false);

          } else {
              System.out.println(String.format("%s не голоден. ", getName()));
              break;

          }

        } while (true) ;

    }

    public int getMAX_RUN_LENGTH() {
        return MAX_RUN_LENGTH;
    }

    public double getMAX_JUMP_HEIGTH() {
        return MAX_JUMP_HEIGTH;
    }


    public int getMIN_RUN_LENGTH() {
        return MIN_RUN_LENGTH;
    }

    public double getMIN_JUMP_HEIGTH() {
        return MIN_JUMP_HEIGTH;
    }


}
