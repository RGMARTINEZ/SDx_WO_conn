/* Decompiler 28ms, total 1450ms, lines 103 */
package com.wavecomm.SDx;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;

public class HttpPostMultipart {
   private final String boundary;
   private static final String LINE = "\r\n";
   private HttpURLConnection httpConn;
   private String charset;
   private OutputStream outputStream;
   private PrintWriter writer;

   public HttpPostMultipart(String requestURL, String charset, Map<String, String> headers) throws IOException {
      this.charset = charset;
      this.boundary = UUID.randomUUID().toString();
      URL url = new URL(requestURL);
      this.httpConn = (HttpURLConnection)url.openConnection();
      this.httpConn.setUseCaches(false);
      this.httpConn.setDoOutput(true);
      this.httpConn.setDoInput(true);
      this.httpConn.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + this.boundary);
      if (headers != null && headers.size() > 0) {
         Iterator it = headers.keySet().iterator();

         while(it.hasNext()) {
            String key = (String)it.next();
            String value = (String)headers.get(key);
            this.httpConn.setRequestProperty(key, value);
         }
      }

      this.outputStream = this.httpConn.getOutputStream();
      this.writer = new PrintWriter(new OutputStreamWriter(this.outputStream, charset), true);
   }

   public void addFormField(String name, String value) {
      this.writer.append("--" + this.boundary).append("\r\n");
      this.writer.append("Content-Disposition: form-data; name=\"" + name + "\"").append("\r\n");
      this.writer.append("Content-Type: text/plain; charset=" + this.charset).append("\r\n");
      this.writer.append("\r\n");
      this.writer.append(value).append("\r\n");
      this.writer.flush();
   }

   public void addFilePart(String fieldName, File uploadFile) throws IOException {
      String fileName = uploadFile.getName();
      this.writer.append("--" + this.boundary).append("\r\n");
      this.writer.append("Content-Disposition: form-data; name=\"" + fieldName + "\"; filename=\"" + fileName + "\"").append("\r\n");
      this.writer.append("Content-Type: " + URLConnection.guessContentTypeFromName(fileName)).append("\r\n");
      this.writer.append("Content-Transfer-Encoding: binary").append("\r\n");
      this.writer.append("\r\n");
      this.writer.flush();
      FileInputStream inputStream = new FileInputStream(uploadFile);
      byte[] buffer = new byte[4096];
      boolean var6 = true;

      int bytesRead;
      while((bytesRead = inputStream.read(buffer)) != -1) {
         this.outputStream.write(buffer, 0, bytesRead);
      }

      this.outputStream.flush();
      inputStream.close();
      this.writer.append("\r\n");
      this.writer.flush();
   }

   public String finish() throws IOException {
      String response = "";
      this.writer.flush();
      this.writer.append("--" + this.boundary + "--").append("\r\n");
      this.writer.close();
      int status = this.httpConn.getResponseCode();
      if (status != 200) {
         throw new IOException("Server returned non-OK status: " + status);
      } else {
         ByteArrayOutputStream result = new ByteArrayOutputStream();
         byte[] buffer = new byte[1024];

         int length;
         while((length = this.httpConn.getInputStream().read(buffer)) != -1) {
            result.write(buffer, 0, length);
         }

         response = result.toString(this.charset);
         this.httpConn.disconnect();
         return response;
      }
   }
}
