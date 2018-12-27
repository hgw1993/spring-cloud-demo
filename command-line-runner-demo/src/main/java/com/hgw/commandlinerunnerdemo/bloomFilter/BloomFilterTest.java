package com.hgw.commandlinerunnerdemo.bloomFilter;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

import java.nio.charset.Charset;

/**
 * created 2018/11/27
 * author  guangwei.huang
 *
 *
 */
public class BloomFilterTest {

    public static void main(String[] args) {
        BloomFilter<String> b = BloomFilter.create(Funnels.stringFunnel(Charset.forName("utf-8")), 1000, 0.000001);
        b.put("121");
        b.put("122");
        b.put("123");
        System.out.println(b.mightContain("12321"));
        BloomFilter<String> b1 = BloomFilter.create(Funnels.stringFunnel(Charset.forName("utf-8")), 1000, 0.000001);
        b1.put("aba");
        b1.put("abb");
        b1.put("abc");
        b1.putAll(b);
        System.out.println(b1.mightContain("123"));
    }
}
