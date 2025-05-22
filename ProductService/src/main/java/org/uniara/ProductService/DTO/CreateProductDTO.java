package org.uniara.ProductService.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter @Setter
public class CreateProductDTO {
    @NotBlank(message = "Nome é necessário")
    private String name;
    private String description;
    @NotNull(message = "Preço é necessário")
    private BigDecimal price;
}
