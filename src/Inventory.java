import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Inventory {

    private ArrayList<Roll> currentStock;
    public Inventory(){
        currentStock = new ArrayList<Roll>();
        loadFromFile();

    }
    private void loadFromFile(){
        try {
            FileReader fr = new FileReader("LWC Gloss & Silk");
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();


            String[] details = new String[0];
            System.out.println(details.length + " " + line);
            line = br.readLine();
            while (line != null) {
                details = line.split(",");
                String name = details[0].trim();
                if (!name.equals("TOTAL")) {
                    int gsm = 0;
                    int width = 0;
                    double weight = 0;
                    if (details.length >= 2) {
                        gsm = Integer.parseInt(details[1].trim());
                    }
                    if (details.length >= 3) {
                        width = Integer.parseInt(details[2].trim());
                    }
                    if (details.length >= 4) {
                        weight = Double.parseDouble(details[4].trim());
                    }

                    Roll newRoll = new Roll(name, gsm, width, weight);
                    currentStock.add(newRoll);

                }
                line = br.readLine();
            }

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    public void search(String input, int gsm) {

        for (int j = 0; j < currentStock.size(); j++) {
            //System.out.println(currentStock.get(j).getName());
            //when u type in the first field, it prints out whole row
            if (input.equals(currentStock.get(j).getName()) && (gsm == currentStock.get(j).getGsm() || gsm == -1)) {
                System.out.print("Search found: ");
                currentStock.get(j).display();
            }
        }
    }
}


