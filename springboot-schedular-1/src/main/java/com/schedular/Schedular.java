package com.schedular;

import org.springframework.stereotype.Component;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.BufferedWriter;


import org.springframework.scheduling.annotation.Scheduled;

@Component
public class Schedular {
	@Scheduled(fixedDelayString = "${schedule.fixedDelay}")
    public void taskWithFixedDelay() throws IOException  
	{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        Date now = new Date();
        String strDate = sdf.format(now);
        
            File f1 = new File("D://fixedDelay.txt");
            FileWriter  file = new FileWriter(f1,true);
            PrintWriter file1= new PrintWriter(file);
            file1.println("Java Fixed Delay:: " + strDate);
            file1.close();
     }
  
    

	@Scheduled(fixedRateString = "${schedule.fixedRate}", initialDelayString = "${schedule.initialDelay}")
    public void taskWithFixedRateAndInitialDelay() throws IOException 
	 {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        Date now = new Date();
        String strDate = sdf.format(now);

        File f1 = new File("D://fixedRate.txt");
        FileWriter  file = new FileWriter(f1,true);
        PrintWriter file1= new PrintWriter(file);
        file1.println("Java Fixed Rate: " + strDate);
        file1.close();
    }

    @Scheduled(cron = "${schedule.cron}")
    public void taskWithCronExpression() throws IOException 
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        Date now = new Date();
        String strDate = sdf.format(now);

        File f1 = new File("D://cron.txt");
        FileWriter  file = new FileWriter(f1,true);
        PrintWriter file1= new PrintWriter(file);
        file1.println("Java Cron Experssion: " + strDate);
        file1.close();
        

    }

}
