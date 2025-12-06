import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;
import java.util.regex.Pattern;

public class Day6Part1 {
    public static void main(String[] args) {
        try {
            ArrayList<String[]> lines = new ArrayList<>();
            BufferedReader myReader = new BufferedReader(new FileReader(Path.of("Day6\\Part1\\src\\Input.txt").toString()));

            while (myReader.ready()) {
              lines.add(myReader.readLine().trim().split("(" + Pattern.quote(" ") + ")+"));
            }
            myReader.close();

            long ans = 0;

            String operand;
            long localTotal;
            for (int i = 0; i < lines.getFirst().length; i++) {
                operand = lines.getLast()[i];
                if (operand.equals("+")){
                    localTotal = 0;
                } else {
                    localTotal = 1;
                }
                for (int j = 0; j<lines.size()-1; j++) {
                    if (operand.equals("+")) {
                        localTotal += Long.parseLong(lines.get(j)[i]);
                    } else {
                        localTotal *= Long.parseLong(lines.get(j)[i]);
                    }
                }
                ans += localTotal;
            }

            System.out.println(ans);

        } catch (IOException e){
            System.out.println("There was an IO exception, the input file likely doesn't exist.");
            System.out.println(e.getMessage());
        }
    }
}