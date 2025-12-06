import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class Day6Part2 {
    public static void main(String[] args) {
        try {
            ArrayList<String> lines = new ArrayList<>();
            BufferedReader myReader = new BufferedReader(new FileReader(Path.of("Day6\\Part2\\src\\Input.txt").toString()));

            while (myReader.ready()) {
                lines.add(myReader.readLine());
            }
            myReader.close();

            if (lines.getFirst().length() != lines.getLast().length()) {
                System.out.println("The text file has been truncated, please use notepad++ or similar instead of intellij to edit the input file.");
            } else {

                long ans = 0;
                long localTotal = 0;
                String num;
                char operand = ' ';
                int lineLength = lines.getFirst().length();
                for (int c = 0; c < lineLength; c++) {
                    if (lines.getLast().charAt(c) != ' ') {
                        operand = lines.getLast().charAt(c);
                        ans += localTotal;
                        localTotal = 0;
                        if (operand == '*') {
                            localTotal++;
                        }
                    }

                    num = "";
                    for (int r = 0; r < lines.size() - 1; r++) {
                        num += lines.get(r).charAt(c);
                    }

                    num = num.trim();

                    if (!num.isEmpty()) {
                        switch (operand) {
                            case '+':
                                localTotal += Long.parseLong(num);
                                break;
                            case '*':
                                localTotal *= Long.parseLong(num);
                                break;
                        }
                    }
                }
                ans += localTotal;

                System.out.println(ans);
            }

        } catch (IOException e){
            System.out.println("There was an IO exception, the input file likely doesn't exist.");
            System.out.println(e.getMessage());
        }
    }
}