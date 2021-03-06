package httpserver.route;

import httpserver.RequestMethod;

import java.util.ArrayList;
import java.util.HashMap;

public class Routes {
    private final HashMap<String, ArrayList<Route>> pathsAndRoutes = new HashMap<>();

    public Routes addRoute(Route route) {
        if(isValidPath(route.getPath())) {
            addToExistingPath(route);
        } else {
            createNewPath(route);
        }
        return this;
    }

    public boolean isValidPath(String path) {
        return pathsAndRoutes.containsKey(path);
    }

    private void addToExistingPath(Route route) {
        var path = route.getPath();
        var requestMethod = route.getRequestMethod();

        if(!doesRouteExist(path, requestMethod)) {
            getRoutes(path).add(route);
        }
    }

    private void createNewPath(Route route) {
        var path = route.getPath();
        var routeList = new ArrayList<Route>();

        routeList.add(route);
        pathsAndRoutes.put(path, routeList);
    }

    public HashMap<String, ArrayList<Route>> getPathsAndRoutes() {
        return pathsAndRoutes;
    }

    public ArrayList<Route> getRoutes(String path) {
        return pathsAndRoutes.get(path);
    }

    public Route getASingleRoute(String path, RequestMethod requestMethod) {
        var routes = getRoutes(path);

        for(Route route: routes) {
           if(route.getRequestMethod() == requestMethod) {
               return route;
           }
        }
        return null;
    }

    public boolean doesRouteExist(String path, RequestMethod requestMethod) {
        var routes = getRoutes(path);

        for(Route route: routes) {
            if(route.getRequestMethod() == requestMethod) {
                return true;
            }
        }
        return false;
    }

    public String getValidMethods(String path) {
        var validMethods = new ArrayList<String>();

        if(isValidPath(path)) {
            var routes = getRoutes(path);

            for(Route route: routes) {
                validMethods.add(route.getRequestMethod().toString());
            }
            return String.join(", ", validMethods);
        }
        return "";
    }
}
