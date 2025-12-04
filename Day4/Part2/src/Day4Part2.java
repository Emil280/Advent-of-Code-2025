import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;

public class Day4Part2 {
    public static void relpace(ArrayList<char[]> grid){
        for (char[] row : grid) {
            for (int i = 0; i < row.length; i++) {
                if (row[i] == 'x') {
                    row[i] = '.';
                }
            }
        }
    }

    public static void main(String[] args) {
        try {
            ArrayList<char[]> grid = new ArrayList<>();
            BufferedReader myReader = new BufferedReader(new FileReader(Path.of("Day4\\Part2\\src\\Input.txt").toString()));
            while (myReader.ready()) {
                grid.add(myReader.readLine().toCharArray());
            }
            myReader.close();

            int oldAns;
            int ans = 0;
            int count;
            char[] row;

            do {
                oldAns = ans;
                for (int i = 0; i < grid.size(); i++) {
                    for (int j = 0; j < grid.getFirst().length; j++){
                        if (grid.get(i)[j] == '@') {
                            count = 0;
                            for (int k = -1; k < 2; k++) {
                                if (i + k >= grid.size() || i + k < 0) {
                                    continue;
                                }
                                row = grid.get(i + k);
                                for (int l = -1; l < 2; l++) {
                                    if (j + l >= row.length || j + l < 0) {
                                        continue;
                                    }
                                    if (row[j + l] == '@' || row[j + l] == 'x') {
                                        count++;
                                    }
                                }
                            }
                            if (count < 5) {
                                ans++;
                                grid.get(i)[j] = 'x';
                            }
                        }
                    }
                }
                relpace(grid);
            } while (ans != oldAns);
            System.out.println(ans);

        } catch (IOException e){
            System.out.println("There was an IO exception, the input file likely doesn't exist.");
            System.out.println(e.getMessage());
        }
    }
}