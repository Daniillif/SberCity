import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        List<City> records = new ArrayList<>();
        int count = 0;
        try (Scanner scanner = new Scanner(new File("src/Задача ВС Java Сбер.csv"))) {
            while (scanner.hasNextLine()) {
                String cityStr = scanner.nextLine();
                String[] words = cityStr.split(";");
                count++;
                if (cityStr.endsWith(";")) {
                    records.add(new City(words[1], words[2], words[3], Integer.valueOf(words[4]), "нет упоминаний"));
                } else
                    records.add(new City(words[1], words[2], words[3], Integer.valueOf(words[4]), words[5]));
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage() + count);
        }
        //Collections.sort(records, new SortByName());
        Collections.sort(records, new SortByDistrict());

        for (City record : records) {
            System.out.println(record.toString());
        }

    }

    public static class City {
        String name;
        String region;
        String district;
        Integer population;
        String foundation;

        public City(String name, String region, String district, Integer population, String foundation) {
            this.name = name;
            this.region = region;
            this.district = district;
            this.population = population;
            this.foundation = foundation;
        }

        @Override
        public String toString() {
            return "City{" +
                    "name='" + name + '\'' +
                    ", region='" + region + '\'' +
                    ", district='" + district + '\'' +
                    ", population=" + population +
                    ", foundation=" + foundation +
                    '}';
        }

        public String getName() {
            return name;
        }

        public String getRegion() {
            return region;
        }

        public String getDistrict() {
            return district;
        }

        public Integer getPopulation() {
            return population;
        }

        public String getFoundation() {
            return foundation;
        }
    }

}