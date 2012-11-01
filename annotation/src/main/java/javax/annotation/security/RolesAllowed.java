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
 * Specifies the list of roles permitted to access method(s) in an application.
 * The value of the RolesAllowed annotation is a list of security role names. 
 * This annotation can be specified on a class or on method(s). Specifying it 
 * at a class level means that it applies to all the methods in the class. 
 * Specifying it on a method means that it is applicable to that method only. 
 * If applied at both the class and methods level , the method value overrides 
 * the class value if the two conflict.
 *
 * @since Common Annotations 1.0
 */
@Documented
@Retention (RUNTIME)
@Target({TYPE, METHOD})
public @interface RolesAllowed {
    String[] value();
}
