/**
 * Created by somebody on 1/24/2018.
 */
public class SocialCircle {


    static StringBuilder socialCircles = new StringBuilder();
    static int length = 0;


    public static void main(String[] args) {

        int[][] circlesArray = {
                {1, 0, 0, 0},
                {0, 1, 0, 0},
                {0, 0, 1, 1},
                {0, 0, 1, 1}
        };
        length = circlesArray.length;
        boolean[] visited = new boolean[length];
        for (int i = 0; i < length; i++)
            visited[i] = false;

        for (int i = 0; i < length; i++) {
            if (!visited[i]) {
                String str = "" + i;
                String circle = findCircle(circlesArray, i, visited, str);
                visited[i] = true;
                if (circle.trim().equals("" + i)) {
                    visited[i] = false;
                } else {
                    socialCircles.append(circle);
                }
            }
        }
        for (int i = 0; i < length; i++) {
            if (!visited[i])
                socialCircles.append("|" + i);
        }
        System.out.println(socialCircles.toString());
    }

    private static String findCircle(int[][] circlesArray, int i, boolean[] visited, String str) {
        String temp = "";
        if (i > length - 1)
            return "";
        for (int j = i + 1; j < length && !visited[j]; j++) {
            if (circlesArray[i][j] == 1) {
                visited[j] = true;
                String circle = findCircle(circlesArray, j, visited, temp);
                str += circle + "," + j;
            }
        }
        return str;
    }
}
