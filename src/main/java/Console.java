import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Console {
    private PrintStream outputStream;

    public Console(PrintStream outputStream) {
        this.outputStream = outputStream;
    }

    public String readLine() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        return bufferedReader.readLine();
    }

    public void print(String value) {
        outputStream.print(value);
    }

    public void println(String value) {
        outputStream.println(value);
    }

    public Book readBook() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        this.println("Enter book title:");
        String title = bufferedReader.readLine();
        this.println("Enter author name:");
        String authorName = bufferedReader.readLine();
        this.println("Enter year of publishing:");
        int yearOfPublishing = Integer.parseInt(bufferedReader.readLine());
        return new Book(title, authorName, yearOfPublishing);
    }
}
