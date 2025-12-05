import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;

public class Day5Part1 {
    public static void main(String[] args) {
        try {
            ArrayList<Long[]> ranges = new ArrayList<>();
            BufferedReader myReader = new BufferedReader(new FileReader(Path.of("Day5\\Part1\\src\\Input.txt").toString()));

            int fresh = 0;

            String line;
            long id;
            while (myReader.ready()) {
                line = myReader.readLine();
                if (Objects.equals(line, "")) {
                    ranges.sort(Comparator.comparingLong(o -> o[0]));
                } else if (line.contains("-")) {
                    ranges.add(new Long[]{Long.parseLong(line.split("-")[0]), Long.parseLong(line.split("-")[1])});
                } else {
                    id = Long.parseLong(line);
                    for (Long[] range : ranges) {
                        if (id < range[0]){
                            break;
                        } else if (id >= range[0] && id <= range[1]){
                            fresh++;
                            break;
                        }
                    }
                }
            }
            myReader.close();

            System.out.println(fresh);

        } catch (IOException e){
            System.out.println("There was an IO exception, the input file likely doesn't exist.");
            System.out.println(e.getMessage());
        }
    }
}