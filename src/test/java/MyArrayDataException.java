public class MyArrayDataException extends Exception {
    private final int row;
    private final int col;
    private final String value;

    public MyArrayDataException(int row, int col, String value) {
        super(String.format("Неверные данные в ячейке [%d][%d]: '%s'", row, col, value));
        this.row = row;
        this.col = col;
        this.value = value;
    }
}