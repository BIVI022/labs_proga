import java.util.ArrayList;
import java.util.Locale;

public class Main {

    interface IConsonantOrNull {
        public char getResult();
    }

    public static boolean isVowel(char symbol){
        String vowels = "aeiou";
        return vowels.contains(Character.toString(symbol).toLowerCase());
    }
    public static boolean isConsonant(char symbol){
        String vowels = "bcdfghjklmnpqrstvwxyz";
        return vowels.contains(Character.toString(symbol).toLowerCase());
    }

    public static IConsonantOrNull getFirstConsonant(String str) {
        for (int i = 0; i < str.length(); i++) {
            char symbol = str.charAt(i);
            if(isConsonant(symbol)) {
//                return symbol;
                return new IConsonantOrNull() {
                    public char result = symbol;
                    public char getResult() {
                        return this.result;
                    }
                };
            }
        }

//        return null;

        return new IConsonantOrNull() {
            public Object result = null;
            public char getResult() {
                return '0';
            }
        };
    }

    public static void main(String[] args) {

        String text = "Oxygen aa dadidas hello object";

        String[] wordsArr = text.split(" ");
        ArrayList<Word> wordsWithVowelFirst = new ArrayList();

        for (int i = 0; i < wordsArr.length; i++) {
            if(isVowel(wordsArr[i].charAt(0))) {
                if(Character.isLetter(getFirstConsonant(wordsArr[i]).getResult())) {
                    wordsWithVowelFirst.add(new Word(wordsArr[i], i));
                }
            }
        }

        boolean isSorted = false;
        Word temp;

        while(!isSorted) {
            isSorted = true;
            for (int i = 0; i < wordsWithVowelFirst.size()-1; i++) {
                IConsonantOrNull consonantSymbol = getFirstConsonant(wordsWithVowelFirst.get(i).word);
                IConsonantOrNull consonantSymbol2 = getFirstConsonant(wordsWithVowelFirst.get(i+1).word);
                if(Character.isLetter(consonantSymbol.getResult()) && Character.isLetter(consonantSymbol2.getResult())) {
                    if(consonantSymbol.getResult() > consonantSymbol2.getResult()) {
                        isSorted = false;

                        temp = wordsWithVowelFirst.get(i);
                        wordsWithVowelFirst.set(i, wordsWithVowelFirst.get(i+1));
                        wordsWithVowelFirst.set(i+1, temp);
                    }
                }
            }
        }

        for (int i = 0; i < wordsWithVowelFirst.size(); i++) {
            Word word = wordsWithVowelFirst.get(i);
            for (int a = i+1; a < wordsWithVowelFirst.size(); a++) {
                Word word2 = wordsWithVowelFirst.get(a);
                if(word2.index == i) {
                    wordsArr[word2.index] = word.word;
                    wordsArr[word.index] = word2.word;
                }
            }
        }

//        for (Word word : wordsWithVowelFirst) {
//            System.out.println(word.word + "; " + word.index + "..... " + getFirstConsonant(word.word).getResult() + " ; " + Character.isLetter(getFirstConsonant(word.word).getResult()));
//        }

        System.out.println("Origin: " + text);
        System.out.println("Process: " + String.join(" ", wordsArr));


    }

}
