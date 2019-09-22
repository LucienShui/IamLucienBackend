package ink.lucien.iamlucien.dto;

import lombok.Data;

/**
 * Created by Lucien on 2019/09/22
 * Request 返回结果 Data Transfer Object
 */
@Data
public class ResultDTO<T> {

    // status code
    Integer code;

    String message;

    T data;

    // TODO Builder
}
