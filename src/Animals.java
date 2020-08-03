abstract class Animals {
    private final int MAX_RUN_LENGTH = 0;
    private final int MAX_SWIM_LENGTH = 0;
    private final double MAX_JUMP_HEIGTH = 0;
    String name;

    public Animals(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    abstract void run(int length);
    abstract void jump(double height);
    }