import java.util.Scanner;

class Tag2 {

    static int countUtil(int p, int q, int r, int last) {
         if (p < 0 || q < 0 || r < 0)
            return 0;

       
        if (p == 1 && q == 0 && r == 0 && last == 0)
            return 1;

        // Same case as above for 'q' and 'r'
        if (p == 0 && q == 1 && r == 0 && last == 1)
            return 1;
        if (p == 0 && q == 0 && r == 1 && last == 2)
            return 1;

        
        if (last == 0)
            return countUtil(p - 1, q, r, 1)
                + countUtil(p - 1, q, r, 2);

        // Same as above case for 'q' and 'r'
        if (last == 1)
            return countUtil(p, q - 1, r, 0)
                + countUtil(p, q - 1, r, 2);

        if (last == 2)
            return countUtil(p, q, r - 1, 0)
                + countUtil(p, q, r - 1, 1);

        return 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int p = scanner.nextInt(); // Number of 'P's
        int q = scanner.nextInt(); // Number of 'Q's
        int r = scanner.nextInt(); // Number of 'R's
        System.out.println(p);
        System.out.println(q);
        System.out.println(r);

        // Total ways to arrange the sequence
        int totalways = countUtil(p, q, r, 2) + countUtil(p, q, r, 1) + countUtil(p, q, r, 0);
        System.out.println(totalways);
    }
}
