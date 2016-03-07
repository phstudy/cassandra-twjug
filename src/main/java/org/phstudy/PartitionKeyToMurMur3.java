package org.phstudy;

import org.apache.cassandra.db.DecoratedKey;
import org.apache.cassandra.db.marshal.UTF8Type;
import org.apache.cassandra.dht.Murmur3Partitioner;

public class PartitionKeyToMurMur3 {
    private static Murmur3Partitioner partitioner = new Murmur3Partitioner();

    public static void main(String[] args) {
        String partitionKey = "abc";
        DecoratedKey decoratedKey = partitioner.decorateKey(UTF8Type.instance.fromString(partitionKey));
        System.out.println(String.format("Partition Key[%s]的Token值=%s", partitionKey, decoratedKey.getToken())); // -5434086359492102041

        partitionKey = "twjug";
        decoratedKey = partitioner.decorateKey(UTF8Type.instance.fromString(partitionKey));
        System.out.println(String.format("Partition Key[%s]的Token值=%s", partitionKey, decoratedKey.getToken())); // -7366555337019518207

        System.out.println();
        System.out.println("Murmur3 Token的最小值=" + Murmur3Partitioner.MINIMUM); // -9223372036854775808
        System.out.println("Murmur3 Token的最大值=" + Murmur3Partitioner.MAXIMUM); // 9223372036854775807
    }
}
