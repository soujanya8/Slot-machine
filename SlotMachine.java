import java.util.Random;
import java.util.Scanner;

public class SlotMachine {
    public static void main(String []args){
        Scanner scanner = new Scanner(System.in);

        double balance = 100;
        double bet;
        double payout;

        String[] row;

        System.out.println("*********************************");
        System.out.println("   Welcome to the slot machine");
        System.out.println("    Symbols: 🍇 🍊 🍎 🍉 🍒");
        System.out.println("*********************************");
        while(balance > 0){
            System.out.println("Your current balance: $"+balance);
            System.out.print("Enter your bet amount: $");
            bet = scanner.nextDouble();
            scanner.nextLine();
            if(bet > balance){
                System.out.println("INSUFFICIENT FUNDS");
            }
            else if(bet < 0){
                System.out.println("Bet can't be less than 0");
            }
            else {
                balance -= bet;
                // System.out.println(balance);
            }


            System.out.println("Spinning.....");
            row = spinRow();
            printRow(row);
            getPayout(row,bet);


            System.out.print("Dou you want to play again (Y/N): ");
            String response = scanner.nextLine().toUpperCase();
            if(!response.equals("Y")){
                break;
            }

        }
        //variable declaration
        //balance
        //payout
        //display welcome

        //symbols of array
        //balance should be >0
        //enter bet amount
        // verify bet >balance
        // bet >0
        //subtract bet from balance
        //spin row
        //print row
        //get payout
        //play again
        //exit message

    }

    static double getPayout(String[] row, double bet) {
        double payout = 0;
        if (row[0].equals(row[1]) && row[1].equals(row[2])) {

            payout = bet*20;

        }
        return payout;
    }

    static void printRow(String[] row) {
        System.out.println("****************");
        System.out.println(" "+String.join(" | ",row));
        System.out.println("****************");
    }

    static String[] spinRow() {
        String[] symbols = {"🍇", "🍊", "🍎" ,"🍉" ,"🍒"};
        String[] row = new String[3];
        for(int i= 0; i < row.length ; i++){
            Random random = new Random();
            row[i] = symbols[random.nextInt(symbols.length)];
        }
        return row;
    }
}
