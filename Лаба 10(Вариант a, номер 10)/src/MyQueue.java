import java.util.ArrayList;

public class MyQueue<T> {

    private ArrayList<T> queue;

   public T add(T element) {
        queue.add(element);
        return element;
   }

   public T remove(T element) {
        queue.remove(0);
        return element;
   }

}
