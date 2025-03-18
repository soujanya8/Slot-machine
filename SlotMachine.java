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

            System.out.println("Spinning.....");
            row = spinRow();
            printRow(row);
            payout = getPayout(row,bet);
            if(payout > 0){
                balance += payout;
                System.out.println("*********** You Won!!! **********");
                System.out.println("Your Payout for this round: "+payout);
                System.out.printf("\n \n Your balance after payout: %.2f \n",balance);
            }
            else{
                balance -= bet;
                System.out.println("********* You Lost :( ********");
                System.out.println("Your Payout for this round: "+payout);
                System.out.printf("\n \n Your balance after loosing bet: %.2f \n",balance);
            }

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
        if (row[0].equals(row[1]) && row[1].equals(row[2])) {
            return switch(row[0]){
                case "🍇" -> bet*30;
                case "🍊" -> bet*25;
                case "🍎" -> bet*20;
                case "🍉" -> bet*10;
                case "🍒" -> bet*5;
                default -> 0;
            };
        }
        else if(row[0].equals(row[1]) || row[1].equals(row[2])){
            return bet*3;
        }
        return 0;
    }

    static void printRow(String[] row) {
        System.out.println("****************");
        System.out.println(" "+String.join(" | ",row));
        System.out.println("****************\n\n");
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
