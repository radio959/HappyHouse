package ssafy.com.kkyuwoo.happyhouse.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BoardSaveRequestDto {

    private String title;
    private String content;
    private String type;

}
