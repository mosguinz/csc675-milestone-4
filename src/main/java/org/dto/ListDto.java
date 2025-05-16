package org.dto;

import java.util.ArrayList;

public class ListDto extends ArrayList {

    public ListDto() {
        super();
    }

    public String toJson() {
        StringBuffer buffer = new StringBuffer("\n[");

        int size = size();
        for (int i = 0; i < size; i++) {
            BaseDto dto = (BaseDto) get(i);

            buffer.append(dto.toJson());
            if (i < size - 1) {
                buffer.append(",");
            }
        }

        buffer.append("]\n");
        return buffer.toString();
    }
}
