package persistence.movie;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import persistence.seans.SeansEntity;

import javax.persistence.*;
import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
@Setter

public class MovieEntity {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int movieId;
    private String title;
    private String director;
    private String duration;

    @OneToMany(mappedBy = "movie")
    private Set<SeansEntity> filmShowEntities;

    public MovieEntity(int movieId, String title, String director, String duration) {
        this.movieId = movieId;
        this.title = title;
        this.director = director;
        this.duration = duration;
    }
}
