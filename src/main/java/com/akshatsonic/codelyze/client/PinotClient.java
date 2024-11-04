package com.akshatsonic.codelyze.client;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.apache.pinot.client.Connection;
import org.apache.pinot.client.ConnectionFactory;
import org.apache.pinot.client.ResultSet;
import org.apache.pinot.client.ResultSetGroup;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PinotClient {
//    @Value("${zookeeper.url}")
//    private String zookeeperUrl;
//    @Value("${pinot.cluster-name}")
//    private String clusterName;
//
//    Connection connection;
//
//    @PostConstruct
//    void initialize() {
//        connection = ConnectionFactory.fromZookeeper(zookeeperUrl + "/" + clusterName);
//    }
//
//    public ResultSetGroup executeQuery(String query) {
//        ResultSetGroup resultSetGroup = connection.execute(query);
//        return resultSetGroup;
//    }
}
