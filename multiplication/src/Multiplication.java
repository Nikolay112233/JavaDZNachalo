public class Multiplication {

    public static void main(String[] args) {
        int[] num = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        for (int tabl : num) {
            for (int trans : num) {
                System.out.printf("%4d", (tabl * trans));
            }
            System.out.println();
        }
    }
}
