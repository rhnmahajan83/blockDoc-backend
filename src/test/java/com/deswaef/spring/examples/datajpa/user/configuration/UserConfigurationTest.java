package com.deswaef.spring.examples.datajpa.user.configuration;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.blockdock.datajpa.UserConfiguration;

/**
 * User: Quinten
 * Date: 8-5-2014
 * Time: 10:54
 *
 * @author Quinten De Swaef
 */
public class UserConfigurationTest {

    @Test
    public void bootstrapsApplication() {
        new AnnotationConfigApplicationContext(UserConfiguration.class);
    }
}
