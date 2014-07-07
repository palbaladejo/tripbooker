package com.palbaladejo.tripbooker.logic.aircraft;

import java.util.List;
import com.palbaladejo.tripbooker.dto.bean.aircraft.IAircraftBean;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public interface IAircraftService {
    List<IAircraftBean> getAllAircrafts();
    boolean persistAircraft(IAircraftBean aircraftBean);
    boolean removeAircraft(IAircraftBean aircraftBean);
}
