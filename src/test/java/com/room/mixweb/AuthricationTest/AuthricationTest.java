package com.room.mixweb.AuthricationTest;

import com.room.mixweb.domain.User;
import com.room.mixweb.message.ResponseMessage;
import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.springframework.boot.test.context.TestComponent;

import java.io.*;
import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * @Author:dong
 * @Despriction:
 * @Date:my Create in 17:57 2019/3/19
 * @Modify by:
 */
@Log4j
public class AuthricationTest {

    @Test
    public void test(){
        /*Optional<User> emptyOpt=Optional.empty();
        emptyOpt.get();*/
        User u=new User("dong","28");
        Optional<User> opt=Optional.of(u);
        log.debug(opt.get().getName()+":"+opt.get().getAge());
    }
    @Test
    public void testMessage(){
        ResponseMessage<Object> ob = ResponseMessage.ok();
        log.debug(ob);
    }
    @Test
    public void testFile() throws IOException{
        File file=new File("D:\\BaiduNetdiskDownload\\tut\\lua经典学习教程.pdf_7861579.pdf");
        if (file.exists()){
            FileInputStream inputStream=new FileInputStream(file);
            FileDescriptor fd = inputStream.getFD();
            fd.sync();
        }
    }
}


