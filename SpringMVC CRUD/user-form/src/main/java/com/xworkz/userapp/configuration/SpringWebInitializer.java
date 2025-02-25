package com.xworkz.userapp.configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class SpringWebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    public SpringWebInitializer(){
        System.out.println("SpringWebInitializer obj created");
    }
    @Override
    protected Class<?>[] getRootConfigClasses() {
        System.out.println("getRootConfigClasses invoked");
        return new Class[0];
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        System.out.println("getServletConfigClasses invoked");
        return new Class[]{SpringConfiguration.class};
    }

    @Override
    protected String[] getServletMappings() {
        System.out.println("getServletMappings invoked");
        return new String[]{"/"};
    }
}
