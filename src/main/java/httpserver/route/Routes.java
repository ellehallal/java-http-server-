package httpserver.route;

import java.util.ArrayList;
import java.util.HashMap;

public class Routes {
    private final HashMap<String, ArrayList<Route>> routes = new HashMap<>();

    public void addRoute(Route route) {
        if(doesRouteExist(route)) {
            addToExistingPath(route);
        } else {
            createNewPath(route);
        }
    }

    private boolean doesRouteExist(Route route) {
        var path = route.getPath();
        return routes.containsKey(path);
    }

    private void addToExistingPath(Route route) {
        var path = route.getPath();
        routes.get(path).add(route);
    }

    private void createNewPath(Route route) {
        var path = route.getPath();
        var routeList = new ArrayList<Route>();

        routeList.add(route);
        routes.put(path, routeList);
    }

    public HashMap<String, ArrayList<Route>> getRoutes() {
        return routes;
    }
}
