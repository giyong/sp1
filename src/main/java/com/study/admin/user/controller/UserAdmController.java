package com.study.admin.user.controller;

import java.text.BreakIterator;
import java.util.Locale;

import org.apache.commons.lang3.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 어드민 사용자
 */
@Controller
public class UserAdmController {
	
    /**
     * 구글 API 클라이언트 ID
     */
    @Value("${gapi.client.id}")
    private String gapiClientId;
	
    @RequestMapping("/admin/user/loginForm")
    public String loginForm(Model model) {
    	
    	model.addAttribute("gapiClientId", gapiClientId);
    	
        return "admin/user/loginForm";
    }
    
    public static void main(String[] args) {
    	System.out.println(StringEscapeUtils.escapeJava("🐂 "));

    	final String text = "11한글\ud83d\udc02\ud83d\udc02";
        
    	System.out.println(text.substring(2, 3));
        
//        final Locale locale = new Locale("hi","IN");
//        final BreakIterator breaker = BreakIterator.getCharacterInstance(locale);
        final BreakIterator breaker = BreakIterator.getCharacterInstance();
        breaker.setText(text);
        int start = breaker.first();
        
        int count = 0;
        
        for (int end = breaker.next(); end != BreakIterator.DONE; start = end, end = breaker.next()) {

//        	System.out.println("start:" + start + "end:" + end);
        	count++;
        	System.out.println(count);
        	
            if (count == 5) {
            
            	System.out.println("for : " + text.substring(0, end));
            	break;
            }
        }
        
//        BreakIterator it = BreakIterator.getCharacterInstance(); 
//        it.setText(text); 
//        int count = 0; 
//        while (it.next() != BreakIterator.DONE) { 
//            count++; 
//        }
//        
//        System.out.println(count);
	}

}
