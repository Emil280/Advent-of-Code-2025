import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.*;

public class Day9Part1 {

    public static void main(String[] args) {
        try {
            BufferedReader myReader = new BufferedReader(new FileReader(Path.of("Day9\\Part1\\src\\Input.txt").toString()));

            ArrayList<long[]> coords = new ArrayList<>();
            String[] coordString;
            while (myReader.ready()) {
                coordString = myReader.readLine().split(",");
                coords.add(new long[]{Long.parseLong(coordString[0]), Long.parseLong(coordString[1])});
            }
            myReader.close();

            long maxArea = 0;
            long area;
            long[] point1;
            long[] point2;
            for (int i=0; i<coords.size()/2; i++){
                point1 = coords.get(i);
                for (int j=coords.size()-1; j>i; j--){
                    point2 = coords.get(j);
                    area = (Math.abs(point1[0] - point2[0])+1) * (Math.abs(point1[1] - point2[1])+1);
                    if (area > maxArea){
                        maxArea = area;
                    }
                }
            }

            System.out.println(maxArea);

        } catch (IOException e){
            System.out.println("There was an IO exception, the input file likely doesn't exist.");
            System.out.println(e.getMessage());
        }
    }
}