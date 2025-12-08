import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;

public class Day7Part2 {
    public static ArrayList<char[]> lines = new ArrayList<>();
    public static HashMap<String, Long> cache = new HashMap<>();

    public static long split(int row, int col){
        if (!cache.containsKey(row+","+col)){
            char[] line = lines.get(row);
            long paths = 0;
            if (col > 0){
                if (line[col-1] == '.'){
                    paths += propagate(row, col-1);
                }
            }
            if (col < line.length - 1){
                if (line[col+1] == '.'){
                    paths += propagate(row, col+1);
                }
            }
            cache.put(row+","+col,paths);
        }
        return cache.get(row+","+col);
    }

    public static long propagate(int row, int col){
        if (row + 1 != lines.size()) {
            char[] line = lines.get(row + 1);
            if (line[col] == '.') {
                return propagate(row + 1, col);
            } else if (line[col] == '^') {
                return split(row+1, col);
            }
        } else {
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        try {
            BufferedReader myReader = new BufferedReader(new FileReader(Path.of("Day7\\Part2\\src\\Input.txt").toString()));

            String firstLine = myReader.readLine();
            int start = firstLine.indexOf('S');

            lines.add(firstLine.toCharArray());

            while (myReader.ready()) {
              lines.add(myReader.readLine().toCharArray());
            }
            myReader.close();

            System.out.println(propagate(0, start));

        } catch (IOException e){
            System.out.println("There was an IO exception, the input file likely doesn't exist.");
            System.out.println(e.getMessage());
        }
    }
}