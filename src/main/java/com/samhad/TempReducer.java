package com.samhad;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.Iterator;

public class TempReducer extends Reducer<Text, IntWritable, Text, IntWritable> {


    @Override
    protected void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {

        Text word = new Text();
        int maxTemp = 0;
        Iterator<IntWritable> iterator = values.iterator();

        while (iterator.hasNext()) {

            int temperature = iterator.next().get();

            if (maxTemp < temperature) {

                maxTemp = temperature;
                word.set(key);
            }
        }

        context.write(word, new IntWritable(maxTemp));
    }
}
