package org.springframework.samples.mvc.validation;

import java.util.concurrent.Callable;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ValidationController {

	// enforcement of constraints on the JavaBean arg require a JSR-303 provider on the classpath

	@RequestMapping("/validate")
	public @ResponseBody Object validate(@Valid JavaBean bean, BindingResult result) {
		if (result.hasErrors()) {
			return "Object has validation errors";
		} else {
			return new Callable<String>() {
				public String call() throws Exception {

					// Do some work..
					Thread.sleep(2000L);

					return "No errors";
				}
			};
		}
	}

}
