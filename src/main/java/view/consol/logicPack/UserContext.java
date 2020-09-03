package view.consol.logicPack;

import domain.client.Client;
import domain.movie.Movie;
import domain.seans.Seans;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserContext {

    private Movie chosenMovie;
    private Seans chosenSeans;
    private String choice;
    private Client client;


}
