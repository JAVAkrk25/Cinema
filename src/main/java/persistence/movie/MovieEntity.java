package persistence.movie;

import lombok.Builder;
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
@Builder

@NamedQueries({
        @NamedQuery(name = "MovieEntity.findByTitle",
                query = "SELECT m FROM MovieEntity m WHERE m.title = :title"),
        @NamedQuery(name = "MovieEntity.getAllMovies",
                query = "SELECT * FROM MovieEntity")
})

@Table(name = "Movie")
public class MovieEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer movieId;
    private String title;
    private String director;
    @Column(length = 2048)
    private String description;

    @OneToMany(mappedBy = "movie")
    private Set<SeansEntity> seansEntities;
}
