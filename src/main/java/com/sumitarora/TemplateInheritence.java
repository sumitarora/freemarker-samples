package com.sumitarora;

import java.io.File;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;

/**
 * Template Inheritence without any data.
 */
public class TemplateInheritence 
{
    public static void main( String[] args )
    {
        Map root = new HashMap();
        root.put("user", "Sumit Arora");
        
        Configuration cfg = new Configuration();
        try {
        	final String current = new java.io.File( "" ).getCanonicalPath() + "\\target\\classes\\templates";
        	cfg.setDirectoryForTemplateLoading(new File(current));
        	final Template temp = cfg.getTemplate("inherit.ftl");
        	Writer out = new StringWriter();
        	temp.process(root, out);
        	System.out.println(out);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
        cfg.setObjectWrapper(new DefaultObjectWrapper());  
    }
}
