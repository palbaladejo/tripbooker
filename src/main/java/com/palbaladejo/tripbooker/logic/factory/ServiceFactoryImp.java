package com.palbaladejo.tripbooker.logic.factory;

import com.palbaladejo.tripbooker.logic.aircraft.AircraftServiceImp;
import com.palbaladejo.tripbooker.logic.aircraft.IAircraftService;
import com.palbaladejo.tripbooker.logic.airline.AirlineServiceImp;
import com.palbaladejo.tripbooker.logic.airline.IAirlineService;
import com.palbaladejo.tripbooker.logic.airport.AirportServiceImp;
import com.palbaladejo.tripbooker.logic.airport.IAirportService;
import com.palbaladejo.tripbooker.logic.booking.BookingServiceImp;
import com.palbaladejo.tripbooker.logic.booking.IBookingService;
import com.palbaladejo.tripbooker.logic.city.CityServiceImp;
import com.palbaladejo.tripbooker.logic.city.ICityService;
import com.palbaladejo.tripbooker.logic.country.CountryServiceImp;
import com.palbaladejo.tripbooker.logic.country.ICountryService;
import com.palbaladejo.tripbooker.logic.flight.FlightServiceImp;
import com.palbaladejo.tripbooker.logic.flight.IFlightService;
import com.palbaladejo.tripbooker.logic.route.IRouteService;
import com.palbaladejo.tripbooker.logic.route.RouteServiceImp;
import com.palbaladejo.tripbooker.logic.ticket.ITicketService;
import com.palbaladejo.tripbooker.logic.ticket.TicketServiceImp;
import com.palbaladejo.tripbooker.logic.user.IUserService;
import com.palbaladejo.tripbooker.logic.user.UserServiceImp;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public class ServiceFactoryImp extends ServiceFactory{

    //Aircraft
    @Override
    public IAircraftService getAircraftService() {
        return new AircraftServiceImp();
    }
    
    //Airline
    @Override
    public IAirlineService getAirlineService() {
        return new AirlineServiceImp();
    }
    
    @Override
    public IAirportService getAirportService() {
        return new AirportServiceImp();
    }
    
    @Override
    public IFlightService getFlightService() {
        return new FlightServiceImp();
    }

    @Override
    public ICityService getCityService() {
        return new CityServiceImp();
    }
    
    @Override
    public ICountryService getCountryService() {
        return new CountryServiceImp();
    }
       
    //Route
    @Override
    public IRouteService getRouteService() {
        return new RouteServiceImp();
    }
    
    //Booking
    @Override
    public IBookingService getBookingService() {
        return new BookingServiceImp();
    }

    @Override
    public IUserService getUserService() {
        return new UserServiceImp();
    }

    @Override
    public ITicketService getTicketService() {
        return new TicketServiceImp();
    }
    
}
