import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] a = new int[size];
        for (int i = 0; i < size; i++) {
            a[i] = scanner.nextInt();
        }
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        boolean b = true;
        int t = 0;
        for (int i = 0; i < a.length; i++) {
            if (i + 1 < a.length)
                t = i + 1;
            if (a[i] == n && a[t] == m || a[i] == m && a[t] == n) {
                b = false;
                break;
            }
        }
        System.out.println(b);
    }
}