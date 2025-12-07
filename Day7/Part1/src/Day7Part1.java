import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class Day7Part1 {
    public static int total = 0;
    public static ArrayList<char[]> lines = new ArrayList<>();

    public static void split(int row, int col){
        char[] line = lines.get(row);
        int newbeams = 0;
        if (col > 0){
            if (line[col-1] == '.'){
                line[col-1] = '|';
                newbeams++;
                propagate(row, col-1);
            } else if (line[col-1] == '|'){
                newbeams++;
            }

        }
        if (col < line.length - 1){
            if (line[col+1] == '.'){
                line[col+1] = '|';
                newbeams++;
                propagate(row, col+1);
            } else if (line[col+1] == '|'){
                newbeams++;
            }
        }
        total += newbeams/2;

    }

    public static void propagate(int row, int col){
        if (row + 1 != lines.size()) {
            char[] line = lines.get(row + 1);
            if (line[col] == '.') {
                line[col] = '|';
                propagate(row + 1, col);
            } else if (line[col] == '^') {
                split(row+1, col);
            }
        }

    }

    public static void main(String[] args) {
        try {
            BufferedReader myReader = new BufferedReader(new FileReader(Path.of("Day7\\Part1\\src\\Input.txt").toString()));

            String firstLine = myReader.readLine();
            int start = firstLine.indexOf('S');

            lines.add(firstLine.toCharArray());

            while (myReader.ready()) {
              lines.add(myReader.readLine().toCharArray());
            }
            myReader.close();

            propagate(0, start);

            System.out.println(total);

        } catch (IOException e){
            System.out.println("There was an IO exception, the input file likely doesn't exist.");
            System.out.println(e.getMessage());
        }
    }
}