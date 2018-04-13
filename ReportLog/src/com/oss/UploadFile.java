package com.oss;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import com.aliyun.oss.OSSClient;

public class UploadFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static void UploadFileToOSS(String key, String filePath){
		
		// endpoint以杭州为例，其它region请按实际情况填写
		String endpoint = "http://oss-cn-hangzhou.aliyuncs.com";
		// 云账号AccessKey有所有API访问权限，建议遵循阿里云安全最佳实践，创建并使用RAM子账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建
		String accessKeyId = "LTAIvETwxcl6quSD";
		String accessKeySecret = "pqJumGAl5tggZk2bzecRbAuFlWUxyA";
		// 创建OSSClient实例
		OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
		// 上传文件流
		InputStream inputStream = null;
		try {
			inputStream = new FileInputStream(filePath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String keyName = key;
		ossClient.putObject("ulinieserverlog", keyName, inputStream);
		// 关闭client
		ossClient.shutdown();
	}
}
