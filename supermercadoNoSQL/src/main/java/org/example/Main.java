package org.example;

import controladores.Administrador;
import controladores.Sistema;
import sevicios.PingService;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        PingService pingService = new PingService();
        pingService.PingMongoDB();
        pingService.PingRedis();
    }
}