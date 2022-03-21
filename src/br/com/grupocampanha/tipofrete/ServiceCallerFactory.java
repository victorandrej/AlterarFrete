/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.grupocampanha.tipofrete;

import br.com.sankhya.modelcore.auth.AuthenticationInfo;
import br.com.sankhya.modelcore.facades.MGEFrontFacade;
import br.com.sankhya.modelcore.servicecaller.ServiceCaller;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.math.BigDecimal;

/**
 *
 * @author jfc
 */
public class ServiceCallerFactory {
      public static ServiceCaller newInstance(BigDecimal userID) throws Exception {
    AuthenticationInfo auth = null;
    StringBuilder authID = new StringBuilder();
    authID.append(System.currentTimeMillis()).append(':').append(userID);
    Integer authenticationID = authID.toString().hashCode();
    try {
      auth = AuthenticationInfo.getCurrentOrNull();
      if (auth != null && auth.getUserID().longValue() != userID.longValue())
        auth = new AuthenticationInfo(null, userID, null, authenticationID); 
    } catch (Exception e) {}
    if (auth == null)
      auth = new AuthenticationInfo(null, userID, null, authenticationID); 
    ServiceCaller instance = new ServiceCaller((MGEFrontFacade)Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[] { MGEFrontFacade.class }, new FrontFacadeProxy(auth)));
    return instance;
  }
      private static class FrontFacadeProxy implements InvocationHandler {
    AuthenticationInfo auth;
    
    public FrontFacadeProxy(AuthenticationInfo auth) {
      this.auth = auth;
    }
    
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
      if (method.getName().equals("getAuthenticationInfo"))
        return this.auth; 
      return method.invoke(proxy, args);
    }
  }
}


 
