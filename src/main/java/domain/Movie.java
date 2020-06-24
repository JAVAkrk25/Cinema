package domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Movie {
    private Integer movieId;
    private String title;
    private String director;
    private String duration;

}
