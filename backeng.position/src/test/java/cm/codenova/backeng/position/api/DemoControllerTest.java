package cm.codenova.backeng.position.api;

import cm.codenova.backeng.position.service.DemoService;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
class DemoControllerTest {
    @InjectMocks
    private DemoService demoService;
}