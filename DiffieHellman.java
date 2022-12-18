package Bonus;

import java.util.Scanner;

public class DiffieHellman {
    public static Scanner cin = new Scanner(System.in);
    private static int a, b, prime, Alpha;

    public static void prime() {
        boolean flag = false, flag2;
        do {
            System.out.println("Enter the prime num ");
            prime = cin.nextInt();

            for (int i = 2; i <= prime / 2; ++i) {
                // condition for nonprime number
                if (prime % i == 0) {
                    flag = true;
                    break;
                }
            }
            if (!flag)
                System.out.println(prime + " is a prime number.");
            else {
                System.out.println(prime + " is not a prime number.");
            }
            flag2 = flag;
            flag = false;
        } while (flag2 == true);

    }

    private static void inputdata() {
        System.out.println("Enter a : ");
        a = cin.nextInt();
        System.out.println("Enter b : ");
        b = cin.nextInt();
        System.out.println("Enter Alpha : ");
        Alpha = cin.nextInt();
        if ((a >= 2 && a <= prime - 2) && (b >= 2 && b <= prime - 2)) {
            System.out.println("Alpha = " + Alpha);
            System.out.println("a = " + a);
            System.out.println("b = " + b);

        } else {
            System.out.println("invalid input : ");
            inputdata();
        }

    }

    public static int power(int base, int exponent) {
        int result = 0;

        if (exponent == 0) {
            result = 1;
        } else if (exponent == 1) {
            result = base;
        } else if (exponent > 1) {
            // result = 2147483647;
            result = base * power(base, exponent - 1);
        }

        int resultTemp = result;
        result = 0;
        return resultTemp;
    }

    private static int Alice() {
        int A = 0;
        A = power(Alpha, a) % prime;

        return A;
    }

    private static int Bob() {
        int B = 0;
        B = power(Alpha, b) % prime;

        return B;
    }

    private static void main2() {
        prime();
        inputdata();
        System.out.println("A = " + Alice());
        System.out.println("B = " + Bob());
        System.out.println("KAB = " + result());
    }

    private static int result() {
        int comp = 0;
        int Alicecon = Alice();
        int Bobcon = Bob();
        int foralice = power(Bobcon, a) % prime;
        int forBob = power(Alicecon, b) % prime;
        if (foralice == forBob) {
            comp = foralice;
        } else {
            System.out.println("the compination is not valid");
            main2();
        }

        return comp;
    }

    public static void main(String[] args) {
        main2();
    }

}
