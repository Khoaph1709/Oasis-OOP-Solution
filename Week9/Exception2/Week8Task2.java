
import java.io.FileNotFoundException;
import java.io.IOException;

public class Week8Task2 {
    public void arithmeticEx() throws ArithmeticException {
        throw new ArithmeticException();
    }

    /**
     *.
     */
    public String arithmeticExTest() {
        try {
            arithmeticEx();
        } catch (ArithmeticException e) {
            return "Lỗi Arithmetic";
        }
        return "Khong co loi";
    }

    /**
     *.
     */
    public void nullPointerEx() throws NullPointerException {
        throw new NullPointerException();
    }

    /**
     *.
     */
    public String nullPointerExTest() {
        try {
            nullPointerEx();
        } catch (NullPointerException e) {
            return "Lỗi Null Pointer";
        }
        return "Khong co loi";
    }

    /**
     *.
     */
    public void arrayIndexOutOfBoundsEx() throws ArrayIndexOutOfBoundsException {
        throw new ArrayIndexOutOfBoundsException();
    }

    /**
     *.
     */
    public String arrayIndexOutOfBoundsExTest() {
        try {
            arrayIndexOutOfBoundsEx();
        } catch (ArrayIndexOutOfBoundsException e) {
            return "Lỗi Array Index Out of Bounds";
        }
        return "Khong co loi";
    }

    /**
     *.
     */
    public void fileNotFoundEx() throws FileNotFoundException {
        throw new FileNotFoundException();
    }

    /**
     *.
     */
    public String fileNotFoundExTest() {
        try {
            fileNotFoundEx();
        } catch (FileNotFoundException e) {
            return "Lỗi File Not Found";
        }
        return "Khong co loi";
    }

    public void ioEx() throws IOException {
        throw new IOException();
    }

    /**
     * .
     */
    public String ioExTest() {
        try {
            ioEx();
        } catch (IOException e) {
            return "Lỗi IO";
        }
        return "Khong co loi";
    }
}