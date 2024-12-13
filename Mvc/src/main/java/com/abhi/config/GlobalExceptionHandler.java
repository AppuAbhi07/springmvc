package com.abhi.config;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.abhi.customexceptions.StudentsNotFoundExceptions;

@ControllerAdvice
public class GlobalExceptionHandler {

	// 404
	// 500
	/*
	 * Model ModelAndView->what will view..
	 * 
	 */

	@ExceptionHandler(StudentsNotFoundExceptions.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ModelAndView studentNotFoundException(Exception ex) {
		ModelAndView mav = new ModelAndView("error");
		mav.addObject("message", ex.getMessage());
		return mav;
	}

	@ExceptionHandler(Exception.class)
	public ModelAndView handleException(Exception ex) {
		ModelAndView mav = new ModelAndView("error");
		mav.addObject("message", ex.getMessage());
		return mav;
	}

}
