package org.uniara.ProductService.DTO;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter @Setter
public class UpdateProductDTO {
    @NotBlank(message = "Id é necessário")
    private String id;
    @NotBlank(message = "Nome é necessário")
    private String name;
    private String description;
    @NotBlank(message = "Preço é necessário")
    private BigDecimal price;
    @NotBlank(message = "Status é necessário")
    private Boolean isAvailable;
}
