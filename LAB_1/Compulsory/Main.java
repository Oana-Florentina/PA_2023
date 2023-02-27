public class Main {
    public static void main(String[] args) {

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
int x= (0b011 | 0b101)&0b001;
String str=1+2+"abc";

        System.out.println(str);
        System.out.println("Willy-nilly, this semester I will learn " + languages[result]);
    }
}