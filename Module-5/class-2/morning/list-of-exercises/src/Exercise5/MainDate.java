package Exercise5;

public class MainDate {
    public static void main(String[] args) {
        Date date;
        try {
            date = new Date(2021, 12, 31);    // new year's eve
            System.out.println(date);
            date.nextDay();
            System.out.println(date);
            date = new Date(2024, 2, 28);     // leap year
            System.out.println(date);
            date.nextDay();
            System.out.println(date);
            date.nextDay();
            System.out.println(date);
            date = new Date(2022, 2, 28);     // normal year
            System.out.println(date);
            date.nextDay();
            System.out.println(date);
            date = new Date(9999, 12, 31);    // last supported date
            System.out.println(date);
            date.nextDay();                                     // should throw an exception
            System.out.println(date);
        } catch (RuntimeException e) {
            e.printStackTrace();
            return;
        }
    }
}
