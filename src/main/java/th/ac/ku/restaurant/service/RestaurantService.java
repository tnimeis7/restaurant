package th.ac.ku.restaurant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import th.ac.ku.restaurant.model.Restaurant;
import th.ac.ku.restaurant.repository.RestaurantRepository;

import java.util.List;
import java.util.UUID;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepository repository;

    public List<Restaurant> getAll(){
        return repository.findAll();
    }

    public Restaurant create(Restaurant restaurant){
        repository.save(restaurant);
        return restaurant;
    }

    public Restaurant getRestaurant(UUID id){
        return repository.findById(id).get();
    }

    public Restaurant update(UUID id, Restaurant requestBody){
        Restaurant record = repository.findById(id).get();
        if (requestBody.getName()!=null) {
            record.setName(requestBody.getName());
        }
        if (requestBody.getAddress()!=null) {
            record.setAddress(requestBody.getAddress());
        }
        if (requestBody.getPhone()!=null) {
            record.setPhone(requestBody.getPhone());
        }
        if (requestBody.getNumSeats()>0) {
            record.setNumSeats(requestBody.getNumSeats());
        }
        repository.save(record);
        return record; //return เพราะอยากดูเฉลยๆว่าอัพเดตอะไรไป
    }

    public Restaurant delete(UUID id) {
        Restaurant record = repository.findById(id).get();
        repository.deleteById(id);
        return record;
    }


}
