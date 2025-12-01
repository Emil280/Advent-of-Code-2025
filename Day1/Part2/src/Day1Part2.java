import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;

public class Day1Part2 {
    public static void main(String[] args) {
        try {
            BufferedReader myReader = new BufferedReader(new FileReader(Path.of("Day1\\Part2\\src\\Input.txt").toString()));

            int pos = 50;

            int count = 0;

            String input;
            int move;
            while (myReader.ready()) {
                input = myReader.readLine();
                move = Integer.parseInt(input.substring(1));
                if (input.charAt(0) == 'L'){
                    if (pos == 0){
                        count += move / 100;
                    } else {
                        count += (move + (100-pos)) / 100;
                    }
                    pos = (pos - move) % 100;
                    if (pos < 0) { pos += 100; }
                } else {
                    count += (pos + move) / 100;
                    pos = (pos + move) % 100;
                }
            }

            System.out.println(count);

        } catch (IOException e){
            System.out.println("There was an IO exception, the input file likely doesn't exist.");
            System.out.println(e.getMessage());
        }
    }
}