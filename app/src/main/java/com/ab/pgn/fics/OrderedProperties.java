package com.ab.pgn.fics;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * Created by Alexander Bootman on 4/23/19.
 */
public class OrderedProperties extends LinkedHashMap<String, String> {
    private static final Pattern pattern = Pattern.compile("^([^=^ ]+) *=? *(.*)$");

    public OrderedProperties(String propertiesFileName) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(propertiesFileName));
            String line;
            while((line = br.readLine()) != null) {
                if(line.startsWith("#")) {
                    continue;
                }
                line = line.trim();
                if(line.isEmpty()) {
                    continue;
                }
                Matcher m = pattern.matcher(line);
                if(m.find()) {
                    String key = m.group(1);
                    String value = m.group(2);
                    put(key, value);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
