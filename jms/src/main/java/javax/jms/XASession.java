/*
 * @(#)XASession.java	1.18 02/04/09
 *
 * Copyright 1997-2002 Sun Microsystems, Inc. All Rights Reserved.
 *
 *  SUN PROPRIETARY/CONFIDENTIAL.
 * This software is the proprietary information of Sun Microsystems, Inc.  
 * Use is subject to license terms.
 * 
 */

package javax.jms;

import javax.transaction.xa.XAResource;

/** The <CODE>XASession</CODE> interface extends the capability of 
  * <CODE>Session</CODE> by adding access to a JMS provider's support for the
  * Java Transaction API (JTA) (optional). This support takes the form of a 
  * <CODE>javax.transaction.xa.XAResource</CODE> object. The functionality of 
  * this object closely resembles that defined by the standard X/Open XA 
  * Resource interface.
  *
  * <P>An application server controls the transactional assignment of an 
  * <CODE>XASession</CODE> by obtaining its <CODE>XAResource</CODE>. It uses 
  * the <CODE>XAResource</CODE> to assign the session to a transaction, prepare 
  * and commit work on the transaction, and so on.
  *
  * <P>An <CODE>XAResource</CODE> provides some fairly sophisticated facilities 
  * for interleaving work on multiple transactions, recovering a list of 
  * transactions in progress, and so on. A JTA aware JMS provider must fully 
  * implement this functionality. This could be done by using the services 
  * of a database that supports XA, or a JMS provider may choose to implement 
  * this functionality from scratch.
  *
  * <P>A client of the application server is given what it thinks is a 
  * regular JMS <CODE>Session</CODE>. Behind the scenes, the application server 
  * controls the transaction management of the underlying 
  * <CODE>XASession</CODE>.
  *
  * <P>The <CODE>XASession</CODE> interface is optional.  JMS providers 
  * are not required to support this interface. This interface is for 
  * use by JMS providers to support transactional environments. 
  * Client programs are strongly encouraged to use the transactional support
  * available in their environment, rather than use these XA
  * interfaces directly. 
  *
  * @version     1.1 February 2, 2002
  * @author      Mark Hapner
  * @author      Rich Burridge
  * @author      Kate Stout
  *
  * @see         javax.jms.Session
  */ 
 
public interface XASession extends Session {

   /** Gets the session associated with this <CODE>XASession</CODE>.
      *  
      * @return the  session object
      *  
      * @exception JMSException if an internal error occurs.
      *
      * @since 1.1
      */ 
 
        Session
        getSession() throws JMSException;
  
    /** Returns an XA resource to the caller.
      *
      * @return an XA resource to the caller
      */

     XAResource
     getXAResource();

    /** Indicates whether the session is in transacted mode.
      *  
      * @return true
      *  
      * @exception JMSException if the JMS provider fails to return the 
      *                         transaction mode due to some internal error.
      */ 

    boolean
    getTransacted() throws JMSException;


    /** Throws a <CODE>TransactionInProgressException</CODE>, since it should 
      * not be called for an <CODE>XASession</CODE> object.
      *
      * @exception TransactionInProgressException if the method is called on 
      *                         an <CODE>XASession</CODE>.
      *                                     
      */

    void
    commit() throws JMSException;


    /** Throws a <CODE>TransactionInProgressException</CODE>, since it should 
      * not be called for an <CODE>XASession</CODE> object.
      *
      * @exception TransactionInProgressException if the method is called on 
      *                         an <CODE>XASession</CODE>.
      *                                     
      */

    void
    rollback() throws JMSException;
}
