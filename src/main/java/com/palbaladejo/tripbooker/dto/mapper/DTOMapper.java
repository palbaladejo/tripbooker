package com.palbaladejo.tripbooker.dto.mapper;

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
import com.palbaladejo.tripbooker.dto.domain.aircraft.IAircraftDO;
import com.palbaladejo.tripbooker.dto.domain.airline.IAirlineDO;
import com.palbaladejo.tripbooker.dto.domain.airport.IAirportDO;
import com.palbaladejo.tripbooker.dto.domain.booking.IBookingDO;
import com.palbaladejo.tripbooker.dto.domain.city.ICityDO;
import com.palbaladejo.tripbooker.dto.domain.country.ICountryDO;
import com.palbaladejo.tripbooker.dto.domain.flight.IFlightDO;
import com.palbaladejo.tripbooker.dto.domain.route.IRouteDO;
import com.palbaladejo.tripbooker.dto.domain.ticket.ITicketDO;
import com.palbaladejo.tripbooker.dto.domain.user.IUserDO;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public abstract class DTOMapper {
    private static DTOMapper instance;
    
    public static synchronized DTOMapper getInstance(){
        if(instance == null) instance = new DTOMapperImp();
        return instance;
    }
    
    //Country
    public abstract ICountryBean getCountryBean(ICountryDO countryDO);
    public abstract ICountryDO getCountryDO(ICountryBean countryBean);
    
    //City
    public abstract ICityBean getCityBean(ICityDO cityDO,  ICountryDO countryDO);
    public abstract ICityDO getCityDO(ICityBean cityBean, ICountryDO countryDO);
    
    //Airport
    public abstract IAirportDO getAirportDO(IAirportBean airportBean, ICityDO cityDO);
    public abstract IAirportBean getAirportBean(IAirportDO airportDO, ICityDO cityDO);
    
    //Flight
    public abstract IFlightBean getFlightBean(IFlightDO flightDO, 
                                                IAirlineDO airlineDO, 
                                                IAirportDO departure, 
                                                IAirportDO destination,
                                                IAircraftDO aircraftDO);
    public abstract IFlightDO getFlightDO(IFlightBean flightBean, 
                                            IAircraftDO aircraftDO, 
                                            IAirlineDO airlineDO, 
                                            IRouteDO routeDO);
    
    //Aircraft
    public abstract IAircraftBean getAircraftBean(IAircraftDO aircraftDO);
    public abstract IAircraftDO getAircraftDO(IAircraftBean aircraftBean);
    
    //Airline
    public abstract IAirlineBean getAirlineBean(IAirlineDO airlineDO, ICountryDO countryDO);
    public abstract IAirlineDO getAirlineDO(IAirlineBean airlineBean, ICountryDO countryDO);
    
    //Route
    public abstract IRouteBean getRouteBean(IRouteDO routeDO, IAirportDO departure, IAirportDO destination);
    public abstract IRouteDO getRouteDO(IRouteBean routeBean, IAirportDO departure, IAirportDO destination);
    
    //Booking
    public abstract IBookingBean getBookingBean(IBookingDO bookingDO, IFlightDO flightDO, IUserDO userDO);
    public abstract IBookingDO getBookingDO(IBookingBean bookingBean, IFlightDO flightDO, IUserDO userDO);
    
    //User
    public abstract IUserBean getUserBean(IUserDO userDO);
    public abstract IUserDO getUserDO(IUserBean userBean);
    
    //Ticket
    public abstract ITicketBean getTicketBean(ITicketDO ticketDO,IUserDO userDO,IFlightDO flightDO);
    public abstract ITicketDO getTicketDO(ITicketBean ticketBean,IUserDO userDO,IFlightDO flightDO);
}

