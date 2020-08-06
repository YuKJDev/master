import java.util.Scanner;
import java.util.Timer;

public class Cat extends  Animals {
    private final int MAX_RUN_LENGTH = 200;
    private final double MAX_JUMP_HEIGTH = 2;
    private int appetite; //добавим нашим котикам свойство аппетит.
    private  final int GET_MAX_SATIETY = 100; //если аппетит достиг этого значения то котик сытый

    public Cat(String name, int appetite) {
        super(name);
        this.appetite = appetite;
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
        int thisCatappetite = getAppetite();
        Timer timer = new Timer(getName());
        MyTimerTask timerTask = new MyTimerTask();
        timer.scheduleAtFixedRate(timerTask, 0, 10 * 1000);
        while (true) {
            try {
                Thread.sleep(1000);

                thisCatappetite = getAppetite();
                System.out.println(String.format("Кот/кошка [%s] проголодался(-лась) на %d%% ", getName(), GET_MAX_SATIETY-thisCatappetite));

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (thisCatappetite == GET_MAX_SATIETY) {
                System.out.println(String.format("Кот/кошка [%s] не голоден(-дна) %d%% ", getName(), thisCatappetite));
                System.out.println("eat: false");
                timer.cancel();
                break;
            } else {
                if (plate.getCountEat() == 100) {
                    for (int i = getAppetite(); i <= GET_MAX_SATIETY; i += 10) {
                        setAppetite(i);
                        System.out.println(String.format("Кот/кошка [%s] поел(-а), сытость %d%% ", getName(), getAppetite()));
                        thisCatappetite = getAppetite();
                    //    for (int j = plate.getCountEat(); j >= 0; j -= 10) {
                            plate.setCountEat(100 - thisCatappetite);


                     //   }
                        System.out.println("В тарелке осталось: " + plate.getCountEat() + " еды");

                    }
                } else if (plate.getCountEat() < thisCatappetite){
                   System.out.println("Недостаточно еды в миске, добавить еды? y/n");
                   answer = scanner.nextLine();
                   if (answer.equals("y")) {
                       plate.run(thisCatappetite);
                       continue;
                   } else {
                       System.out.println("Покормите котэ!!!");
                       continue;

                   }

                }
            }

            try {
                Thread.sleep(3000);


            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
 }
