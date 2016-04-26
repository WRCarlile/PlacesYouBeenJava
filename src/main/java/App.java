import java.util.*;
import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;
import java.util.ArrayList;

public class App {
  public static void main(String[] args) {


    staticFileLocation("/public");

      get("/", (request, response) -> {
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("places", request.session().attribute("places"));
        model.put("template", "templates/index.vtl");
        return new ModelAndView(model, "templates/layout.vtl");
      }, new VelocityTemplateEngine());

      post("/places", (request, response) -> {
        Map<String, Object> model = new HashMap<String, Object>();

        ArrayList<Places> places = request.session().attribute("places");
        if (places == null) {
          places = new ArrayList<Places>();
          request.session().attribute("places", places);
        }

        String description = request.queryParams("description");
        Places newPlace = new Places(description);
        places.add(newPlace);
        // request.session().attribute("places",newPlace);

        model.put("template", "templates/success.vtl");
        return new ModelAndView(model, "templates/layout.vtl");
      }, new VelocityTemplateEngine());
  }



}
