import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

//        createFolder("whatever");
//        createFile(K.DESKTOP + "whatever\\","file1");
//        writeFile(K.DESKTOP + "whatever\\file1" + K.TXT,"my text");
//        String s = readFile(K.DESKTOP + "whatever\\file1" + K.TXT);
//        System.out.println(s);
        File original = new File(K.DESKTOP + "whatever\\file1" + K.TXT);
        File copy = new File(K.DESKTOP + "whatever\\file2" + K.TXT);
        copyFile(original,copy);
    }

    public static void createFolder(String folderName){
        File file = new File(K.DESKTOP+folderName);
        file.mkdir();
    }

    public static void createFile(String folderPath, String fileName){
        File file = new File(folderPath + fileName + K.TXT);
        try {
            file.createNewFile();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void writeFile(String filePath, String text){
        File file = new File(filePath);
        try {
            FileWriter writer = new FileWriter(file);
            writer.write(text);
            writer.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static String readFile(String filePath){
        String temp = "";
        File file = new File(filePath);
        try {
            Scanner sc = new Scanner(file);
            while(sc.hasNext()){
                temp += sc.nextLine() + "\n";
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
        return temp;
    }

    public static void copyFile(File original, File copy){
        try {
            copy.createNewFile();
            FileWriter writer = new FileWriter(copy,true);
            Scanner scanner = new Scanner(original);
            while (scanner.hasNext()){
                writer.write(scanner.nextLine() + "\n");
            }
            writer.close();
        } catch (Exception e) {
            System.out.println(e);;
        }
    }



}
