/* Decompiler 394ms, total 1152ms, lines 734 */
package com.wavecomm.SDx;

import com.kadme.tool.log.Reporter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.Request.Builder;
import org.json.JSONArray;
import org.json.JSONObject;

public class WhereoilConexion {
   String url;
   String userName;
   String secToken;
   String password;
   boolean connection;
   String connAnswer;
   static OutputStream ouputStream = null;
   static BufferedReader reader = null;
   static HttpURLConnection urlConn = null;

   public WhereoilConexion(String url, String userName, String password, String secToken) {
      this.url = url;
      this.userName = userName;
      this.password = password;
      this.secToken = secToken;
   }

   public void printConectionParameters() {
      System.out.println("la url es:      " + this.url);
      System.out.println("el userName es: " + this.userName);
      System.out.println("el password es: " + this.password);
      System.out.println("el token es:    " + this.secToken);
   }

   public static OutputStream connectorPost(String urlLink, String knowToken, String newTicket) {
      try {
         URL urlObjConnMet = new URL(urlLink);
         urlConn = (HttpURLConnection)urlObjConnMet.openConnection();
         urlConn.setDoOutput(true);
         urlConn.setRequestMethod("POST");
         urlConn.setRequestProperty("Content-Type", "application/json");
         urlConn.setRequestProperty("kadme.security.token", knowToken);
         urlConn.setRequestProperty("Accept", "application/json");
         if (newTicket != null && !newTicket.equals("")) {
            urlConn.setRequestProperty("ticket", newTicket);
            urlConn.setDoOutput(true);
         }

         urlConn.setConnectTimeout(60000);
         urlConn.setReadTimeout(60000);
         ouputStream = urlConn.getOutputStream();
         return ouputStream;
      } catch (Exception var4) {
         System.out.println(SDx_Application.getLineNumber() + "Se ha presentado un error en com.wavecomm.OW.WhereoilConexion.connectorPost()");
         System.out.println(var4);
         return null;
      }
   }

   public static OutputStream connectorPut(String urlLink, String knowToken, String newTicket) {
      try {
         URL urlObjConnMet = new URL(urlLink);
         urlConn = (HttpURLConnection)urlObjConnMet.openConnection();
         urlConn.setDoOutput(true);
         urlConn.setRequestMethod("PUT");
         urlConn.setRequestProperty("Content-Type", "application/json");
         urlConn.setRequestProperty("kadme.security.token", knowToken);
         urlConn.setRequestProperty("Accept", "application/json");
         if (newTicket != null && !newTicket.equals("")) {
            urlConn.setRequestProperty("ticket", newTicket);
            urlConn.setDoOutput(true);
         }

         urlConn.setConnectTimeout(30000);
         urlConn.setReadTimeout(30000);
         ouputStream = urlConn.getOutputStream();
         return ouputStream;
      } catch (Exception var4) {
         System.out.println(SDx_Application.getLineNumber() + "Se ha presentado un error en com.wavecomm.OW.WhereoilConexion.connectorPost()");
         System.out.println(var4);
         return null;
      }
   }

   public OutputStream connectorGet(String urlLink, String knowToken, String newTicket) {
      try {
         URL urlObjConnMet = new URL(urlLink);
         urlConn = (HttpURLConnection)urlObjConnMet.openConnection();
         urlConn.setDoOutput(true);
         urlConn.setRequestMethod("POST");
         urlConn.setRequestProperty("kadme.security.token", knowToken);
         urlConn.setRequestProperty("ticket", newTicket);
         urlConn.setRequestProperty("Content-Type", "application/json");
         urlConn.setDoOutput(true);
         urlConn.setConnectTimeout(30000);
         urlConn.setReadTimeout(30000);
         connectionOperations.outputStream = urlConn.getOutputStream();
         return connectionOperations.outputStream;
      } catch (Exception var5) {
         System.out.println(SDx_Application.getLineNumber() + "Se ha presentado un error en WhereoilConexion.connectorGet()");
         System.out.println(var5);
         return null;
      }
   }

   public OutputStream connectorDelete(String urlLink, String knowToken, String newTicket) {
      try {
         URL urlObjConnMet = new URL(urlLink);
         urlConn = (HttpURLConnection)urlObjConnMet.openConnection();
         urlConn.setDoOutput(true);
         urlConn.setRequestMethod("DELETE");
         urlConn.setRequestProperty("User-Agent", "Mozilla/5.0");
         urlConn.setRequestProperty("Content-Type", "application/json");
         urlConn.setRequestProperty("kadme.security.token", knowToken);
         urlConn.setRequestProperty("Accept", "application/json");
         urlConn.setRequestProperty("ticket", newTicket);
         urlConn.setDoOutput(true);
         urlConn.setConnectTimeout(30000);
         urlConn.setReadTimeout(30000);
         ouputStream = urlConn.getOutputStream();
         return ouputStream;
      } catch (Exception var5) {
         System.out.println(SDx_Application.getLineNumber() + " Se ha presentado un error en com.wavecomm.OW.WhereoilConexion.connectorDelete()");
         System.out.println(var5);
         return null;
      }
   }

   public static String getTicket(String url, String secToken, String userName, String password) {
      if (SDx_Application.isDebugFlag()) {
         System.out.println(SDx_Application.getLineNumber() + " getTicket.");
      }

      JSONObject rta = new JSONObject();

      try {
         ouputStream = connectorPost(url, secToken, "");
         if (ouputStream == null) {
            ouputStream = connectorPost(url, secToken, "");
         }

         String jsonInput = "{\"userName\":\"" + userName + "\", \"password\":\"" + password + "\"}";
         ouputStream.write(jsonInput.getBytes());
         ouputStream.flush();
         if (urlConn.getResponseCode() != 200) {
            rta.put("done", false);
            rta.put("url", url);
            rta.put("secToken", secToken);
            rta.put("userName", userName);
            rta.put("password", password);
            return rta.toString();
         } else if (urlConn.getResponseCode() != 200) {
            return "false 3  en getTicket";
         } else {
            InputStream is = urlConn.getInputStream();
            reader = new BufferedReader(new InputStreamReader(is));
            String tmpStr = null;

            String connAnswer;
            for(connAnswer = ""; (tmpStr = reader.readLine()) != null; connAnswer = tmpStr) {
            }

            ouputStream.close();
            JSONObject jsonAnswer = new JSONObject(connAnswer);
            jsonAnswer.put("done", true);
            return jsonAnswer.toString();
         }
      } catch (Exception var10) {
         System.out.println(var10);
         System.err.println("Se ha presentado un error indeterminado al intentar obtener un ticket");
         System.out.println("Los valores usados son: url:" + url + " sec_token: " + secToken);
         System.out.println("userName: " + userName);
         System.out.println("password: " + password);
         return SDx_Application.getLineNumber() + "false 2 200";
      }
   }

   public static JSONObject funcionInteresante(String user, int key, String pass) {
      JSONObject variable1 = new JSONObject();
      variable1.put("user", user);
      variable1.put("pass", pass);
      variable1.put("key", key);
      return variable1;
   }

   public String writeConnector(String[] json2post, String eventName, String newTicket) {
      String url_proc = "";

      String var6;
      try {
         int sizeLength = json2post.length;
         byte var7 = -1;
         switch(eventName.hashCode()) {
         case -1550425527:
            if (eventName.equals("SourcingContracts")) {
               var7 = 2;
            }
            break;
         case 626986070:
            if (eventName.equals("ProvidersDocuments")) {
               var7 = 1;
            }
            break;
         case 1608462721:
            if (eventName.equals("Contracts")) {
               var7 = 3;
            }
            break;
         case 1667692932:
            if (eventName.equals("sdx:files")) {
               var7 = 0;
            }
         }

         switch(var7) {
         case 0:
            url_proc = SDx_FirstFuncion.getWHEREOIL_URL_SDxFiles();
         case 1:
         case 2:
         case 3:
         default:
            for(int i = 0; i < sizeLength; ++i) {
               OutputStream ouputStream = connectorPost(url_proc, this.secToken, newTicket);

               try {
                  byte[] arrayBytes = json2post[i].getBytes();
                  ouputStream.write(arrayBytes);
               } catch (Exception var23) {
                  System.err.println("Unable to POST the data to WhereOil, The system answer: " + urlConn.getResponseCode());
                  var23.printStackTrace();
                  String var9 = url_proc + " " + this.secToken + " " + newTicket;
                  return var9;
               }

               if (urlConn.getResponseCode() != 200) {
                  System.err.println("Unable to connect to the URL, The system answer: " + urlConn.getResponseCode());
                  System.err.println("Maybe some field data have some error, like decimal data from insert in a int field.");
                  PrintStream var10000 = System.out;
                  String var10001 = SDx_Application.getLineNumber();
                  var10000.println(var10001 + " the json data is :  " + json2post[i].toString());
                  System.out.println();
               } else {
                  InputStream is2 = urlConn.getInputStream();
                  reader = new BufferedReader(new InputStreamReader(is2));
               }

               ouputStream.close();
            }

            var6 = this.connAnswer;
            return var6;
         }
      } catch (MalformedURLException var24) {
         System.err.println(SDx_Application.getLineNumber() + " Some Error enconted when the system trying to send the report to WhereOil.");
         var24.printStackTrace();
         this.connection = false;
         var6 = SDx_Application.getLineNumber() + "false 1";
      } catch (IOException var25) {
         System.err.println(SDx_Application.getLineNumber() + " Some Error enconted when the system trying to send the report to WhereOil.");
         System.err.println(json2post);
         var25.printStackTrace();
         this.connection = false;
         var6 = "false 2 ";
         return var6;
      } finally {
         try {
            if (reader != null) {
               reader.close();
            }

            if (urlConn != null) {
               urlConn.disconnect();
            }
         } catch (Exception var22) {
            this.connection = false;
            return "false 3";
         }

      }

      return var6;
   }

   public JSONObject validateAndGetTicket(WhereoilConexion woConnection, JSONObject ticketToOperate, Reporter reporter) throws ParseException {
      if (ticketToOperate.isNull("validUntil")) {
         ticketToOperate = woConnection.getValidTiket_v2(reporter);
      } else {
         SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
         LocalDateTime now = LocalDateTime.now();
         Date horaLocal = dateFormat.parse(now.toString());
         Date date2 = dateFormat.parse(ticketToOperate.getString("validUntil"));
         long diffInMillies = date2.getTime() - horaLocal.getTime();
         long diff = TimeUnit.HOURS.convert(diffInMillies, TimeUnit.MILLISECONDS);
         if (diff <= 2L) {
            ticketToOperate = woConnection.getValidTiket_v2(reporter);
         }
      }

      return ticketToOperate;
   }

   public JSONObject getValidTiket_v2(Reporter reporter) {
      try {
         this.connAnswer = getTicket(this.url, this.secToken, this.userName, this.password);
         JSONObject objetoJsonTikTok = new JSONObject(this.connAnswer);
         return objetoJsonTikTok;
      } catch (Exception var4) {
         JSONObject objetoJsonTikTok = new JSONObject();
         objetoJsonTikTok.put("error", "error");
         return objetoJsonTikTok;
      }
   }

   public String writeConnector(String[] json2post, String eventName, String newTicket, Reporter reporter) {
      String url_proc = "";

      try {
         String var7;
         try {
            int sizeLength = json2post.length;
            byte var8 = -1;
            switch(eventName.hashCode()) {
            case -1186435078:
               if (eventName.equals("maduracionproj:maduracionproj")) {
                  var8 = 1;
               }
               break;
            case 1959274354:
               if (eventName.equals("sdx:epp")) {
                  var8 = 0;
               }
            }

            switch(var8) {
            case 0:
               url_proc = SDx_FirstFuncion.getWHEREOIL_URL_SDxFiles();
               break;
            case 1:
               url_proc = SDx_FirstFuncion.getWHEREOIL_URL_HLPFiles();
            }

            for(int i = 0; i < sizeLength; ++i) {
               json2post[i] = DataOperators.encodeTildes1(json2post[i]);
               new JSONArray(json2post[i]);
               OutputStream ouputStream = connectorPost(url_proc, this.secToken, newTicket);

               try {
                  byte[] arrayBytes = json2post[i].getBytes();
                  ouputStream.write(arrayBytes);
               } catch (Exception var25) {
                  reporter.reportError(SDx_Application.getLineNumber() + "Error de conexion a WhereOil para escritura", var25);
                  reporter.reportError("El codigo de error es:  " + urlConn.getResponseCode());
                  var25.printStackTrace();
                  String var11 = url_proc + " " + this.secToken + " " + newTicket;
                  return var11;
               }

               if (urlConn.getResponseCode() != 200) {
                  reporter.reportError("Se ha presentado un error al escribir en WhereOil, puede estar asociado al JSON de escritura o configuracion de columnas o tipos de datos.");
                  reporter.reportError("El codigo de error es:  " + urlConn.getResponseCode());
                  reporter.reportError(urlConn.getResponseMessage());
                  reporter.reportInfo("Datos a escribir: " + Arrays.toString(json2post));
               } else {
                  String ans = urlConn.getResponseMessage();
                  if (ans != null) {
                     String var10001 = SDx_Application.getLineNumber();
                     reporter.reportInfo(var10001 + " respuesta al insert es: " + ans);
                  }

                  InputStream is2 = urlConn.getInputStream();
                  reader = new BufferedReader(new InputStreamReader(is2));
               }

               ouputStream.close();
            }

            var7 = this.connAnswer;
            return var7;
         } catch (MalformedURLException var26) {
            reporter.reportError(SDx_Application.getLineNumber() + "se ha encontrado algún tipo de error general al escribir.", var26);
            reporter.reportInfo("Datos a escribir: " + Arrays.toString(json2post));
            var26.printStackTrace();
            this.connection = false;
            var7 = SDx_Application.getLineNumber() + "false 1";
            return var7;
         } catch (IOException var27) {
            reporter.reportError(SDx_Application.getLineNumber() + "Se ha encontrado algún tipo de error general al escribir.", var27);
            reporter.reportInfo("Datos a escribir: " + Arrays.toString(json2post));
            var27.printStackTrace();
            this.connection = false;
            var7 = "false 2 ";
            return var7;
         }
      } finally {
         try {
            if (reader != null) {
               reader.close();
            }

            if (urlConn != null) {
               urlConn.disconnect();
            }
         } catch (Exception var24) {
            reporter.reportError("Se ha encontrado algun tipo de error general al escribir.", var24);
            this.connection = false;
            return "false 3";
         }

      }
   }

   public String writeConnectorPut(String[] json2post, String eventName, String newTicket, Reporter reporter) {
      String url_proc = "";

      try {
         String var7;
         try {
            int sizeLength = json2post.length;
            url_proc = SDx_QueryUrls.getWHEREOIL_URL_SDxFiles();

            for(int i = 0; i < sizeLength; ++i) {
               OutputStream ouputStream = connectorPut(url_proc, this.secToken, newTicket);

               try {
                  byte[] arrayBytes = json2post[i].getBytes();
                  ouputStream.write(arrayBytes);
               } catch (Exception var24) {
                  reporter.reportError("Error de conexion a WhereOil para escritura", var24);
                  System.err.println("Unable to POST the data to WhereOil, The system answer: " + urlConn.getResponseCode());
                  var24.printStackTrace();
                  String var10 = url_proc + " " + this.secToken + " " + newTicket;
                  return var10;
               }

               if (urlConn.getResponseCode() != 200) {
                  reporter.reportError("Se ha presentado un error al escribir en WhereOil, puede estar asociado al JSON de escritura o copnfiguracion de columnas o tipos de datos.");
               } else {
                  InputStream is2 = urlConn.getInputStream();
                  reader = new BufferedReader(new InputStreamReader(is2));
               }

               SDx_FirstFuncion.registerGroupToSend = new JSONArray();
               ouputStream.close();
            }

            var7 = this.connAnswer;
            return var7;
         } catch (MalformedURLException var25) {
            reporter.reportError("se ha encontrado algun tipo de error general al escribir.", var25);
            System.err.println(SDx_Application.getLineNumber() + " Some Error enconted when the system trying to send the report to WhereOil.");
            var25.printStackTrace();
            this.connection = false;
            var7 = SDx_Application.getLineNumber() + "false 1";
            return var7;
         } catch (IOException var26) {
            reporter.reportError("se ha encontrado algun tipo de error general al escribir.", var26);
            System.err.println(SDx_Application.getLineNumber() + " Some Error enconted when the system trying to send the report to WhereOil.");
            System.err.println(json2post);
            var26.printStackTrace();
            this.connection = false;
            var7 = "false 2 ";
            return var7;
         }
      } finally {
         try {
            if (reader != null) {
               reader.close();
            }

            if (urlConn != null) {
               urlConn.disconnect();
            }
         } catch (Exception var23) {
            reporter.reportError("Se ha encontrado algun tipo de error general al escribir.", var23);
            this.connection = false;
            return "false 3";
         }

      }
   }

   public String queryConnector(String json2query, String eventName) {
      String url_proc = "";
      byte var5 = -1;
      switch(eventName.hashCode()) {
      case 1718460372:
         if (eventName.equals("SDx_queryUrls")) {
            var5 = 0;
         }
      }

      switch(var5) {
      case 0:
         url_proc = SDx_QueryUrls.getWHEREOIL_URL_SDxFiles();
      default:
         try {
            this.connAnswer = getTicket(this.url, this.secToken, this.userName, this.password);
            String[] tiktok = DataOperators.conversor_tandus(this.connAnswer);
            ouputStream = this.connectorGet(url_proc, this.secToken, tiktok[1]);
            ouputStream.write(json2query.getBytes());
            if (urlConn.getResponseCode() != 200) {
               System.err.println("Unable to connect to the URL, The system answer: " + urlConn.getResponseCode());
               PrintStream var10000 = System.out;
               String var10001 = SDx_Application.getLineNumber();
               var10000.println(var10001 + " the json data is :  " + json2query);
               System.out.println();
            }

            InputStream is2 = urlConn.getInputStream();
            reader = new BufferedReader(new InputStreamReader(is2));

            for(String tmpStr = null; (tmpStr = reader.readLine()) != null; this.connAnswer = tmpStr) {
            }

            ouputStream.close();
            return this.connAnswer;
         } catch (Exception var7) {
            return "false";
         }
      }
   }

   public String queryConnector(String json2query, String eventName, Reporter reporter) {
      String url_proc = eventName;

      try {
         this.connAnswer = getTicket(this.url, this.secToken, this.userName, this.password);
         String[] tiktok = DataOperators.conversor_tandus(this.connAnswer);
         ouputStream = this.connectorGet(url_proc, this.secToken, tiktok[1]);
         ouputStream.write(json2query.getBytes());
         String var10001;
         if (urlConn.getResponseCode() != 200) {
            reporter.reportError("Unable to connect to the URL, The system answer: " + urlConn.getResponseCode());
            var10001 = SDx_Application.getLineNumber();
            reporter.reportError(var10001 + " the json query is :  " + json2query);
         } else if (SDx_Application.isDebugFlag()) {
            PrintStream var10000 = System.out;
            var10001 = SDx_Application.getLineNumber();
            var10000.println(var10001 + " the json data is :  " + json2query);
         }

         InputStream is2 = urlConn.getInputStream();
         reader = new BufferedReader(new InputStreamReader(is2));

         for(String tmpStr = null; (tmpStr = reader.readLine()) != null; this.connAnswer = tmpStr) {
         }

         ouputStream.close();
         return this.connAnswer;
      } catch (Exception var8) {
         return "false";
      }
   }

   public String getValidTicket() {
      try {
         int counter = 0;

         while(counter < 3) {
            this.connAnswer = getTicket(this.url, this.secToken, this.userName, this.password);
            JSONObject jsonAnswer = new JSONObject(this.connAnswer);
            if (jsonAnswer.getBoolean("done")) {
               String[] tiktok = DataOperators.conversor_tandus(this.connAnswer);
               return tiktok[1];
            }

            ++counter;
            TimeUnit.SECONDS.sleep(30L);
         }

         return "false";
      } catch (Exception var4) {
         return "error";
      }
   }

   public JSONObject getValidTicketJson() {
      JSONObject jsonAnswer = new JSONObject();

      try {
         int counter = 0;

         while(counter < 3) {
            this.connAnswer = getTicket(this.url, this.secToken, this.userName, this.password);
            jsonAnswer = new JSONObject(this.connAnswer);
            if (jsonAnswer.getBoolean("done")) {
               String[] tiktok = DataOperators.conversor_tandus(this.connAnswer);
               return jsonAnswer;
            }

            ++counter;
            TimeUnit.SECONDS.sleep(30L);
         }

         jsonAnswer.put("done", false);
         return jsonAnswer;
      } catch (Exception var4) {
         jsonAnswer.put("done", false);
         return jsonAnswer;
      }
   }

   public String getValidTiket(Reporter reporter) {
      try {
         this.connAnswer = getTicket(this.url, this.secToken, this.userName, this.password);
         String[] tiktok = DataOperators.conversor_tandus(this.connAnswer);
         return tiktok[1];
      } catch (Exception var3) {
         reporter.reportError(SDx_Application.getLineNumber() + " Se ha presentado un error al solicitar el token de WhereOil. ", var3);
         return "error";
      }
   }

   public String deleteRegisters(String json2query, String eventName, String validTicket, Reporter reporter) {
      String url_proc = "";
      byte var7 = -1;
      switch(eventName.hashCode()) {
      case -1733466587:
         if (eventName.equals("sdx:comisionamiento.json")) {
            var7 = 1;
         }
         break;
      case -1703225884:
         if (eventName.equals("sdx:epp.json")) {
            var7 = 3;
         }
         break;
      case -852581279:
         if (eventName.equals("sdx:construccion.json")) {
            var7 = 2;
         }
         break;
      case -405088611:
         if (eventName.equals("sdx:calidad.json")) {
            var7 = 0;
         }
         break;
      case -352673188:
         if (eventName.equals("maduracionproj:maduracionproj.json")) {
            var7 = 6;
         }
         break;
      case 835598830:
         if (eventName.equals("sdx:materiales.json")) {
            var7 = 5;
         }
         break;
      case 1201940864:
         if (eventName.equals("sdx:ingenieria.json")) {
            var7 = 4;
         }
      }

      switch(var7) {
      case 0:
         url_proc = SDx_FirstFuncion.getWHEREOIL_SDX_CLASSNAME_ROOT() + "sdx:calidad.json";
         break;
      case 1:
         url_proc = SDx_FirstFuncion.getWHEREOIL_SDX_CLASSNAME_ROOT() + "sdx:comisionamiento.json";
         break;
      case 2:
         url_proc = SDx_FirstFuncion.getWHEREOIL_SDX_CLASSNAME_ROOT() + "sdx:construccion.json";
         break;
      case 3:
         url_proc = SDx_FirstFuncion.getWHEREOIL_SDX_CLASSNAME_ROOT() + "sdx:epp.json";
         break;
      case 4:
         url_proc = SDx_FirstFuncion.getWHEREOIL_SDX_CLASSNAME_ROOT() + "sdx:ingenieria.json";
         break;
      case 5:
         url_proc = SDx_FirstFuncion.getWHEREOIL_SDX_CLASSNAME_ROOT() + "sdx:materiales.json";
         break;
      case 6:
         url_proc = SDx_FirstFuncion.getWHEREOIL_HLP_CLASSNAME_ROOT() + "maduracionproj:maduracionproj.json";
      }

      try {
         ouputStream = this.connectorDelete(url_proc, this.secToken, validTicket);
         ouputStream.write(json2query.getBytes());
         if (urlConn.getResponseCode() != 200) {
            String var10001 = SDx_Application.getLineNumber();
            reporter.reportError(var10001 + " Unable to connect to the URL, The system answer: " + urlConn.getResponseCode());
            var10001 = SDx_Application.getLineNumber();
            reporter.reportError(var10001 + " url_proc: " + url_proc);
            var10001 = SDx_Application.getLineNumber();
            reporter.reportError(var10001 + " The request is :  " + json2query);
            var10001 = SDx_Application.getLineNumber();
            reporter.reportError(var10001 + " getHeaderField: " + urlConn.getHeaderField("Location"));
         } else {
            InputStream is2 = urlConn.getInputStream();
            reader = new BufferedReader(new InputStreamReader(is2));

            for(String tmpStr = null; (tmpStr = reader.readLine()) != null; this.connAnswer = tmpStr) {
            }

            ouputStream.close();
         }

         return this.connAnswer;
      } catch (Exception var8) {
         reporter.reportError(SDx_Application.getLineNumber() + " Se presento un error en \"deleteRegisters\" detectado con la excepcion.");
         reporter.reportInfo(json2query);
         return "0";
      }
   }

   public JSONObject okhttpqueryWO() throws IOException {
      OkHttpClient client = (new OkHttpClient()).newBuilder().build();
      String body = "{\n  \"pagination\": {\n    \"start\": 0,\n    \"count\": 100,\n    \"sort\": \"sdx:Id_archivo\",\n    \"dir\": \"ASC\"\n  },\n  \"query\": {\"classname\": \"sdx:comisionamiento.json\"},\n  \"loadProperties\": [\n    \"sdx:URL\",\n    \"sdx:Id_archivo\",\n    \"sdx:Codigo_proyecto\"\n  ]\n}";
      Request request = (new Builder()).url("https://ecosearch-test.kadme.com/whereoil-rest-server/data/sdx/sdx:comisionamiento.json").method("GET", (RequestBody)null).addHeader("kadme.security.token", "4e54564d596d46684f3245684d5751745a7930774c4464304e574a6b4e44596c59474e745a574d6a4d545a347a57456b").addHeader("ticket", "f9dce8adf8689b5b341d423a49abe9f8").addHeader("Content-Type", "application/json").addHeader("Cookie", "JSESSIONID=D3D1FF7C6BE74B0AB674FDCC4C55036C").build();
      Response response = client.newCall(request).execute();
      System.out.println(response.body().string());
      JSONObject answer2send = new JSONObject(response);
      return answer2send;
   }
}
