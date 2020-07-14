package persistence;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Builder
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
    private Set<SeansEntity> filmShowEntities;
}
