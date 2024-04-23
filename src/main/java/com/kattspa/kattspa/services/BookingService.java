package com.kattspa.kattspa.services;

import java.util.List;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.kattspa.kattspa.models.Bookings;

@Service
public class BookingService {
	private final MongoOperations mongoOperations;

	public BookingService(MongoOperations mongoOperations) {
		this.mongoOperations = mongoOperations;
	}

	public Bookings addBooking(Bookings booking) {
		return mongoOperations.insert(booking);
	}

	public List<Bookings> getBookings() {
		return mongoOperations.findAll(Bookings.class);
	}

	public Bookings getBooking(String id) {
		//måste skriva en Query
		Query query = new Query();
		query.addCriteria(Criteria.where("id").is(id));

		return mongoOperations.findOne(query, Bookings.class);
	}

	//uppdatera specifikt värde i dokumentet

	// public Spaceship editSpaceship(String id, Spaceship spaceship) {
	// 	Query query = Query.query(Criteria.where("id").is(id));
	// 	Update update = Update.update("captain",spaceship.getCaptain());
		

	// 	mongoOperations.updateFirst(query, update, Spaceship.class);
	// 	return mongoOperations.findById(id, Spaceship.class);
	// }


	//uppdatera hela dokumentet
	public Bookings editBooking(String id, Bookings booking) {
		booking.setId(id); //se till så man har rätt id med sig
		return mongoOperations.save(booking);
	}

	public void deleteBooking(String id) {
		Query query = Query.query(Criteria.where("id").is(id));
		mongoOperations.remove(query, Bookings.class);
	}
}
