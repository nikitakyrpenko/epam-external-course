package task5.task3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Translator {

    public Map<String, String> words = new HashMap<>();
    private File file;
    private Scanner scanner;

    public Translator(File file) throws FileNotFoundException {
        this.file = file;
        this.scanner = new Scanner(file);
        readFromFile();
    }

    public Translator() throws  FileNotFoundException{
        this.file = new File(System.getProperty("user.dir")+ "\\src\\main\\java\\task5\\task3\\words.txt");
        this.scanner = new Scanner(file);
        readFromFile();
    }

    public void addWords(String eng, String russ) {
        words.put(eng,russ);
    }

    public String translate(String line){
        String[] text = line.split("[,\\s]");
        StringBuilder stringBuilder = new StringBuilder();

        for (String txt : text) {
            String translatedWord = words.get(txt);
            if (translatedWord != null)
                stringBuilder.append(translatedWord + " ");
            else
                stringBuilder.append(txt + " ");
        }
        return stringBuilder.toString();
    }

    private void readFromFile(){
        while (scanner.hasNext()){
            String line = scanner.nextLine();
            String[] words = line.split("[\\s]");
            addWords(words[2], words[1]);
        }
        scanner.close();
    }

}
