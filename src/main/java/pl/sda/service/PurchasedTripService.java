package pl.sda.service;


import pl.sda.model.PurchasedTrip;

import java.util.List;

public interface PurchasedTripService {
    PurchasedTrip addPurchasedTrip(PurchasedTrip purchasedTrip);
    PurchasedTrip getPurchasedTripById(Integer id);
    //PurchasedTrip findPurchasedTripByName(String name);
    List<PurchasedTrip> getAllPurchasedTrips();
    boolean deletePurchasedTrip(Integer id);
}
