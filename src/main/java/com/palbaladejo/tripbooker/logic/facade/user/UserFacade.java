package com.palbaladejo.tripbooker.logic.facade.user;

import java.util.List;
import com.palbaladejo.tripbooker.dto.bean.airport.IAirportBean;
import com.palbaladejo.tripbooker.dto.bean.city.ICityBean;
import com.palbaladejo.tripbooker.dto.bean.country.ICountryBean;
import com.palbaladejo.tripbooker.dto.bean.flight.IFlightBean;
import com.palbaladejo.tripbooker.logic.factory.ServiceFactory;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public class UserFacade implements IUserFacade{
    @Override
    public List<ICountryBean> getAllCountries() {
        return ServiceFactory.getInstance().getCountryService().getAllCountries();
    }
    
    @Override
    public ICountryBean getCountryByName(String name) {
        return ServiceFactory.getInstance().getCountryService().getCountryByName(name);
    }
    
    @Override
    public List<ICityBean> getAllCitiesByCountry(String code) {
        return ServiceFactory.getInstance().getCityService().getAllCitiesByCountry(code);
    }
    @Override
    public ICityBean getCityByName(String name) {
        return ServiceFactory.getInstance().getCityService().getCityByName(name);
    }
    
    @Override
    public List<IAirportBean> getAllAirportsByCity(String code) {
        return ServiceFactory.getInstance().getAirportService().getAllAirportsByCity(code);
    }

    @Override
    public List<IFlightBean> getAllFlightsByAirports(String depatureAirpotCode, String destinationAirpotCode) {
        return ServiceFactory.getInstance().getFlightService().getAllFlightsByAirports(depatureAirpotCode, destinationAirpotCode);
    }
}
