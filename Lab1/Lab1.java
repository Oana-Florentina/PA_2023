
public class Lab1 {
    public static void main(String args[]) {
        Lab1 lab1 = new Lab1();
        lab1.compulsory();
        lab1.homework(args);
    }


    void homework(String[] args) {

        //Validate the argument
        if (args.length != 1) {
            System.err.println("wrong number of arguments!!");
            System.exit(-1);
        }
        int n;
        try {
            n = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            System.err.println("n must be an integer!!");
            return;
        }
        if (n <= 0) {
            System.err.println("n must be a positive integer!!");
            return;
        }


        // Create n x n Latin Square as a matrix
        int i, j;
        int[][] latinSquare = new int[n][n];
        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                latinSquare[i][j] = (i + j) % n + 1;
            }
        }
        //for running time
        long startTime = System.nanoTime();

        System.out.println("The Latin Square matrix:");
        for (i = 0; i < n; i++) {
            StringBuilder row = new StringBuilder();
            for ( j = 0; j < n; j++) {
                row.append(latinSquare[i][j]).append(" ");
            }
            System.out.println(row.toString());
        }

        // Measure running time
        long endTime = System.nanoTime();
        long elapsedTime = endTime - startTime;
        System.out.println("Running time: " + elapsedTime + " nanoseconds");
        
    }
    
    
    
    
    void compulsory() {
        System.out.println("Hello world!");
        String[] languages = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};
        int n = (int) (Math.random() * 1_000_000);

        n = n * 3;
        System.out.println(n);

        int number = Integer.parseInt("10101", 2);
        System.out.println(number);

        int value = Integer.parseInt("FF", 16);
        System.out.println(value);

        int Sum = n + value;
        System.out.println(Sum);

        int M = Sum * 6;
        Sum = 0;

        System.out.println(M);
        while (M != 0) {
            Sum = Sum + M % 10;
            M = M / 10;
        }
        System.out.println(Sum);
        M = Sum;
        int ok;

        if (Sum > 9) {
            ok = 1;
            Sum = 0;
        } else
            ok = 0;

        while (ok == 1) {
            while (M != 0) {
                Sum = Sum + M % 10;
                M = M / 10;
            }
            if (Sum > 9)
                M = Sum;
            else
                ok = 0;
        }
        int result = Sum;

        System.out.println(Sum);
        int x = (0b011 | 0b101) & 0b001;
        String str = 1 + 2 + "abc";

        System.out.println(str);
        System.out.println("Willy-nilly, this semester I will learn " + languages[result]);
    }

}
