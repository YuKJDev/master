public class Cat extends  Animals {
    private final int MAX_RUN_LENGTH = 200;
    private final double MAX_JUMP_HEIGTH = 2;

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
}
