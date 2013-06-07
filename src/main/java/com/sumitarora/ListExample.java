package com.sumitarora;

import java.io.File;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;

/**
 * List sample getting started.
 */
public class ListExample 
{
    public static void main( String[] args )
    {
    	List<String> users = new ArrayList<String>();
    	users.add("Sumit Arora");
    	users.add("Sam Hans");
    	users.add("John Doe");
        
    	Map user = new HashMap();
      user.put("users", users);

      Configuration cfg = new Configuration();
      try {
        final String current = new java.io.File( "" ).getCanonicalPath() + "\\target\\classes\\templates";
        cfg.setDirectoryForTemplateLoading(new File(current));
        final Template temp = cfg.getTemplate("list.ftl");
        Writer out = new StringWriter();
        temp.process(users, out);
        System.out.println(out);
      } catch (Exception ex) {
        System.out.println(ex.getMessage());
      }
        cfg.setObjectWrapper(new DefaultObjectWrapper());  
    }
}

