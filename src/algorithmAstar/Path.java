package algorithmAstar;

import java.util.ArrayList;
import java.util.List;

public class Path {

    private List<City> citiesVisited = new ArrayList<>();
    private List<City> citiesToVisit = new ArrayList<>();
    private double distance = 0;
    private double distanceEstimated = 0;

    public Path(List<City> listOfCities) {
        getCitiesToVisit().addAll(listOfCities);
    }

    public void visitNextTheCity() {
        City cityFrom = getCitiesVisited().get(getCitiesVisited().size() - 1);
        City cityTo = getCitiesToVisit().get(0);
        addDistance(getDist(cityFrom, cityTo));
        getCitiesToVisit().remove(cityTo);
        getCitiesVisited().add(cityTo);
        estimateDistance();
    }

    private void estimateDistance() {
        double lowestDistance = Double.MAX_VALUE;
        for (City city : citiesToVisit) {
            double tmp = getDist(citiesVisited.get(citiesVisited.size() - 1), citiesToVisit.get(0));
            if (tmp < lowestDistance) {
                lowestDistance = tmp;
            }
        }
        distanceEstimated = lowestDistance * citiesToVisit.size();
    }

    public int getSizeCitiesToVisit() {
        return citiesToVisit.size();
    }

    public double getDistance() {
        return distance;
    }

    public double getDistanceEstimated() {
        return distanceEstimated;
    }

    public void addDistance(double distance) {
        this.distance += distance;
    }

    public static double getDist(City firstCity, City secondCity) {
        return Math.sqrt(Math.pow((firstCity.getPosX() - secondCity.getPosX()), 2)
                         + Math.pow((firstCity.getPosY() - secondCity.getPosY()), 2));
    }

    public List<City> getCitiesToVisit() {
        return citiesToVisit;
    }

    public List<City> getCitiesVisited() {
        return citiesVisited;
    }

    public void addStartCity(City startPoint) {
        citiesVisited.add(startPoint);
        citiesToVisit.add(startPoint);
    }
}
