package org.tensorflow.bridge;

import java.util.*;

/**
 * Created by intel on 16-12-20.
 */
public class Server_Test {

    public static void main(String args[])
    {
        Map<String,List<String>> cluster_spec_test=new HashMap<String, List<String>>();
        String job_name1,job_name2;
        List<String> addresses1=new ArrayList<String>();
        List<String> addresses2=new ArrayList<String>();

        job_name1="worker";
        addresses1.add("intel-XPS-8900:2222");
        addresses1.add("intel-XPS-8900:2223");
        cluster_spec_test.put(job_name1,addresses1);

        job_name2="ps";
        addresses2.add("intel-XPS-8900:2224");
        cluster_spec_test.put(job_name2,addresses2);

        ClusterSpec cluster=new ClusterSpec(cluster_spec_test);

        //System.out.println(cluster.nonzero());//pass

        //System.out.println(cluster.num_tasks("worker"));//pass

        //System.out.println(cluster.jobs()); //pass

        //System.out.println(cluster.task_indices("worker")); //pass

        //System.out.println(cluster.task_address("worker",1)); //pass

        //System.out.println(cluster.job_tasks("worker")); //pass

        //System.out.println(cluster.as_dict()); //pass

        System.out.println(cluster.cluster_def);

        System.out.println("hello!");
    }
}
