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

public class MovieEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int movieId;
    private String title;
    private String director;
    private String duration;

    @OneToMany(mappedBy = "movie")
    private Set<FilmShowEntity> filmShowEntities;


}
