package org.java.luke.baedb.service;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyApplicationContext {
  /**
   * Logger for this class
   */
  private static final Logger logger = Logger.getLogger(MyApplicationContext.class);

  private static ApplicationContext context = null;

  private MyApplicationContext() {
  }

  public static ApplicationContext getInstance() {
    // System.out.println("try to getInstance for spring ApplicationContext");
    try {
      if (context == null) {
        synchronized (ApplicationContext.class) {
          if (context == null) {
            logger.info("first time try to get MyApplicationContext instance!");
            // context = new MyFakeApplicationContext();
            context = new ClassPathXmlApplicationContext("applicationContext.xml");
          }
        }
      }
    } catch (Exception ee) {
      logger.error("into getInstance of org.alle.pub.db.service.MyApplicationContext");
      logger.error("iexception=" + ee);
    }
    // System.out.println(" getInstance for spring ApplicationContext END");
    return context;
  }

}
