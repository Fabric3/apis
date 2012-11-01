/*
 * @(#)ServerSessionPool.java	1.12 02/04/09
 *
 * Copyright 1997-2002 Sun Microsystems, Inc. All Rights Reserved.
 *
 *  SUN PROPRIETARY/CONFIDENTIAL.
 * This software is the proprietary information of Sun Microsystems, Inc.  
 * Use is subject to license terms.
 * 
 */


package javax.jms;

/** A <CODE>ServerSessionPool</CODE> object is an object implemented by an 
  * application server to provide a pool of <CODE>ServerSession</CODE> objects 
  * for processing the messages of a <CODE>ConnectionConsumer</CODE> (optional).
  *
  * <P>Its only method is <CODE>getServerSession</CODE>. The JMS API does not 
  * architect how the pool is implemented. It could be a static pool of 
  * <CODE>ServerSession</CODE> objects, or it could use a sophisticated 
  * algorithm to dynamically create <CODE>ServerSession</CODE> objects as 
  * needed.
  *
  * <P>If the <CODE>ServerSessionPool</CODE> is out of 
  * <CODE>ServerSession</CODE> objects, the <CODE>getServerSession</CODE> call 
  * may block. If a <CODE>ConnectionConsumer</CODE> is blocked, it cannot 
  * deliver new messages until a <CODE>ServerSession</CODE> is 
  * eventually returned.
  *
  * @version     1.0 - 9 March 1998
  * @author      Mark Hapner
  * @author      Rich Burridge
  *
  * @see javax.jms.ServerSession
  */

public interface ServerSessionPool {

    /** Return a server session from the pool.
      *
      * @return a server session from the pool
      *  
      * @exception JMSException if an application server fails to
      *                         return a <CODE>ServerSession</CODE> out of its
      *                         server session pool.
      */ 

    ServerSession
    getServerSession() throws JMSException;
}
