import java.util.ArrayList;

public class Main {

    public static String reverseString(String str) {
        char[] array = str.toCharArray();
        String result = "";
        for (int i = array.length - 1; i >= 0; i--) {
            result += array[i];
        }
        return result;
    }

    public static void main(String[] args) {

        String text = "Privet kak tevIrP dela aled";

        String[] wordsArr = text.split(" ");
        ArrayList<WordsPare> result = new ArrayList();

        for (int i = 0; i < wordsArr.length; i++) {
            String word = wordsArr[i].toLowerCase();
            for (int a = i+1; a < wordsArr.length; a++) {
                String compareWord = wordsArr[a].toLowerCase();
                String reverseWord = reverseString(compareWord);
                if(word.equals(reverseWord)) {
                    result.add(new WordsPare(wordsArr[i], wordsArr[a]));
                }
            }
        }

        for(WordsPare wordsPare : result) {
            System.out.println("Pair: " + wordsPare.word1 + ":" + wordsPare.word2);
        }

    }
}
