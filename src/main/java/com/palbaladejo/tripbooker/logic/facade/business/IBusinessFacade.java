package com.palbaladejo.tripbooker.logic.facade.business;

import java.util.List;
import com.palbaladejo.tripbooker.dto.bean.aircraft.IAircraftBean;
import com.palbaladejo.tripbooker.dto.bean.airline.IAirlineBean;
import com.palbaladejo.tripbooker.dto.bean.airport.IAirportBean;
import com.palbaladejo.tripbooker.dto.bean.booking.IBookingBean;
import com.palbaladejo.tripbooker.dto.bean.city.ICityBean;
import com.palbaladejo.tripbooker.dto.bean.country.ICountryBean;
import com.palbaladejo.tripbooker.dto.bean.flight.IFlightBean;
import com.palbaladejo.tripbooker.dto.bean.route.IRouteBean;
import com.palbaladejo.tripbooker.dto.bean.ticket.ITicketBean;
import com.palbaladejo.tripbooker.dto.bean.user.IUserBean;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public interface IBusinessFacade {
    //Aircraft
    List<IAircraftBean> getAllAircrafts();
    boolean persistAircraft(IAircraftBean aircraftBean);
    boolean removeAircraft(IAircraftBean aircraftBean);

    //Airline
    List<IAirlineBean> getAllAirlines();
    boolean persistAirline(IAirlineBean airlineBean);
    boolean removeAirline(IAirlineBean airlineBean);
    
    //Airport
    List<IAirportBean> getAllAirports();
    List<IAirportBean> getAllAirportsByCity(String code);
    boolean persistAirport(IAirportBean airportBean);
    boolean removeAirport(IAirportBean airportBean);
    
    //City
    List<ICityBean> getAllCities();
    List<ICityBean> getAllCitiesByCountry(String code);
    ICityBean getCityByName(String name);
    boolean persistCity(ICityBean cityBean);
    boolean removeCity(ICityBean cityBean);
    
    //Country
    List<ICountryBean> getAllCountries();
    ICountryBean getCountryByName(String name);
    boolean persistCountry(ICountryBean countryBean);
    boolean removeCountry(ICountryBean countryBean);
    
    //Flight
    List<IFlightBean> getAllFlights();
    List<IFlightBean> getAllFlightsByAirline(String airlineCode);
    List<IFlightBean> getAllFlightsByDepartureAirport(String airportCode);
    List<IFlightBean> getAllFlightsByDestinationAirport(String airportCode);
    List<IFlightBean> getAllFlightsByAirports(String depatureAirportCode, String destinationAirportCode);
    boolean persistFlight(IFlightBean flightBean);
    boolean removeFlight(IFlightBean flightBean);
    
    //Route
    List<IRouteBean> getAllRoutes();
    List<IRouteBean> getAllRoutesByDeparture(String airportCode);
    List<IRouteBean> getAllRoutesByDestination(String airportCode);
    IRouteBean getRoute(String departureCode, String destinationCode);
    boolean removeRoute(IRouteBean routeBean);
    boolean persistRoute(IRouteBean routeBean);
    
    //User
    List<IUserBean> getAllUsers();
    IUserBean getUserByCode(String code);
    boolean removeUser(IUserBean userBean);
    boolean persistUser(IUserBean userBean);
    
    //Booking
    List<IBookingBean> getAllBookings();
    IBookingBean getBookingByCode(String code);
    boolean persistBooking(IBookingBean bookingBean);
    boolean removeBooking(IBookingBean bookingBean);
    
    //Ticket
    List<ITicketBean> getAllTickets();
    ITicketBean getTicketByCode(String code);
    boolean persistTicket(ITicketBean ticketBean);
    boolean removeTicket(ITicketBean ticketBean);
}
