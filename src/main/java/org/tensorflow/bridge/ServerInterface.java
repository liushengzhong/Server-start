package org.tensorflow.bridge;

/**
 * Created by intel on 16-12-15.
 */
public class ServerInterface {

    public ServerInterface()
    {

    }

    public String target()
    {
        String s = "grpc://localhost:" + "2222";   //port number
        return s;
    }
}
