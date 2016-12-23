package org.tensorflow.bridge;

import com.google.protobuf.CodedOutputStream;
import org.tensorflow.framework.*;
import org.tensorflow.distruntime.*;
import org.tensorflow.JNI.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Server {

    public ServerDef server_def;
    public ServerInterface server;   //这个类应该是从C++里面的ServerInterface类的对象


    public Server(ClusterSpec cluster_spec, String job_name, int task_index) throws IOException //传进来的本身就是一个ClusterSpec类的对象，里面有ClusterDef的成员对象
    {
        server_def=make_server_def(cluster_spec,job_name,task_index);

        ByteArrayOutputStream output= new ByteArrayOutputStream();
        server_def.writeTo(output);
        byte[] ByteArray=output.toByteArray();
        //long server_def_long=(long)ByteArray;  //怎么能转成SWIGTYPE_p_ServerDef类型的对象

        //server=Server_New(server_def);  //问题是怎么把server_def传进去给c++？

        //启动服务器
        this.start();

    }

    //create a ServerDef protocol buffer
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
        //Server_Start(server);
    }

    public void join()
    {
       // Server_Join(server);

    }

    //return the target for a 'tf.Session' to connect to this server
    //这个函数的最终目的，是要调到ServerInterface C++类里面的target函数
    public String target()
    {
        return server.target();
    }

    public ServerDef server_def()
    {
        return server_def;
    }


    public static Server create_local_server() throws IOException {
        HashMap<String,List<String>> cluster=new HashMap<String,List<String>>();
        List<String> address_list=new ArrayList<String>();
        address_list.add("localhost:0");
        cluster.put("local",address_list);
        ClusterSpec cluster_spec=new ClusterSpec(cluster);
        return new Server(cluster_spec, "local", 0);
    }

    //为了减少java和c++之间的对象互传，然后简化的函数版本
//    public static native void Server_New_and_Start(ServerDef server_def);
//
//    public static native ServerInterface Server_New(ServerDef server_def);
//
//    public static native void Server_Start(ServerInterface in_server);
//
//    public static native void Server_Stop(ServerInterface in_server);
//
//    public static native void Server_Join(ServerInterface in_server);


    public static void main(String args[])
    {
        System.out.println("hello!");
    }
}