package algorithmAstar;

import java.util.ArrayList;
import java.util.List;

public class Main {

    protected static City startPoint = new City(0, 0, "Pabianice");
    protected static List<Path> listOfPaths = new ArrayList<Path>();
    protected static List<City> listOfCities = new ArrayList<City>();

    public static void main(String[] args) {
        listOfCities.add(new City(20, -30, "Lodz"));
        listOfCities.add(new City(10, 15, "Belchatow"));
        listOfCities.add(new City(-15, 20, "Lask"));
        @SuppressWarnings("unused")
        Permutation permutation = new Permutation();
        addStartAndFinishCity();
        Path bestPath = aStarAlgorithm();
        printArray(bestPath.getCitiesVisited());
        System.out.println("Distance: " + bestPath.getDistance() + "\n=====================================================");
    }

    private static Path aStarAlgorithm() {
        Path pathWithLowestDistnace = null;
        while (true) {
            for (Path path : listOfPaths) {
                if (path.getSizeCitiesToVisit() == 0) {
                    return path;
                }
                if (pathWithLowestDistnace == null
                    || (path.getDistance() + path.getDistanceEstimated()) < (pathWithLowestDistnace.getDistance()
                                                                             + pathWithLowestDistnace.getDistanceEstimated())) {
                    pathWithLowestDistnace = path;
                }
            }
            pathWithLowestDistnace.visitNextTheCity();
            dumpData();
            System.out.println("=====================================================");
        }
    }

    private static void addStartAndFinishCity() {
        for (Path path : listOfPaths) {
            path.addStartCity(startPoint);
        }
    }

    public static void printArray(List<City> list) {
        for (City city : list) {
            System.out.print(city.getName() + " ");
        }
        System.out.print("\n");
    }

    public static void printPaths() {
        for (Path path : listOfPaths) {
            printArray(path.getCitiesToVisit());
        }
    }

    public static void dumpData() {
        for (Path path : listOfPaths) {
            printArray(path.getCitiesToVisit());
            printArray(path.getCitiesVisited());
            System.out.println("g(x) = "
                               + path.getDistance()
                               + " h(x) = "
                               + path.getDistanceEstimated()
                               + " SUMA: "
                               + (path.getDistance() + path.getDistanceEstimated()));
            System.out.println("----------------------------------------");
        }
    }
}
