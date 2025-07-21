/* Decompiler 659ms, total 795ms, lines 1218 */
package com.wavecomm.SDx;

import com.google.common.base.Predicate;
import com.kadme.tool.log.Reporter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.Request.Builder;
import org.apache.commons.codec.binary.Base64;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.ParseException;

public class connectionOperations {
   static OutputStream outputStream = null;
   static BufferedReader reader = null;
   static HttpURLConnection urlConn = null;
   private String urlLink;
   private String UserNameOpenText;
   private String passwordOpenText;

   public String connectorPost() {
      try {
         System.setProperty("https.protocols", "TLSv1,TLSv1.1,TLSv1.2");
         String responseBody = "";
         URL urlObjConnMet = new URL(this.urlLink);
         System.setProperty("https.protocols", "TLSv1,TLSv1.1,TLSv1.2");
         urlConn = (HttpURLConnection)urlObjConnMet.openConnection();
         urlConn.setDoOutput(true);
         urlConn.setRequestMethod("POST");
         urlConn.setRequestProperty("Authorization", "Basic " + this.basicAuth());
         urlConn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
         urlConn.setConnectTimeout(30000);
         urlConn.setReadTimeout(30000);
         System.setProperty("https.protocols", "TLSv1,TLSv1.1,TLSv1.2");
         outputStream = urlConn.getOutputStream();
         OutputStreamWriter osw = new OutputStreamWriter(outputStream, "UTF-8");
         osw.write("grant_type=openapi_2lo");
         osw.flush();
         osw.close();
         StringBuilder response = new StringBuilder();
         System.setProperty("https.protocols", "TLSv1.2");
         BufferedReader br;
         if (100 <= urlConn.getResponseCode() && urlConn.getResponseCode() <= 399) {
            br = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));

            while((responseBody = br.readLine()) != null) {
               response.append(responseBody);
            }
         } else {
            br = new BufferedReader(new InputStreamReader(urlConn.getErrorStream()));

            while((responseBody = br.readLine()) != null) {
               response.append(responseBody);
            }

            br.close();
         }

         PrintStream var10000 = System.out;
         String var10001 = SDx_Application.getLineNumber();
         var10000.println(var10001 + " response: " + response.toString());
         return response.toString();
      } catch (Exception var6) {
         System.out.println(var6);
         return null;
      }
   }

   public String connectorPost(Reporter reporter) {
      try {
         reporter.reportInfo("ingresó a conectorPost para hacer la conexion.");
         System.setProperty("https.protocols", "TLSv1,TLSv1.1,TLSv1.2");
         String responseBody = "";
         URL urlObjConnMet = new URL(this.urlLink);
         System.setProperty("https.protocols", "TLSv1,TLSv1.1,TLSv1.2");
         urlConn = (HttpURLConnection)urlObjConnMet.openConnection();
         urlConn.setDoOutput(true);
         urlConn.setRequestMethod("POST");
         urlConn.setRequestProperty("Authorization", "Basic " + this.basicAuth());
         urlConn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
         urlConn.setConnectTimeout(30000);
         urlConn.setReadTimeout(30000);
         System.setProperty("https.protocols", "TLSv1,TLSv1.1,TLSv1.2");
         outputStream = urlConn.getOutputStream();
         OutputStreamWriter osw = new OutputStreamWriter(outputStream, "UTF-8");
         osw.write("grant_type=openapi_2lo");
         osw.flush();
         osw.close();
         StringBuilder response = new StringBuilder();
         System.setProperty("https.protocols", "TLSv1,TLSv1.1,TLSv1.2");
         BufferedReader br;
         if (100 <= urlConn.getResponseCode() && urlConn.getResponseCode() <= 399) {
            br = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));

            while((responseBody = br.readLine()) != null) {
               response.append(responseBody);
            }
         } else {
            br = new BufferedReader(new InputStreamReader(urlConn.getErrorStream()));

            while((responseBody = br.readLine()) != null) {
               response.append(responseBody);
            }

            br.close();
         }

         PrintStream var10000 = System.out;
         String var10001 = SDx_Application.getLineNumber();
         var10000.println(var10001 + " response: " + response.toString());
         return response.toString();
      } catch (Exception var7) {
         reporter.reportError(var7.toString());
         return null;
      }
   }

   public JSONObject connectorPostJson(Reporter reporter) {
      new JSONObject();

      try {
         reporter.reportInfo("ingresó a conectorPostJson para Solicitar token.");
         System.setProperty("https.protocols", "TLSv1,TLSv1.1,TLSv1.2");
         String responseBody = "";
         URL urlObjConnMet = new URL(this.urlLink);
         System.setProperty("https.protocols", "TLSv1,TLSv1.1,TLSv1.2");
         urlConn = (HttpURLConnection)urlObjConnMet.openConnection();
         urlConn.setDoOutput(true);
         urlConn.setRequestMethod("POST");
         urlConn.setRequestProperty("Authorization", "Basic " + this.basicAuth());
         urlConn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
         urlConn.setConnectTimeout(30000);
         urlConn.setReadTimeout(30000);
         System.setProperty("https.protocols", "TLSv1,TLSv1.1,TLSv1.2");
         outputStream = urlConn.getOutputStream();
         OutputStreamWriter osw = new OutputStreamWriter(outputStream, "UTF-8");
         osw.write("grant_type=openapi_2lo");
         osw.flush();
         osw.close();
         StringBuilder response = new StringBuilder();
         System.setProperty("https.protocols", "TLSv1,TLSv1.1,TLSv1.2");
         BufferedReader br;
         if (100 <= urlConn.getResponseCode() && urlConn.getResponseCode() <= 399) {
            br = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));

            while((responseBody = br.readLine()) != null) {
               response.append(responseBody);
            }
         } else {
            br = new BufferedReader(new InputStreamReader(urlConn.getErrorStream()));

            while((responseBody = br.readLine()) != null) {
               response.append(responseBody);
            }

            br.close();
         }

         String stringConectionAnswer = response.toString();
         JSONObject jsonTokenObject = new JSONObject(stringConectionAnswer);
         long unixTimestamp = Instant.now().getEpochSecond();
         System.out.println("unixTimestamp: " + unixTimestamp);
         jsonTokenObject.put("serverTimestamp", unixTimestamp);
         jsonTokenObject.put("tokenExpire", unixTimestamp + (long)jsonTokenObject.getInt("expires_in"));
         return jsonTokenObject;
      } catch (Exception var11) {
         reporter.reportError(var11.toString());
         return null;
      }
   }

   public boolean validateToken(JSONObject fullToken) {
      long nowUnix = Instant.now().getEpochSecond();

      try {
         if (fullToken.isNull("tokenExpire")) {
            return false;
         } else {
            return fullToken.getLong("tokenExpire") > nowUnix + 30L;
         }
      } catch (Exception var5) {
         return false;
      }
   }

   JSONObject queryAuthToken(JSONObject inputParams, final Reporter reporter) {
      String var10001;
      try {
         new URL(inputParams.getString("url"));
         SSLContext sslContext = SSLContext.getInstance("TLSv1.2");
         sslContext.init((KeyManager[])null, (TrustManager[])null, new SecureRandom());
         System.setProperty("https.protocols", "TLSv1,TLSv1.1,TLSv1.2");
         URL urlObjConnMet = new URL(inputParams.getString("url"));
         System.setProperty("https.protocols", "TLSv1.1,TLSv1.2");
         urlConn = (HttpsURLConnection)urlObjConnMet.openConnection();
         urlConn.setDoOutput(true);
         urlConn.setDoInput(true);
         urlConn.setRequestMethod("POST");
         HttpURLConnection var10000 = urlConn;
         String var10002 = this.basicAuth(inputParams);
         var10000.setRequestProperty("Authorization", "Basic " + var10002);
         urlConn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
         urlConn.setConnectTimeout(30000);
         urlConn.setReadTimeout(30000);
         outputStream = urlConn.getOutputStream();
         OutputStreamWriter osw = new OutputStreamWriter(outputStream, "UTF-8");
         osw.write("grant_type=openapi_2lo");
         osw.flush();
         osw.close();
         StringBuilder response = new StringBuilder();
         String responseBody;
         BufferedReader br;
         if (100 <= urlConn.getResponseCode() && urlConn.getResponseCode() <= 399) {
            br = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));

            while((responseBody = br.readLine()) != null) {
               response.append(responseBody);
            }
         } else {
            br = new BufferedReader(new InputStreamReader(urlConn.getErrorStream()));

            while((responseBody = br.readLine()) != null) {
               response.append(responseBody);
            }

            br.close();
         }

         var10001 = SDx_Application.getLineNumber();
         reporter.reportInfo(var10001 + " Rta: " + response.toString());
         JSONObject totalResponse = new JSONObject(response.toString());
         return totalResponse;
      } catch (Exception var11) {
         System.out.println(var11);
         var10001 = SDx_Application.getLineNumber();
         reporter.reportInfo(var10001 + " Se ha presentado un error al intentar consultar el token de autorización, la excepción es: \n" + var11);
         return null;
      }
   }

   JSONObject queryAuthToken(JSONObject inputParams) {
      try {
         URL urlObjConnMet = new URL(inputParams.getString("url"));
         urlConn = (HttpURLConnection)urlObjConnMet.openConnection();
         urlConn.setDoOutput(true);
         urlConn.setRequestMethod("POST");
         HttpURLConnection var9 = urlConn;
         String var10002 = this.basicAuth(inputParams);
         var9.setRequestProperty("Authorization", "Basic " + var10002);
         urlConn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
         urlConn.setConnectTimeout(30000);
         urlConn.setReadTimeout(30000);
         outputStream = urlConn.getOutputStream();
         OutputStreamWriter osw = new OutputStreamWriter(outputStream, "UTF-8");
         osw.write("grant_type=openapi_2lo");
         osw.flush();
         osw.close();
         StringBuilder response = new StringBuilder();
         String responseBody;
         BufferedReader br;
         if (100 <= urlConn.getResponseCode() && urlConn.getResponseCode() <= 399) {
            br = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));

            while((responseBody = br.readLine()) != null) {
               response.append(responseBody);
            }
         } else {
            br = new BufferedReader(new InputStreamReader(urlConn.getErrorStream()));

            while((responseBody = br.readLine()) != null) {
               response.append(responseBody);
            }

            br.close();
         }

         JSONObject totalResponse = new JSONObject(response.toString());
         return totalResponse;
      } catch (Exception var8) {
         PrintStream var10000 = System.out;
         String var10001 = SDx_Application.getLineNumber();
         var10000.println(var10001 + "se presentó una excepcion al solicitar el token: " + var8);
         return null;
      }
   }

   public void queryAuthTokenCurl(JSONObject inputParams, Reporter reporter) throws IOException {
      String line = null;
      String command = "curl --location --request POST 'https://api.ariba.com/v2/oauth/token' --header 'Content-Type: application/x-www-form-urlencoded' --header 'Authorization: Basic ZGQyY2Q0NjgtYzkyMi00YWM3LTliY2YtYmNjNzljMmMyZGVmOmt2R012bFkwcTVOZUpxRnYxd0RZRmkzVjNmakVTdzhj' --data-urlencode 'grant_type=openapi_2lo'";
      Process process = Runtime.getRuntime().exec(command);
      BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

      try {
         while((line = reader.readLine()) != null) {
            reporter.reportInfo(line);
         }
      } catch (IOException var8) {
         String var10001 = SDx_Application.getLineNumber();
         reporter.reportInfo(var10001 + " Se ha encontrado una excepcion." + var8);
         var8.printStackTrace();
      }

   }

   public JSONArray newConnectorPost(connectionObject connectionObject, Reporter reporter) {
      try {
         String responseBody = "";
         String urlQuery = connectionObject.getUrl();
         URL urlObjConnMet = new URL(urlQuery);
         urlConn = (HttpURLConnection)urlObjConnMet.openConnection();
         urlConn.setDoOutput(true);
         urlConn.setRequestMethod("POST");
         urlConn.setRequestProperty("Authorization", "Bearer " + connectionObject.getAcces_token());
         urlConn.setRequestProperty("Content-Type", "application/json");
         urlConn.setRequestProperty("APIkey", connectionObject.getAPIkey());
         urlConn.setConnectTimeout(120000);
         urlConn.setReadTimeout(120000);
         outputStream = urlConn.getOutputStream();
         OutputStreamWriter osw = new OutputStreamWriter(outputStream, "UTF-8");
         osw.write("{\"outputFormat\": \"JSON\", \"withQuestionnaire\":true, \"smVendorIds\":[]}");
         osw.flush();
         osw.close();
         StringBuilder response = new StringBuilder();
         System.out.println(SDx_Application.getLineNumber());
         BufferedReader br;
         if (100 <= urlConn.getResponseCode() && urlConn.getResponseCode() <= 399) {
            br = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));

            while((responseBody = br.readLine()) != null) {
               response.append(responseBody);
            }
         } else {
            br = new BufferedReader(new InputStreamReader(urlConn.getErrorStream()));

            while((responseBody = br.readLine()) != null) {
               response.append(responseBody);
            }

            br.close();
         }

         JSONArray jsonRta = new JSONArray(response.toString());
         return jsonRta;
      } catch (Exception var10) {
         reporter.reportError("Error en conexión: ", var10);
         PrintStream var10000 = System.out;
         String var10001 = SDx_Application.getLineNumber();
         var10000.println(var10001 + " ---> " + var10);
         return null;
      }
   }

   public JSONObject postQuery(connectionObject connectionObject) {
      try {
         String responseBody = "";
         URL urlObjConnMet = new URL(connectionObject.getUrl());
         urlConn = (HttpURLConnection)urlObjConnMet.openConnection();
         urlConn.setDoOutput(true);
         urlConn.setRequestMethod("GET");
         urlConn.setRequestProperty("Authorization", "Bearer " + connectionObject.getAcces_token());
         urlConn.setRequestProperty("User-Agent", "Mozilla/5.0");
         urlConn.setRequestProperty("APIkey", connectionObject.getAPIkey());
         urlConn.setConnectTimeout(30000);
         urlConn.setReadTimeout(30000);
         StringBuilder response = new StringBuilder();
         BufferedReader br;
         if (100 <= urlConn.getResponseCode() && urlConn.getResponseCode() <= 399) {
            br = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));

            while((responseBody = br.readLine()) != null) {
               response.append(responseBody);
            }
         } else {
            br = new BufferedReader(new InputStreamReader(urlConn.getErrorStream()));

            while((responseBody = br.readLine()) != null) {
               response.append(responseBody);
            }

            br.close();
         }

         PrintStream var10000 = System.out;
         String var10001 = SDx_Application.getLineNumber();
         var10000.println(var10001 + " --- " + response.toString());
         JSONObject jsonRta = new JSONObject();
         String answer = response.toString();
         if (answer != "" && !answer.equals("")) {
            jsonRta = new JSONObject(response.toString());
            return jsonRta;
         } else {
            return jsonRta;
         }
      } catch (Exception var9) {
         System.out.println(var9);
         return null;
      }
   }

   public JSONObject getQuery(connectionObject connectionObject, Reporter reporter) {
      StringBuilder response = new StringBuilder();
      String responseBody = "";

      try {
         URL urlObjConnMet = new URL(connectionObject.getUrl());
         urlConn = (HttpURLConnection)urlObjConnMet.openConnection();
         urlConn.setDoOutput(true);
         urlConn.setRequestMethod("GET");
         urlConn.setRequestProperty("Authorization", "Bearer " + connectionObject.getAcces_token());
         urlConn.setRequestProperty("User-Agent", "Mozilla/5.0");
         urlConn.setRequestProperty("APIkey", connectionObject.getAPIkey());
         urlConn.setConnectTimeout(30000);
         urlConn.setReadTimeout(30000);
         BufferedReader br;
         if (100 <= urlConn.getResponseCode() && urlConn.getResponseCode() <= 399) {
            br = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));

            while((responseBody = br.readLine()) != null) {
               response.append(responseBody);
            }
         } else {
            br = new BufferedReader(new InputStreamReader(urlConn.getErrorStream()));

            while((responseBody = br.readLine()) != null) {
               response.append(responseBody);
            }

            br.close();
         }

         JSONObject jsonRta = new JSONObject();
         String answer = response.toString();
         if (answer != "" && !answer.equals("")) {
            jsonRta = new JSONObject(response.toString());
            return jsonRta;
         } else {
            return jsonRta;
         }
      } catch (Exception var10) {
         System.out.println(var10);
         return null;
      }
   }

   public JSONObject postQueryGeneral(connectionObject connectionObject) {
      try {
         String responseBody = "";
         URL urlObjConnMet = new URL(connectionObject.getUrl());
         urlConn = (HttpURLConnection)urlObjConnMet.openConnection();
         urlConn.setDoOutput(true);
         urlConn.setRequestMethod("POST");
         urlConn.setRequestProperty("Authorization", "Bearer " + connectionObject.getAcces_token());
         urlConn.setRequestProperty("Content-Type", "application/json");
         urlConn.setRequestProperty("APIkey", connectionObject.getAPIkey());
         urlConn.setConnectTimeout(30000);
         urlConn.setReadTimeout(30000);
         outputStream = urlConn.getOutputStream();
         OutputStreamWriter osw = new OutputStreamWriter(outputStream, "UTF-8");
         osw.write(connectionObject.getPayload());
         osw.flush();
         osw.close();
         StringBuilder response = new StringBuilder();
         BufferedReader br;
         if (100 <= urlConn.getResponseCode() && urlConn.getResponseCode() <= 399) {
            br = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));

            while((responseBody = br.readLine()) != null) {
               response.append(responseBody);
            }
         } else {
            br = new BufferedReader(new InputStreamReader(urlConn.getErrorStream()));

            while((responseBody = br.readLine()) != null) {
               response.append(responseBody);
            }

            br.close();
         }

         PrintStream var10000 = System.out;
         String var10001 = SDx_Application.getLineNumber();
         var10000.println(var10001 + " response code:   " + urlConn.getResponseCode());
         var10000 = System.out;
         var10001 = SDx_Application.getLineNumber();
         var10000.println(var10001 + " response String: " + response.toString());
         JSONObject jsonRta = new JSONObject();
         String answer = response.toString();
         if (answer != "" && !answer.equals("")) {
            jsonRta = new JSONObject();
            jsonRta.put("code", urlConn.getResponseCode());
            if (urlConn.getResponseCode() == 429) {
               jsonRta.put("text", response.toString());
               jsonRta.put("code", urlConn.getResponseCode());
            } else {
               jsonRta = new JSONObject(response.toString());
               jsonRta.put("code", urlConn.getResponseCode());
            }

            return jsonRta;
         } else {
            jsonRta.put("code", urlConn.getResponseCode());
            return jsonRta;
         }
      } catch (Exception var9) {
         System.out.println(var9);
         return null;
      }
   }

   public JSONObject postQueryGeneralV2(connectionObject connectionObject) {
      try {
         boolean isComplete = false;
         StringBuilder response = new StringBuilder();
         int triesCounter = 0;

         while(!isComplete) {
            String responseBody = "";
            URL urlObjConnMet = new URL(connectionObject.getUrl());
            urlConn = (HttpURLConnection)urlObjConnMet.openConnection();
            urlConn.setDoOutput(true);
            urlConn.setRequestMethod("POST");
            urlConn.setRequestProperty("Authorization", "Bearer " + connectionObject.getAcces_token());
            urlConn.setRequestProperty("Content-Type", "application/json");
            urlConn.setRequestProperty("APIkey", connectionObject.getAPIkey());
            urlConn.setConnectTimeout(30000);
            urlConn.setReadTimeout(30000);
            outputStream = urlConn.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(outputStream, "UTF-8");
            osw.write(connectionObject.getPayload());
            osw.flush();
            osw.close();
            response = new StringBuilder();
            BufferedReader br;
            if (100 <= urlConn.getResponseCode() && urlConn.getResponseCode() <= 399) {
               br = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));

               while((responseBody = br.readLine()) != null) {
                  response.append(responseBody);
               }

               isComplete = true;
            } else {
               br = new BufferedReader(new InputStreamReader(urlConn.getErrorStream()));

               while((responseBody = br.readLine()) != null) {
                  response.append(responseBody);
               }

               br.close();
               TimeUnit.SECONDS.sleep(30L);
               ++triesCounter;
               if (triesCounter >= 12) {
                  isComplete = true;
               }
            }

            PrintStream var10000 = System.out;
            String var10001 = SDx_Application.getLineNumber();
            var10000.println(var10001 + " response code:   " + urlConn.getResponseCode());
            var10000 = System.out;
            var10001 = SDx_Application.getLineNumber();
            var10000.println(var10001 + " response String: " + response.toString());
         }

         JSONObject jsonRta = new JSONObject();
         String answer = response.toString();
         if (answer != "" && !answer.equals("")) {
            jsonRta.put("code", urlConn.getResponseCode());
            if (urlConn.getResponseCode() == 429) {
               jsonRta.put("text", response.toString());
               jsonRta.put("code", urlConn.getResponseCode());
            } else {
               jsonRta = new JSONObject(response.toString());
               jsonRta.put("code", urlConn.getResponseCode());
            }

            return jsonRta;
         } else {
            jsonRta.put("code", urlConn.getResponseCode());
            return jsonRta;
         }
      } catch (Exception var9) {
         System.out.println(var9);
         return null;
      }
   }

   public JSONObject postQueryGeneralV3(JSONObject connectionObject) {
      try {
         boolean isComplete = false;
         StringBuilder response = new StringBuilder();
         int triesCounter = 0;

         while(!isComplete) {
            String responseBody = "";
            URL urlObjConnMet = new URL(connectionObject.getString("url"));
            urlConn = (HttpURLConnection)urlObjConnMet.openConnection();
            urlConn.setDoOutput(true);
            urlConn.setRequestMethod("POST");
            urlConn.setRequestProperty("Authorization", "Bearer " + connectionObject.getString("access_token"));
            urlConn.setRequestProperty("Content-Type", "application/json");
            urlConn.setRequestProperty("APIkey", connectionObject.getString("APIkey"));
            urlConn.setConnectTimeout(30000);
            urlConn.setReadTimeout(30000);
            outputStream = urlConn.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(outputStream, "UTF-8");
            osw.write(connectionObject.getString("payload"));
            osw.flush();
            osw.close();
            response = new StringBuilder();
            BufferedReader br;
            if (100 <= urlConn.getResponseCode() && urlConn.getResponseCode() <= 399) {
               br = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));

               while((responseBody = br.readLine()) != null) {
                  response.append(responseBody);
               }

               isComplete = true;
            } else {
               br = new BufferedReader(new InputStreamReader(urlConn.getErrorStream()));

               while((responseBody = br.readLine()) != null) {
                  response.append(responseBody);
               }

               br.close();
               TimeUnit.SECONDS.sleep(30L);
               ++triesCounter;
               if (triesCounter >= 12) {
                  isComplete = true;
               }
            }

            PrintStream var10000 = System.out;
            String var10001 = SDx_Application.getLineNumber();
            var10000.println(var10001 + " response code:   " + urlConn.getResponseCode());
            var10000 = System.out;
            var10001 = SDx_Application.getLineNumber();
            var10000.println(var10001 + " response String: " + response.toString());
         }

         JSONObject jsonRta = new JSONObject();
         String answer = response.toString();
         if (answer != "" && !answer.equals("")) {
            jsonRta.put("code", urlConn.getResponseCode());
            if (urlConn.getResponseCode() == 429) {
               jsonRta.put("text", response.toString());
               jsonRta.put("code", urlConn.getResponseCode());
            } else {
               jsonRta = new JSONObject(response.toString());
               jsonRta.put("code", urlConn.getResponseCode());
            }

            return jsonRta;
         } else {
            jsonRta.put("code", urlConn.getResponseCode());
            return jsonRta;
         }
      } catch (Exception var9) {
         System.out.println(var9);
         return null;
      }
   }

   public JSONObject postQueryGeneralV3(JSONObject connectionObject, Reporter reporter) {
      try {
         boolean isComplete = false;
         StringBuilder response = new StringBuilder();
         int triesCounter = 0;

         while(!isComplete) {
            String responseBody = "";
            URL urlObjConnMet = new URL(connectionObject.getString("url"));
            urlConn = (HttpURLConnection)urlObjConnMet.openConnection();
            urlConn.setDoOutput(true);
            urlConn.setRequestMethod("POST");
            urlConn.setRequestProperty("Authorization", "Bearer " + connectionObject.getString("access_token"));
            urlConn.setRequestProperty("Content-Type", "application/json");
            urlConn.setRequestProperty("APIkey", connectionObject.getString("APIkey"));
            urlConn.setConnectTimeout(30000);
            urlConn.setReadTimeout(30000);
            outputStream = urlConn.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(outputStream, "UTF-8");
            osw.write(connectionObject.getString("payload"));
            osw.flush();
            osw.close();
            response = new StringBuilder();
            BufferedReader br;
            if (100 <= urlConn.getResponseCode() && urlConn.getResponseCode() <= 399) {
               br = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));

               while((responseBody = br.readLine()) != null) {
                  response.append(responseBody);
               }

               isComplete = true;
            } else {
               reporter.reportInfo("Conection response code: " + urlConn.getResponseCode());
               br = new BufferedReader(new InputStreamReader(urlConn.getErrorStream()));

               while((responseBody = br.readLine()) != null) {
                  response.append(responseBody);
               }

               br.close();
               TimeUnit.SECONDS.sleep(30L);
               ++triesCounter;
               if (triesCounter >= 8) {
                  isComplete = true;
               }
            }

            PrintStream var10000 = System.out;
            String var10001 = SDx_Application.getLineNumber();
            var10000.println(var10001 + " response code:   " + urlConn.getResponseCode());
            var10000 = System.out;
            var10001 = SDx_Application.getLineNumber();
            var10000.println(var10001 + " response String: " + response.toString());
         }

         JSONObject jsonRta = new JSONObject();
         String answer = response.toString();
         if (answer != "" && !answer.equals("")) {
            jsonRta.put("code", urlConn.getResponseCode());
            if (urlConn.getResponseCode() == 429) {
               jsonRta.put("text", response.toString());
               jsonRta.put("code", urlConn.getResponseCode());
            } else {
               jsonRta = new JSONObject(response.toString());
               jsonRta.put("code", urlConn.getResponseCode());
            }

            return jsonRta;
         } else {
            jsonRta.put("code", urlConn.getResponseCode());
            return jsonRta;
         }
      } catch (Exception var10) {
         System.out.println(var10);
         return null;
      }
   }

   public JSONObject postQuery(JSONObject connectionObject, Reporter reporter) throws MalformedURLException, ProtocolException, IOException, InterruptedException {
      OkHttpClient client = (new OkHttpClient()).newBuilder().build();
      MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
      JSONObject payload = connectionObject.getJSONObject("payload");
      String bodyString = DataOperators.json2stringConcatenated(payload);
      RequestBody body = RequestBody.create(mediaType, bodyString);
      Request request = (new Builder()).url(connectionObject.getString("url")).method("POST", body).build();
      Response response = client.newCall(request).execute();
      JSONObject answerToSend = new JSONObject();
      answerToSend.put("code", response.code());
      answerToSend.put("message", response.message());
      String answerBodyReceived = response.body().string();
      JSONObject answerBody = new JSONObject(answerBodyReceived);
      int unixTimestamp = (int)Instant.now().getEpochSecond();
      answerBody.put("generation_time", unixTimestamp);
      answerBody.put("expiration_time", unixTimestamp + answerBody.getInt("expires_in"));
      answerToSend.put("body", answerBody);
      return answerToSend;
   }

   public JSONObject getQueryGeneral(connectionObject connectionObject) {
      try {
         String responseBody = "";
         URL urlObjConnMet = new URL(connectionObject.getUrl());
         urlConn = (HttpURLConnection)urlObjConnMet.openConnection();
         urlConn.setDoOutput(true);
         urlConn.setRequestMethod("GET");
         urlConn.setRequestProperty("Authorization", "Bearer " + connectionObject.getAcces_token());
         urlConn.setRequestProperty("User-Agent", "Mozilla/5.0");
         urlConn.setRequestProperty("APIkey", connectionObject.getAPIkey());
         urlConn.setConnectTimeout(30000);
         urlConn.setReadTimeout(30000);
         if (!Objects.isNull(connectionObject.getPayload())) {
            outputStream = urlConn.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(outputStream, "UTF-8");
            osw.write(connectionObject.getPayload());
            osw.flush();
            osw.close();
         }

         StringBuilder response = new StringBuilder();
         BufferedReader br;
         if (100 <= urlConn.getResponseCode() && urlConn.getResponseCode() <= 399) {
            br = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));

            while((responseBody = br.readLine()) != null) {
               response.append(responseBody);
            }
         } else {
            br = new BufferedReader(new InputStreamReader(urlConn.getErrorStream()));

            while((responseBody = br.readLine()) != null) {
               response.append(responseBody);
            }

            br.close();
         }

         PrintStream var10000 = System.out;
         String var10001 = SDx_Application.getLineNumber();
         var10000.println(var10001 + " response code:   " + urlConn.getResponseCode());
         var10000 = System.out;
         var10001 = SDx_Application.getLineNumber();
         var10000.println(var10001 + " response String: " + response.toString());
         JSONObject jsonRta = new JSONObject();
         String answer = response.toString();
         if (answer != "" && !answer.equals("")) {
            jsonRta = new JSONObject(response.toString());
            return jsonRta;
         } else {
            return jsonRta;
         }
      } catch (Exception var9) {
         System.out.println(var9);
         return null;
      }
   }

   public JSONObject getQueryGeneral(JSONObject connectionObject) {
      try {
         String responseBody = "";
         URL urlObjConnMet = new URL(connectionObject.getString("url"));
         urlConn = (HttpURLConnection)urlObjConnMet.openConnection();
         urlConn.setDoOutput(true);
         urlConn.setRequestMethod("GET");
         urlConn.setRequestProperty("Authorization", "Bearer " + connectionObject.getString("access_token"));
         urlConn.setRequestProperty("User-Agent", "Mozilla/5.0");
         urlConn.setRequestProperty("APIkey", connectionObject.getString("APIkey"));
         urlConn.setConnectTimeout(120000);
         urlConn.setReadTimeout(120000);
         StringBuilder response = new StringBuilder();
         BufferedReader br;
         if (100 <= urlConn.getResponseCode() && urlConn.getResponseCode() <= 399) {
            br = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));

            while((responseBody = br.readLine()) != null) {
               response.append(responseBody);
            }
         } else {
            br = new BufferedReader(new InputStreamReader(urlConn.getErrorStream()));

            while((responseBody = br.readLine()) != null) {
               response.append(responseBody);
            }

            br.close();
         }

         JSONObject jsonRta = new JSONObject();
         String answer = response.toString();
         if (answer != "" && !answer.equals("")) {
            jsonRta = new JSONObject(response.toString());
            jsonRta.put("code", urlConn.getResponseCode());
            return jsonRta;
         } else {
            jsonRta.put("code", urlConn.getResponseCode());
            return jsonRta;
         }
      } catch (Exception var9) {
         System.out.println(var9);
         System.out.println(SDx_Application.getLineNumber());
         System.out.println("connectionObject: " + connectionObject.toString(2));
         return null;
      }
   }

   public JSONObject getQueryGp(JSONObject connectionObject, Reporter reporter) {
      try {
         String responseBody = "";
         URL urlObjConnMet = new URL(connectionObject.getString("url"));
         urlConn = (HttpURLConnection)urlObjConnMet.openConnection();
         urlConn.setDoOutput(true);
         urlConn.setRequestMethod("GET");
         new JSONObject();
         urlConn.setRequestProperty("Accept-Charset", StandardCharsets.UTF_8.toString());
         JSONObject headers = connectionObject.getJSONObject("headers");
         Iterator keys = headers.keys();

         while(keys.hasNext()) {
            String currentHeaderKey = (String)keys.next();
            String currentHeaderValue = headers.getString(currentHeaderKey);
            urlConn.setRequestProperty(currentHeaderKey, currentHeaderValue);
         }

         urlConn.setConnectTimeout(120000);
         urlConn.setReadTimeout(120000);
         StringBuilder response = new StringBuilder();
         BufferedReader br;
         if (100 <= urlConn.getResponseCode() && urlConn.getResponseCode() <= 399) {
            br = new BufferedReader(new InputStreamReader(urlConn.getInputStream(), StandardCharsets.UTF_8));

            while((responseBody = br.readLine()) != null) {
               response.append(responseBody);
            }
         } else {
            br = new BufferedReader(new InputStreamReader(urlConn.getErrorStream()));

            while((responseBody = br.readLine()) != null) {
               response.append(responseBody);
            }

            br.close();
         }

         JSONObject jsonRta = new JSONObject();
         String answer = response.toString();
         if (answer != "" && !answer.equals("")) {
            jsonRta = new JSONObject(answer);
            jsonRta.put("code", urlConn.getResponseCode());
            return jsonRta;
         } else {
            jsonRta.put("code", urlConn.getResponseCode());
            return jsonRta;
         }
      } catch (Exception var12) {
         String var10001 = SDx_Application.getLineNumber();
         reporter.reportError(var10001 + " " + var12.toString());
         reporter.reportError("connectionObject: " + connectionObject.toString(2));
         return null;
      }
   }

   public JSONObject ConnectorPostGeneralV3(JSONObject connectionObject) {
      JSONObject jsonRta = new JSONObject();
      String responseBody = "";
      StringBuilder response = new StringBuilder();
      boolean isComplete = false;
      int triesCounter = 0;

      try {
         System.setProperty("https.protocols", "TLSv1,TLSv1.1,TLSv1.2");

         while(true) {
            while(!isComplete) {
               String urlDestino = connectionObject.getString("url");
               URL urlObjConnMet = new URL(urlDestino);
               System.setProperty("https.protocols", "TLSv1,TLSv1.1,TLSv1.2");
               urlConn = (HttpURLConnection)urlObjConnMet.openConnection();
               urlConn.setDoOutput(true);
               urlConn.setRequestMethod("GET");
               urlConn.setRequestProperty("Authorization", "Bearer " + connectionObject.getString("access_token"));
               urlConn.setRequestProperty("User-Agent", "Mozilla/5.0");
               String apiKey = connectionObject.getString("APIkey");
               urlConn.setRequestProperty("APIkey", apiKey);
               urlConn.setConnectTimeout(30000);
               urlConn.setReadTimeout(30000);
               String payload = null;
               payload = connectionObject.getString("payload");
               if (payload != null) {
                  OutputStreamWriter osw = new OutputStreamWriter(outputStream, "UTF-8");
                  osw.write(connectionObject.getString("payload"));
                  osw.flush();
                  osw.close();
               }

               int responseCode = urlConn.getResponseCode();
               System.out.println("resposeCode:" + responseCode);
               BufferedReader br;
               if (100 <= urlConn.getResponseCode() && urlConn.getResponseCode() <= 399) {
                  br = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));

                  while((responseBody = br.readLine()) != null) {
                     response.append(responseBody);
                  }

                  System.out.println(SDx_Application.getLineNumber() + " si supero el while.");
                  jsonRta = new JSONObject(response.toString());
                  isComplete = true;
               } else {
                  br = new BufferedReader(new InputStreamReader(urlConn.getErrorStream()));

                  while((responseBody = br.readLine()) != null) {
                     response.append(responseBody);
                  }

                  br.close();
                  jsonRta.put("error", responseCode);
                  TimeUnit.SECONDS.sleep(30L);
                  ++triesCounter;
                  if (triesCounter >= 12) {
                     isComplete = true;
                  }
               }
            }

            return jsonRta;
         }
      } catch (Exception var14) {
         System.out.println(var14);
         jsonRta.put("error", 500);
         return jsonRta;
      }
   }

   public JSONObject ConnectorPostGeneralV3(JSONObject connectionObject, Reporter reporter) {
      JSONObject jsonRta = new JSONObject();
      String responseBody = "";
      StringBuilder response = new StringBuilder();
      boolean isComplete = false;
      int triesCounter = 0;

      try {
         while(true) {
            while(!isComplete) {
               String urlDestino = connectionObject.getString("url");
               URL urlObjConnMet = new URL(urlDestino);
               urlConn = (HttpURLConnection)urlObjConnMet.openConnection();
               urlConn.setDoOutput(true);
               urlConn.setRequestMethod("GET");
               urlConn.setRequestProperty("Authorization", "Bearer " + connectionObject.getString("access_token"));
               urlConn.setRequestProperty("User-Agent", "Mozilla/5.0");
               String apiKey = connectionObject.getString("APIkey");
               urlConn.setRequestProperty("APIkey", apiKey);
               urlConn.setConnectTimeout(30000);
               urlConn.setReadTimeout(30000);
               if (!connectionObject.isNull("payload")) {
                  OutputStreamWriter osw = new OutputStreamWriter(outputStream, "UTF-8");
                  osw.write(connectionObject.getString("payload"));
                  osw.flush();
                  osw.close();
               }

               int responseCode = urlConn.getResponseCode();
               System.out.println("resposeCode:" + responseCode);
               BufferedReader br;
               if (100 <= urlConn.getResponseCode() && urlConn.getResponseCode() <= 399) {
                  br = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));

                  while((responseBody = br.readLine()) != null) {
                     response.append(responseBody);
                  }

                  jsonRta = new JSONObject(response.toString());
                  isComplete = true;
               } else {
                  br = new BufferedReader(new InputStreamReader(urlConn.getErrorStream()));

                  while((responseBody = br.readLine()) != null) {
                     response.append(responseBody);
                  }

                  br.close();
                  jsonRta.put("error", responseCode);
                  TimeUnit.SECONDS.sleep(1L);
                  ++triesCounter;
                  if (triesCounter >= 12) {
                     isComplete = true;
                  }
               }
            }

            return jsonRta;
         }
      } catch (Exception var14) {
         reporter.reportError(SDx_Application.getLineNumber() + " error en el try", var14);
         PrintStream var10000 = System.out;
         String var10001 = SDx_Application.getLineNumber();
         var10000.println(var10001 + " -------> " + var14);
         jsonRta.put("error", 500);
         return jsonRta;
      }
   }

   private String basicAuth() {
      try {
         String authString = this.UserNameOpenText + ":" + this.passwordOpenText;
         System.out.println("Auth string: " + authString);
         byte[] authEncBytes = Base64.encodeBase64(authString.getBytes());
         String authStringEnc = new String(authEncBytes);
         System.out.println("Base64 encoded auth string: " + authStringEnc);
         return authStringEnc;
      } catch (Exception var4) {
         var4.printStackTrace();
         return null;
      }
   }

   private String basicAuth(JSONObject connectionParams) {
      try {
         String var10000 = connectionParams.getString("user");
         String authString = var10000 + ":" + connectionParams.getString("pass");
         byte[] authEncBytes = Base64.encodeBase64(authString.getBytes());
         String authStringEnc = new String(authEncBytes);
         return authStringEnc;
      } catch (Exception var5) {
         var5.printStackTrace();
         return null;
      }
   }

   public void jsonString2Array(String jsonString) throws ParseException {
      Reporter reporter = null;
      ArrayList<String> ArrayListNames = new ArrayList();
      ArrayList<String> ArrayListValue = new ArrayList();
      JSONObject jsnobject = new JSONObject(jsonString);
      System.out.println("size of jsnobject=" + jsnobject.length());
      System.out.println("los elementos son:" + jsnobject.toString());
      JSONArray jsonArray = new JSONArray();
      Iterator x = jsnobject.keys();
      int n = jsnobject.length();
      int j = 0;

      String[][] fullMatrix;
      for(fullMatrix = new String[n][2]; x.hasNext(); ++j) {
         String key = (String)x.next();
         jsonArray.put(jsnobject.get(key));
         fullMatrix[j][0] = key;
         fullMatrix[j][1] = jsnobject.get(key).toString();
      }

      System.out.println("jsonArray:" + jsonArray);
      System.out.println("fullMatrix:" + fullMatrix.toString());
      String[][] var19 = fullMatrix;
      int var12 = fullMatrix.length;

      String[] matrix;
      for(int var13 = 0; var13 < var12; ++var13) {
         String[] columna = var19[var13];
         matrix = columna;
         int var16 = columna.length;

         for(int var17 = 0; var17 < var16; ++var17) {
            String fila = matrix[var17];
            System.out.println("fila   :" + fila);
         }
      }

      ArrayList<ArrayList<String>> ArrayListComplete = new ArrayList();
      JSONArray nameArray = jsnobject.names();
      JSONArray valArray = jsnobject.toJSONArray(nameArray);

      int i;
      for(i = 0; i < nameArray.length(); ++i) {
         ArrayListNames.add(nameArray.getString(i));
      }

      ArrayListComplete.add(ArrayListNames);

      for(i = 0; i < valArray.length(); ++i) {
         ArrayListValue.add(valArray.get(i).toString());
      }

      ArrayListComplete.add(ArrayListValue);
      Object[] objects = ArrayListComplete.toArray();
      matrix = null;
      System.out.println("Arrays.toString(objects):" + Arrays.toString(objects));
      System.out.println("verifique el contenido de stringArray");
   }

   public void string2json(String stringRecibido) {
      JSONObject jsnobject = new JSONObject(stringRecibido);
      JSONArray jsonArray = jsnobject.getJSONArray("");

      for(int i = 0; i < jsonArray.length(); ++i) {
         jsonArray.getJSONObject(i);
      }

   }

   public static String[] toStringArray(JSONArray array) {
      if (array == null) {
         return null;
      } else {
         String[] arr = new String[array.length()];

         for(int i = 0; i < arr.length; ++i) {
            arr[i] = array.optString(i);
         }

         return arr;
      }
   }

   public void jsonString2jsonArray(String stringEntrada) {
      System.out.println("JSON entrada: " + stringEntrada);
      JSONArray jsonArr = new JSONArray(stringEntrada);

      for(int i = 0; i < jsonArr.length(); ++i) {
         JSONObject jsonObj = jsonArr.getJSONObject(i);
         System.out.println("el objeto " + i + " es: " + jsonObj);
      }

   }

   private void assertThat(int statusCode, Predicate<Integer> equalTo) {
      throw new UnsupportedOperationException("Not supported yet.");
   }
}
