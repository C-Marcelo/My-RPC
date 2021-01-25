package com.myk;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author myk
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HelloObject implements Serializable {
    private int id;
    private String message;
}
