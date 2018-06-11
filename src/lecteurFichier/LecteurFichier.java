package lecteurFichier;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class LecteurFichier {

    public LecteurFichier() {
    }
    public ArrayList<String[]> lir(String nomFichier) {
        ArrayList<String[]> ArrayQuestions = new ArrayList<>();
        File file = new File(nomFichier);
        Scanner scanner = null;
        try
        {
            scanner = new Scanner(file);
            while (scanner.hasNextLine())
            {
                String l = scanner.nextLine();
                String[] array = l.split(",");
                ArrayQuestions.add(array);
            }
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (scanner != null)
                scanner.close();
        }
        return ArrayQuestions;
    }

}
