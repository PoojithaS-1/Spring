package com.xworkz.countryapp.politician;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Setter
@ToString
@Component // Ensures this class is registered as a Spring bean so it can be autowired into dependent components.
// Without this annotation, Spring will throw NoSuchBeanDefinitionException when injecting Politician into Country.

// Error creating bean with name 'country': Unsatisfied dependency expressed through field 'politician';
// NoSuchBeanDefinitionException: No qualifying bean of type 'com.xworkz.countryapp.politician.Politician' available: expected at least 1 bean which qualifies as autowire candidate. Dependency annotations: {@org.springframework.beans.factory.annotation.Autowired(required=true)}
public class Politician {
    @Value("1")
    private int politicianId;
    @Value("Tejaswi Surya")
    private String name;

}
