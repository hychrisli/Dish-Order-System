package cmpe.dos.dto;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

import com.fasterxml.jackson.annotation.JsonInclude;

import io.swagger.annotations.ApiModelProperty;

public class CreditInfoDto {

	@JsonInclude(value = NON_NULL)
    @ApiModelProperty(required = true)
    private String username;
}
