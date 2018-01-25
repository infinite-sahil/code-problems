/*****************************************
 * Created by Sahil Verma on 1/25/2018.
 *****************************************
 * Problem statement:
 * --------------------
 * we have to create a friend circle of person.
 * suppose we have 3 friends 1,2,3 and they are connected using a array like this
 * ---------------------
 *  1 person: {1, 1, 0},
 *  2 person: {1, 1, 0},
 *  3 person: {0, 0, 1}
 * --------------------
 * each person is a friend of himself. so diagonal of this array will be always 1.
 * 1 : means they are friend
 * 0 : they are not friend
 * 
 * like we have friend [0][1] = 1, i.e person 1 and person 2 are friends. 
 * but person 3 is friend of itself only as it is not a friend of person1 and person2.
 * 
 * Note: we have to take care of transitive dependency:
 * means: if A is Friend of B and B is friend of C then A, B and C are friends.
 * it makes one friend circle.
 * 
 * Output of the above problem: 1,2|3 
 * Explanation: if n people are friends, then they are separted by ,(comma) and people who are friend \
 * of himself only will come in the output as | (pipe) separated, like 3 in our case.
 *
 * -------------------- 
 * One more example:
 * --------------------
 * person1: {1, 0, 0, 0},
 * person2: {0, 1, 0, 0},
 * person3: {0, 0, 1, 1},
 * person4: {0, 0, 1, 1}
 *
 * ---------------------------------
 * Output of this will be : 3,4|1|2 
 * ---------------------------------  
 *
 * -------------------- 
 * One more example:
 * --------------------
 * person1: {1, 1, 1, 0},
 * person2: {1, 1, 1, 0},
 * person3: {1, 1, 1, 0},
 * person4: {0, 0, 0, 1}
 *
 * ---------------------------------
 * Output of this will be : 1,2,3|4 
 * ---------------------------------
 * 
 * try yourself, use recursion and take time. 
 * try to finish it in 1 to 2 hours of time. 
 *
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
