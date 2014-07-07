package com.palbaladejo.tripbooker.integration.factory;

import com.palbaladejo.tripbooker.integration.aircraft.AircraftDAOImp;
import com.palbaladejo.tripbooker.integration.aircraft.IAircraftDAO;
import com.palbaladejo.tripbooker.integration.airline.AirlineDAOImp;
import com.palbaladejo.tripbooker.integration.airline.IAirlineDAO;
import com.palbaladejo.tripbooker.integration.airport.AirportDAOImp;
import com.palbaladejo.tripbooker.integration.airport.IAirportDAO;
import com.palbaladejo.tripbooker.integration.booking.BookingDAOImp;
import com.palbaladejo.tripbooker.integration.booking.IBookingDAO;
import com.palbaladejo.tripbooker.integration.city.CityDAOImp;
import com.palbaladejo.tripbooker.integration.city.ICityDAO;
import com.palbaladejo.tripbooker.integration.country.CountryDAOImp;
import com.palbaladejo.tripbooker.integration.country.ICountryDAO;
import com.palbaladejo.tripbooker.integration.flight.FlightDAOImp;
import com.palbaladejo.tripbooker.integration.flight.IFlightDAO;
import com.palbaladejo.tripbooker.integration.route.IRouteDAO;
import com.palbaladejo.tripbooker.integration.route.RouteDAOImp;
import com.palbaladejo.tripbooker.integration.ticket.ITicketDAO;
import com.palbaladejo.tripbooker.integration.ticket.TicketDAOImp;
import com.palbaladejo.tripbooker.integration.user.IUserDAO;
import com.palbaladejo.tripbooker.integration.user.UserDAOImp;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public class DAOFactoryImp extends DAOFactory{

    @Override
    public IAirlineDAO getAirlineDAO() {
        return new AirlineDAOImp();
    }

    @Override
    public IAircraftDAO getAircraftDAO() {
        return new AircraftDAOImp();
    }

    @Override
    public IAirportDAO getAirportDAO() {
        return new AirportDAOImp();
    }

    @Override
    public IRouteDAO getRouteDAO() {
        return new RouteDAOImp();
    }
    
    @Override
    public ICityDAO getCityDAO() {
        return new CityDAOImp();
    }

    @Override
    public ICountryDAO getCountryDAO() {
        return new CountryDAOImp();
    }
    
    @Override
    public IFlightDAO getFlightDAO() {
        return new FlightDAOImp();
    }

    @Override
    public IBookingDAO getBookingDAO() {
        return new BookingDAOImp();
    }

    @Override
    public IUserDAO getUserDAO() {
        return new UserDAOImp();
    }

    @Override
    public ITicketDAO getTicketDAO() {
        return new TicketDAOImp();
    }
}
