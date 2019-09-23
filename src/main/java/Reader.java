import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Reader {
    private double summary;
    private int directoryCount;
    private String path;
    private List<File> inFolder = new ArrayList<>();
    private List<File> directories = new ArrayList<>();
    private List<File> files = new ArrayList<>();

    public void folderSize(String path) {
        this.path = path;
        sizeCalculator(folderList(path));
        sizeToString();
    }

    private List<File> folderList(String path) {
        inFolder.addAll(Arrays.asList(new File(path).listFiles()));
        fileOrDirectory();

        for (int i = 0; i < directoryCount; i++) {
           inFolder.removeAll(inFolder);
           inFolder.addAll(Arrays.asList(directories.get(i).listFiles()));
           fileOrDirectory();
       }
        return files;
    }

    private void fileOrDirectory() {
        for (File f : inFolder) {
            if (f.isDirectory()) {
                directoryCount++;
                directories.add(f);
            } else
                files.add(f);
        }
    }

    private double sizeCalculator(List<File> files) {
        for(File f : files)
            summary += f.length();
        return summary;
    }

    private void sizeToString() {
        if (summary < 1024)
            System.out.format("Папка " + path + " занимает %.2f Байт %n", summary);
        else if (summary < 1024 * 1024)
            System.out.format("Папка " + path + " занимает %.2f Кбайт %n", summary/1024);
        else if (summary < 1024 * 1024 * 1024)
            System.out.format("Папка " + path + " занимает %.2f Мб %n", summary/1024/1024);
        else if (summary < 1024 * 1024 * 1024 * 1024)
            System.out.format("Папка " + path + " занимает %.2f Гб %n", summary/1024/1024/1024);
    }
}
