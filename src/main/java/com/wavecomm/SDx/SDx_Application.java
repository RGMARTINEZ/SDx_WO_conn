/* Decompiler 20ms, total 370ms, lines 34 */
package com.wavecomm.SDx;

import com.kadme.rest.webtool.AbstractToolApplication;
import com.kadme.rest.webtool.tool.Tool;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SDx_Application extends AbstractToolApplication {
   private static boolean debugFlag = false;

   public static void main(String[] args) {
      SpringApplication.run(SDx_Application.class, args);
   }

   protected Tool getTool() {
      return new ToolTest();
   }

   public static boolean isDebugFlag() {
      return debugFlag;
   }

   public static String getLineNumber() {
      DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
      LocalDateTime now = LocalDateTime.now();
      String hora = dtf.format(now);
      String className = Thread.currentThread().getStackTrace()[2].getClassName();
      return className + " " + Thread.currentThread().getStackTrace()[2].getLineNumber() + " " + hora;
   }
}
