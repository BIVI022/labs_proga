import java.util.Arrays;
import java.util.Date;

public class Mobile {

    public Storage[] storage;

    public Mobile(){
        storage = new Storage[0];
    }

    public class Storage {

        public String model;

        public Storage(String model){
            this.model = model;
        }

    }

    public void addStorage(String model) {
        this.storage = Arrays.copyOf(this.storage, this.storage.length + 1);

        this.storage[this.storage.length - 1] = new Storage(model);
    }

}
