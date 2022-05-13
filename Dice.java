public class Dice {
    // d20 dice
    public static int roll20() {
        return (int) (Math.random() * (20 - 1) + 1);
    }
    
    // d6 dice
    public static int roll6() {
        return (int) (Math.random() *(6 - 1) + 1);
    }
    
    // d4 dice
    public static int roll4() {
        return (int) (Math.random() *(4 -1) + 1);
    }
    
    // d8 dice
    public static int roll8() {
        return (int) (Math.random() *(8 -1) + 1);
    }
    
    // d12 dice
    public static int roll12() {
        return (int) (Math.random() *(12 -1) + 1);
    }
}