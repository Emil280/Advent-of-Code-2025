import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.regex.Pattern;

public class Day3Part1 {
    public static void main(String[] args) {
        try {
            BufferedReader myReader = new BufferedReader(new FileReader(Path.of("Day3\\Part1\\src\\Input.txt").toString()));

            int ans = 0;

            String bank;
            int posNum;

            while (myReader.ready()) {
                bank = myReader.readLine();
                for (char i = '9'; i > '0'; i--) {
                    posNum = bank.indexOf(i);
                    if (posNum != -1 && posNum != bank.length() - 1) {
                        ans += Character.getNumericValue(i) * 10;
                        bank = bank.substring(posNum + 1);

                        for (char j = '9'; j > '0'; j--) {
                            if (bank.indexOf(j) != -1) {
                                ans += Character.getNumericValue(j);
                                break;
                            }
                        }

                        break;
                    }
                }
            }

            myReader.close();


            System.out.println(ans);

        } catch (IOException e){
            System.out.println("There was an IO exception, the input file likely doesn't exist.");
            System.out.println(e.getMessage());
        }
    }
}