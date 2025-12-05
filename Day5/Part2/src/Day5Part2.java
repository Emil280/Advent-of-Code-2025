import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;

public class Day5Part2 {
    public static void combine(ArrayList<Long[]> ranges) {
        Long[] r1;
        Long[] r2;
        for (int i = ranges.size() - 1; i > 0; i--) {
            r1 = ranges.get(i - 1);
            r2 = ranges.get(i);
            if ((r2[0]-1 <= r1[0] && r2[1]+1 >= r1[0]) || (r2[0]-1 <= r1[1] && r2[1]+1 >= r1[1]) || (r1[0]-1 <= r2[0] && r1[1]+1 >= r2[0]) || (r1[0]-1 <= r2[1] && r1[1]+1 >= r2[1])) {
                r1[0] = Math.min(r1[0], r2[0]);
                r1[1] = Math.max(r1[1], r2[1]);
                ranges.remove(r2);

                if (!(i++ < ranges.size())) {i--;}
            }
        }
    }

    public static void main(String[] args) {
        try {
            ArrayList<Long[]> ranges = new ArrayList<>();
            BufferedReader myReader = new BufferedReader(new FileReader(Path.of("Day5\\Part2\\src\\Input.txt").toString()));

            String line;
            while (myReader.ready()) {
                line = myReader.readLine();
                if (Objects.equals(line, "")) {
                    ranges.sort(Comparator.comparingLong(r -> r[0]));
                    myReader.close();
                    break;
                } else if (line.contains("-")) {
                    ranges.add(new Long[]{Long.parseLong(line.split("-")[0]), Long.parseLong(line.split("-")[1])});
                }
            }

            combine(ranges);

            long fresh = 0;
            for (Long[] range : ranges) {
                fresh+= range[1] - range[0];
                fresh++;
            }

            System.out.println(fresh);

        } catch (IOException e){
            System.out.println("There was an IO exception, the input file likely doesn't exist.");
            System.out.println(e.getMessage());
        }
    }
}