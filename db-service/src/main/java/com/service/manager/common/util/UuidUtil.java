package com.service.manager.common.util;

import java.math.BigInteger;
import java.text.NumberFormat;
import java.util.Date;

/**
 * Created by Druid on 2018/4/11.
 *
 */
public class UuidUtil {
    private static final String CHR_POOL = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static int CHR_LEN = CHR_POOL.length();
    private static int SEQ_LEN = 4;
    private static int ZONE_LEN = 3;
    private static int TS_LEN = 10;
    private static int ENCODED_LEN = 10;

    private static String ZONE_ID = "200";

    private static int seq = 1;

    /**
     * ID组成： 4位随机数 + 3位Zone编号 + 10位时间戳
     * @return
     */
    public synchronized static String getId(){
        //int seq = (int) (Math.random() * Math.pow(10,SEQ_LEN));
        if (seq >= Math.pow(10,SEQ_LEN) ){
            seq = 1;
        }
        int i = seq;
        seq++;
        Date date = new Date();
        long  timeInt =  (date.getTime()/(long)(Math.pow(10,13-TS_LEN)));
        return (fill(i) + ZONE_ID + String.format("%0"+TS_LEN+"d",timeInt));
    }

    private static String fill(int number){
        NumberFormat nf = NumberFormat.getInstance();
        nf.setGroupingUsed(false);
        nf.setMaximumIntegerDigits(SEQ_LEN);
        nf.setMinimumIntegerDigits(SEQ_LEN);
        return nf.format(number);

    }

    /**
     * 对ID进行压缩
     * @param ori_id
     * @return
     */
    public static String encode(String ori_id){
        StringBuffer encoded_id = new StringBuffer();
        BigInteger n = new BigInteger(ori_id);
        while (n.compareTo(BigInteger.valueOf(0))>0) {
            BigInteger c = n.remainder(BigInteger.valueOf(CHR_LEN));
            encoded_id.append(CHR_POOL.charAt(c.intValue()));
            n = n.divide(BigInteger.valueOf(CHR_LEN));
        }
        String id = encoded_id.reverse().toString();
        while (id.length() < ENCODED_LEN){
            id = "0" + id;
        }
        return  id;
    }

    public static String encode(){
        return  encode(getId());
    }

    /**
     * 解压缩
     * @param encoded_id
     * @return
     */
    public static String decode(String encoded_id){
        int i = ENCODED_LEN - 1;
        BigInteger ori_id = BigInteger.valueOf(0);
        for (char c:encoded_id.toCharArray()) {
            int index = CHR_POOL.indexOf(c);
            BigInteger tmp = BigInteger.valueOf(index).multiply(BigInteger.valueOf(62).pow(i));
            ori_id =ori_id.add(tmp);
            --i;
        }
        return ori_id.toString();
    }

}
