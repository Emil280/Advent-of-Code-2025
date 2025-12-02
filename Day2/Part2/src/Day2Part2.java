import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.regex.Pattern;

public class Day2Part2 {
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
                    for (int s = 1; s<=(id.length()/2); s++){
                        sub = id.substring(0, s);
                        if (id.matches("(" + Pattern.quote(sub) + ")+")){
                            ans += n;
                            break;
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