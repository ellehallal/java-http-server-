package httpserver.route;

import java.util.ArrayList;

public class Router {
    private final ArrayList<Route> routes = new ArrayList<>();

    public Router add(Route route) {
        routes.add(route);
        return this;
    }

    public ArrayList<Route> getAllRoutes() {
        return routes;
    }
}
