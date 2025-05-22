package org.uniara.CustomerService.DTO;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter @Setter
public class CreateCustomerDTO {
    @NotBlank(message = "Nome é obrigatório")
    private String name;
    @NotBlank(message = "Telefone é obrigatório")
    private String phoneNumber;
}
