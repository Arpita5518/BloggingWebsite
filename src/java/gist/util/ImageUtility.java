package gist.util;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.commons.fileupload.*;
import org.apache.commons.fileupload.disk.*;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


public class ImageUtility {
    public static String uploadImage(HttpServletRequest request,ServletConfig config,String imgFolder){
         String pic=null;
        try {

            String ImgFile = "";
            String imgName = "";
           
             boolean isMultipart = ServletFileUpload.isMultipartContent(request);
            if (!isMultipart) {
                System.out.println(1);
            } else {
                FileItemFactory factory = new DiskFileItemFactory();
                ServletFileUpload upload = new ServletFileUpload(factory);
                List items = null;
                try {
                    items = upload.parseRequest(request);
                } catch (FileUploadException e) {
                    System.out.println("file upload error : "+ e.getMessage());
                }

                Iterator itr = items.iterator();
                while (itr.hasNext()) {
                    FileItem item = (FileItem) itr.next();
                     if(!item.isFormField()) {
                        try {
                            imgName = item.getName();
                            System.out.println(imgName);
                            File savedFile = new File(config.getServletContext().getRealPath("/") + imgFolder + "/" + imgName);
                            item.write(savedFile);
                            pic = imgFolder+ "/"+imgName;
                           } catch (Exception e) {
                            System.out.println("Error  " + e.getMessage());
                            System.out.println(e.getMessage());
                        }
                    }
                }
                
                 
                }
                 
            }catch(Exception e){
                System.out.println("Error "+e.getMessage());
            }
        return pic;
    }
}
