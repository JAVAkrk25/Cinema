package persistence;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
@Setter

public class MovieEntity {

    @Id
        private String movieId;
        private String title;
        private String director;
        private String duration;

    @OneToOne(mappedBy = "movie")
    private Set<MovieEntity> movies = new HashSet<>();

    public MovieEntity(String movieId, String title, String director, String duration) {
        this.movieId = movieId;
        this.title = title;
        this.director = director;
        this.duration = duration;
    }
}
