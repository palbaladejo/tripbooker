package com.palbaladejo.tripbooker.logic.booking;

import java.util.List;
import com.palbaladejo.tripbooker.dto.bean.booking.IBookingBean;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public interface IBookingService {
    List<IBookingBean> getAllBookings();
    IBookingBean getBookingByCode(String code);
    boolean persistBooking(IBookingBean bookingBean);
    boolean removeBooking(IBookingBean bookingBean);
}
