package cm.codenova.backeng.position.service;

import cm.codenova.backeng.position.demo.dto.DemoDTO;
import cm.codenova.backeng.position.repository.DemoSpringRepository;
import cm.codenova.backeng.position.service.mapper.DemoMapper;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DemoService {
  private final DemoMapper demoMapper;
  private final DemoSpringRepository demoSpringRepository;

  public List<DemoDTO> fetchAllDemos() {
    return demoSpringRepository.findAll().stream().map(demoMapper::mapToDemoDTO).toList();
  }
}
