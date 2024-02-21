import java.util.Comparator;

public class SortByDistrict implements Comparator<Main.City> {
    @Override
    public int compare(Main.City o1, Main.City o2) {
        if(o1.getDistrict().compareTo(o2.getDistrict())==0){
            return o1.getName().compareTo(o2.getName());
        } else if (o1.getDistrict().compareTo(o2.getDistrict())>0) {
            return 1;
        }else
            return -1;
    }
}
