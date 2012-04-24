package org.springframework.samples.mvc.fileupload;

import java.io.IOException;
import java.util.concurrent.Callable;

import org.springframework.mvc.extensions.ajax.AjaxUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/fileupload")
public class FileUploadController {

	@ModelAttribute
	public void ajaxAttribute(WebRequest request, Model model) {
		model.addAttribute("ajaxRequest", AjaxUtils.isAjaxRequest(request));
	}

	@RequestMapping(method=RequestMethod.GET)
	public void fileUploadForm() {
	}

	@RequestMapping(method=RequestMethod.POST)
	public Callable<Object> processUpload(final @RequestParam MultipartFile file, final Model model) throws IOException {

		return new Callable<Object>() {
			public Object call() throws Exception {

				// Process input file..
				Thread.sleep(3000L);

				model.addAttribute("message", "File '" + file.getOriginalFilename() + "' uploaded successfully");
				return null;
			}
		};
	}

}
