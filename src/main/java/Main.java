import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Reader reader = new Reader();

    System.out.println("Говорите точно, сколько вешать в граммах?");
    System.out.println("Например: C:/Windows/System32");


    for(;;) {
        System.out.print("Путь к папке для взвешивания >> ");
        String path = scanner.nextLine();
        reader.folderSize(path);
    }
    }
}
