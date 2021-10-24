package spaceX;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Comparator;
import java.util.List;

public class App {
    private static final String POSTS_API_URL = "https://api.spacexdata.com/v4/capsules";

    public static void main(String[] args) throws IOException, InterruptedException {
        //receiving data using the Http client
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().GET().uri(URI.create(POSTS_API_URL)).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());


        //Parse JSON into objects
        ObjectMapper mapper = new ObjectMapper();
        List<Capsule> posts = mapper.readValue(response.body(), new TypeReference<List<Capsule>>() {
        });


        //calculation of statistics
        System.out.println("1) How many capsules have been reused?");
        System.out.println(posts.stream().filter(x -> x.getReuse_count() != 0).count());


        System.out.println("2) Which capsules have been reused?");
        posts.stream().filter(x -> x.getReuse_count() != 0)
                .sorted(Comparator.comparingInt(Capsule::getReuse_count).reversed())
                .forEach(System.out::println);

        System.out.println("3) Percentage of reused capsules");
        System.out.println("Percentage is " +
                Math.round((double) posts.stream().filter(x -> x.getReuse_count() != 0).count()
                        / (double) posts.stream().count() * 100)
                + "%"
        );

        System.out.println("4) which reused capsules of type Dragon 2.0 are still active?");
        posts.stream().filter(x -> x.getReuse_count() != 0
                        && x.getStatus().equals("active") && x.getType().equals("Dragon 2.0"))
                .sorted(Comparator.comparingInt(Capsule::getReuse_count).reversed())
                .forEach(System.out::println);


        System.out.println("5) What percentage of capsules land in water?");
        System.out.println("Percentage is " +
                Math.round((double) posts.stream().filter(x -> !x.getWater_landings().equals(0)).count()
                        / (double) posts.stream().count() * 100)
                + "%"
        );
    }
}
