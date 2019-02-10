package com.amp.work;

public class Contants {
    public enum ConnectionState{
        CONNECTED("CONNECTED"),
        NOTCONNECTED("NOT CONNECTED");
        private final String value;

        ConnectionState(String value) {
            this.value = value;
        }

        public String value() {
            return this.value;
        }

    }



}
