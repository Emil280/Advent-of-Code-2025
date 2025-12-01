import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;

public class Day1Part1 {
    public static void main(String[] args) {
        try {
            BufferedReader myReader = new BufferedReader(new FileReader(Path.of("Day1\\Part1\\src\\Input.txt").toString()));

            int pos = 50;

            int count = 0;

            String input;
            int left;
            while (myReader.ready()) {
                input = myReader.readLine();
                if (input.charAt(0) == 'L'){
                    left = Integer.parseInt(input.substring(1)) % 100;
                    if (pos - left < 0 ){
                        pos = 100 - (left-pos);
                    } else {
                        pos -= left;
                    }
                } else {
                    pos = (pos + Integer.parseInt(input.substring(1))) % 100;
                }
                if (pos == 0){
                    count++;
                }
            }

            System.out.println(count);

        } catch (IOException e){
            System.out.println("There was an IO exception, the input file likely doesn't exist.");
            System.out.println(e.getMessage());
        }
    }
}