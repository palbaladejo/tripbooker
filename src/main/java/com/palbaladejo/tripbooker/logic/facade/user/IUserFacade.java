package com.palbaladejo.tripbooker.logic.facade.user;

import java.util.List;
import com.palbaladejo.tripbooker.dto.bean.airport.IAirportBean;
import com.palbaladejo.tripbooker.dto.bean.city.ICityBean;
import com.palbaladejo.tripbooker.dto.bean.country.ICountryBean;
import com.palbaladejo.tripbooker.dto.bean.flight.IFlightBean;
import com.palbaladejo.tripbooker.dto.bean.route.IRouteBean;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public interface IUserFacade {

    //Country
    List<ICountryBean> getAllCountries();
    ICountryBean getCountryByName(String name);
    
    //City
    List<ICityBean> getAllCitiesByCountry(String code);
    ICityBean getCityByName(String name);
    
    //Airport
    List<IAirportBean> getAllAirportsByCity(String code);
    
    //Flight
    List<IFlightBean> getAllFlightsByAirports(String depatureAirpotCode, String destinationAirpotCode);
}
