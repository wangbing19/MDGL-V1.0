package com.md.sys.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/") 
@Controller
public class PageController{//类加载(将类读到内存)-->Class
	  public PageController() {
		 System.out.println("PageController");
	  }
	  
	  @RequestMapping("doIndexUI")
	  public String doIndexUI(){
		  return "starter";
	  }
	  
	  @RequestMapping("doLoginUI")
	  public String doLoginUI(){
		  return "login";
	  }
	  @RequestMapping("doNullUI")
	  public String doNullUI(){
		  return "starter2";
	  }
	  
	  @RequestMapping("doPageUI")
	  public String doPageUI(){
		  return "common/page";
	  }
	  
}
