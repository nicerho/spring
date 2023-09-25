package hello.itemservice.domain.item;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DeliveryCode {

    private String code; //FAST 빠른배송 NORMAL 일반 SLOW 느린
    private String displayName;
}
