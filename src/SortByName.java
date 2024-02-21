import java.util.Comparator;

public class SortByName implements Comparator<Main.City> {
    @Override
    public int compare(Main.City o1, Main.City o2) {
        return o1.getName().compareToIgnoreCase(o2.getName());
    }
}
