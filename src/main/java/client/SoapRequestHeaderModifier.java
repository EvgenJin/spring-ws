/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.io.IOException;
import java.util.Base64;
import javax.xml.soap.MimeHeaders;
import javax.xml.transform.TransformerException;
import org.springframework.ws.WebServiceMessage;
import org.springframework.ws.client.core.WebServiceMessageCallback;
import org.springframework.ws.soap.saaj.SaajSoapMessage;

/**
 *
 * @author admin
 */
public class SoapRequestHeaderModifier implements WebServiceMessageCallback {
 private final String userName = "test";
 private final String passWd = "test";

 @Override
 public void doWithMessage(WebServiceMessage message) throws IOException, TransformerException {
  if (message instanceof SaajSoapMessage) {
   SaajSoapMessage soapMessage = (SaajSoapMessage) message;
   MimeHeaders mimeHeader = soapMessage.getSaajMessage().getMimeHeaders();
   mimeHeader.setHeader("Authorization", getB64Auth(userName, passWd));
  }
 }

 private String getB64Auth(String login, String pass) {
    byte[] encodedBytes = Base64.getEncoder().encode((login + ":" + pass).getBytes());
    return "Basic " + new String(encodedBytes);     
//  String source = login + ":" + pass;
//  String retunVal = "Basic " + Base64.getUrlEncoder().encodeToString(source.getBytes());
//  String retunVal = "Basic asdads";
//  return retunVal;
 }
}