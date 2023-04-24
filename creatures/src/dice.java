public class dice {

    public static int d(int x) {
        return (int) (Math.random() * x);
    }

    public static int d4() {
        return (int) (Math.random() * 4);
    }

    public static int d6() {
        return (int) (Math.random() * 6);
    }

    public static int d8() {
        return (int) (Math.random() * 8);
    }

    public static int d12() {
        return (int) (Math.random() * 12);
    }

    public static int d20() {
        return (int) (Math.random() * 20);
    }

    public static int d100() {
        return (int) (Math.random() * 100);
    }
}
