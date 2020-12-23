package com.google.algorithm;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class SnowFlake {

    private static final long TWEPOCH = 12888349746579L;

    private static final long WORKER_ID_BITS = 5L;

    private static final long DATACENTER_ID_BITS = 5L;

    private static final long SEQUENCE_BITS = 12L;

    private static final long WORKER_ID_SHIFT = 12L;

    private static final long DATACENTER_ID_SHIFT = 17L;

    private static final long TIMESTAMP_LEFT_SHIFT = 22L;

    private static final long SEQUENCE_MASK = 4095L;

    private static long LAST_TIMESTAMP = -1L;

    private long sequence = 0L;

    private long workerId = 1L;

    private static long workerMask = 31L;

    private long processId = 1L;

    private static long processMask = 31L;

    private static SnowFlake snowFlake = null;

    static {
        snowFlake = new SnowFlake();
    }

    public static synchronized String nextId() {
        return snowFlake.getNextId() + "";
    }

    private SnowFlake() {
        this.workerId = getMachineNum();
        RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();
        this.processId = Long.valueOf(runtimeMXBean.getName().split("@")[0]).longValue();
        this.workerId &= workerMask;
        this.processId &= processMask;
    }

    public synchronized long getNextId() {
        long timestamp = timeGen();
        if (timestamp < LAST_TIMESTAMP)
            try {
                throw new Exception("Clock moved backwards.  Refusing to generate id for " + (LAST_TIMESTAMP - timestamp) + " milliseconds");
            } catch (Exception e) {
                e.printStackTrace();
                //logger.error(", e);
            }
        if (LAST_TIMESTAMP == timestamp) {
            this.sequence = this.sequence + 1L & 0xFFFL;
            if (this.sequence == 0L)
                timestamp = tilNextMillis(LAST_TIMESTAMP);
        } else {
            this.sequence = 0L;
        }
        LAST_TIMESTAMP = timestamp;
        long nextId = timestamp - 12888349746579L << 22L | this.processId << 17L | this.workerId << 12L | this.sequence;
        return nextId;
    }

    private long tilNextMillis(long lastTimestamp) {
        long timestamp = timeGen();
        while (timestamp <= LAST_TIMESTAMP)
            timestamp = timeGen();
        return timestamp;
    }

    private long timeGen() {
        return System.currentTimeMillis();
    }

    private long getMachineNum() {
        StringBuilder sb = new StringBuilder();
        Enumeration<NetworkInterface> e = null;
        try {
            e = NetworkInterface.getNetworkInterfaces();
        } catch (SocketException e1) {
            e1.printStackTrace();
        }
        while (e.hasMoreElements()) {
            NetworkInterface ni = e.nextElement();
            sb.append(ni.toString());
        }
        long machinePiece = sb.toString().hashCode();
        return machinePiece;
    }

    public static void main(String[] args) {
      /*  for (int i = 0; i <20 ; i++) {
            System.out.println(SnowFlake.nextId());
        }*/
        System.out.println("8007104296010170368".length());
    }
}
