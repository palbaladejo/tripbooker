package com.palbaladejo.tripbooker.dto.bean.factory;

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

public abstract class BeanFactory {
    private static BeanFactory instance;
    
    public static synchronized BeanFactory getInstance(){
        if(instance == null) instance = new BeanFactoryImp();
        return instance;
    }

    public abstract IFlightBean getFlightBean();
    public abstract IAirportBean getAirportBean();
    public abstract ICityBean getCityBean();
    public abstract ICountryBean getCountryBean();
    public abstract IAircraftBean getAircraftBean();
    public abstract IAirlineBean getAirlineBean();
    public abstract IRouteBean getRouteBean();
    public abstract IBookingBean getBookingBean();
    public abstract IUserBean getUserBean();
    public abstract ITicketBean getTicketBean();
}
