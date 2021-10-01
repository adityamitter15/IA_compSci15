import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

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
                    int brightness = 0;
                    double weight = 0;
                    if (details.length >= 2) {
                        gsm = Integer.parseInt(details[1].trim());
                    }
                    if (details.length >= 3) {
                        width = Integer.parseInt(details[2].trim());
                    }
                    if (details.length >= 4) {
                        brightness = Integer.parseInt(details[3].trim());
                    }
                    if (details.length >= 5) {
                        weight = Double.parseDouble(details[4].trim());
                    }

                    Roll newRoll = new Roll(name, gsm, width, brightness, weight);
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
    public ArrayList<String> search(String input, int gsm, int width, int brightness, double weight) {
        // move this method out
        ArrayList<String> results = new ArrayList<>();
        for (int j = 0; j < currentStock.size(); j++) {
            //System.out.println(currentStock.get(j).getName());
            //when u type in the first field, it prints out whole row
            if (input.equals(currentStock.get(j).getName()) && (((gsm == currentStock.get(j).getGsm() || gsm == -1)) || (width == currentStock.get(j).getWidth() || width == -1) || (brightness == currentStock.get(j).getBrightness() || brightness == -1) || (weight == currentStock.get(j).getWeight() || weight == -1))) {
                System.out.print("Search found: ");
                currentStock.get(j).display();
                results.add(currentStock.get(j).toString());
            }
        }
        System.out.println(results.size() + " gguiggg");
        return results;
    }
}


