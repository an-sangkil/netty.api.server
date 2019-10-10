package com.netty.api.aerospike.client;

import com.aerospike.client.AerospikeClient;
import com.aerospike.client.policy.WritePolicy;
import org.junit.Test;

/**
 * <pre>
 * Description :
 * @author mezzomedia
 * @since 2018.05.11
 * @version
 *
 * Copyright (C) 2018 by Mezzomedia.Inc. All right reserved.
 */
public class AerospikeDummyData {

    @Test
    public void sampleDateInsert () {
        AerospikeClient client = new AerospikeClient("210.221.235.202",3000);

        // Initialize policy.
        WritePolicy policy = new WritePolicy();
        policy.setTimeout(50);// 50 millisecond timeout


        //client.put();



    }
}
