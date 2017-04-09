package ohtu;

import com.google.gson.Gson;
import java.io.IOException;
import org.apache.http.client.fluent.Request;

public class Main {

    public static void main(String[] args) throws IOException {
        // vaihda oma opiskelijanumerosi seuraavaan, ÄLÄ kuitenkaan laita githubiin omaa opiskelijanumeroasi
        String studentNr = "012345678";
        if ( args.length>0) {
            studentNr = args[0];
        }

        String url = "http://ohtustats2017.herokuapp.com/students/"+studentNr+"/submissions";

        String bodyText = Request.Get(url).execute().returnContent().asString();

        Gson mapper = new Gson();
        Submission[] subs = mapper.fromJson(bodyText, Submission[].class);

        url = "https://ohtustats2017.herokuapp.com/courses/1.json";
        bodyText = Request.Get(url).execute().returnContent().asString();
        Course course = mapper.fromJson(bodyText, Course.class);

        System.out.println("Kurssi: " + course.getName() + ", " + course.getTerm() + "\n");

        System.out.println("opiskelijanumero: " + studentNr + "\n");
        int tasks = 0;
        double hours = 0.0;
        for (Submission submission : subs) {
            submission.setWeekMax(course);
            System.out.println(submission);
            hours += submission.getHours();
            tasks += submission.getTasksDone();
        }
        System.out.println("\nyhteensä: " + tasks + " tehtävää " + hours + " tuntia");

    }
}

