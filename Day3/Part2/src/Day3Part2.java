import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;

public class Day3Part2 {
    public static long findBiggest(String input, int digits) {
        if (digits == 0){
            return 0;
        }
        if (digits == input.length()){
            return Long.parseLong(input);
        }
        int posNum;
        for (char i = '9'; i > '0'; i--) {
            posNum = input.indexOf(i);
            if (posNum != -1 && posNum <= input.length() - digits) {
                Long rest = findBiggest(input.substring(posNum+1), digits-1);
                if (rest > -1) {
                    return (long) (rest + (Character.getNumericValue(i) * Math.pow(10, digits-1)));
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int digits = 12;
        try {
            BufferedReader myReader = new BufferedReader(new FileReader(Path.of("Day3\\Part2\\src\\Input.txt").toString()));

            long ans = 0;

            String bank;

            while (myReader.ready()) {
                bank = myReader.readLine();
                ans += findBiggest(bank, digits);
            }

            myReader.close();


            System.out.println(ans);

        } catch (IOException e){
            System.out.println("There was an IO exception, the input file likely doesn't exist.");
            System.out.println(e.getMessage());
        }
    }
}