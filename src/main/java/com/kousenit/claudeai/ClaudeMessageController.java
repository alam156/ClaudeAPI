package com.kousenit.claudeai;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/claude")
@RequiredArgsConstructor
public class ClaudeMessageController {
    @Autowired
    private final ClaudeService service;

    @PostMapping("/complete-response")
    public String getCertificateList(@RequestBody ClaudeRequest request) {
        return service.getClaudeResponse("",request.prompt(),request.model(), request.temperature());
    }

}
