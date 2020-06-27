package view.consol.logicPack;

import domain.Movie;
import domain.Seans;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserContext {

    private Movie chosenMovie;
    private Seans chosenSeans;
    private String choice;


}
