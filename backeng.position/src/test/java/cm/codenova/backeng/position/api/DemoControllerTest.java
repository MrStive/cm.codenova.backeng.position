package cm.codenova.backeng.position.api;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import cm.codenova.backeng.position.demo.dto.DemoDTO;
import cm.codenova.backeng.position.service.DemoService;
import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.http.ContentType;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

class DemoControllerTest extends BaseControllerTest {
  @MockitoBean private DemoService demoService;

  @Test
  public void testGetUserById() {
    RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    String id1 = UUID.randomUUID().toString();
    String id2 = UUID.randomUUID().toString();
    String name1 = "name1";
    String name2 = "name2";
    DemoDTO demoDto1 = new DemoDTO().id(UUID.fromString(id1)).name(name1);
    DemoDTO demoDto2 = new DemoDTO().id(UUID.fromString(id2)).name(name2);
    when(demoService.fetchAllDemos()).thenReturn(List.of(demoDto1, demoDto2));

    var response =
        given()
            .accept(ContentType.JSON)
            .param("fieldsToExtractCode", "fieldsToExtractCode_1")
            .when()
            .get("/demo")
            .then()
            .statusCode(200)
            .extract()
            .as(new TypeRef<List<DemoDTO>>() {});

    assertThat(response).hasSize(2).contains(demoDto1, demoDto2);
  }
}
