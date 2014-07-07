package com.palbaladejo.tripbooker.dto.domain.route;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public interface IRouteDO {
    int getRouteID();
    void setRouteID(int routeID);
    
    int getDepartureID();
    void setDepartureID(int departureID);

    int getDestinationID();
    void setDestinationID(int destinationID);

    int getDuration();
    void setDuration(int duration);
}
