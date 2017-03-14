/**
 * Created by DrDan on 3/12/2017.
 *
 * NOTES:
 * In order to get mongodb running:
 * net start MongoDB (localhost:27017)
 *
 * In order to look at trizic doc
 * npm run dev (localhost:8001)
 *
 * In order to run this app
 * run Api.java (localhost:4567)
 *
 */

import static spark.Spark.*;

import com.google.gson.Gson;
import com.mongodb.*;
import com.mongodb.client.MongoDatabase;
import org.eclipse.jetty.http.HttpStatus;
import spark.Response;

import java.util.List;


public class Api {

    static ApiActions api = new ApiActions();

    public static void main(String[] args) {

        Gson gson = new Gson();

        //PUT advisor model
        put("v1/advisor/:advisorId/model", (req,res)->{
            res.type("application/json");
            AdvisorModel am = gson.fromJson(req.body(), AdvisorModel.class);
            am.setAdvisor(req.params(":advisorId"));
            am.generateId();
            String responseMsg = api.addAdvisorModel(am, req.params(":advisorId"));
            if ( responseMsg == "Advisor not found.")
                res.status(404);
            else if ( responseMsg == "Advisor model successfully added.")
                res.status(400);
            else if ( responseMsg == "Advisor model asset allocation errors.")
                res.status(200);
            return responseMsg;
        }, gson::toJson);

        //PUT advisor
        put("v1/advisor/:advisorId", (req,res)->{
            res.type("application/json");
            return api.addAdvisor(req.params(":advisorId"));
        }, gson::toJson);

        //GET
        get("v1/advisor/:advisorId/model", (req, res)->{
            res.type("application/json");
            int pageNumber = req.queryParams("pageNumber") != null ? Integer.parseInt(req.queryParams("pageNumber")) : 0;
            int pageSize = req.queryParams("pageSize") != null ? Integer.parseInt(req.queryParams("pageSize")) : 10;
            List<AdvisorModel> models = api.getAdvisorModels(req.params(":advisorId"), pageNumber, pageSize);
            if (models == null)
                res.status(404);
            return models;
        }, gson::toJson);

        //GET all
        get("/", (req, res)->{
            res.type("application/json");
            return api.getAllAdvisorModels();
        }, gson::toJson);

    }

}
