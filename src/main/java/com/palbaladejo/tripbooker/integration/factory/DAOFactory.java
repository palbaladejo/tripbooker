package com.palbaladejo.tripbooker.integration.factory;

import com.palbaladejo.tripbooker.integration.aircraft.IAircraftDAO;
import com.palbaladejo.tripbooker.integration.airline.IAirlineDAO;
import com.palbaladejo.tripbooker.integration.airport.IAirportDAO;
import com.palbaladejo.tripbooker.integration.booking.IBookingDAO;
import com.palbaladejo.tripbooker.integration.city.ICityDAO;
import com.palbaladejo.tripbooker.integration.country.ICountryDAO;
import com.palbaladejo.tripbooker.integration.flight.IFlightDAO;
import com.palbaladejo.tripbooker.integration.route.IRouteDAO;
import com.palbaladejo.tripbooker.integration.ticket.ITicketDAO;
import com.palbaladejo.tripbooker.integration.user.IUserDAO;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public abstract class DAOFactory {
    private static DAOFactory instance;
    
    public static synchronized DAOFactory getInstance(){
        if(instance == null) instance = new DAOFactoryImp();
        return instance;
    }
    
    public abstract IAirlineDAO getAirlineDAO();
    public abstract IAircraftDAO getAircraftDAO();
    public abstract IAirportDAO getAirportDAO();
    public abstract IRouteDAO getRouteDAO();
    public abstract ICityDAO getCityDAO();
    public abstract ICountryDAO getCountryDAO();
    public abstract IFlightDAO getFlightDAO();
    public abstract IBookingDAO getBookingDAO();
    public abstract IUserDAO getUserDAO();
    public abstract ITicketDAO getTicketDAO();
}

