import java.util.*;

public class Exercises {
    private void initialConsoleHandling(String Message) {
        System.out.println("Tip: Type \'exit\' to leave.");
        System.out.println(Message);
    }

    private void printEven(int upTo) {
        int current = 0;
        while(current <= upTo) {
            System.out.println(current);
            current += 2;
        }
    }

    private Integer convertFromLine(String line) {
        int input;
        try {
            input = Integer.parseInt(line);
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            return null;
        }
        return input;
    }

    public void Exercise1() {
        initialConsoleHandling("Pick a number:");
        Scanner scan = new Scanner(System.in);
        String line = scan.nextLine();
        while(!line.equals("exit")) {
            evenLoop(line);
            line = scan.nextLine();
        }
    }

    private void evenLoop(String line) {
        Integer val = convertFromLine(line);
        if(val==null)
            return;
        printEven(val);
    }

    public void Exercise2() {
        initialConsoleHandling("Pick two numbers (how many numbers, what divisor) separated by a comma:");
        Scanner scan = new Scanner(System.in);
        String line = scan.nextLine();
        line = line.replaceAll("\\s", "");
        while(!line.equals("exit")) {
            multipleNumberLoop(line);
            line = scan.nextLine();
            line.replaceAll("\\s", "");
        }
    }

    public void multipleNumberLoop(String line) {
        String[] values = line.split(",");
        int n, m;
        try {
            values = line.split(",");
            n = Integer.parseInt(values[0]);
            m = Integer.parseInt(values[1]);
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            return;
        }
        multipleOf(m, n);
    }

    public void multipleOf(int m, int upTo) {
        int current = m,
                count = 0;
        while(count < upTo) {
            if (current % m != 0) {
                current++;
                continue;
            }
            System.out.println(current);
            current++;
            count++;
        }
    }

    public void Exercise3() {
        initialConsoleHandling("Pick a number:");
        Scanner scan = new Scanner(System.in);
        String line = scan.nextLine();
        while(!line.equals("exit")) {
            primeNumberLoop(line);
            line = scan.nextLine();
        }
    }

    public void primeNumberLoop(String line) {
        Integer val = convertFromLine(line);
        if(val==null)
            return;
        System.out.println(isPrime(convertFromLine(line)) ? "is prime" : "not prime");
    }

    private boolean isPrime(int n) {
        int val = 2;
        while(val <= Math.sqrt(n) && n%val != 0) {
            val++;
        }
        return val > Math.sqrt(n) && n > 1;
    }

    public void Exercise4() {
        initialConsoleHandling("Pick a number:");
        Scanner scan = new Scanner(System.in);
        String line = scan.nextLine();
        while(!line.equals("exit")) {
            multiplePrimeNumberLoop(line);
            line = scan.nextLine();
        }
    }

    private void multiplePrimeNumberLoop(String line) {
        Integer val = convertFromLine(line);
        if(val==null)
            return;
        int current = 2,
            count = 0;
        while(count < val) {
            if(isPrime(current)) {
                System.out.println(current);
                count++;
            }
            current++;
        }
    }

    public void Exercise5() {
        initialConsoleHandling("Pick three numbers (how many numbers, how many equal digits, what digit) separated by a comma:");
        Scanner scan = new Scanner(System.in);
        String line = scan.nextLine();
        line = line.replaceAll("\\s", "");
        while(!line.equals("exit")) {
            digitCountLoop(line);
            line = scan.nextLine();
            line.replaceAll("\\s", "");
        }
    }

    private void digitCountLoop(String line) {
        String[] values = line.split(",");
        int n, m, d;
        try {
            values = line.split(",");
            n = Integer.parseInt(values[0]);
            m = Integer.parseInt(values[1]);
            d = Integer.parseInt(values[2]);
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            return;
        }
        if(n > 0)
            digitCount(n, m, d);
    }

    private void digitCount(int n, int m, Integer d) {
        String first = "";
        for (int i = 0; i < m; i++) {
            first += d;
        }
        Integer number = Integer.parseInt(first);
        int count = 0;
        char digit = d.toString().charAt(0);
        while(count < n) {
            if (number.toString().chars().filter(ch -> ch == digit).count() == m) {
                System.out.println(number);
                count++;
            }
            number++;
        }
    }

    public void Exercise6() {
        Integer[] values = {52, 10, 85, 1324, 01, 13, 62, 30, 12, 127};
        Arrays.sort(values);
        System.out.println(Arrays.toString(values));
        Arrays.sort(values, Collections.reverseOrder());
        System.out.println(Arrays.toString(values));
    }

    public void Exercise7() {
        Company X = new Company(1130000, 1.48f);
        Company Y = new Company(18400000, .32f);
        short year = 2021;
        while(X.getValue() < Y.getValue()) {
            printCompaniesValue(year, X.getValue(), Y.getValue());
            X.reEvaluate();
            Y.reEvaluate();
            year++;
        }
        printCompaniesValue(year, X.getValue(), Y.getValue());
    }

    public void printCompaniesValue(short year, double valueX, double valueY) {
        System.out.println("-------------------------------------------------");
        System.out.printf("Empresa X - 01/01/%d - Valor da empresa: %.2f\n", year, valueX/100000);
        System.out.printf("Empresa Y - 01/01/%d - Valor da empresa: %.2f\n", year, valueY/100000);
    }

    public void Exercise8() {
        initialConsoleHandling("Write your grocery list:");
        Scanner scan = new Scanner(System.in);
        ArrayList<Product> basket = new ArrayList<Product>();
        for (int i = 0; i < 3; i++) {
            System.out.printf("Write the next product:");
            readProduct(scan, basket);
        }
        writeGroceryList(basket);
    }

    private void writeGroceryList(ArrayList<Product> basket) {
        Product previous = null,
                current;
        double value = 0.;
        int index = 1;
        for (int i = 0; i < basket.size(); i++) {
            current = basket.get(i);
            if (!Objects.isNull(previous) && previous.getName().equals(current.getName())) {
                continue;
            }
            String currentName = current.getName();
            long count = basket.stream().filter(x -> x.getName().equals(currentName)).count();
            value += count*current.getPrice();
            System.out.printf("Produto %d\n%s\nR$%.2f\nQuantidade: %d\n\n", index, current.getName(), current.getPrice(), count);
            index++;

            previous = new Product(current);
        }
        System.out.println("Preço Total: R$" + value);
    }

    public void readProduct(Scanner scan, ArrayList<Product> basket) {
        scan.nextLine();
        String name = scan.nextLine();
        String value = scan.nextLine();
        String quantity = scan.nextLine();
        value = value.replaceAll("R\\$", "");
        double v = Double.parseDouble(value);
        quantity = quantity.replaceAll("Quantidade: ", "");
        int q = Integer.parseInt(quantity);
        for (int i = 0; i < q; i++) {
            basket.add(new Product(v, name));
        }
    }
}