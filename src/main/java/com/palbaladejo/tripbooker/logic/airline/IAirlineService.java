package com.palbaladejo.tripbooker.logic.airline;

import java.util.List;
import com.palbaladejo.tripbooker.dto.bean.airline.IAirlineBean;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public interface IAirlineService {
    List<IAirlineBean> getAllAirlines();
    boolean persistAirline(IAirlineBean airlineBean);
    boolean removeAirline(IAirlineBean airlineBean);
}
