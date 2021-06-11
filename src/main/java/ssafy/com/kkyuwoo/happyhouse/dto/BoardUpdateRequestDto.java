package ssafy.com.kkyuwoo.happyhouse.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class BoardUpdateRequestDto {

    private String title;
    private String content;

}
