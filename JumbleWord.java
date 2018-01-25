/**
 * Created by somebody on 1/25/2018.
 */
public class JumbleWord {

    public static void main(String[] args) {

        String inputString = "2,JASMEET,RAHUL,PIYUSH,ABHISHEK";
        String[] inputArr = inputString.split(",");
        Integer pairsTOBeCreated = Integer.valueOf(inputArr[0]);

        for (int i = 0; i < pairsTOBeCreated; i++) {
            String wordCreated = createFirstWord(inputArr[i + 1], inputArr[i + 2]);
            System.out.println(wordCreated);
        }
    }

    private static String createFirstWord(String first, String second) {
        StringBuilder wordBd = new StringBuilder();
        int firstCharConsumed = 0;
        int secondCharConsumed = 0;
        while (firstCharConsumed < first.length() && secondCharConsumed < second.length()) {
            if (first.charAt(firstCharConsumed) < second.charAt(secondCharConsumed)) {
                ++firstCharConsumed;
                wordBd.append(first.charAt(firstCharConsumed));
            } else {
                ++secondCharConsumed;
                wordBd.append(second.charAt(secondCharConsumed));
            }
        }
        wordBd.append(first.substring(firstCharConsumed)).append(second.substring(secondCharConsumed));
        return wordBd.toString();
    }


}
