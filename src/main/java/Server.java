import org.tensorflow.framework.*;
import org.tensorflow.distruntime.*;

/**
 * Created by intel on 16-12-13.
 */


public class Server {

    public ServerDef server_def;

    public ClusterSpec cluster_spec;
    public String job_name;
    public int task_index;
    public ConfigProto config;
    public String protocol;

    public Server(ClusterSpec cluster_spec, String job_name, int task_index)
    {

    }

    public void make_server_def(ClusterSpec cluster_spec, String job_name, int task_index, ConfigProto config, String protocol)
    {

    }

    public void make_server_def(ClusterSpec cluster_spec, String job_name, int task_index)//参数不全时候的包装函数
    {
        make_server_def(cluster_spec, job_name, task_index, org.tensorflow.framework.ConfigProto.getDefaultInstance(), "grpc");
    }

    public void start()
    {

    }

    public void join()
    {

    }


    public static void main(String args[])
    {
        System.out.println("hello!");
    }
}