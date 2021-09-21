import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Vector;

public class ConvertMoves {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public ConvertMoves() {

    }

    public static Vector<Integer> convertInInteger(String buffer) {
        Vector<Integer> move = new Vector<>();

        if (buffer.length() == 4) {
            move.add((buffer.charAt(0) - 'a' + 1));
            move.add(Character.getNumericValue(buffer.charAt(1)));
            move.add((buffer.charAt(2) - 'a' + 1));
            move.add(Character.getNumericValue(buffer.charAt(3)));

        } else if (buffer.length() == 5) {
            move.add((buffer.charAt(0) - 'a' + 1));
            move.add(Character.getNumericValue(buffer.charAt(1)));
            move.add((buffer.charAt(2) - 'a' + 1));
            move.add(Character.getNumericValue(buffer.charAt(3)));
            move.add((buffer.charAt(4) - 'a' + 1));
        }

        return move;
    }

    public static String convertInString(Pair<Integer, Integer> pair) {
        String result = "";
        result += (char)('a' + pair.getY() - 1);
        result += ((Integer)(9 - pair.getX())).toString();

        return result;
    }
}