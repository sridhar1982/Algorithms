package stringManipulations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * calculate combinations for phone numbers
 */
public class PhoneNumbers {

    private static Map<Integer, Character[]> map = constructMap();

    public static void main(String[] args) {

        List<String> result = new ArrayList<>();

        phoneNumbers("227", 0, "", result);
        System.out.println(result.size());
        System.out.println(result);



    }

    public static void phoneNumbers(String input, int index, String result, List<String> finalList) {

        if (index==input.length()) {
            finalList.add(result);
            return;
        }

        Integer var = Integer.parseInt(input.substring(index, index+1));
        for (Character c : map.get(var)) {
            phoneNumbers(input, index+1, result+c, finalList);
        }
    }


    public static Map<Integer, Character[]> constructMap() {

        Map<Integer, Character[]> map = new HashMap<>();
        map.put(2, new Character[] {'A', 'B', 'C'});
        map.put(3, new Character[] {'D', 'E', 'F'});
        map.put(4, new Character[] {'G', 'H', 'I'});
        map.put(5, new Character[] {'J', 'K', 'L'});
        map.put(6, new Character[] {'M', 'N', 'O'});
        map.put(7, new Character[] {'P', 'Q', 'R', 'S'});
        map.put(8, new Character[] {'T', 'U', 'V'});
        map.put(9, new Character[] {'W', 'X', 'Y', 'Z'});

        return map;
    }




}
