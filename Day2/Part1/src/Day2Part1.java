import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;

public class Day2Part1 {
    public static void main(String[] args) {
        int[][] IDRanges;
        try {
            BufferedReader myReader = new BufferedReader(new FileReader(Path.of("Day2\\Part1\\src\\Input.txt").toString()));
            String input = myReader.readLine();
            myReader.close();

            String[] ranges = input.split(",");

            long ans = 0;
            String[] sRange;
            String id;
            for (int i = 0; i < ranges.length; i++) {
                sRange = ranges[i].split("-");
                if (sRange[0].length() == sRange[1].length() && sRange[0].length() % 2 == 1) {
                    continue;
                } else {
                    for (long n = Long.parseLong(sRange[0]); n <= Long.parseLong(sRange[1]); n++){
                        id = Long.toString(n);
                        if (id.length() % 2 == 1) {
                            continue;
                        }
                        if (id.substring(0, (id.length() / 2)).equals(id.substring(id.length() / 2))) {
                            ans+=n;
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