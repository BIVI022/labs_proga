public class File extends  Directory {

    private int _size;

    public File(int size) {
        this._size = size;
    }

    public int getSize() {
        return this._size;
    }
}
