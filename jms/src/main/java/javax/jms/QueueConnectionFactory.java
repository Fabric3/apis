/*
 * @(#)QueueConnectionFactory.java	1.14 02/04/23
 *
 * Copyright 1997-2002 Sun Microsystems, Inc. All Rights Reserved.
 *
 *  SUN PROPRIETARY/CONFIDENTIAL.
 * This software is the proprietary information of Sun Microsystems, Inc.  
 * Use is subject to license terms.
 * 
 */



package javax.jms;

/** A client uses a <CODE>QueueConnectionFactory</CODE> object to create 
  * <CODE>QueueConnection</CODE> objects with a point-to-point JMS provider.
  *
  * <P><CODE>QueueConnectionFactory</CODE> can be used to create a 
  * <CODE>QueueConnection</CODE>, from which specialized queue-related objects
  * can be  created. A more general, and recommended,  approach 
  * is to use the <CODE>ConnectionFactory</CODE> object.
  *
  *<P> The <CODE>QueueConnectionFactory</CODE> object
  * can be used to support existing code that already uses it.
  *
  * @version     1.1 - February 2, 2002
  * @author      Mark Hapner
  * @author      Rich Burridge
  * @author      Kate Stout
  *
  * @see         javax.jms.ConnectionFactory
  */

public interface QueueConnectionFactory extends ConnectionFactory {

    /** Creates a queue connection with the default user identity.
      * The connection is created in stopped mode. No messages 
      * will be delivered until the <code>Connection.start</code> method
      * is explicitly called.
      *
      .
      *
      * @return a newly created queue connection
      *
      * @exception JMSException if the JMS provider fails to create the queue 
      *                         connection due to some internal error.
      * @exception JMSSecurityException  if client authentication fails due to 
      *                         an invalid user name or password.
      */ 

    QueueConnection
    createQueueConnection() throws JMSException;


    /** Creates a queue connection with the specified user identity.
      * The connection is created in stopped mode. No messages 
      * will be delivered until the <code>Connection.start</code> method
      * is explicitly called.
      *  
      * @param userName the caller's user name
      * @param password the caller's password
      *  
      * @return a newly created queue connection
      *
      * @exception JMSException if the JMS provider fails to create the queue 
      *                         connection due to some internal error.
      * @exception JMSSecurityException  if client authentication fails due to 
      *                         an invalid user name or password.
      */ 

    QueueConnection
    createQueueConnection(String userName, String password) 
					     throws JMSException;
}
