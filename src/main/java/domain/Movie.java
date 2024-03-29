package domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Movie {
    private Integer movieId;
    private String title;
    private String director;
    private String description;

    public Movie(String title, String director, String description) {
        this.title = title;
        this.director = director;
        this.description = description;
    }
}
