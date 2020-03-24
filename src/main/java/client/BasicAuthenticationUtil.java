/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.util.Base64;

public class BasicAuthenticationUtil {

  private BasicAuthenticationUtil() {}

  public static String generateBasicAutenticationHeader(String userName, String userPassword) {
    byte[] encodedBytes = Base64.getEncoder().encode((userName + ":" + userPassword).getBytes());
    return "Basic " + new String(encodedBytes);
  }
}