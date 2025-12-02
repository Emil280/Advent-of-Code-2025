import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.regex.Pattern;

public class Day2Part2 {
    public static boolean isRepeated(String s) {
        String doubled = s + s;
        // search for s starting from index 1
        return doubled.indexOf(s, 1) != s.length();
    }

    public static void main(String[] args) {
        try {
            BufferedReader myReader = new BufferedReader(new FileReader(Path.of("Day2\\Part2\\src\\Input.txt").toString()));
            String input = myReader.readLine();
            myReader.close();

            String[] ranges = input.split(",");

            long ans = 0;
            String[] sRange;
            String id;
            String sub;
            for (int i = 0; i < ranges.length; i++) {
                sRange = ranges[i].split("-");
                for (long n = Long.parseLong(sRange[0]); n <= Long.parseLong(sRange[1]); n++){
                    id = Long.toString(n);
                    if (isRepeated(id)) {
                        ans+= n;
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