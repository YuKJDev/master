public class Dog extends Waterfowl {
    private  int MAX_RUN_LENGTH = 500;
    private final int MAX_SWIM_LENGTH = 10;
    private final double MAX_JUMP_HEIGTH = 0.5;
    private String breed;
    public Dog(String name, String breed) {
        super(name);
        this.breed = breed;
    }

    public String getBreed() {
        return breed;
    }

    @Override
    void run(int length) {

        if(getBreed().equals("овчарка")) MAX_RUN_LENGTH = 600;
        if(getBreed().equals("шпиц")) MAX_RUN_LENGTH = 400;
        if (length >= 0 && length < MAX_RUN_LENGTH) {
            System.out.println(String.format("Собака [%s] бежит ", getName()));
            System.out.println("run: true");
        }
        if (length == 0) {
            System.out.println(String.format("Собака [%s] стоит ", getName()));
            System.out.println("run: false");
        }
        if (length < 0) {
            System.out.println(String.format("Собака [%s] пятится ", getName()));
            System.out.println("run: true");
        }
        if (length >= MAX_RUN_LENGTH) {
            System.out.println(String.format("Собака [%s] прибежал ", getName()));
            System.out.println("run: false");
        }


    }

    @Override
    void toSwim(int length) {
        if ((length >= 0) && (length <= MAX_SWIM_LENGTH)) {
            System.out.println(String.format("Собака [%s] плывет ", getName()));
            System.out.println("swim: true");
        } else {
            System.out.println(String.format("Собака [%s] неплывет ", getName()));
            System.out.println("swim: false");
        }

    }

    @Override
    void jump(double height) {
        if (height >= 0 && height <= MAX_JUMP_HEIGTH) {
            System.out.println(String.format("Собака [%s] прыгнул[а] ", getName()));
            System.out.println("jump: true");
        }
        if (height == 0) {
            System.out.println(String.format("Собака [%s] стоит ", getName()));
            System.out.println("jump: false");
        }
        if (height < 0) {
            System.out.print(String.format("Собака [%s] спрыгнул[а] ", getName()));
            if (height < -2) System.out.println(" и разбился[-лась] к чертям");
            else System.out.println();
            System.out.println("jump: true");
        }
        if (height > MAX_RUN_LENGTH) {
            System.out.println(String.format("Собака [%s] не может прыгнуть на высоту %d ", getName(), height));
            System.out.println("jump: false");
        }


    }


}
