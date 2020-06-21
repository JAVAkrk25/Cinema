package persistence;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class FilmShowEntity {

    @Id
    private String filmShowId;

    private LocalDateTime startTimeAndDate;

    @ManyToOne
    private MovieEntity movie;

    @ManyToOne
    private FilmShowroomEntity filmShowroomEntity;
}
