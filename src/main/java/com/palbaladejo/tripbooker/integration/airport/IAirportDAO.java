package com.palbaladejo.tripbooker.integration.airport;

import java.util.List;
import com.palbaladejo.tripbooker.dto.domain.airport.IAirportDO;
import com.palbaladejo.tripbooker.persistence.database.exception.TransactionException;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public interface IAirportDAO {
    List<IAirportDO> getAllAirports()throws TransactionException;
    List<IAirportDO> getAirportsByCity(int cityID)throws TransactionException;
    IAirportDO getAirportByID(int id)throws TransactionException;
    IAirportDO getAirportByCode(String code)throws TransactionException;
    boolean removeAirport(int id) throws TransactionException;
    boolean persistAirport(IAirportDO airport) throws TransactionException;
}
