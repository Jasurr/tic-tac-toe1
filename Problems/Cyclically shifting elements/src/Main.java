import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int c = scanner.nextInt();
        int[] a = new int[c];
        for (int i = 0; i < c; i++) {
            a[i] = scanner.nextInt();
        }
        int n = 1;
        int[] b = new int[a.length];
        for (int i = a.length - 1; i >= 0; i--) {
            if (n + i >= a.length) {
                b[i + n - a.length] = a[i];
            } else {
                b[i + n] = a[i];
            }
        }
        for (int val : b) {
            System.out.print(val + " ");
        }
    }
}