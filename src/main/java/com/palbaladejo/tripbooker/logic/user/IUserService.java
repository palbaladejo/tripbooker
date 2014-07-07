package com.palbaladejo.tripbooker.logic.user;

import java.util.List;
import com.palbaladejo.tripbooker.dto.bean.user.IUserBean;


/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public interface IUserService {
    List<IUserBean> getAllUsers();
    IUserBean getUserByCode(String code);
    boolean removeUser(IUserBean userBean);
    boolean persistUser(IUserBean userBean);
}
