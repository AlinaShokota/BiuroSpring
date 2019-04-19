package pl.sda.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.model.PurchasedTrip;
import pl.sda.repository.PurchasedTripRepository;

import java.util.List;

@Service
public class PurchasedTripServiceImplementation implements PurchasedTripService {
    @Autowired
    PurchasedTripRepository purchasedTripRepository;

    @Override
    public PurchasedTrip addPurchasedTrip(PurchasedTrip purchasedTrip) {
        return purchasedTripRepository.save(purchasedTrip);
    }

    @Override
    public PurchasedTrip getPurchasedTripById(Integer id) {
        return purchasedTripRepository.findById(id).get();
    }

//    @Override
//    public PurchasedTrip findPurchasedTripByName(String name) {
//        return purchasedTripRepository.findByNameIgnoreCaseContaining(name);
//    }

    @Override
    public List<PurchasedTrip> getAllPurchasedTrips() {
        return purchasedTripRepository.findAll();
    }

    @Override
    public boolean deletePurchasedTrip(Integer id) {
        try {
            purchasedTripRepository.deleteById(id);
        } catch (Exception e){
            e.printStackTrace();
        }
        return true;
    }
}
