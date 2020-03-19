/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.evg_springws.service;

import java.util.Date;

public interface HumanResourceService {
   void bookLeave(Date startDate, Date endDate, String name);
}