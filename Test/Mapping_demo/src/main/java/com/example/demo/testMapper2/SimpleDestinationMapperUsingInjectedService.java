package com.example.demo.testMapper2;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class SimpleDestinationMapperUsingInjectedService {
    @Autowired
    protected SimpleService simpleService;
@Mapping(target = "name", expression = "java(simpleService.concateStr(source.getName()))")
public abstract SimpleDestination sourceToDestination(SimpleSource source);
    public abstract SimpleSource destinationToSource(SimpleDestination destination);
}
