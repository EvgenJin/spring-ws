/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.evg_springws.service;

import java.util.Date;
import org.springframework.stereotype.Service;

@Service
public class HumanResourceServiceImpl implements HumanResourceService {
   public void bookLeave(Date startDate, Date endDate, String name) {
      System.out.println("Booking holiday for [" + startDate + "-" + endDate + "for [" + name + "] ");
   }
}