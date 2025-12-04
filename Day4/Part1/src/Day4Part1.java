import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;

public class Day4Part1 {
    public static void main(String[] args) {
        try {
            ArrayList<char[]> grid = new ArrayList<>();
            BufferedReader myReader = new BufferedReader(new FileReader(Path.of("Day4\\Part1\\src\\Input.txt").toString()));
            while (myReader.ready()) {
                grid.add(myReader.readLine().toCharArray());
            }
            myReader.close();

            int ans = 0;
            int count;

            for (int i = 0; i < grid.size(); i++) {
                for (int j = 0; j < grid.getFirst().length; j++) {
                    if (grid.get(i)[j] == '@') {
                        count = 0;
                        for (int k = -1; k < 2; k++) {
                            if (i + k >= grid.size() || i + k < 0) {continue;}
                            for (int l = -1; l < 2; l++) {
                                if (j + l >= grid.getFirst().length || j + l < 0) {continue;}
                                if (grid.get(i + k)[j + l] == '@') {
                                    count++;
                                }
                            }
                        }
                        if (count < 5){
                            ans++;
                        }
                    }
                }
            }
            System.out.println(ans);

        } catch (IOException e){
            System.out.println("There was an IO exception, the input file likely doesn't exist.");
            System.out.println(e.getMessage());
        }
    }
}