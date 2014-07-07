package com.palbaladejo.tripbooker.dto.bean.factory;

import com.palbaladejo.tripbooker.dto.bean.aircraft.AircraftBean;
import com.palbaladejo.tripbooker.dto.bean.aircraft.IAircraftBean;
import com.palbaladejo.tripbooker.dto.bean.airline.AirlineBean;
import com.palbaladejo.tripbooker.dto.bean.airline.IAirlineBean;
import com.palbaladejo.tripbooker.dto.bean.airport.AirportBean;
import com.palbaladejo.tripbooker.dto.bean.airport.IAirportBean;
import com.palbaladejo.tripbooker.dto.bean.booking.BookingBean;
import com.palbaladejo.tripbooker.dto.bean.booking.IBookingBean;
import com.palbaladejo.tripbooker.dto.bean.city.CityBean;
import com.palbaladejo.tripbooker.dto.bean.city.ICityBean;
import com.palbaladejo.tripbooker.dto.bean.country.CountryBean;
import com.palbaladejo.tripbooker.dto.bean.country.ICountryBean;
import com.palbaladejo.tripbooker.dto.bean.flight.FlightBean;
import com.palbaladejo.tripbooker.dto.bean.flight.IFlightBean;
import com.palbaladejo.tripbooker.dto.bean.route.IRouteBean;
import com.palbaladejo.tripbooker.dto.bean.route.RouteBean;
import com.palbaladejo.tripbooker.dto.bean.ticket.ITicketBean;
import com.palbaladejo.tripbooker.dto.bean.ticket.TicketBean;
import com.palbaladejo.tripbooker.dto.bean.user.IUserBean;
import com.palbaladejo.tripbooker.dto.bean.user.UserBean;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public class BeanFactoryImp extends BeanFactory{
 @Override
    public IFlightBean getFlightBean() {
        return new FlightBean();
    }

    @Override
    public IAirportBean getAirportBean() {
        return new AirportBean();
    }

    @Override
    public ICityBean getCityBean() {
        return new CityBean();
    }

    @Override
    public ICountryBean getCountryBean() {
        return new CountryBean();
    }

    @Override
    public IAircraftBean getAircraftBean() {
        return new AircraftBean();
    }

    @Override
    public IAirlineBean getAirlineBean() {
        return new AirlineBean();
    }

    @Override
    public IRouteBean getRouteBean() {
        return new RouteBean();
    }

    @Override
    public IBookingBean getBookingBean() {
        return new BookingBean();
    }

    @Override
    public IUserBean getUserBean() {
        return new UserBean();
    }

    @Override
    public ITicketBean getTicketBean() {
        return new TicketBean();
    }
}
