package persistence;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class FilmShowroomEntity {

    @OneToMany(mappedBy = "filmShowroomEntity")
    private List<FilmShowEntity> filmShowEntities;

    @OneToMany(mappedBy = "filmShowroomEntity")
    private List<SeatEntity> seats;

}
