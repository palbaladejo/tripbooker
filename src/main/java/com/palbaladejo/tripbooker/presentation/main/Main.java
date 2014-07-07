package com.palbaladejo.tripbooker.presentation.main;

import com.palbaladejo.tripbooker.presentation.controller.Controller;
import com.palbaladejo.tripbooker.presentation.controller.event.BusinessEvent;

/**
 *
 * @author Pablo Albaladejo Mestre <pablo.albaladejo.mestre@gmail.com>
 */

public class Main {
    public static void main(String[] args) {
        Controller.getInstance().action(BusinessEvent.APP_START, null);
    }
}
