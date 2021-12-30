import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.stream.Stream;

public class Day2_2015 {
    public static void main(String[] args) throws IOException {
        int totalSquareOfPaper = 0;
        int totalFeetOfRibbon = 0;

        final int NR_OF_FACES = 2;

        List<Integer> listOfAllBoxesWrapperNeeds = new ArrayList<>();

        List<Integer> listOfAllBoxesRibbonNeeds = new ArrayList<>();

        File file = new File("E:\\IdeaProjects\\AdventOfCode\\src\\file\\file_day2_2015.txt");


        calcPaperNeeds(NR_OF_FACES, listOfAllBoxesWrapperNeeds, file);
        for (Integer i : listOfAllBoxesWrapperNeeds) {
            totalSquareOfPaper += i;
        }
        System.out.println(totalSquareOfPaper);

        calcRibbonNeeds(listOfAllBoxesRibbonNeeds, file);
        for (Integer j: listOfAllBoxesRibbonNeeds) {
            totalFeetOfRibbon += j;
        }
        System.out.println(totalFeetOfRibbon);

    }

    private static void calcPaperNeeds(int NR_OF_FACES, List<Integer> listOfAllBoxesWrapperNeeds, File file) throws FileNotFoundException {
        Scanner sc = new Scanner(file);
        while (sc.hasNext()) {
            String st = sc.nextLine();
            st = st.trim();
            st = st.replaceAll("x", " ");
            String[] parts = st.split(" ");
            int[] arr = Stream.of(parts).mapToInt(Integer::parseInt).toArray();
            int facesResult = (NR_OF_FACES * arr[0] * arr[1]) + (NR_OF_FACES * arr[1] * arr[2]) + (NR_OF_FACES * arr[0] * arr[2]);
            Arrays.sort(arr);
            int finalResult = facesResult + (arr[0] * arr[1]);
            listOfAllBoxesWrapperNeeds.add(finalResult);
        }
    }

    private static void calcRibbonNeeds(List<Integer> listOfAllBoxesRibbonNeeds, File file) throws FileNotFoundException {
        Scanner sc = new Scanner(file);
        while (sc.hasNext()) {
            String st = sc.nextLine();
            st = st.trim();
            st = st.replaceAll("x", " ");
            String[] parts = st.split(" ");
            int[] arr = Stream.of(parts).mapToInt(Integer::parseInt).toArray();
            Arrays.sort(arr);
            int facesResult = (arr[0] * 2) + (arr[1] * 2);
            int bowResult = arr[0] * arr[1] * arr[2];
            int finalResult = facesResult + bowResult;
            listOfAllBoxesRibbonNeeds.add(finalResult);
        }
    }
}
