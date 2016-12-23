package org.tensorflow.bridge;

import java.io.IOException;
import java.util.*;

/**
 * Created by intel on 16-12-20.
 */
public class Server_Test {

    public static void main(String args[]) throws IOException {
        Map<String,List<String>> clusterSpecTest=new HashMap<String, List<String>>();
        String jobName1,jobName2;
        List<String> addresses1=new ArrayList<String>();
        List<String> addresses2=new ArrayList<String>();

        jobName1="worker";
        addresses1.add("intel-XPS-8900:2222");
        addresses1.add("intel-XPS-8900:2223");
        clusterSpecTest.put(jobName1,addresses1);

        jobName2="ps";
        addresses2.add("intel-XPS-8900:2224");
        clusterSpecTest.put(jobName2,addresses2);

        ClusterSpec cluster=new ClusterSpec(clusterSpecTest);

        //System.out.println(cluster.nonzero());//pass

        System.out.println(cluster.numTasks("worker"));//pass

        //System.out.println(cluster.jobs()); //pass

        //System.out.println(cluster.taskIndices("worker")); //pass

        //System.out.println(cluster.taskAddress("worker",1)); //pass

        //System.out.println(cluster.jobTasks("worker")); //pass

        System.out.println(cluster.asDict()); //pass

        //System.out.println(cluster.asClusterDef()); //pass

        //Server server=Server.create_local_server();
        //System.out.println(server.server_def);

        System.out.println("hello!");
    }
}
