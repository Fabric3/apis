/*
 * The contents of this file are subject to the terms 
 * of the Common Development and Distribution License 
 * (the "License").  You may not use this file except 
 * in compliance with the License.
 * 
 * You can obtain a copy of the license at 
 * glassfish/bootstrap/legal/CDDLv1.0.txt or 
 * https://glassfish.dev.java.net/public/CDDLv1.0.html. 
 * See the License for the specific language governing 
 * permissions and limitations under the License.
 * 
 * When distributing Covered Code, include this CDDL 
 * HEADER in each file and include the License file at 
 * glassfish/bootstrap/legal/CDDLv1.0.txt.  If applicable, 
 * add the following below this CDDL HEADER, with the 
 * fields enclosed by brackets "[]" replaced with your 
 * own identifying information: Portions Copyright [yyyy] 
 * [name of copyright owner]
 */

/*
 *
 * Copyright 2005-2006 Sun Microsystems, Inc. All Rights Reserved.
 */


package javax.annotation.security;
import java.lang.annotation.*;
import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

/**
 * Specifies that all security roles are allowed to invoke the specified 
 * method(s) i.e that the specified method(s) are "unchecked". It can be 
 * specified on a class or on methods. Specifying it on the class means that 
 * it applies to all methods of the class. If specified at the method level, 
 * it only affects that method. If the RolesAllowed is specified at the class 
 * level and this annotation is applied at the method level, the PermitAll 
 * annotation overrides the RolesAllowed for the specified method.
 *
 * @see javax.annotation.security.RolesAllowed
 * @see javax.annotation.security.DenyAll
 *
 * @since Common Annotations 1.0
 */
@Documented
@Retention (RUNTIME)
@Target({TYPE, METHOD})
public @interface PermitAll {
}
