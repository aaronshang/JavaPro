package com.main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.oss.UploadFile;

public class MainFrame {

	JTextField descTextField;
	JFrame groundFrame;
	String currentPath;
	String logPath;
	String timestr;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("begin to upload.");
	
		MainFrame mainFrame = new MainFrame();
		mainFrame.LoadMainFrame();
	}
	
	public void LoadMainFrame(){
		
		//获取当前目录
		currentPath = System.getProperty("user.dir");
		System.out.println(currentPath);
		
		logPath = currentPath.concat("/Core/Debug");
		System.out.println("log path: "+logPath);
		
		groundFrame = new JFrame("日志上传工具");
		groundFrame.setSize(600, 150);
		groundFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		groundFrame.setLayout(new BorderLayout());
		groundFrame.setResizable(false);
		groundFrame.setLocationRelativeTo(null);
		
		groundFrame.setLayout(new BorderLayout());
		
		LoadTextField();
		LoadUploadButton();
		groundFrame.setVisible(true);		
	}
	
	public void LoadTextField(){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");//设置日期格式
		timestr = df.format(new Date(System.currentTimeMillis()));// new Date()为获取当前系统时间，也可使用当前时间戳
		
		JPanel panel = new JPanel();
		
		JLabel timeStr = new JLabel();
		timeStr.setText(timestr);
		

		JLabel nameLabel = new JLabel();
		nameLabel.setText("请输入描述信息：");
		
		descTextField = new JTextField("");
		descTextField.setPreferredSize(new Dimension(220, 30));
		
		FlowLayout flow = new FlowLayout();
		panel.add(timeStr, flow);
		panel.add(nameLabel, flow);
		panel.add(descTextField, flow);
		
		groundFrame.add(panel, BorderLayout.NORTH);
	}
	
	public void LoadUploadButton(){
		
		JPanel panel = new JPanel();
		JButton btnUpload = new JButton("上传");
		panel.add(btnUpload, null);
		groundFrame.add(panel, BorderLayout.CENTER);
		
		btnUpload.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				String zipName = timestr+"-"+descTextField.getText()+".zip";
				String pathName = currentPath.concat("/").concat(zipName);
				createZip(logPath, pathName);
				
				UploadFile.UploadFileToOSS(zipName, pathName);
				
				JOptionPane.showMessageDialog(null, "日志上传成功", "您好", JOptionPane.INFORMATION_MESSAGE);
			}
			
		});
	}
	
    public static void createZip(String sourcePath, String zipPath) {  
        FileOutputStream fos = null;  
        ZipOutputStream zos = null;  
        try {  
            fos = new FileOutputStream(zipPath);  
            zos = new ZipOutputStream(fos);  
  
            writeZip(new File(sourcePath), "", zos);  
        } catch (FileNotFoundException e) {  

        } finally {  
            try {  
                if (zos != null) {  
                    zos.close();  
                }  
            } catch (IOException e) {  
            }  
  
        }  
    } 
    
    private static void writeZip(File file, String parentPath, ZipOutputStream zos) {  
        if(file.exists()){  
            if(file.isDirectory()){//处理文件夹  
                parentPath+=file.getName()+File.separator;  
                File [] files=file.listFiles();  
                if(files.length != 0)  
                {  
                    for(File f:files){  
                        writeZip(f, parentPath, zos);  
                    }  
                }  
                else  
                {       //空目录则创建当前目录  
                        try {  
                            zos.putNextEntry(new ZipEntry(parentPath));  
                        } catch (IOException e) {  
                            // TODO Auto-generated catch block  
                            e.printStackTrace();  
                        }  
                }  
            }else{  
                FileInputStream fis=null;  
                try {  
                    fis=new FileInputStream(file);  
                    ZipEntry ze = new ZipEntry(parentPath + file.getName());  
                    zos.putNextEntry(ze);  
                    byte [] content=new byte[1024];  
                    int len;  
                    while((len=fis.read(content))!=-1){  
                        zos.write(content,0,len);  
                        zos.flush();  
                    }  
  
                } catch (FileNotFoundException e) {  
                   
                } catch (IOException e) {  
               
                }finally{  
                    try {  
                        if(fis!=null){  
                            fis.close();  
                        }  
                    }catch(IOException e){   
                    }  
                }  
            }  
        }  
    }   

}
