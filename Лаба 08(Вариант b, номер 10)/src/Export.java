import java.io.*;

public class Export {

    public Export(String path, Object object)  {
        try(FileOutputStream outputStream  = new FileOutputStream(path)) {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(object);
        } catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        try(FileWriter writer = new FileWriter(path, false)) {
            writer.write(object.toString());
            writer.flush();
        } catch(IOException ex){
            System.out.println(ex.getMessage());
        }

    }
}
