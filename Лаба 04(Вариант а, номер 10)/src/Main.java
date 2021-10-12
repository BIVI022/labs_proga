public class Main {

    public static void main(String[] args) {

        double wingLength = 3.52;

        Plain plain = new Plain(
                new Wing(wingLength),
                new Wing(wingLength)
        );

    }

}
