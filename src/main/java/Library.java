import java.util.List;

public interface Library {
    List<String> showItems();

    String checkOutItem(Item item);

    String returnItem(Item item);
}
