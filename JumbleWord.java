/**
 * Created by Sahil Verma on 1/25/2018.
 * **********************************************************
 * Problem statement:
 * ------------------
 * User will give the input like : "2,CAT,ROB,BAT,CAP"
 * first digit : signifies we have to create 2 words by using pairs of two words
 * futhure arguments are the input words.
 * 
 * For example:
 * "2,CAT,ROB,BAT,CAP"
 * first word will be created from using CAT and ROB
 * second word will be created from using BAT and CAP
 * 
 * How to create first word:
 * compare first char of CAT -> C with the first char of BAT -> B
 * which ever is lexigally small, will be the first char of the resultant word.. and so on.....
 * 
 * First and Second Output Word will be: CAROBT and BACAPT
 * 
 * This problem is vert easy, try to solve it in 15 minutes of time.
 * 
 *
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
