package org.gradle.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.sun.javafx.collections.MappingChange.Map;



@RestController
@RequestMapping("/file")
public class FileController {
    @RequestMapping(value = "/upload", produces = { "application/json" }, method =RequestMethod.POST )
    public  String upload(
    //@RequestParam(value="files",required=false) MultipartFile[] files,
    @RequestParam(value = "test", required = true) boolean test,
    HttpServletRequest request){
    	//MultipartFile[] files = null;
    	// boolean test=false;
    	 System.out.println(test);
    	 MultipartHttpServletRequest multipartRequest = null;
    	 if (request instanceof MultipartHttpServletRequest) {
    		 multipartRequest = (MultipartHttpServletRequest) request;
		}
    	 if (multipartRequest!=null) {
			//Map<String, MultipartFile>map=(Map<String, MultipartFile>) multipartRequest.getFileMap();
    		Set<String> fList=multipartRequest.getFileMap().keySet();
    		for (String string : fList) {
    			MultipartFile file=multipartRequest.getFileMap().get(string);
        		SavedFile(file, "/Users/zhangpeng/workspace_gradle/SpringBootAugularJs/src/main/resources/files/"+file.getOriginalFilename());
			}
		}
    //这里的logo就是接受的文件了
   /* if(files!=null){
       //进行操作吧
    	for (MultipartFile file : files) {
    		System.out.println(file.getOriginalFilename());
    		SavedFile(file, "/Users/zhangpeng/workspace_gradle/SpringBootAugularJs/src/main/resources/files/"+file.getOriginalFilename());
		}
    }*/
    return "success";
   }

	private void SavedFile(MultipartFile file,String filePath) {
		try {
			File path = new File(filePath);
			System.out.println(path.getPath());
			/*if (!path.getParentFile().exists()) {
				path.mkdirs();
			}*/
			file.transferTo(path);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
    
	 /* @RequestMapping(method = RequestMethod.GET, value = "/sample/download")
	    public void handleCreditRequestDownload(HttpServletResponse response ) throws Exception {
	        
	       
	        byte[] cr = getBytes();
	        response.setContentType("application/octet-stream");
	        response.setContentLength(cr.length);
	        response.setHeader("Content-Disposition","attachment; filename=\"download.csv\"");
	    
	        ServletOutputStream ros = response.getOutputStream();       
	        ros.write(cr);
	        ros.flush();
	        
	    }*/
	
	@RequestMapping(value = "/download",method = RequestMethod.GET)
    public void accountFile(HttpServletResponse response) throws URISyntaxException {
        File file = new File("/Users/zhangpeng/workspace_gradle/SpringBootAugularJs/src/main/resources/files/2012年经典菜谱家常菜.doc");
        if(file != null) {
            response.reset();
            FileInputStream fs = null;
            OutputStream os = null;
            try {
                response.setHeader("Content-Disposition","attachment; filename=" + URLEncoder.encode(file.getName(), "utf-8"));
                response.setContentType("application/octet-stream;charset=GBK");
                fs = new FileInputStream(file.getPath());
                os = new BufferedOutputStream(response.getOutputStream());
                int len = 0;
                byte[] b = new byte[1024];
                while ((len = fs.read(b)) > 0) {
                    os.write(b, 0, len);
                }
                fs.close();
                os.flush();
                os.close();
            }catch(Exception ex) {
                ex.printStackTrace();
            }finally {
                 try {
                     if(fs != null) {
                         fs.close();
                     }
                     if(os != null) {
                         os.close();
                     }
                 }catch (IOException e) {
                     e.printStackTrace();
                 }
             }
        }
   }
    
}
