package com.osyunge2.fastdfs;

import com.osyunge.utils.FastDFSClient;
import org.csource.fastdfs.*;
import org.junit.Test;


public class TestFastDFS {
    @Test
    public void testUploadFile() throws Exception {
        //1.把FastDFS 提供的jar包添加到工程中
        //2.初始化全局配置。加载一个配置文件。
        //E:\WebPorjectFile\wl-itmuch-manager\wl-itmuch-manager-web\src\main\resources\properties
        ClientGlobal.init("E:\\WebPorjectFile\\wl-itmuch-manager\\wl-itmuch-manager-web\\src\\main\\resources\\properties\\client.conf");
        //3.创建一个TrackerClient对象
        TrackerClient trackerClient = new TrackerClient();
        //4.创建一个TrackerServer对象。
        TrackerServer trackerServer = trackerClient.getConnection();
        //5.声明一个StorageServer 对象,null
        StorageServer storageServer = null;
        //6.获得StorageClient对象
        StorageClient storageClient = new StorageClient(trackerServer,storageServer);
        //7.直接调用 StorageClient 对象方法上传文件即可。
        //"E:\\aaa.jpg","jpg","null"
        String[] strings = storageClient.upload_file("E:\\p\\aaa.jpg","jpg",null);
        for (String string:strings){
            System.out.println(string);
        }
    }

    @Test
    public void testUploadFileUtil() throws Exception {
        FastDFSClient client = new FastDFSClient("E:\\WebPorjectFile\\wl-itmuch-manager\\wl-itmuch-manager-web\\src\\main\\resources\\properties\\client.conf");
        String jpg = client.uploadFile("E:\\p\\aaa.jpg", "jpg");
        System.out.println(jpg);
    }
}
