package com.myk.rpc.api;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * @author myk
 */
@Data
@AllArgsConstructor
public class HelloObject implements Serializable {
    private int id;
    private String message;
}
