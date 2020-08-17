import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int justForPrintAnswer = 1;

        int numberOfCases = scanner.nextInt();
        while (numberOfCases > 0) {
            int previousRecord = 0;
            int recordBreaksCount = 0;
            int numberOfDaysInCurrentCase = scanner.nextInt();
            List<Integer> numberOfVisitors = new ArrayList<>(numberOfDaysInCurrentCase);
            for (int i = 0; i < numberOfDaysInCurrentCase; i++) {
                numberOfVisitors.add(scanner.nextInt());
            }
            for (int i = 0; i < numberOfVisitors.size(); i++) {
                boolean greaterThanPreviousDays = i == 0 || numberOfVisitors.get(i) > previousRecord;
                boolean greaterThanFollowingDay = i == numberOfVisitors.size() - 1 || numberOfVisitors.get(i) > numberOfVisitors.get(i + 1);
                if (greaterThanPreviousDays && greaterThanFollowingDay) {
                    recordBreaksCount++;
                }
                previousRecord = Math.max(previousRecord, numberOfVisitors.get(i));
            }
            System.out.println("Case #" + justForPrintAnswer + ": " + recordBreaksCount);
            justForPrintAnswer++;
            numberOfCases--;
        }
    }
}
