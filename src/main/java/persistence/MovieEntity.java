package persistence;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "Movie")
public class MovieEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer movieId;
    private String title;
    private String director;
    private String description;

    @OneToMany(mappedBy = "movie")
    private Set<SeansEntity> filmShowEntities;

    public MovieEntity(Integer movieId, String title, String director, String description) {
        this.movieId = movieId;
        this.title = title;
        this.director = director;
        this.description = description;
    }
}
