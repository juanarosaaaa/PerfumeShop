import java.util.*;

public class Lab1 {

    public static Scanner input = new Scanner(System.in);

    public static int qty, select, yesNo, answer, ordinaryQty, elegantQty, totalQty;
    public static double total, discount, payment;
    static double ordinaryPrice, elegantPrice, totalOrdinary, totalElegant, finalTotal, change;
    static String ordinaryPromo = "N/A", elegantPromo = "N/A";

    // order
    public static void order() {

        do {
            System.out.println("\t\t\t\t==================================================");
            System.out.println("\t\t\t\t                Perfume Shop                      ");
            System.out.println("\t\t\t\t                     Menu                         ");
            System.out.println("\t\t\t\t1. Ordinary Perfume                               ");
            System.out.println("\t\t\t\t2. Elegant Perfume                                ");
            System.out.println("\t\t\t\t3. Exit                                           ");
            System.out.println("\t\t\t\t==================================================");

            System.out.print("\t\t\t\tPlease select a number: ");
            select = input.nextInt();

            // ORDINARY PERFUME
            if (select == 1) {

                System.out.println("\t\t\t\t==================================================");
                System.out.println("\t\t\t\t                 Perfume Shop                     ");
                System.out.println("\t\t\t\t               Ordinary Perfume                   ");
                System.out.println("\t\t\t\tPrice/Promo:                                      ");
                System.out.println("\t\t\t\t1 bottle                         Php165.00        ");
                System.out.println("\t\t\t\tMinimum of 5 bottles purchase    Php150.00/bottle ");
                System.out.println("\t\t\t\tMinimum of 10 bottles purchase   Php125.00/bottle ");
                System.out.println("\t\t\t\tExceeds 20 bottles purchase      5% discount      ");
                System.out.println("\t\t\t\t==================================================");

                // invalid inputs

                do {
                    System.out.print("\t\t\t\tHow many perfume you want to purchase?: ");
                    ordinaryQty = input.nextInt();
                } while (ordinaryQty < 1);

                // 1 bottle of ordinary perfume

                if (ordinaryQty >= 1 && ordinaryQty <= 4) {
                    ordinaryPrice = 165.00;
                    ordinaryPromo = "N/A";
                    totalOrdinary = totalOrdinary + (ordinaryQty * ordinaryPrice);
                    System.out.printf("\t\t\t\tThe total cost is %.2f\n", totalOrdinary);

                    // minimum of 5 bottles of ordinary perfume
                } else if (ordinaryQty <= 9) {
                    ordinaryPrice = 150.00;
                    ordinaryPromo = "Min. of 5";
                    totalOrdinary = totalOrdinary + (ordinaryQty * ordinaryPrice);
                    System.out.printf("\t\t\t\tThe total cost is %.2f\n", totalOrdinary);

                    // minimum of 10 bottles of ordinary perfume
                } else if (ordinaryQty >= 10) {
                    ordinaryPrice = 125.00;
                    ordinaryPromo = "Min. of 10";
                    totalOrdinary = totalOrdinary + (ordinaryQty * ordinaryPrice);
                    System.out.printf("\t\t\t\tThe total cost is %.2f\n", totalOrdinary);
                } else {
                    System.out.println("\t\t\t\tInvalid input.");
                }

                // ELEGANT PERFUME
            } else if (select == 2) {

                System.out.println("\t\t\t\t==================================================");
                System.out.println("\t\t\t\t                 Perfume Shop                     ");
                System.out.println("\t\t\t\t                Elegant Perfume                   ");
                System.out.println("\t\t\t\tPrice/Promo:                                      ");
                System.out.println("\t\t\t\t1 bottle                         Php250.00        ");
                System.out.println("\t\t\t\tMinimum of 5 bottles purchase    Php185.00/bottle ");
                System.out.println("\t\t\t\tMinimum of 10 bottles purchase   Php170.00/bottle ");
                System.out.println("\t\t\t\tExceeds 20 bottles purchase      5% discount      ");
                System.out.println("\t\t\t\t==================================================");

                // invalid inputs
                do {
                    System.out.print("\t\t\t\tHow many perfume you want to purchase?: ");
                    elegantQty = input.nextInt();
                } while (elegantQty < 1);

                // 1 bottle of elegant perfume
                if (elegantQty >= 1 && elegantQty <= 4) {
                    elegantPrice = 250.00;
                    elegantPromo = "N/A";
                    totalElegant = totalElegant + (elegantQty * elegantPrice);
                    System.out.printf("\t\t\t\tThe total cost is %.2f\n", totalElegant);

                    // minimum of 5 bottles of elegant perfume
                } else if (elegantQty <= 9) {
                    elegantPrice = 185.00;
                    elegantPromo = "Min. of 5";
                    totalElegant = totalElegant + (elegantQty * elegantPrice);
                    System.out.printf("\t\t\t\tThe total cost is %.2f\n", totalElegant);

                    // minimum of 10 bottles of elegant perfume
                } else if (elegantQty >= 10) {
                    elegantPrice = 170.00;
                    elegantPromo = "Min. of 10";
                    totalElegant = totalElegant + (elegantQty * elegantPrice);
                    System.out.printf("\t\t\t\tThe total cost is %.2f\n", totalElegant);

                } else {
                    System.out.println("\t\t\t\tInvalid input.");
                }
                // exit
            } else if (select == 3) {
                System.exit(0);

                // invalid inputs
            } else {
                System.out.println("\t\t\t\tChoose between 1 to 3 only.");
                order();
            }

            // buy again
            System.out.println("\t\t\t\t==================================================");
            System.out.println("\t\t\t\tDo you want to buy again?");

            // invalid inputs
            do {
                System.out.println("\t\t\t\tPress 1 for Yes, Press 2 for No");
                System.out.print("\t\t\t\tYour choice: ");
                yesNo = input.nextInt();
            } while (yesNo != 1 && yesNo != 2);

            if (yesNo == 1) {
                order();
            } else if (yesNo == 2) {
                finalTotal = totalOrdinary + totalElegant;
                System.out.println("\t\t\t\t==================================================");
                System.out.printf("\t\t\t\tThe total cost is %.2f\n", finalTotal);
                totalQty = ordinaryQty + elegantQty; // total quantity of the items

                // total qty of bottle perfumes exceeds 20 will have a discount
                if (totalQty > 20) {
                    discount = 0.05;
                }
                total = finalTotal - (finalTotal * discount);

                // PAYMENT AND CHANGE
                do {
                    System.out.print("\t\t\t\tEnter your payment: ");
                    payment = input.nextInt();
                } while (payment < finalTotal);
                change = payment - total;

                // receipt
                System.out.println(
                        "\t\t\t\t================================================================================");
                System.out.println(
                        "\t\t\t\t                                   Perfume Shop                                      ");
                System.out.println(
                        "\t\t\t\t                                      Receipt                                        ");
                System.out.println(
                        "\t\t\t\tQty       Item           OriginalPrice      Promo         Price           Total   ");
                System.out.println(
                        "\t\t\t\t--------------------------------------------------------------------------------");
                System.out.printf("\t\t\t\t" + ordinaryQty + "    Ordinary Perfume       165.00        " + ordinaryPromo
                        + "    " + ordinaryPrice + "/bottle    %.2f\n", totalOrdinary);
                System.out.printf("\t\t\t\t" + elegantQty + "    Elegant Perfume        250.00        " + elegantPromo
                        + "    " + elegantPrice + "/bottle    %.2f\n", totalElegant);
                System.out.println(
                        "\t\t\t\t--------------------------------------------------------------------------------");
                System.out.printf(
                        "\t\t\t\t                                                             Subtotal    %.2f\n",
                        finalTotal);
                System.out.printf(
                        "\t\t\t\t                                                             Discount    %.2f\n",
                        discount);
                System.out.println(
                        "\t\t\t\t                                                                        --------  \n");
                System.out.printf(
                        "\t\t\t\t                                                             Total       %.2f\n",
                        total);
                System.out.println(
                        "\t\t\t\t                                                                                ");
                System.out.printf(
                        "\t\t\t\t                                                             Payment     %.2f\n",
                        payment);
                System.out.printf(
                        "\t\t\t\t                                                             Change      %.2f\n",
                        change);
                System.out.println(
                        "\t\t\t\t                                     Thank You!                                     ");
                System.out.println(
                        "\t\t\t\t================================================================================");

            } else {
                System.out.println("\t\t\t\tChoose between 1 and 2 only.");
            }
            //RESTART
            System.out.println("\t\t\t\tWould you like to use the system again?");
            System.out.println("\t\t\t\t1: Yes");
            System.out.println("\t\t\t\t2: No");
            System.out.print("\t\t\t\t:");
            answer = input.nextInt();
            
        } while (answer == 1);
        input.close();
    }
    public static void main(String[] args) {
        order();

    }
    
}
