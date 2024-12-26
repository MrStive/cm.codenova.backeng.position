package cm.codenova.backeng.position.api;

import cm.codenova.backeng.position.demo.dto.DemoDTO;
import cm.codenova.backeng.position.service.DemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequiredArgsConstructor
public class DemoController implements DemoApi {
    private final DemoService demoService;
    @Override
    public ResponseEntity<List<DemoDTO>> fetchAllDemo(String fieldsToExtractCode) {
        return ResponseEntity.ok().body(demoService.fetchAllDemos());
    }
}
