package com.catdog.care.conf;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Configurable;

@Configurable
@OpenAPIDefinition(
        info = @Info(
                title = "JEA TEST, (EMP)"
                , description = "사원에 대한 CRUD를 할 수 있는 장소입니다."
                , version = "v1.0.0"
        )
)
public class SwaggerConfig {
}
