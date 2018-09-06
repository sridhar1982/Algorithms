package stringManipulations;

/**
 * gvien a string, find first non-repeated character
 * eg: abc$abc = $
 */
public class firstNonRepeatedChar {

    public static void main(String[] args){

        System.out.println((char)firstNonRepeated("abc$abc"));
        System.out.println((char)firstNonRepeated("!bbccaa"));
        System.out.println((char)firstNonRepeated("!!bbccaa"));

    }

    public static int firstNonRepeated(String input){

        //index array
        int[] idxArr = new int[256];
        for (int i = 0; i<idxArr.length; i++) {
            idxArr[i]=-1;
        }

        char[] charArray = input.toCharArray();
        for (int i =0; i< charArray.length; i++) {
            int c  = charArray[i];
            if (idxArr[c] == -1){
                idxArr[c] = i;
            }
            else if (idxArr[c] >= 0) {
                idxArr[c] = -2;
            }
        }

        for (int i : idxArr) {
            if (i >=0) {
                return input.charAt(i);
            }
        }

        return -1;
    }


}
