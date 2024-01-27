package com.skysoft.restapi.restapiproject.filttering;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.skysoft.restapi.restapiproject.versioning.PersonV1;

import org.springframework.hateoas.EntityModel;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class FilteringResource {

    @GetMapping(path = "filter-dynamic")
    public MappingJacksonValue getAllDynamic(){
      List<SomeBean> list = Arrays.asList(new SomeBean("value1","value2", "value3"),
				new SomeBean("value4","value5", "value6"));
                MappingJacksonValue mappingJacksonValue=new MappingJacksonValue(list);
                SimpleBeanPropertyFilter filter=SimpleBeanPropertyFilter.filterOutAllExcept("item1","item2");
                FilterProvider filterProvider=new SimpleFilterProvider().addFilter("SomeBean",filter);
                mappingJacksonValue.setFilters(filterProvider);
        return mappingJacksonValue;
    }





 


    @GetMapping(path = "/v11")
	public PersonV1 getFirstVersionOfPerson() {
		return new PersonV1("Muhammad");
	}
}
