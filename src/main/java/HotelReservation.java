
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HotelReservation {

    private ArrayList<Hotel> hotelCollection;

    public HotelReservation() {
        this.hotelCollection = new ArrayList<Hotel>();

        int[][] aux = {{90, 110}, {80, 80}};
        hotelCollection.add(new Hotel("Lakewood", 3, aux));
        int[][] aux1 = {{60, 160}, {50, 110}};
        hotelCollection.add(new Hotel("Bridgewood", 4, aux1));
        int[][] aux2 = {{150, 220}, {40, 100}};
        hotelCollection.add(new Hotel("Ridgewood", 5, aux2));

    }

    public String getCheapestHotel(String input) {
        String[] aux = input.split(":");
        int weekend = 0;
        int week = 0;
        String[] aux2 = input.split(",");

        String cheapestHotel = this.hotelCollection.get(0).getName();
        int classification = this.hotelCollection.get(0).getClassification();
        int cheapestHotelPrice;

        for (int i = 0; i < aux2.length; i++) {
            if (aux2[i].contains("mon") || (aux2[i].contains("tues") || (aux2[i].contains("wed")) || (aux2[i].contains("thur")) || (aux2[i].contains("fri")))) {
                week++;
            } else if (aux2[i].contains("sat") || (aux2[i].contains("sun"))) {
                weekend++;
            }
        }

        if (input.contains("Regular")) {
            cheapestHotelPrice = week * this.hotelCollection.get(0).getPrices()[0][1] + weekend * this.hotelCollection.get(0).getPrices()[0][0];
        } else {
            cheapestHotelPrice = week * this.hotelCollection.get(0).getPrices()[1][1] + weekend * this.hotelCollection.get(0).getPrices()[1][0];
        }

        for (int cont = 1; cont < this.hotelCollection.size(); cont++) {
            if (input.contains("Regular")) {
                if ((week * this.hotelCollection.get(cont).getPrices()[0][1] + weekend * this.hotelCollection.get(cont).getPrices()[0][0]) < cheapestHotelPrice) {
                    cheapestHotelPrice = week * this.hotelCollection.get(cont).getPrices()[0][1] + weekend * this.hotelCollection.get(cont).getPrices()[0][0];
                    cheapestHotel = this.hotelCollection.get(cont).getName();
                    classification = this.hotelCollection.get(cont).getClassification();
                } else {
                    if ((week * this.hotelCollection.get(cont).getPrices()[0][1] + weekend * this.hotelCollection.get(cont).getPrices()[0][0]) == cheapestHotelPrice) {
                        if (this.hotelCollection.get(cont).getClassification() > classification) {
                            cheapestHotelPrice = week * this.hotelCollection.get(cont).getPrices()[0][1] + weekend * this.hotelCollection.get(cont).getPrices()[0][0];
                            cheapestHotel = this.hotelCollection.get(cont).getName();
                            classification = this.hotelCollection.get(cont).getClassification();
                        }
                    }
                }
            } else {
                if ((week * this.hotelCollection.get(cont).getPrices()[1][1] + weekend * this.hotelCollection.get(cont).getPrices()[1][0]) < cheapestHotelPrice) {
                    cheapestHotelPrice = week * this.hotelCollection.get(cont).getPrices()[1][1] + weekend * this.hotelCollection.get(cont).getPrices()[1][0];
                    cheapestHotel = this.hotelCollection.get(cont).getName();
                    classification = this.hotelCollection.get(cont).getClassification();
                }   else {
                    if ((week * this.hotelCollection.get(cont).getPrices()[1][1] + weekend * this.hotelCollection.get(cont).getPrices()[1][0]) == cheapestHotelPrice) {
                        if (this.hotelCollection.get(cont).getClassification() > classification) {
                            cheapestHotelPrice = week * this.hotelCollection.get(cont).getPrices()[1][1] + weekend * this.hotelCollection.get(cont).getPrices()[1][0];
                            cheapestHotel = this.hotelCollection.get(cont).getName();
                            classification = this.hotelCollection.get(cont).getClassification();
                        }
                    }
                }
            }
        }

        return cheapestHotel;
    }
}
