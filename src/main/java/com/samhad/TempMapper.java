package com.samhad;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;
import java.util.StringTokenizer;

public class TempMapper extends Mapper<LongWritable, Text, Text, IntWritable> {

    private Text word = new Text();

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

        StringTokenizer tokenizer = new StringTokenizer(value.toString(), "\n");

        while (tokenizer.hasMoreElements()) {

            String[] split = tokenizer.nextToken().trim().split(" ");
            word.set(split[0]);
            context.write(
                    word,
                    new IntWritable(Integer.parseInt(split[1]))
            );
        }
    }
}
