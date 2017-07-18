import java.util.Arrays;

public class Program {
    public static void main(String[] args) {
        System.out.println(String.format("%15s","Chapter1"));
        int[] arr = {4,3,2,5,1,8,0,7,6};
        print(arr);
        Arrays.sort(arr);
        print(arr);

        System.out.println(sqrt(100));
    }

    public static double sqrt(double val) {
        double err = 1e-15;
        double t = val;
        while(Math.abs(t-val/t) > err * t)
            t = (val/t + t) / 2.0;
        return t;
    }

    public static void print(int[] arr) {
        for(int x : arr) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
}
