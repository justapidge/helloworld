package com.iweb.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wmn
 * @date 2023/11/25 15:49
 */
@Data
@NoArgsConstructor
public class reader {
    private int id;
    private String name;
    private String pwd;
    private int phoneNumber;
    private String gender;
    private int amount;

}
