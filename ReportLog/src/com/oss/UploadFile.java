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
		
		// endpoint�Ժ���Ϊ��������region�밴ʵ�������д
		String endpoint = "http://oss-cn-hangzhou.aliyuncs.com";
		// ���˺�AccessKey������API����Ȩ�ޣ�������ѭ�����ư�ȫ���ʵ����������ʹ��RAM���˺Ž���API���ʻ��ճ���ά�����¼ https://ram.console.aliyun.com ����
		String accessKeyId = "LTAIvETwxcl6quSD";
		String accessKeySecret = "pqJumGAl5tggZk2bzecRbAuFlWUxyA";
		// ����OSSClientʵ��
		OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
		// �ϴ��ļ���
		InputStream inputStream = null;
		try {
			inputStream = new FileInputStream(filePath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String keyName = key;
		ossClient.putObject("ulinieserverlog", keyName, inputStream);
		// �ر�client
		ossClient.shutdown();
	}
}
