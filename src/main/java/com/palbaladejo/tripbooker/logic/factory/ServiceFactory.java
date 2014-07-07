package com.palbaladejo.tripbooker.logic.factory;

import com.palbaladejo.tripbooker.logic.aircraft.IAircraftService;
import com.palbaladejo.tripbooker.logic.airline.IAirlineService;
import com.palbaladejo.tripbooker.logic.airport.IAirportService;
import com.palbaladejo.tripbooker.logic.booking.IBookingService;
import com.palbaladejo.tripbooker.logic.city.ICityService;
import com.palbaladejo.tripbooker.logic.country.ICountryService;
import com.palbaladejo.tripbooker.logic.flight.IFlightService;
import com.palbaladejo.tripbooker.logic.route.IRouteService;
import com.palbaladejo.tripbooker.logic.ticket.ITicketService;
import com.palbaladejo.tripbooker.logic.user.IUserService;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public abstract class ServiceFactory {
    private static ServiceFactory instance;
    
    public static synchronized ServiceFactory getInstance(){
        if(instance == null) instance = new ServiceFactoryImp();
        return instance;
    }
    
    public abstract IAircraftService getAircraftService();
    public abstract IAirlineService getAirlineService();
    public abstract IAirportService getAirportService();
    public abstract IFlightService getFlightService();
    public abstract ICountryService getCountryService();
    public abstract ICityService getCityService();
    public abstract IRouteService getRouteService();
    public abstract IBookingService getBookingService();
    public abstract IUserService getUserService();
    public abstract ITicketService getTicketService();
}
