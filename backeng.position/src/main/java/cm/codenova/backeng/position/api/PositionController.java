package cm.codenova.backeng.position.api;

import cm.codenova.backeng.position.demo.dto.PositionDTO;
import cm.codenova.backeng.position.service.PositionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class PositionController implements PositionApi {
    private final PositionService positionService;

    @Override
    public ResponseEntity<UUID> positionPost(PositionDTO positionDTO) {
        return ResponseEntity.ok(positionService.createPosition(positionDTO));
    }
}
