package com.google.ios;

import java.io.File;

/**
 * 批量修改文件名称
 */
public class ModifyFileName {

	public static void main(String[] args) {

		String path = "F:\\BaiduNetdiskDownload\\33-算法通关40讲\\41-54";
		File fileList = new File(path);
		File[] files = fileList.listFiles();
		if (fileList.exists() && fileList.isDirectory()) {
			for(File file:files) {

				String fileName = file.getName();
				File oldFile = new File(path+File.separatorChar+fileName);
				System.out.println("oldName："+fileName);
				if(fileName.contains("XXX")) {
					fileName = fileName.replace("XXX", "");
				}
				System.out.println("newName："+fileName);
				File newFile = new File(path+File.separatorChar+fileName);
				oldFile.renameTo(newFile);
			}
		}
	}

}
