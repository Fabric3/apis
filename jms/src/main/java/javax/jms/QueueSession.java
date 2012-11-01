/*
 * @(#)QueueSession.java	1.26 02/04/09
 *
 * Copyright 1997-2002 Sun Microsystems, Inc. All Rights Reserved.
 *
 *  SUN PROPRIETARY/CONFIDENTIAL.
 * This software is the proprietary information of Sun Microsystems, Inc.  
 * Use is subject to license terms.
 * 
 */



package javax.jms;

/** A <CODE>QueueSession</CODE> object provides methods for creating 
  * <CODE>QueueReceiver</CODE>, <CODE>QueueSender</CODE>, 
  * <CODE>QueueBrowser</CODE>, and <CODE>TemporaryQueue</CODE> objects.
  *
  * <P>If there are messages that have been received but not acknowledged 
  * when a <CODE>QueueSession</CODE> terminates, these messages will be retained 
  * and redelivered when a consumer next accesses the queue.
  *
  *<P>A <CODE>QueueSession</CODE> is used for creating Point-to-Point specific
  * objects. In general, use the <CODE>Session</CODE> object. 
  * The <CODE>QueueSession</CODE> is used to support
  * existing code. Using the <CODE>Session</CODE> object simplifies the 
  * programming model, and allows transactions to be used across the two 
  * messaging domains.
  * 
  * <P>A <CODE>QueueSession</CODE> cannot be used to create objects specific to the 
  * publish/subscribe domain. The following methods inherit from 
  * <CODE>Session</CODE>, but must throw an
  * <CODE>IllegalStateException</CODE> 
  * if they are used from <CODE>QueueSession</CODE>:
  *<UL>
  *   <LI><CODE>createDurableSubscriber</CODE>
  *   <LI><CODE>createTemporaryTopic</CODE>
  *   <LI><CODE>createTopic</CODE>
  *   <LI><CODE>unsubscribe</CODE>
  * </UL>
  *
  * @version     1.1 - April 2, 2002
  * @author      Mark Hapner
  * @author      Rich Burridge
  * @author      Kate Stout
  *
  * @see         javax.jms.Session
  * @see         javax.jms.QueueConnection#createQueueSession(boolean, int)
  * @see         javax.jms.XAQueueSession#getQueueSession()
  */

public interface QueueSession extends Session {

    /** Creates a queue identity given a <CODE>Queue</CODE> name.
      *
      * <P>This facility is provided for the rare cases where clients need to
      * dynamically manipulate queue identity. It allows the creation of a
      * queue identity with a provider-specific name. Clients that depend 
      * on this ability are not portable.
      *
      * <P>Note that this method is not for creating the physical queue. 
      * The physical creation of queues is an administrative task and is not
      * to be initiated by the JMS API. The one exception is the
      * creation of temporary queues, which is accomplished with the 
      * <CODE>createTemporaryQueue</CODE> method.
      *
      * @param queueName the name of this <CODE>Queue</CODE>
      *
      * @return a <CODE>Queue</CODE> with the given name
      *
      * @exception JMSException if the session fails to create a queue
      *                         due to some internal error.
      */ 
 
    Queue
    createQueue(String queueName) throws JMSException;


    /** Creates a <CODE>QueueReceiver</CODE> object to receive messages from the
      * specified queue.
      *
      * @param queue the <CODE>Queue</CODE> to access
      *
      * @exception JMSException if the session fails to create a receiver
      *                         due to some internal error.
      * @exception InvalidDestinationException if an invalid queue is specified.
      */

    QueueReceiver
    createReceiver(Queue queue) throws JMSException;


    /** Creates a <CODE>QueueReceiver</CODE> object to receive messages from the 
      * specified queue using a message selector.
      *  
      * @param queue the <CODE>Queue</CODE> to access
      * @param messageSelector only messages with properties matching the
      * message selector expression are delivered. A value of null or
      * an empty string indicates that there is no message selector 
      * for the message consumer.
      *  
      * @exception JMSException if the session fails to create a receiver
      *                         due to some internal error.
      * @exception InvalidDestinationException if an invalid queue is specified.
      * @exception InvalidSelectorException if the message selector is invalid.
      *
      */ 

    QueueReceiver
    createReceiver(Queue queue, 
		   String messageSelector) throws JMSException;


    /** Creates a <CODE>QueueSender</CODE> object to send messages to the 
      * specified queue.
      *
      * @param queue the <CODE>Queue</CODE> to access, or null if this is an 
      * unidentified producer
      *
      * @exception JMSException if the session fails to create a sender
      *                         due to some internal error.
      * @exception InvalidDestinationException if an invalid queue is specified.
      */
 
    QueueSender
    createSender(Queue queue) throws JMSException;


    /** Creates a <CODE>QueueBrowser</CODE> object to peek at the messages on 
      * the specified queue.
      *
      * @param queue the <CODE>Queue</CODE> to access
      *
      * @exception JMSException if the session fails to create a browser
      *                         due to some internal error.
      * @exception InvalidDestinationException if an invalid queue is specified.
      */

    QueueBrowser 
    createBrowser(Queue queue) throws JMSException;


    /** Creates a <CODE>QueueBrowser</CODE> object to peek at the messages on 
      * the specified queue using a message selector.
      *  
      * @param queue the <CODE>Queue</CODE> to access
      * @param messageSelector only messages with properties matching the
      * message selector expression are delivered. A value of null or
      * an empty string indicates that there is no message selector 
      * for the message consumer.
      *  
      * @exception JMSException if the session fails to create a browser
      *                         due to some internal error.
      * @exception InvalidDestinationException if an invalid queue is specified.
      * @exception InvalidSelectorException if the message selector is invalid.
      */ 

    QueueBrowser
    createBrowser(Queue queue,
		  String messageSelector) throws JMSException;


    /** Creates a <CODE>TemporaryQueue</CODE> object. Its lifetime will be that 
      * of the <CODE>QueueConnection</CODE> unless it is deleted earlier.
      *
      * @return a temporary queue identity
      *
      * @exception JMSException if the session fails to create a temporary queue
      *                         due to some internal error.
      */

    TemporaryQueue
    createTemporaryQueue() throws JMSException;
}
