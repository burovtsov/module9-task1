import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Scanner;

public class Main {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Reader reader = new Reader();

    System.out.println("Говорите точно, сколько вешать в граммах?");
    System.out.println("Например: C:/Windows/System32");


    for(;;) {
        System.out.print("Путь к папке для взвешивания >> ");
        try {
            String path = scanner.nextLine();
            reader.folderSize(path);
        }
        catch (NullPointerException e)
        {
            System.out.println("Произошла ошибка. Подробности в файле logs/exceptions.log");
            LOGGER.error(e);
        }
    }
    }
}
