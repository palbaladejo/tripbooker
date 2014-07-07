package com.palbaladejo.tripbooker.dto.domain.factory;

import com.palbaladejo.tripbooker.dto.domain.aircraft.AircraftDOImp;
import com.palbaladejo.tripbooker.dto.domain.aircraft.IAircraftDO;
import com.palbaladejo.tripbooker.dto.domain.airline.AirlineDOImp;
import com.palbaladejo.tripbooker.dto.domain.airline.IAirlineDO;
import com.palbaladejo.tripbooker.dto.domain.airport.AirportDOImp;
import com.palbaladejo.tripbooker.dto.domain.airport.IAirportDO;
import com.palbaladejo.tripbooker.dto.domain.booking.BookingDOImp;
import com.palbaladejo.tripbooker.dto.domain.booking.IBookingDO;
import com.palbaladejo.tripbooker.dto.domain.city.CityDOImp;
import com.palbaladejo.tripbooker.dto.domain.city.ICityDO;
import com.palbaladejo.tripbooker.dto.domain.country.CountryDOImp;
import com.palbaladejo.tripbooker.dto.domain.country.ICountryDO;
import com.palbaladejo.tripbooker.dto.domain.flight.FlightDOImp;
import com.palbaladejo.tripbooker.dto.domain.flight.IFlightDO;
import com.palbaladejo.tripbooker.dto.domain.route.IRouteDO;
import com.palbaladejo.tripbooker.dto.domain.route.RouteDOImp;
import com.palbaladejo.tripbooker.dto.domain.ticket.ITicketDO;
import com.palbaladejo.tripbooker.dto.domain.ticket.TicketDOImp;
import com.palbaladejo.tripbooker.dto.domain.user.IUserDO;
import com.palbaladejo.tripbooker.dto.domain.user.UserDOImp;


/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public class DOFactoryImp extends DOFactory{

    @Override
    public IAirlineDO getAirlineDO() {
        return new AirlineDOImp();
    }

    @Override
    public IAircraftDO getAircraftDO() {
        return new AircraftDOImp();
    }

    @Override
    public IAirportDO getAirportDO() {
       return new AirportDOImp();
    }

    @Override
    public IRouteDO getRouteDO() {
        return new RouteDOImp();
    }
    
    @Override
    public ICityDO getCityDO() {
        return new CityDOImp();
    }

    @Override
    public ICountryDO getCountryDO() {
        return new CountryDOImp();
    }
    
    @Override
    public IFlightDO getFlightDO() {
        return new FlightDOImp();
    }

    @Override
    public IBookingDO getBookingDO() {
        return new BookingDOImp();
    }

    @Override
    public IUserDO getUserDO() {
        return new UserDOImp();
    }

    @Override
    public ITicketDO getTicketDO() {
        return new TicketDOImp();
    }
}
