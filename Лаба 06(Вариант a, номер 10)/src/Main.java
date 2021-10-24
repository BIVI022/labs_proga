

public class Main {

    public static void main(String[] strings) {
        Mobile mobile = new Mobile();

        mobile.addStorage("Nokia 3310");
        mobile.addStorage("Iphone 13");

        for (int i = 0; i < mobile.storage.length; i++) {
            System.out.println(mobile.storage[i].model);
        }

    }

}
