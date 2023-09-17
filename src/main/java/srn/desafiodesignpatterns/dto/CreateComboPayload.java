package srn.desafiodesignpatterns.dto;

import srn.desafiodesignpatterns.model.Combo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Modelo de request para criação do combo")
public class CreateComboPayload {
    @ApiModelProperty(value = "ID do cliente", example = "1", required = true)
    private Long client_id;

    @ApiModelProperty(value = "Combo escolhido", example = "1", allowableValues = "1, 2, 3", required = true)
    private Integer combo_number;

    public Long getClient_id() {
        return client_id;
    }

    public void setClient_id(Long client_id) {
        this.client_id = client_id;
    }

    public Integer getCombo_number() {
        return combo_number;
    }

    public void setCombo_number(Integer combo_number) {
        this.combo_number = combo_number;
    }
}
