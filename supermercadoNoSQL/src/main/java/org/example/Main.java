package org.example;

import sevicios.PingService;

public class Main {

    public static void main(String[] args) {
        PingService pingService = new PingService();
        pingService.PingMongoDB();
        pingService.PingRedis();
    }
}