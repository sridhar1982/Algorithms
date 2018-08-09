package stringManipulations;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * given a dictionary and a word, give a sentence that can be formed by the words in dictionary
 * eg: dict ={cat, cats, and, dog, dogs} word=catsanddogs, the result should be "cats and dogs"
 */
public class WordBreak {

    public static void main(String[] args){

        Set<String> dict = new HashSet<>();
        dict.addAll(Arrays.asList("cat", "cats", "and", "dogs"));
        String result = wordBreak(dict, 0, "catsanddogs");
        System.out.println(result);

    }

    //returns null when no break can be formed
    public static String wordBreak(Set<String> dict, int start, String word) {
        StringBuffer buffer = new StringBuffer();

        for (int i=start; i<word.length(); i++) {
            buffer.append(word.charAt(i));
            if (dict.contains(buffer.toString())) {
                String result = wordBreak(dict, i+1, word);
                if (result!=null) {
                    return buffer.toString() + " " + result;
                }
            }
        }
        if(dict.contains(buffer.toString())){
            return buffer.toString();
        }
        return null;

    }
}
