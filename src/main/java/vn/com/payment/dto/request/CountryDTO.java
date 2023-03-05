package vn.com.payment.dto.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CountryDTO {

    private Long id;
    @Size(max = 255)
    @NotNull(message = "The country name is required")
    private String countryName;
    @Size(max = 255)
    @NotNull(message = "The country code is required")
    private String countryCode;
    @Size(max = 255)
    @NotNull(message = "The notes is required")
    private String notes;
}
