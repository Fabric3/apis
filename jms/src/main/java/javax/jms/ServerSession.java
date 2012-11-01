/*
 * @(#)ResourceAllocationException.java	1.4 01/02/16
 *
 * Copyright 1997-1999 Sun Microsystems, Inc. All Rights Reserved.
 * 
 * This software is the proprietary information of Sun Microsystems, Inc.  
 * Use is subject to license terms.
 * 
 */


package javax.jms;

/** A <CODE>ServerSession</CODE> object is an application server object that 
  * is used by a server to associate a thread with a JMS session (optional).
  *
  * <P>A <CODE>ServerSession</CODE> implements two methods:
  *
  * <UL>
  *   <LI><CODE>getSession</CODE> - returns the <CODE>ServerSession</CODE>'s 
  *       JMS session.
  *   <LI><CODE>start</CODE> - starts the execution of the 
  *       <CODE>ServerSession</CODE> 
  *       thread and results in the execution of the JMS session's 
  *       <CODE>run</CODE> method.
  * </UL>
  *
  * <P>A <CODE>ConnectionConsumer</CODE> implemented by a JMS provider uses a 
  * <CODE>ServerSession</CODE> to process one or more messages that have 
  * arrived. It does this by getting a <CODE>ServerSession</CODE> from the 
  * <CODE>ConnectionConsumer</CODE>'s <CODE>ServerSessionPool</CODE>; getting 
  * the <CODE>ServerSession</CODE>'s JMS session; loading it with the messages; 
  * and then starting the <CODE>ServerSession</CODE>.
  *
  * <P>In most cases the <CODE>ServerSession</CODE> will register some object 
  * it provides as the <CODE>ServerSession</CODE>'s thread run object. The 
  * <CODE>ServerSession</CODE>'s <CODE>start</CODE> method will call the 
  * thread's <CODE>start</CODE> method, which will start the new thread, and 
  * from it, call the <CODE>run</CODE> method of the 
  * <CODE>ServerSession</CODE>'s run object. This object will do some 
  * housekeeping and then call the <CODE>Session</CODE>'s <CODE>run</CODE> 
  * method. When <CODE>run</CODE> returns, the <CODE>ServerSession</CODE>'s run 
  * object can return the <CODE>ServerSession</CODE> to the 
  * <CODE>ServerSessionPool</CODE>, and the cycle starts again.
  *
  * <P>Note that the JMS API does not architect how the 
  * <CODE>ConnectionConsumer</CODE> loads the <CODE>Session</CODE> with 
  * messages. Since both the <CODE>ConnectionConsumer</CODE> and 
  * <CODE>Session</CODE> are implemented by the same JMS provider, they can 
  * accomplish the load using a private mechanism.
  *
  * @version     1.0 - 9 March 1998
  * @author      Mark Hapner
  * @author      Rich Burridge
  *
  * @see         javax.jms.ServerSessionPool
  * @see         javax.jms.ConnectionConsumer
  */

public interface ServerSession {

    /** Return the <CODE>ServerSession</CODE>'s <CODE>Session</CODE>. This must 
      * be a <CODE>Session</CODE> created by the same <CODE>Connection</CODE> 
      * that will be dispatching messages to it. The provider will assign one or
      * more messages to the <CODE>Session</CODE> 
      * and then call <CODE>start</CODE> on the <CODE>ServerSession</CODE>.
      *
      * @return the server session's session
      *  
      * @exception JMSException if the JMS provider fails to get the associated
      *                         session for this <CODE>ServerSession</CODE> due
      *                         to some internal error.
      **/

    Session
    getSession() throws JMSException;


    /** Cause the <CODE>Session</CODE>'s <CODE>run</CODE> method to be called 
      * to process messages that were just assigned to it.
      *  
      * @exception JMSException if the JMS provider fails to start the server
      *                         session to process messages due to some internal
      *                         error.
      */

    void 
    start() throws JMSException; 
}
