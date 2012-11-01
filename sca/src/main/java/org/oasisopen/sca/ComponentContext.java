/*
 * Fabric3
 * Copyright (c) 2009-2012 Metaform Systems
 *
 * Fabric3 is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of
 * the License, or (at your option) any later version, with the
 * following exception:
 *
 * Linking this software statically or dynamically with other
 * modules is making a combined work based on this software.
 * Thus, the terms and conditions of the GNU General Public
 * License cover the whole combination.
 *
 * As a special exception, the copyright holders of this software
 * give you permission to link this software with independent
 * modules to produce an executable, regardless of the license
 * terms of these independent modules, and to copy and distribute
 * the resulting executable under terms of your choice, provided
 * that you also meet, for each linked independent module, the
 * terms and conditions of the license of that module. An
 * independent module is a module which is not derived from or
 * based on this software. If you modify this software, you may
 * extend this exception to your version of the software, but
 * you are not obligated to do so. If you do not wish to do so,
 * delete this exception statement from your version.
 *
 * Fabric3 is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty
 * of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU General Public License for more details.
 *
 * You should have received a copy of the
 * GNU General Public License along with Fabric3.
 * If not, see <http://www.gnu.org/licenses/>.
 *
 * Based on artifacts from OASIS:
 *
 * Copyright(C) OASIS(R) 2005,2009. All Rights Reserved.
 * OASIS trademark, IPR and other policies apply.
 */
package org.oasisopen.sca;

import java.util.Collection;

/**
 * Interface providing programmatic access to a component's SCA context as an alternative to injection. It provides access to reference and property
 * values for the component and provides a mechanism for obtaining a reference to a service that can be passed to other components.
 * <p/>
 * SCA components obtain an instance of this interface through injection. Non-SCA client code may also obtain an instance through runtime-specific
 * mechanisms.
 *
 * @version $Rev: 7249 $ $Date: 2009-07-03 17:23:49 +0200 (Fri, 03 Jul 2009) $
 */
public interface ComponentContext {
    /**
     * Returns the absolute URI of the component within the SCA Domain.
     *
     * @return the absolute URI of the component
     */
    String getURI();

    /**
     * Cast a type-safe reference to a CallableReference. Converts a type-safe reference to an equivalent CallableReference; if the target refers to a
     * service then a ServiceReference will be returned, if the target refers to a callback then a CallableReference will be returned.
     *
     * @param target a reference proxy provided by the SCA runtime
     * @param <B>    the Java type of the business interface for the reference
     * @param <R>    the type of reference to be returned
     * @return a ServiceReference equivalent for the proxy
     * @throws IllegalArgumentException if the supplied instance is not a reference supplied by the SCA runtime
     */
    <B, R extends ServiceReference<B>> R cast(B target) throws IllegalArgumentException;

    /**
     * Returns a proxy for a reference defined by this component.
     *
     * @param businessInterface the interface that will be used to invoke the service
     * @param referenceName     the name of the reference
     * @param <B>               the Java type of the business interface for the reference
     * @return an object that implements the business interface
     */
    <B> B getService(Class<B> businessInterface, String referenceName);

    /**
     * Returns a ServiceReference for a reference defined by this component.
     *
     * @param businessInterface the interface that will be used to invoke the service
     * @param referenceName     the name of the reference
     * @param <B>               the Java type of the business interface for the reference
     * @return a ServiceReference for the designated reference
     */
    <B> ServiceReference<B> getServiceReference(Class<B> businessInterface, String referenceName);

    /**
     * Returns a list of service proxies for an interface type and reference name.
     *
     * @param interfaze     the interface used to represent the target service
     * @param referenceName the name of the service reference
     * @return the collection of service proxies
     */
    <B> Collection<B> getServices(Class<B> interfaze, String referenceName);

    /**
     * Returns a list of service references for an interface type and a reference name.
     *
     * @param interfaze     the interface used to represent the target service
     * @param referenceName the name of the service reference
     * @return the collection of service proxies
     */
    <B> Collection<ServiceReference<B>> getServiceReferences(Class<B> interfaze, String referenceName);

    /**
     * Returns the value of an SCA property defined by this component.
     *
     * @param type         the Java type to be returned for the property
     * @param propertyName the name of the property whose value should be returned
     * @param <B>          the Java type of the property
     * @return the property value
     */
    <B> B getProperty(Class<B> type, String propertyName);

    /**
     * Returns a ServiceReference that can be used to invoke this component over the default service.
     *
     * @param businessInterface the interface that will be used to invoke the service
     * @param <B>               the Java type of the business interface for the reference
     * @return a ServiceReference that will invoke this component
     */
    <B> ServiceReference<B> createSelfReference(Class<B> businessInterface);

    /**
     * Returns a ServiceReference that can be used to invoke this component over the designated service.
     *
     * @param businessInterface the interface that will be used to invoke the service
     * @param serviceName       the name of the service to invoke
     * @param <B>               the Java type of the business interface for the reference
     * @return a ServiceReference that will invoke this component
     */
    <B> ServiceReference<B> createSelfReference(Class<B> businessInterface, String serviceName);

    /**
     * Returns the context for the current SCA service request, or null if there is no current request or if the context is unavailable.
     *
     * @return the SCA request context; may be null
     */
    RequestContext getRequestContext();

}