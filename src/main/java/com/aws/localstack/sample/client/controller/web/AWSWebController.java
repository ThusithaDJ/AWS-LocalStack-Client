package com.aws.localstack.sample.client.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aws.localstack.sample.client.service.SQSListenerService;

@Controller
public class AWSWebController {

	@RequestMapping(value = "/index")
	public String index(Model model) {
		model.addAttribute("messages", SQSListenerService.messges);
		return "index";
	}
}
