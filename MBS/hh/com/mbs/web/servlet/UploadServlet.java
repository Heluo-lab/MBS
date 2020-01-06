package com.mbs.web.servlet;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.mbs.dto.UsersInfo;

/**
 * 用户文件上传servlet
 */
@WebServlet("/upload")
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.setCharacterEncoding("UTF-8");
		try {
			//接受上传文件
			//1、创建磁盘文件项工厂
			DiskFileItemFactory factory = new DiskFileItemFactory();
			//2、创建文件上传的核心类
			ServletFileUpload upload = new ServletFileUpload(factory);
			//3、解析request---获得文件项集合
			List<FileItem> parseRequest = upload.parseRequest(request);
			upload.setHeaderEncoding("UTF-8");
			HttpSession session = request.getSession();
			UsersInfo usersInfo = (UsersInfo)session.getAttribute("usersInfo");
			//UsersInfo usersInfo = new UsersInfo();
			Class clz = usersInfo.getClass();
			String fileName = null;
			//4、遍历文件项集合
			for(FileItem item : parseRequest){
				//5、判断普通表单项/文件上传项
				boolean formField = item.isFormField();//是否是一个普通表单项
				if(formField){
					//普通表单项
					String fieldName = item.getFieldName();
					String fieldValue = item.getString("UTF-8");
					Field field = clz.getDeclaredField((fieldName));
					field.setAccessible(true);
					field.set(usersInfo, fieldValue);
					System.out.println(fieldName+":"+fieldValue);
				}else{
					try {
						//文件上传项
						//获得上传文件的名称
						fileName = item.getName();
//						System.out.println(fileName+"===");
						//clz.getDeclaredField("");
						//获得上传文件的内容
						InputStream in = item.getInputStream();
						//将in中的数据拷贝服务器上
						String path = this.getServletContext().getRealPath("headPic");
						OutputStream out = new FileOutputStream(path+"/"+fileName);
						int len = 0;
						byte[] buffer = new byte[1024];
						while((len=in.read(buffer))>0){
							out.write(buffer, 0, len);
						}
						usersInfo.setUsersPic("headPic/"+fileName+new Date().getTime());
						in.close();
						out.close();
					} catch (Exception e) {
						//usersInfo.setUsersPic("headPic/"+fileName+new Date().getTime());
					}
				}
			}
			System.out.println(usersInfo);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
