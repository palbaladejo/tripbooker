package com.palbaladejo.tripbooker.dto.domain.factory;

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

public abstract class DOFactory {
    private static DOFactory instance;
    
    public static synchronized DOFactory getInstance(){
        if(instance == null) instance = new DOFactoryImp();
        return instance;
    }
    
    public abstract IFlightDO getFlightDO();
    public abstract IAirportDO getAirportDO();
    public abstract ICityDO getCityDO();
    public abstract ICountryDO getCountryDO();
    public abstract IAircraftDO getAircraftDO();
    public abstract IAirlineDO getAirlineDO();
    public abstract IRouteDO getRouteDO();    
    public abstract IBookingDO getBookingDO();
    public abstract IUserDO getUserDO();
    public abstract ITicketDO getTicketDO();
}


