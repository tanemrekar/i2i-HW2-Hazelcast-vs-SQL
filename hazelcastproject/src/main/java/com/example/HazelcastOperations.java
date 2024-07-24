package com.example;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HazelcastOperations {
    private final HazelcastInstance hazelcastInstance;

    public HazelcastOperations(HazelcastInstance hazelcastInstance) {
        this.hazelcastInstance = hazelcastInstance;
    }

    public void putRandomNumbers(int count) {
        IMap<Integer, Integer> map = hazelcastInstance.getMap("numbers");
        Random random = new Random();
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < count; i++) {
            map.put(i, random.nextInt());
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Time to put " + count + " numbers: " + (endTime - startTime) + " ms");
    }

    public void getRandomNumbers(int count) {
        IMap<Integer, Integer> map = hazelcastInstance.getMap("numbers");
        Random random = new Random();
        List<Integer> keys = new ArrayList<>(map.keySet());
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < count; i++) {
            map.get(keys.get(random.nextInt(keys.size())));
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Time to get " + count + " numbers: " + (endTime - startTime) + " ms");
    }
}