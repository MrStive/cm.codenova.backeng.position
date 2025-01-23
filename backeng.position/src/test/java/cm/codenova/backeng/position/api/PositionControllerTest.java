package cm.codenova.backeng.position.api;

import cm.codenova.backeng.position.demo.dto.PositionDTO;
import cm.codenova.backeng.position.service.PositionService;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import io.restassured.common.mapper.TypeRef;
import io.restassured.http.ContentType;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.Mockito.doReturn;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.util.UUID;
@ExtendWith(MockitoExtension.class)
class PositionControllerTest extends  BaseControllerTest {
    @MockitoBean
    private PositionService positionService;

    @Test
    public void createPositionTest() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        UUID expected = UUID.randomUUID();
        PositionDTO positionDTO = new PositionDTO().id(UUID.randomUUID());
        doReturn(expected).when(positionService).createPosition(positionDTO);

        var response =
                given()
                        .contentType(ContentType.JSON)
                        .body(positionDTO)
                        .when()
                        .post("/position")
                        .then()
                        .statusCode(200)
                        .extract()
                        .as(new TypeRef<UUID>() {});

        assertThat(response).isEqualTo(expected);
    }

}