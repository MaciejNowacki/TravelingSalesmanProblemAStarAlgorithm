package algorithmAstar;

import java.util.Collections;
import java.util.List;

public class Permutation extends Main {

    public static void permute(List<City> listOfCities, int l, int r) {
        if (l == r) {
            listOfPaths.add(new Path(listOfCities));
        } else {
            for (int i = l; i <= r; i++) {
                Collections.swap(listOfCities, l, i);
                permute(listOfCities, l + 1, r);
                Collections.swap(listOfCities, l, i);
            }
        }
    }

    public Permutation() {
        permute(listOfCities, 0, listOfCities.size() - 1);
    }
}
