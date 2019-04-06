package com.room.mixweb.domain;

import lombok.Data;
import java.util.*;

/**
 * @Author:dong
 * @Despriction:
 * @Date:my Create in 15:56 2019/3/19
 * @Modify by:
 */
@Data
public class Permission {
    private String id;
    private List<String> Actions;
}
