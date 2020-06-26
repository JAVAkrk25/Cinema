package view.consol;

import logic.ClientService;
import logic.ClientServiceImpl;
import persistence.ClientDAO;
import view.consol.graphicsPack.CinemaHallSeats;
import view.consol.logicPack.ClientService.AddClientMenuEntry;
import view.consol.logicPack.MenuFactory;

public class RunnerTestMenu {
    public static void main(String[] args) {

        System.out.print("\n\n\n");
        MenuFactory.getFullLine();
        MenuFactory.getEmptyLine();
        MenuFactory.getCentreLine("CINEMA");
        MenuFactory.getCentreLine("MOVING  IMAGES");
        MenuFactory.getEmptyLine();
        MenuFactory.getFullLine();
        MenuFactory.getEmptyLine();
        MenuFactory.getTitleLine("Menu:");
        MenuFactory.getPointLine("1.", "Nowa rezerwacja.", "", "");
        MenuFactory.getPointLine("2.", "Film:", null, null);
        MenuFactory.getInfoLine("Krzyżacy", null, null, null);
        MenuFactory.getEmptyLine();
        MenuFactory.getTextMultiLine("Zbyszko z Bogdańca (Mieczysław Kalenik) jako ostatni z rodu powraca wraz ze swoim " +
                "stryjem Maćkiem (Aleksander Fogiel) ze zwycięskiej wyprawy wojennej. Podczas postoju w karczmie poznaje " +
                "piękną Danuśkę (Grażyna Staniszewska) i urzeczony historią dziewczyny ślubuje jej dostarczenie kilku czubów " +
                "krzyżackich. Pechowo jednak jako pierwszego atakuje posła krzyżackiego. Zostaje za to skazany na śmierć. " +
                "Podczas szukania ratunku dla bratanka stryj chłopaka zostaje ciężko ranny. Ostatnią nadzieją dla młodzieńca " +
                "okazuje się Danuśka, która nakrywając go nałęczką, ratuje Zbyszka przed śmiercią. Kiedy dziewczyna zostaje " +
                "porwana, rycerz robi wszystko, aby ją uratować. Pomaga mu w tym jego stryj oraz wierny giermek Hlawa " +
                "(Mieczysław Stoor).");
        MenuFactory.getEmptyLine();
        MenuFactory.getFullLine();

        MenuFactory.getEmptyLine();


        System.out.print("\n\n\n");

        CinemaHallSeats cinemaHallSeats = new CinemaHallSeats();
        System.out.println(cinemaHallSeats.toString());



    }
}
