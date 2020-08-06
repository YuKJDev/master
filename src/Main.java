import java.awt.*;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Plate plate = new Plate(0);
        Cat[] cats = new Cat[100];
        Cat cat;
        int length;
        double height;
       do{
             for (int i = 1; i < cats.length; i++) {
                cats[i] = new Cat("Кошак №" + i, true);
                cat = cats[i];
                length = getData(cat.getMIN_RUN_LENGTH(), cat.getMAX_RUN_LENGTH());
                height = getData(cat.getMIN_JUMP_HEIGTH(), cat.getMAX_JUMP_HEIGTH());
                cat.run(length);
                doEat(cat, plate);
                cat.jump(height);

            }
             break;
        }while (true);

        System.out.println("//-----------------------------//");

        Waterfowl dog = new Dog("Полкан", "овчарка");
        Waterfowl dog2 = new Dog("Живчик", "шпиц");
        Waterfowl dog3 = new Dog("Вилли", "пудель");

        dog.run(600);
        dog.jump(0.4);
        dog.toSwim(2);

        System.out.println("//-----------------------------//");

        dog2.run(130);
        dog2.jump(0.3);
        dog2.toSwim(10);

        System.out.println("//-----------------------------//");

        dog3.run(-100);
        dog3.jump(-3);
        dog3.toSwim(5);



    }
    static int getData (int min, int max) {

        int diff = max - min;
        Random random = new Random();
        int i = random.nextInt(diff + 1);
        i += min;
        return i;
    }
    static double getData (double min, double max) {

       // double diff = max - min;
        Random random = new Random();
        double i = random.nextDouble();
        i += min;
        return i;
    }

    static void doEat (Cat cat, Plate plate) {

        int countEat = plate.getCount();
        String answer;
        Scanner scanner = new Scanner(System.in);
        do {
            if (countEat > 0) {
                if (cat.isHungry()) {
                    cat.eat();
                    countEat -= 10;
                    plate.setCount(countEat);
                    System.out.println(String.format("%d осталось еды в миске. ", plate.getCount()));
                    break;
                }
            } else {
                if (plate.getCount() == 0) {
                    System.out.println("Недостаточно еды в миске, добавить еды? y/n");
                    answer = scanner.nextLine();
                    if (answer.equalsIgnoreCase("y")) {
                        plate.setCount(100);
                        countEat = plate.getCount();

                    } else {
                        System.out.println("Покормите котэ!");
                        break;
                    }
                }
            }
        } while (true);

    }



}
