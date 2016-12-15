import org.tensorflow.framework.*;
import org.tensorflow.distruntime.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by intel on 16-12-13.
 */


public class Server {

    public ServerDef server_def;
    public ServerInterface server;
    public ClusterSpec cluster_spec;
    public String job_name;
    public int task_index;
    public ConfigProto config;
    public String protocol;

    public Server(ClusterSpec cluster_spec, String job_name, int task_index) //传进来的本身就是一个ClusterSpec类的对象，里面有ClusterDef的成员对象
    {
        server_def=make_server_def(cluster_spec,job_name,task_index);
        server=Server_New(server_def);

        //启动服务器
        this.start();

    }

    public static ServerDef make_server_def(ClusterSpec cluster_spec, String job_name, int task_index, ConfigProto config, String protocol)
    {

        ServerDef.Builder server_def_builder = ServerDef.newBuilder();
        server_def_builder.setJobName(job_name);
        server_def_builder.setTaskIndex(task_index);
        server_def_builder.setProtocol(protocol);
        server_def_builder.setDefaultSessionConfig(config);
        ServerDef server_def=server_def_builder.build();
        return server_def;

    }

    public static ServerDef make_server_def(ClusterSpec cluster_spec, String job_name, int task_index)//参数不全时候的包装函数
    {
        return make_server_def(cluster_spec, job_name, task_index, org.tensorflow.framework.ConfigProto.getDefaultInstance(), "grpc");
    }

    public void start()
    {
        Server_Start(server);
    }

    public void join()
    {
        Server_Join(server);

    }

    public ServerDef server_def()
    {
        return server_def;
    }

    public String target()
    {
        return server.target();
    }

    public Server create_local_server()
    {
        HashMap<String,List<String>> cluster=new HashMap<String,List<String>>();
        List<String> address_list=new ArrayList<String>();
        address_list.add("localhost:0");
        cluster.put("local",address_list);
        ClusterSpec cluster_spec=new ClusterSpec(cluster);
        return new Server(cluster_spec, "worker", 0);
    }

    public static native ServerInterface Server_New(ServerDef server_def);

    public static native void Server_Start(ServerInterface in_server);

    public static native void Server_Stop(ServerInterface in_server);

    public static native void Server_Join(ServerInterface in_server);

    public static void main(String args[])
    {
        System.out.println("hello!");
    }
}