package com.kafka.producer;

import java.util.Map;
import java.util.Random;

import org.apache.kafka.clients.producer.Partitioner;

/**
 * 自定义分区（新API）
 */
import org.apache.kafka.common.Cluster;

public class CustomPartitioner implements Partitioner {

	static Random ran = new Random();

	public void configure(Map<String, ?> configs) {

	}

	public int partition(String topic, Object key, byte[] keyBytes, Object value, byte[] valueBytes, Cluster cluster) {
		// 控制分区
		int i = ran.nextInt(2);
		return i;
	}

	public static void main(String[] args) {

		for (int i = 0; i < 10; i++) {
			System.out.println(ran.nextInt(2));
		}
	}

	public void close() {

	}
}