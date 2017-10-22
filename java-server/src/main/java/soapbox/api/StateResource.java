package soapbox.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/state")
public class StateResource {

    @RequestMapping("/getAll")
    public List<String> getAll() {
        return new ArrayList<>();
    }
}