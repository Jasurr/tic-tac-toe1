import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] a = new int[4];
        for (int i = 0; i < a.length; i++) {
            a[i] = scanner.nextInt();
        }
        for (int value : a) {
            System.out.print((value - 1) + " ");
        }

    }
}