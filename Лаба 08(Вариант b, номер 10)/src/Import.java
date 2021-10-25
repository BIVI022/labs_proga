import java.io.*;

public class Import {

    public Import(String path)  {
        try(FileReader reader = new FileReader(path)) {
            File file = new File(path);
            long length = file.length();
            char[] a = new char[(int) length];
            reader.read(a);
            reader.close();
            for(char c : a) {
                System.out.print(c);
            }
        } catch(IOException ex){
            System.out.println(ex.getMessage());
        }

    }
}
