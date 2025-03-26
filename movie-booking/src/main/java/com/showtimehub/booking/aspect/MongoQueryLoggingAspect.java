package com.showtimehub.booking.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MongoQueryLoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(MongoQueryLoggingAspect.class);

    @Pointcut("execution(* org.springframework.data.mongodb.core.MongoTemplate.aggregate(..)) && args(aggregation, inputType, outputType)")
    public void aggregateMethod(Aggregation aggregation, Class<?> inputType, Class<?> outputType) {}

    @AfterReturning(pointcut = "aggregateMethod(aggregation, inputType, outputType)", returning = "result")
    public void logAggregateQuery(Aggregation aggregation, Class<?> inputType, Class<?> outputType, AggregationResults<?> result) {
        logger.info("Executed aggregation query: {}", aggregation);
    }
}