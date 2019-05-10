package com.myproj.myproj.mq;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

/**
 * Created by wangjinyu on 2019/5/9 15:45.
 */
public class Rs {
    public static void main(String[] args) {
        SimpleDateFormat sfd = new SimpleDateFormat("yyyy-MM-dd");

        try {
            Date parse = sfd.parse("2019-05-08");
            System.out.println(parse.toInstant());
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
