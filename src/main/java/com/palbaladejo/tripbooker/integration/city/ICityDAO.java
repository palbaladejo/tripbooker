package com.palbaladejo.tripbooker.integration.city;

import java.util.List;
import com.palbaladejo.tripbooker.dto.domain.city.ICityDO;
import com.palbaladejo.tripbooker.persistence.database.exception.TransactionException;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public interface ICityDAO {
    List<ICityDO> getAllCities()throws TransactionException;
    List<ICityDO> getAllCitiesByCountry(int countryID)throws TransactionException;
    ICityDO getCityByID(int id)throws TransactionException;
    ICityDO getCityByCode(String code)throws TransactionException;
    ICityDO getCityByName(String name)throws TransactionException;
    boolean removeCity(int id) throws TransactionException;
    boolean persistCity(ICityDO city) throws TransactionException;
}
