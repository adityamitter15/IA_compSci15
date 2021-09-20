import java.util.Scanner;

//this is the front screen
public class MainMenu {

    public static void main(String[] args) {
        //new OrderPlacing();
        //new Login();

        new GuiSearch();

        //MagazinePaper calc = new MagazinePaper();
        //calc.calculate();
        //you get the info and updates of the company
        Inventory paper = new Inventory();
        Scanner in = new Scanner(System.in);
        System.out.println("Search name: ");
        String input = in.nextLine();
        System.out.println("Search GSM: ");
        int gsm= in.nextInt();
        paper.search(input, gsm);

    }
}
//to do list
// create gui form
// add search and filter methods
// create a file with exact order details available (text file ) , which could be attached to an email