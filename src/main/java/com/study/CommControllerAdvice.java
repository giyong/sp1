package com.study;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
public class CommControllerAdvice {

	@ResponseBody
    @ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handler(Exception e) {
    	
		Map<String, Object> resBody = new HashMap<>();
		resBody.put("code"   , "9999");
		resBody.put("message", e.getMessage());
		
		return new ResponseEntity<>(resBody, HttpStatus.INTERNAL_SERVER_ERROR);
	}

    /**
     * @valid  유효성체크에 통과하지 못하면  MethodArgumentNotValidException 이 발생한다.
     */
	@ResponseBody
    @ExceptionHandler(BindException.class)
    public ResponseEntity<Object> methodValidException(BindException e, HttpServletRequest request){
        
		ObjectError oe = e.getBindingResult().getAllErrors().get(0);
		
    	Map<String, Object> resBody = new HashMap<>();
    	resBody.put("code"   , "9999");
    	resBody.put("message", String.format("%s : %s", ((FieldError)oe).getField(), oe.getDefaultMessage()));        
    	
        return new ResponseEntity<>(resBody, HttpStatus.BAD_REQUEST);
    }
    
}
