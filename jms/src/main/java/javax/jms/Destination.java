/*
 * @(#)Destination.java	1.16 02/04/09
 *
 * Copyright 1997-2002 Sun Microsystems, Inc. All Rights Reserved.
 *
 *  SUN PROPRIETARY/CONFIDENTIAL.
 * This software is the proprietary information of Sun Microsystems, Inc.  
 * Use is subject to license terms.
 * 
 */


package javax.jms;

/** A <CODE>Destination</CODE> object encapsulates a provider-specific 
  * address.
  * The JMS API does not define a standard address syntax. Although a standard
  * address syntax was considered, it was decided that the differences in 
  * address semantics between existing message-oriented middleware (MOM) 
  * products were too wide to bridge with a single syntax. 
  *
  * <P>Since <CODE>Destination</CODE> is an administered object, it may 
  * contain 
  * provider-specific configuration information in addition to its address.
  *
  * <P>The JMS API also supports a client's use of provider-specific address 
  * names.
  *
  * <P><CODE>Destination</CODE> objects support concurrent use.
  *
  * <P>A <CODE>Destination</CODE> object is a JMS administered object.
  *
  * <P>JMS administered objects are objects containing configuration 
  * information that are created by an administrator and later used by 
  * JMS clients. They make it practical to administer the JMS API in the 
  * enterprise.
  *
  * <P>Although the interfaces for administered objects do not explicitly 
  * depend on the Java Naming and Directory Interface (JNDI) API, the JMS API 
  * establishes the convention that JMS clients find administered objects by
  * looking them up in a JNDI namespace.
  *
  * <P>An administrator can place an administered object anywhere in a 
  * namespace. The JMS API does not define a naming policy.
  *
  * <P>It is expected that JMS providers will provide the tools an
  * administrator needs to create and configure administered objects in a
  * JNDI namespace. JMS provider implementations of administered objects
  * should implement the <CODE>javax.naming.Referenceable</CODE> and
  * <CODE>java.io.Serializable</CODE> interfaces so that they can be stored in 
  * all JNDI naming contexts. In addition, it is recommended that these
  * implementations follow the JavaBeans<SUP><FONT SIZE="-2">TM</FONT></SUP> 
  * design patterns.
  *
  * <P>This strategy provides several benefits:
  *
  * <UL>
  *   <LI>It hides provider-specific details from JMS clients.
  *   <LI>It abstracts JMS administrative information into objects in the Java 
  *       programming language ("Java objects") 
  *       that are easily organized and administered from a common 
  *       management console.
  *   <LI>Since there will be JNDI providers for all popular naming 
  *       services, JMS providers can deliver one implementation
  *       of administered objects that will run everywhere.
  * </UL>
  *
  * <P>An administered object should not hold on to any remote resources. 
  * Its lookup should not use remote resources other than those used by the
  * JNDI API itself.
  *
  * <P>Clients should think of administered objects as local Java objects. 
  * Looking them up should not have any hidden side effects or use surprising 
  * amounts of local resources.
  *
  * @version     1.0 - 3 August 1998
  * @author      Mark Hapner
  * @author      Rich Burridge
  *
  * @see         javax.jms.Queue
  * @see         javax.jms.Topic
  */

public interface Destination {
}
