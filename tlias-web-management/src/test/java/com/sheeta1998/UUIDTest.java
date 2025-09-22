package com.sheeta1998;

public class UUIDTest {
    public void testUuid() {
        for (int i = 0; i < 100; i++) {
            System.out.println(java.util.UUID.randomUUID().toString());
        }
    }
}
