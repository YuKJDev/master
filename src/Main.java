import java.awt.*;

public class Main {
    public static void main(String[] args) {
        Animals cat = new Cat("Барсик");
        Animals cat2 = new Cat("Мурка");
        Animals cat3 = new Cat("Дарсик");
        cat.run(100);
        cat.jump(-100);


        System.out.println("//-----------------------------//");

        cat2.run(10);
        cat2.jump(1);


        System.out.println("//-----------------------------//");

        cat3.run(300);
        cat3.jump(3);


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
}
