package com.iweb.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wmn
 * @date 2023/11/25 16:37
 */
@Data
@NoArgsConstructor
public class novel {
    private int id;
    private String name;
    private int totalCount;
    private String situation;
    private String author;
}
