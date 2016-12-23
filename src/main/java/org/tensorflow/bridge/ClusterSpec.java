package org.tensorflow.bridge;

import org.tensorflow.distruntime.ClusterDef;
import org.tensorflow.distruntime.JobDef;

import java.util.*;

/**
 * Created by Shengzhong Liu on 16-12-13.
 */
public class ClusterSpec extends Object{

    private ClusterDef clusterDef;
    private Map<String, Map<Integer, String>> clusterSpec;  // jobName taskIndex  address

    public ClusterSpec(Map<String, List<String>> cluster)  //cluster: job name --> address list map
    {
        clusterSpec = new HashMap<String, Map<Integer, String>>();
        Iterator iter = cluster.entrySet().iterator();
        Integer i = 0;
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            String key = (String) entry.getKey();
            ArrayList<String> value = (ArrayList<String>) entry.getValue();
            Map<Integer, String> jobTasks = new HashMap<Integer, String>();
            i = 0;
            Iterator iterAddress = value.iterator();
            while (iterAddress.hasNext()) {
                jobTasks.put(i, (String) iterAddress.next());
                i++;
            }
            clusterSpec.put(key, jobTasks);
        }
        this.makeClusterDef();
    }

    /**
     * Create a ClusterDef based on the given clusterSpec
     */
    private void makeClusterDef() {
        Map<Integer, String> tasks;
        int taskIndex;
        String address;

        ClusterDef.Builder clusterDefBuilder = ClusterDef.newBuilder();
        JobDef.Builder jobBuilder;
        JobDef job;

        Collection<String> jobSet = clusterSpec.keySet();
        List<String> jobList = new ArrayList<String>(jobSet);  //a list of job names
        Collections.sort(jobList);  //sort the key of clusterSpec

        for (int i = 0; i < jobList.size(); i++) {
            jobBuilder = JobDef.newBuilder();
            jobBuilder.setName(jobList.get(i));  //get the name of the i-th job
            tasks = clusterSpec.get(jobList.get(i));  //the map corresponding to the i-th job, taskIndex-->address

            Collection<Integer> taskIndexSet = tasks.keySet();
            List<Integer> taskIndexList = new ArrayList<Integer>(taskIndexSet);
            Collections.sort(taskIndexList);  //sort the index of tasks
            for (int j = 0; j < taskIndexList.size(); j++) {
                taskIndex = taskIndexList.get(j);
                address = tasks.get(taskIndex);
                jobBuilder.putTasks(taskIndex, address); //put the taskIndex and its address into the jobBuilder
            }
            job = jobBuilder.build();
            clusterDefBuilder.addJob(job);
        }

        clusterDef = clusterDefBuilder.build();
    }

    /**
     * Judge whether the cluster is empty
     */
    public boolean nonZero() {
        return clusterDef.isInitialized();
    }

    /**
     * Judge whether two cluster specs equal to each other
     */
    @Override
    public boolean equals(Object other) {
        ClusterSpec otherSpec = (ClusterSpec) other;
        return clusterDef.equals(otherSpec.clusterDef);
    }

    /**
     * return a map from job names to their tasks(as the list form)
     */
    public Map<String, List<String>> asDict() {
        Map<String, List<String>> jobTasksMap = new HashMap<String, List<String>>();
        String jobName;
        List<String> jobs = this.jobs();
        for (int i = 0; i < jobs.size(); i++) {
            jobName = jobs.get(i);
            List<Integer> taskIndices = this.taskIndices(jobName);
            if (Collections.max(taskIndices) + 1 == taskIndices.size()) //the tasks indices are dense
            {
                jobTasksMap.put(jobName, this.jobTasks(jobName));
            } else //the tasks indices are not dense, manually make the list dense
            {
                List<String> tasks = new ArrayList<String>();
                Integer taskIndex;
                for (int j = 0; j < taskIndices.size(); j++) {
                    taskIndex = taskIndices.get(j);
                    tasks.add(this.taskAddress(jobName, taskIndex));

                }
            }
        }
        return jobTasksMap;
    }

    /**
     * return the list consisting of all the jobs
     */
    public List<String> jobs() {
        Collection<String> jobSet = clusterSpec.keySet();
        List<String> jobList = new ArrayList<String>(jobSet);
        return jobList;
    }

    /**
     * return the number of tasks defined in the given job
     */
    public int numTasks(String jobName) {
        return clusterSpec.get(jobName).keySet().size();
    }

    /**
     * return a list of valid task indices in the given job
     */
    public List<Integer> taskIndices(String jobName) {
        Collection<Integer> taskIndexSet = clusterSpec.get(jobName).keySet();
        List<Integer> taskIndexList = new ArrayList<Integer>(taskIndexSet);
        return taskIndexList;
    }

    /**
     * return the address of the given task in the given job
     */
    public String taskAddress(String jobName, Integer taskIndex) {
        Map<Integer, String> job = clusterSpec.get(jobName);
        return job.get(taskIndex);
    }

    /**
     * return a list of tasks addresses, where the index in the list corresponds to the task index of each task
     */
    public List<String> jobTasks(String jobName) {
        Map<Integer, String> job = clusterSpec.get(jobName);
        List<String> addressList = new ArrayList<String>(job.size() + 1);

        Collection<Integer> taskIndexSet = job.keySet();
        List<Integer> taskIndexList = new ArrayList<Integer>(taskIndexSet);
        Collections.sort(taskIndexList);  //sort the index of tasks
        int taskIndex;
        String address;
        for (int j = 0; j < taskIndexList.size(); j++) {
            taskIndex = taskIndexList.get(j);
            address = job.get(taskIndex);
            //addressList.set(taskIndex,address);
            addressList.add(address);
        }
        return addressList;
    }

    /**
     * Return the ClusterDef property
     */
    public ClusterDef asClusterDef() {
        return clusterDef;
    }


}
