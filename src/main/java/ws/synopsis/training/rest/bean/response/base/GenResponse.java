package ws.synopsis.training.rest.bean.response.base;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GenResponse<T> {
    private Status status;
    private T data;
}
