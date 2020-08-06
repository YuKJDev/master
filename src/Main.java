import java.awt.*;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Cat[] cats = new Cat[10];
        Cat cat = null;
        int length = 0;
        double height = 0;
       while (true){

            for (int i = 1; i < cats.length; i++) {
                cats[i] = new Cat("Кошак №" + i);
                cat = cats[i];
                length = getNumber();
                height = getNumber();
                cat.setAppetite(rCatAppetite());
                cat.run(length);
                cat.eat();
                cat.jump(height);

            }
             break;
        }

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
    static int getNumber () {
        int min = -200;
        int max = 200;
        int diff = max - min;
        Random random = new Random();
        int i = random.nextInt(diff + 1);
        i += min;
        return i;
    }

    static int rCatAppetite () {
        int min = 0;
        int max = 100;
        int diff = max - min;
        Random random = new Random();
        int i = random.nextInt(diff + 1);
        i += min;
        return i;
    }


}
