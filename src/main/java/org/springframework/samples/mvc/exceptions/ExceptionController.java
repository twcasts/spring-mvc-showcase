package org.springframework.samples.mvc.exceptions;

import java.util.concurrent.Callable;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ExceptionController {

	@RequestMapping("/exception")
	public @ResponseBody Callable<String> exception() {

		return new Callable<String>() {
			public String call() throws Exception {

				// Do some work..
				Thread.sleep(2000L);

				throw new IllegalStateException("Sorry!");
			}
		};
	}

	@ExceptionHandler
	public @ResponseBody String handle(IllegalStateException e) {
		return "IllegalStateException handled!";
	}

}
