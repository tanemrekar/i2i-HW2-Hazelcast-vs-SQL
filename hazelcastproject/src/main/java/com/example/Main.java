package com.example;


import com.hazelcast.core.HazelcastInstance;

public class Main {
    public static void main(String[] args) {
        HazelcastInstance hazelcastInstance = HazelcastConfig.createHazelcastInstance();
        HazelcastOperations operations = new HazelcastOperations(hazelcastInstance);

        operations.putRandomNumbers(20000);
        operations.getRandomNumbers(20000);

        operations.putRandomNumbers(100000);
        operations.getRandomNumbers(100000);

        hazelcastInstance.shutdown();
    }
}
