package domain.movie;

import domain.seans.Seans;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Movie {
    private Integer movieId;
    private String title;
    private String director;
    private String description;
    private Set<Seans> seans;
}
