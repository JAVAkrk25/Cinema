package persistence;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class FilmShowroomEntity {

    @OneToMany(mappedBy = "filmShowroomEntity")
    private List<FilmShowEntity> filmShowEntities;

    @OneToMany(mappedBy = "filmShowroomEntity")
    private List<SeatEntity> seats;


}
