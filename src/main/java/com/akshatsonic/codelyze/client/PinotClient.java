package com.akshatsonic.codelyze.client;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.apache.pinot.client.Connection;
import org.apache.pinot.client.ConnectionFactory;
import org.apache.pinot.client.ResultSetGroup;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class PinotClient {
    @Value("${pinot.brokers.list}")
    private String brokersList;

    //TODO : Not using clusterName because its using internal ip for broker
//    @Value("${pinot.cluster-name}")
//    private String clusterName;

    private static Connection connection;

    @PostConstruct
    public void init() {
        connection = ConnectionFactory.fromHostList(brokersList);
    }


    public ResultSetGroup executeQuery(String query) {
        ResultSetGroup resultSetGroup = connection.execute(query);
        return resultSetGroup;
    }
}
