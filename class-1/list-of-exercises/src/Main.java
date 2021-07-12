import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String chosen;
        if(args.length <= 1) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Please input which exercise (1-8) to run:");
            chosen = scan.nextLine();
        } else {
            chosen = args[1];
        }
        Exercises ex = new Exercises();
        switch (chosen) {
            case("1"):
                ex.Exercise1();
                break;
            case("2"):
                ex.Exercise2();
                break;
            case("3"):
                ex.Exercise3();
                break;
            case("4"):
                ex.Exercise4();
                break;
            case("5"):
                ex.Exercise5();
                break;
            case("6"):
                ex.Exercise6();
                break;
            case("7"):
                ex.Exercise7();
                break;
            default:
                ex.Exercise8();
                break;
        }
    }
}