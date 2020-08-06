import java.util.Scanner;
import java.util.Timer;

public class Cat extends  Animals {
    private  final int MAX_RUN_LENGTH = 200;
    private  final double MAX_JUMP_HEIGTH = 2;
    private  final int GET_MAX_SATIETY = 100; //если аппетит достиг этого значения то котик сытый
    private  final int MIN_RUN_LENGTH = -200;
    private  final double MIN_JUMP_HEIGTH = -2;
    private  final int GET_MIN_SATIETY = 0; //если аппетит достиг этого значения то котик сытый

    private int appetite; //добавим нашим котикам свойство аппетит.

    public Cat(String name) {
        super(name);

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

    public int getAppetite() {
        return appetite;
    }

    public void setAppetite(int appetite) {
        this.appetite = appetite;
    }

    // покормим наших котов
    @Override
    public void eat() {

        String answer;
        Scanner scanner = new Scanner(System.in);
        Plate plate = new Plate();

        Timer timer = new Timer(getName());
        MyTimerTask timerTask = new MyTimerTask();
        timer.scheduleAtFixedRate(timerTask, 0, 10 * 1000);
       
        do {
            int countEat;
            try {
                Thread.sleep(1000);

                //  thisCatappetite = getAppetite();
                countEat = plate.getCountEat();
                if (countEat > 0)
                System.out.println("В тарелке " + countEat);
                if (countEat == 0 ) {
                    System.out.println("Недостаточно еды в миске, добавить еды? y/n");
                    answer = scanner.nextLine();
                    if (answer.equalsIgnoreCase("y")) {
                        plate.run(getAppetite());
                        countEat = plate.getCountEat();
                        plate.setCountEat(countEat);


                    } else {
                        System.out.println("Покормите котэ!!!");

                    }

                }
                System.out.println(String.format("Кот/кошка [%s] проголодался(-лась) на %d%% ", getName(),
                        getGET_MAX_SATIETY()-getAppetite()));


                    System.out.println(String.format("Кот/кошка [%s] голоден(-на)", getName()));


            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (getAppetite() == GET_MAX_SATIETY) {
                System.out.println(String.format("Кот/кошка [%s] не голоден(-дна) %d%% ", getName(),
                        getAppetite()));

                System.out.println("eat: false");
                timer.cancel();
                break;
            } else {

                if (plate.getCountEat() > 0) {

                    countEat = plate.getCountEat();
                    if (countEat >= 0) {
                        plate.setCountEat(countEat - (getGET_MAX_SATIETY() - getAppetite()));
                        for (int i = getAppetite(); i <= getGET_MAX_SATIETY(); i++) {

                            setAppetite(i);
                            System.out.println(String.format("Кот/кошка [%s] поел(-а), сытость %d%% ", getName(), getAppetite()));
                            //  thisCatappetite = getAppetite();
                            //    for (int j = plate.getCountEat(); j >= 0; j -= 10) {


                        }

                        System.out.println("В тарелке осталось: " + plate.getCountEat() + " еды");
                    }


                   // }
                } else if (plate.getCountEat() < getAppetite()) {
                    System.out.println("Недостаточно еды в миске, добавить еды? y/n");
                    answer = scanner.nextLine();
                    if (answer.equalsIgnoreCase("y")) {
                        plate.run(getAppetite());


                    } else {
                        System.out.println("Покормите котэ!!!");

                    }

                 //   continue;

                }



            }

            try {
                Thread.sleep(3000);


            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (true);
    }

    public int getMAX_RUN_LENGTH() {
        return MAX_RUN_LENGTH;
    }

    public double getMAX_JUMP_HEIGTH() {
        return MAX_JUMP_HEIGTH;
    }

    public int getGET_MAX_SATIETY() {
        return GET_MAX_SATIETY;
    }

    public int getMIN_RUN_LENGTH() {
        return MIN_RUN_LENGTH;
    }

    public double getMIN_JUMP_HEIGTH() {
        return MIN_JUMP_HEIGTH;
    }

    public int getGET_MIN_SATIETY() {
        return GET_MIN_SATIETY;
    }
}
