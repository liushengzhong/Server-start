package org.tensorflow.bridge;

import java.util.*;
import org.tensorflow.distruntime.*;

/**
 * Created by intel on 16-12-13.
 */
public class ClusterSpec {

    ClusterDef cluster_def;
    Map<String,Map<Integer,String>> cluster_spec;  // job_name task_index  address

    public ClusterSpec(Map<String,List<String>> cluster)  //cluster: job name --> address list    map
    {
        cluster_spec=new HashMap<String, Map<Integer,String>>();
        Iterator iter = cluster.entrySet().iterator();
        Integer i=0;
        while (iter.hasNext())
        {
            Map.Entry entry= (Map.Entry) iter.next();
            String key = (String) entry.getKey();
            ArrayList<String> value = (ArrayList<String>)entry.getValue();
            Map<Integer,String>job_tasks=new HashMap<Integer, String>();
            i=0;
            Iterator iter_address = value.iterator();
            while (iter_address.hasNext())
            {
                job_tasks.put(i, (String)iter_address.next());
                i++;
            }
            cluster_spec.put(key, job_tasks);
        }
        this.make_cluster_def();
    }

    //Create a ClusterDef based on the given cluster_spec
    public void make_cluster_def()
    {
        Map<Integer,String> tasks;
        int taskIndex;
        String address;

        ClusterDef.Builder cluster_def_builder=ClusterDef.newBuilder();
        JobDef.Builder job_builder;
        JobDef job;

        Collection<String> jobSet= cluster_spec.keySet();
        List<String> jobList = new ArrayList<String>(jobSet);  //list就是一个job name的list
        Collections.sort(jobList);  //sort the key of cluster_spec

        for (int i=0;i<jobList.size();i++)
        {
            job_builder=JobDef.newBuilder();
            job_builder.setName(jobList.get(i));  //得到第i个job的name
            tasks=cluster_spec.get(jobList.get(i));  //第i个job对应的task的一个map, taskIndex-->address

            Collection<Integer> taskIndexSet= tasks.keySet();
            List<Integer> taskIndexList = new ArrayList<Integer>(taskIndexSet);
            Collections.sort(taskIndexList);  //sort the index of tasks
            for (int j=0;j<taskIndexList.size();j++)
            {
                taskIndex=taskIndexList.get(j);
                address=tasks.get(taskIndex);
                job_builder.putTasks(taskIndex,address);  //把taskIndex和对应的address放到job_builder里面
            }
            job=job_builder.build();
            cluster_def_builder.addJob(job);
        }

        cluster_def=cluster_def_builder.build();
    }

    //Judge whether the cluster is empty
    public boolean nonzero()
    {
        return cluster_def.isInitialized();
    }

    //Judge whether two cluster specs equal to each other
    public boolean equals(ClusterSpec other)
    {
        return cluster_def.equals(other.cluster_def);
    }

    //Return the ClusterDef property
    public ClusterDef as_cluster_def()
    {
        return cluster_def;
    }


}
