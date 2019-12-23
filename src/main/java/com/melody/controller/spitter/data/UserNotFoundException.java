package com.melody.controller.spitter.data;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 处理用户不存在异常
 * @author 40431
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND,
                reason = "User Not Found")
public class UserNotFoundException extends RuntimeException {

}
