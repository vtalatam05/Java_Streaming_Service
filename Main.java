import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int netflixHours, primeHours, hotstarHours;

        System.out.print("Viewing hours for Netflix: ");
        netflixHours = sc.nextInt();

        System.out.print("Viewing hours for Amazon Prime: ");
        primeHours = sc.nextInt();

        System.out.print("Viewing hours for Hotstar: ");
        hotstarHours = sc.nextInt();

        try {
            int total = 0;

            total += calculateCost("Netflix", netflixHours, 10, 10);
            total += calculateCost("Amazon Prime", primeHours, 2, 5);
            total += calculateCost("Hotstar", hotstarHours, 1, 5);

            System.out.println("Total amount should be paid: Rs." + total);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        sc.close();
    }

    private static int calculateCost(String service, int hours, int pricePerUnit, int unitHours) {
        if (hours % unitHours != 0) {
            throw new IllegalArgumentException(
                    service + " allows viewing hours in multiples of " + unitHours + " only"
            );
        }

        int units = hours / unitHours;
        return units * pricePerUnit;
    }
}
