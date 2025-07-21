/* Decompiler 747ms, total 937ms, lines 1365 */
package com.wavecomm.SDx;

import com.kadme.tool.log.Reporter;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringEscapeUtils;
import org.json.JSONArray;
import org.json.JSONObject;

public class DataOperators {
   public static String json2stringConcatenated(JSONObject jsonInput) {
      String currentKey = "";
      String currentValue = "";
      String chainObject = "";
      Iterator keys = jsonInput.keys();

      while(keys.hasNext()) {
         currentKey = (String)keys.next();
         currentValue = jsonInput.get(currentKey).toString();
         chainObject = chainObject + currentKey + "=" + currentValue;
         if (keys.hasNext()) {
            chainObject = chainObject + "&";
         }
      }

      return chainObject;
   }

   public static String[] conversor_tandus(String entrada) {
      String[] salida = new String[3];

      try {
         JSONObject jsonObject = new JSONObject(entrada);
         String ticket = (String)jsonObject.get("ticket");
         salida[1] = ticket;
         String username = (String)jsonObject.get("username");
         salida[2] = username;
         salida[0] = "true";
      } catch (Exception var5) {
         System.out.println(SDx_Application.getLineNumber() + " Error desconocido en conversor tandus. ");
         var5.printStackTrace();
      }

      return salida;
   }

   public static String[] shaArray(String[][] input, String eventName, String WHEREOIL_URL, String USERNAME_WHEREOIL, String WHEREOIL_PASSWORD, String WHEREOIL_TOKEN) {
      String[] control = new String[1];

      try {
         String[] sha1Array = new String[input.length];
         String mensajes = "";
         WhereoilConexion connectOW = new WhereoilConexion(WHEREOIL_URL, USERNAME_WHEREOIL, WHEREOIL_PASSWORD, WHEREOIL_TOKEN);
         String newTicket = connectOW.getValidTicket();
         if (newTicket == "error") {
            control[0] = SDx_Application.getLineNumber() + " getValidTicket es: error";
         }

         String bulkDate = "14/10/2020";
         int i = 0;

         while(i < input.length) {
            mensajes = "";
            byte var14 = -1;
            switch(eventName.hashCode()) {
            case -955367053:
               if (eventName.equals("WhereoilEvents_EDM")) {
                  var14 = 0;
               }
            }

            switch(var14) {
            case 0:
               try {
                  boolean diff = false;
                  boolean diffCutDate = false;
                  int diffCutDate1 = dateCompare(input[i][13], bulkDate);
                  if (diffCutDate1 == 2) {
                     String var17 = "{ \"classname\": \"pvtconector:pvt_tabla\", \"eq\": [ { \"pvtconector:WELL_ID\": \"" + input[i][0] + "\"}, {\"well_data:AFE_ID\": \"" + input[i][1] + "\"}, {\"well_data:EVENT_ID\": \"" + input[i][2] + "\"}, {\"well_data:RIG_ID\": \"" + input[i][3] + "\" }] }";
                  }

                  mensajes = eventName + " " + input[i][0] + " " + input[i][1] + " " + input[i][2] + " " + input[i][3];
               } catch (Exception var18) {
                  System.err.println(SDx_Application.getLineNumber() + " Se presento una excepcion al convertir el formato fecha o construir la sentencia de borrado.");
                  mensajes = eventName + " " + input[i][0] + " " + input[i][1] + " " + input[i][2] + " " + input[i][3];
               }
            default:
               sha1Array[i] = DigestUtils.sha1Hex(mensajes);
               ++i;
            }
         }

         return sha1Array;
      } catch (Exception var19) {
         return control;
      }
   }

   public static int dateCompare(String date1, String date2) {
      byte diff = 0;

      try {
         if (date1 != "" && date1 != "null" && date2 != "" && date2 != "null") {
            SimpleDateFormat dateFormatWO = new SimpleDateFormat("d/M/yyyy");
            SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy-M-d");
            Date formatedDate1;
            if (date1.contains("/")) {
               formatedDate1 = dateFormatWO.parse(date1);
            } else {
               formatedDate1 = dateFormat2.parse(date1);
            }

            Date formatedDate2;
            if (date2.contains("/")) {
               formatedDate2 = dateFormatWO.parse(date2);
            } else {
               formatedDate2 = dateFormat2.parse(date2);
            }

            if (formatedDate2.compareTo(formatedDate1) > 0) {
               diff = 2;
            } else if (formatedDate2.compareTo(formatedDate1) == 0) {
               diff = 2;
            } else if (formatedDate2.compareTo(formatedDate1) < 0) {
               diff = 1;
            }
         }

         return diff;
      } catch (Exception var7) {
         return diff;
      }
   }

   public static int datesOperator(String date1, String date2) {
      int diff = 0;

      try {
         if (date1 != "" && date1 != "null" && date2 != "" && date2 != "null") {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy");
            LocalDate myDate1 = LocalDate.parse(date1, formatter);
            LocalDate myDate2 = LocalDate.parse(date2, formatter);
            diff = (int)ChronoUnit.DAYS.between(myDate1, myDate2);
         }

         if (diff >= 0) {
            ++diff;
         }

         return diff;
      } catch (Exception var6) {
         return -999;
      }
   }

   public static String postDate() {
      Date objDate = new Date();
      String strDateFormat = "yyyy-MM-dd";
      SimpleDateFormat objSDF = new SimpleDateFormat(strDateFormat);
      String formated = objSDF.format(objDate);
      return formated;
   }

   public static String postDateTime() {
      Date objDate = new Date();
      String strDateFormat = "yyyy-MM-dd HH:mm:ss";
      SimpleDateFormat objSDF = new SimpleDateFormat(strDateFormat);
      String formated = objSDF.format(objDate);
      return formated;
   }

   public static Date DateSubs(Date dateIn, int numDays) {
      Calendar cal = Calendar.getInstance();
      cal.setTime(dateIn);
      cal.add(5, -numDays);
      Date finalDate = cal.getTime();
      return finalDate;
   }

   public static String DateTimeFormater(Date objDate) {
      String strDateFormat = "yyyy-MM-dd HH:mm:ss";
      SimpleDateFormat objSDF = new SimpleDateFormat(strDateFormat);
      String formated = objSDF.format(objDate);
      return formated;
   }

   public static String DateFormater(Date objDate) {
      String strDateFormat = "yyyy-MM-dd";
      SimpleDateFormat objSDF = new SimpleDateFormat(strDateFormat);
      String formated = objSDF.format(objDate);
      return formated;
   }

   public static Date dateFromUnixTime(long timeStamp) {
      Instant instant = Instant.ofEpochSecond(timeStamp / 1000L);
      Date date = Date.from(instant);
      return date;
   }

   public static String[][] rs2matrix(ResultSet results) throws SQLException {
      ResultSetMetaData metadata = results.getMetaData();
      int columns = metadata.getColumnCount();
      int size = 0;
      String[] datos = new String[columns];
      if (results.last()) {
         size = results.getRow();
         results.beforeFirst();
      }

      String[][] matriz = new String[size][columns];

      for(int row = 0; results.next(); ++row) {
         for(int i = 0; i < columns; ++i) {
            if (results.getObject(i + 1) == null) {
               datos[i] = "null";
            } else {
               datos[i] = results.getObject(i + 1).toString();
            }

            matriz[row][i] = datos[i];
         }
      }

      return matriz;
   }

   public static boolean[] repeatedReg(String[][] dataRows) {
      boolean[] answer = new boolean[dataRows.length];

      for(int i = 1; i < dataRows.length; ++i) {
         if (Arrays.equals(dataRows[i], dataRows[i - 1])) {
            answer[i] = true;
         }
      }

      return answer;
   }

   public static double isDouble(String str) {
      try {
         double var1 = 0.0D;
         str = str.replaceAll(",", ".");
         var1 = Double.parseDouble(str);
         return var1;
      } catch (NumberFormatException var3) {
         return 0.0D;
      }
   }

   public static JSONArray makeDatesList(String startDate) {
      LocalDate date = LocalDate.parse(startDate);
      LocalDate now = LocalDate.now();
      LocalDate endDate = date;

      JSONArray datesList;
      for(datesList = new JSONArray(); endDate.compareTo(now) < 0; date = endDate) {
         endDate = date.plusDays(30L);
         if (endDate.compareTo(now) > 0) {
            endDate = now;
         }

         JSONObject datesPair = new JSONObject();
         datesPair.put("endDate", endDate);
         datesPair.put("startDate", date);
         datesList.put(datesPair);
      }

      return datesList;
   }

   public static JSONArray makeDatesList(String startDate, int daysInterval) {
      LocalDate date = LocalDate.parse(startDate);
      LocalDate now = LocalDate.now();
      LocalDate endDate = date;

      JSONArray datesList;
      for(datesList = new JSONArray(); endDate.compareTo(now) < 0; date = endDate) {
         endDate = date.plusDays((long)daysInterval);
         if (endDate.compareTo(now) > 0) {
            endDate = now;
         }

         org.json.simple.JSONObject datesPair = new org.json.simple.JSONObject();
         datesPair.put("endDate", endDate);
         datesPair.put("startDate", date);
         datesList.put(datesPair);
      }

      return datesList;
   }

   public static boolean isValidWindowTime(int startTimeHourInt, int endTimeHourint) {
      int hourNow = LocalTime.now().getHour();
      return startTimeHourInt <= hourNow || hourNow < endTimeHourint;
   }

   public static JSONObject makeJsonAuthParams() {
      JSONObject autenticationPayload = new JSONObject();
      JSONObject autenticationParams = new JSONObject();
      autenticationPayload.put("grant_type", "client_credentials");
      autenticationPayload.put("username", SDx_FirstFuncion.getSDx_Username());
      autenticationPayload.put("password", SDx_FirstFuncion.getSDx_password());
      autenticationPayload.put("Authorization", SDx_FirstFuncion.getSDx_Authorization());
      autenticationPayload.put("client_id", SDx_FirstFuncion.getSDx_client_id());
      autenticationPayload.put("client_secret", SDx_FirstFuncion.getSDx_client_secret());
      autenticationPayload.put("scope", SDx_FirstFuncion.getSDx_scope());
      autenticationParams.put("url", SDx_FirstFuncion.getSDx_token_URL());
      autenticationParams.put("payload", autenticationPayload);
      return autenticationParams;
   }

   public static JSONObject makeJsonAuthParamsTestConn() {
      JSONObject autenticationPayload = new JSONObject();
      JSONObject autenticationParams = new JSONObject();
      autenticationPayload.put("grant_type", "client_credentials");
      autenticationPayload.put("username", SDx_testConnection.getSDx_Username());
      autenticationPayload.put("password", SDx_testConnection.getSDx_password());
      autenticationPayload.put("Authorization", SDx_testConnection.getSDx_Authorization());
      autenticationPayload.put("client_id", SDx_testConnection.getSDx_client_id());
      autenticationPayload.put("client_secret", SDx_testConnection.getSDx_client_secret());
      autenticationPayload.put("scope", SDx_testConnection.getSDx_scope());
      autenticationParams.put("url", SDx_testConnection.getSDx_token_URL());
      autenticationParams.put("payload", autenticationPayload);
      return autenticationParams;
   }

   public static JSONObject makeJsonAuthParamsQueryUrlConn() {
      JSONObject autenticationPayload = new JSONObject();
      JSONObject autenticationParams = new JSONObject();
      autenticationPayload.put("grant_type", "client_credentials");
      autenticationPayload.put("username", SDx_QueryUrls.getSDx_Username());
      autenticationPayload.put("password", SDx_QueryUrls.getSDx_password());
      autenticationPayload.put("Authorization", SDx_QueryUrls.getSDx_Authorization());
      autenticationPayload.put("client_id", SDx_QueryUrls.getSDx_client_id());
      autenticationPayload.put("client_secret", SDx_QueryUrls.getSDx_client_secret());
      autenticationPayload.put("scope", SDx_QueryUrls.getSDx_scope());
      autenticationParams.put("url", SDx_QueryUrls.getSDx_token_URL());
      autenticationParams.put("payload", autenticationPayload);
      return autenticationParams;
   }

   public static JSONObject makeFacilityQueryParams(int skip) {
      JSONObject optionHeadersFacilities = new JSONObject();
      JSONObject facilityQueryParams = new JSONObject();
      JSONObject body = SDx_FirstFuncion.getJsonToken().getJSONObject("body");
      String var10000 = SDx_FirstFuncion.getSDx_facility_query_url();
      String url2FacilityQuery = var10000 + "$top=100&$skip=" + skip + "&$select=Name,UID&$count=true";
      optionHeadersFacilities.put("Authorization", "Bearer " + body.getString("access_token"));
      optionHeadersFacilities.put("SPFQuerySelectedConfigOnly", "false");
      facilityQueryParams.put("headers", optionHeadersFacilities);
      facilityQueryParams.put("url", url2FacilityQuery);
      return facilityQueryParams;
   }

   public static JSONObject makeProjectsListQueryParams(String projectUID, int skip2) {
      JSONObject projectsListQueryParams = new JSONObject();
      JSONObject headersProjectsList = new JSONObject();
      JSONObject var10002 = SDx_FirstFuncion.getJsonToken().getJSONObject("body");
      headersProjectsList.put("Authorization", "Bearer " + var10002.getString("access_token"));
      headersProjectsList.put("SPFQuerySelectedConfigOnly", "false");
      headersProjectsList.put("SPFConfigUID", projectUID);
      String var4 = SDx_FirstFuncion.getSDx_projects_query_url();
      projectsListQueryParams.put("url", var4 + "$count=true&$select=Name,UID&$top=100&$skip=" + skip2);
      projectsListQueryParams.put("headers", headersProjectsList);
      return projectsListQueryParams;
   }

   public static JSONObject makeProjectsDocumentsQueryParams(String projectObjectUID, int skip, Reporter reporter) throws UnsupportedEncodingException {
      JSONObject headersProjectsDocuments = new JSONObject();
      JSONObject ProjectsDocumentsQueryParams = new JSONObject();
      String date4cut = getCutDate(SDx_FirstFuncion.getQtty_of_cut_off_days_for_delete(), reporter);
      PrintStream var10000 = System.out;
      String var10001 = SDx_Application.getLineNumber();
      var10000.println(var10001 + " - " + date4cut);
      JSONObject var10002 = SDx_FirstFuncion.getJsonToken().getJSONObject("body");
      headersProjectsDocuments.put("Authorization", "Bearer " + var10002.getString("access_token"));
      headersProjectsDocuments.put("SPFQuerySelectedConfigOnly", "false");
      headersProjectsDocuments.put("SPFConfigUID", projectObjectUID);
      headersProjectsDocuments.put("SPFCreateConfigUID", projectObjectUID);
      headersProjectsDocuments.put("SPFQueryConfigUID", projectObjectUID);
      String complementoUrl = "$count=true&$expand=All_Files&$select=Id,Name,Configuración,Titulo,Revisión,Tipo_de_Documento,Estado,Disciplina,Contrato,Originador,Creación_fecha,Modificación_fecha,Área_Técnica,Orden_De_Servicio,Área,Unidad,Tipo_de_Ingenieria,Num_Doc_Interno,Código_Proyecto,Tag,SOP,SSOP,Motivo_de_emision,Fecha_Emisión,ENS_Databook,Orden_De_Compra,Versión_Entregable,VarianteCategoría,FaseSubProceso,Proceso,Entregable,Estado_Revisión_Documental&$filter=Estado%20eq%20'Current'%20and%20Modificación_fecha%20ge%20" + date4cut;
      String urlSinCondificar = SDx_FirstFuncion.getSDx_documents_projects_query_url() + "$top=100&$skip=" + skip + "&" + complementoUrl;
      String urlCodificada = URLEncoder.encode(urlSinCondificar, "UTF-8");
      urlCodificada = encodeTildes(urlSinCondificar);
      ProjectsDocumentsQueryParams.put("url", urlCodificada);
      ProjectsDocumentsQueryParams.put("headers", headersProjectsDocuments);
      return ProjectsDocumentsQueryParams;
   }

   public static void validateJsonToken(Reporter reporter) {
      JSONObject actualToken = SDx_FirstFuncion.getJsonToken();
      connectionOperations connectionObject = new connectionOperations();
      String var10001;
      if (actualToken != null && !actualToken.isEmpty() && !actualToken.equals((Object)null)) {
         int unixTimestamp = (int)Instant.now().getEpochSecond();
         int expirationTime = actualToken.getJSONObject("body").getInt("expiration_time");
         if (expirationTime <= unixTimestamp + 180) {
            try {
               SDx_FirstFuncion.setJsonToken(connectionObject.postQuery(makeJsonAuthParams(), reporter));
            } catch (Exception var6) {
               var10001 = SDx_Application.getLineNumber();
               reporter.reportError(var10001 + " - " + var6.toString());
            }
         }
      } else {
         try {
            SDx_FirstFuncion.setJsonToken(connectionObject.postQuery(makeJsonAuthParams(), reporter));
         } catch (Exception var7) {
            var10001 = SDx_Application.getLineNumber();
            reporter.reportError(var10001 + " - " + var7.toString());
         }
      }

   }

   public static JSONObject validateJsonTokenGeneral(JSONObject actualToken, JSONObject AuthParams, Reporter reporter) {
      connectionOperations connectionObject = new connectionOperations();
      if (actualToken != null && !actualToken.isEmpty() && !actualToken.equals((Object)null)) {
         int unixTimestamp = (int)Instant.now().getEpochSecond();
         int expirationTime = actualToken.getJSONObject("body").getInt("expiration_time");
         if (expirationTime <= unixTimestamp + 180) {
            try {
               actualToken = connectionObject.postQuery(AuthParams, reporter);
            } catch (Exception var7) {
               reporter.reportError(var7.toString());
            }
         }
      } else {
         try {
            actualToken = connectionObject.postQuery(AuthParams, reporter);
         } catch (Exception var8) {
            reporter.reportError(var8.toString());
         }
      }

      return actualToken;
   }

   public static void validateJsonTokenTestConn(Reporter reporter) {
      JSONObject actualToken = SDx_testConnection.getJsonToken();
      connectionOperations connectionObject = new connectionOperations();
      if (actualToken != null && !actualToken.isEmpty() && !actualToken.equals((Object)null)) {
         int unixTimestamp = (int)Instant.now().getEpochSecond();
         int expirationTime = actualToken.getJSONObject("body").getInt("expiration_time");
         if (expirationTime <= unixTimestamp + 3) {
            try {
               SDx_testConnection.setJsonToken(connectionObject.postQuery(makeJsonAuthParams(), reporter));
            } catch (Exception var6) {
               reporter.reportError(var6.toString());
            }
         }
      } else {
         try {
            JSONObject connectionParams = makeJsonAuthParamsTestConn();
            reporter.reportInfo("los parametros usados para establecer la conexión son: " + connectionParams.toString(2));
            JSONObject postQueryResult = connectionObject.postQuery(connectionParams, reporter);
            reporter.reportInfo("El resultado de la consulta es: " + postQueryResult.toString());
            SDx_testConnection.setJsonToken(postQueryResult);
         } catch (Exception var7) {
            reporter.reportError(var7.toString());
         }
      }

   }

   public static JSONArray doFacilitiesQuery(connectionOperations connectionObject, int skip, Reporter reporter) {
      JSONObject facilityQueryParams = makeFacilityQueryParams(skip);
      String var10001 = SDx_Application.getLineNumber();
      reporter.reportInfo(var10001 + " facilityQueryParams: " + facilityQueryParams);
      JSONObject facilities = connectionObject.getQueryGp(facilityQueryParams, reporter);
      JSONArray facilityValues = facilities.getJSONArray("value");
      return facilityValues;
   }

   public static JSONArray doProjectsListQuery(JSONObject project, int skip2, connectionOperations connectionObject, Reporter reporter) {
      JSONObject projectsList = new JSONObject();
      JSONObject projectsListQueryParams = new JSONObject();
      JSONArray projectsListValue = new JSONArray();

      try {
         String UID = project.get("UID").toString();
         projectsListQueryParams = makeProjectsListQueryParams(UID, skip2);
         projectsList = connectionObject.getQueryGp(projectsListQueryParams, reporter);
         if (!projectsList.has("value")) {
            reporter.reportWarning(SDx_Application.getLineNumber() + " alerta, no se encuentra la etiqueta \"value\" en el objeto json.");
            reporter.reportInfo(projectsList.toString(2));
            return projectsListValue;
         } else {
            projectsListValue = projectsList.getJSONArray("value");
            return projectsListValue;
         }
      } catch (Exception var8) {
         reporter.reportError(SDx_Application.getLineNumber() + " Se ha producido una excepcion basada en la respuesta obtenida.");
         String var10001 = SDx_Application.getLineNumber();
         reporter.reportError(var10001 + " projectsListQueryParams es: " + projectsListQueryParams.toString());
         var10001 = SDx_Application.getLineNumber();
         reporter.reportError(var10001 + " projectList es: " + projectsList.toString());
         projectsListValue = new JSONArray("[]");
         return projectsListValue;
      }
   }

   public static JSONObject doDocumentsProjectsQuery(JSONObject projectObject, int skip, connectionOperations connectionObject, Reporter reporter) {
      String projectObjectUID = projectObject.getString("UID");
      String UrlToUSe = "";
      JSONObject projectsDocumentsParams = new JSONObject();

      String var10001;
      try {
         projectsDocumentsParams = makeProjectsDocumentsQueryParams(projectObjectUID, skip, reporter);
         UrlToUSe = projectsDocumentsParams.getString("url");
      } catch (Exception var8) {
         UrlToUSe = "";
         var10001 = SDx_Application.getLineNumber();
         reporter.reportError(var10001 + " Error con la url: " + var8);
      }

      var10001 = SDx_Application.getLineNumber();
      reporter.reportInfo(var10001 + " La url a usar es:" + UrlToUSe);
      JSONObject documentsProjects = connectionObject.getQueryGp(projectsDocumentsParams, reporter);
      return documentsProjects;
   }

   public static JSONObject doNoCurrentDocumentsProjectsQuery(JSONObject projectObject, int skip, connectionOperations connectionObject, Reporter reporter) {
      String projectObjectUID = projectObject.getString("UID");
      String UrlToUSe = "";
      JSONObject projectsDocumentsParams = new JSONObject();

      String var10001;
      try {
         projectsDocumentsParams = makeNotCurrentDocumentsQueryParams(projectObjectUID, skip, reporter);
         UrlToUSe = projectsDocumentsParams.getString("url");
      } catch (Exception var8) {
         var10001 = SDx_Application.getLineNumber();
         reporter.reportError(var10001 + " Error con la url: " + var8);
         var10001 = SDx_Application.getLineNumber();
         reporter.reportError(var10001 + " UrlToUSe estaba en: " + UrlToUSe);
         UrlToUSe = "";
      }

      var10001 = SDx_Application.getLineNumber();
      reporter.reportInfo(var10001 + " La url a usar es:" + UrlToUSe);
      JSONObject documentsProjects = connectionObject.getQueryGp(projectsDocumentsParams, reporter);
      return documentsProjects;
   }

   public static JSONObject doUrlFilesQuery(String fileId, String fileUID, connectionOperations connectionObject, Reporter reporter) {
      JSONObject urlFilesParams = makeFilesUrlQueryParams(fileUID, fileId);
      JSONObject UrlFiles = connectionObject.getQueryGp(urlFilesParams, reporter);
      return UrlFiles;
   }

   public static JSONObject doUrlFilesQuery(String fileId, connectionOperations connectionObject, Reporter reporter) {
      JSONObject urlFilesParams = makeFilesUrlQueryParams(fileId);
      JSONObject UrlFiles = connectionObject.getQueryGp(urlFilesParams, reporter);
      return UrlFiles;
   }

   public static JSONObject doUrlFilesQuery(connectionOperations connectionObject, JSONObject urlFilesParams, Reporter reporter) {
      JSONObject UrlFiles = connectionObject.getQueryGp(urlFilesParams, reporter);
      return UrlFiles;
   }

   public static JSONObject makeFilesUrlQueryParams(String projectObjectUID, String fileID) {
      JSONObject headersProjectsDocuments = new JSONObject();
      JSONObject ProjectsDocumentsQueryParams = new JSONObject();
      String urlBase = SDx_FirstFuncion.getSDx_Files_URL_query_URL();
      fileID = "'" + fileID + "'";
      String fullUrl = urlBase.replace("$##$", fileID);
      JSONObject var10002 = SDx_FirstFuncion.getJsonToken().getJSONObject("body");
      headersProjectsDocuments.put("Authorization", "Bearer " + var10002.getString("access_token"));
      headersProjectsDocuments.put("SPFConfigUID", projectObjectUID);
      headersProjectsDocuments.put("SPFCreateConfigUID", projectObjectUID);
      headersProjectsDocuments.put("SPFQueryConfigUID", projectObjectUID);
      ProjectsDocumentsQueryParams.put("url", fullUrl);
      ProjectsDocumentsQueryParams.put("headers", headersProjectsDocuments);
      return ProjectsDocumentsQueryParams;
   }

   public static JSONObject makeFilesUrlQueryParams(String fileID) {
      JSONObject headersProjectsDocuments = new JSONObject();
      JSONObject ProjectsDocumentsQueryParams = new JSONObject();
      String urlBase = SDx_FirstFuncion.getSDx_Files_URL_query_URL();
      if (urlBase == null || urlBase.equals("")) {
         urlBase = SDx_QueryUrls.getSDx_Files_URL_query_URL();
      }

      fileID = "'" + fileID + "'";
      String fullUrl = urlBase.replace("$##$", fileID);
      JSONObject var10002 = SDx_FirstFuncion.getJsonToken().getJSONObject("body");
      headersProjectsDocuments.put("Authorization", "Bearer " + var10002.getString("access_token"));
      ProjectsDocumentsQueryParams.put("url", fullUrl);
      ProjectsDocumentsQueryParams.put("headers", headersProjectsDocuments);
      return ProjectsDocumentsQueryParams;
   }

   public static JSONObject makeFilesUrlQueryParamsGeneral(String fileID, String projectObjectUID, JSONObject jsonToken) {
      JSONObject headersProjectsDocuments = new JSONObject();
      JSONObject ProjectsDocumentsQueryParams = new JSONObject();
      String urlBase = SDx_FirstFuncion.getSDx_Files_URL_query_URL();
      if (urlBase == null || urlBase.equals("")) {
         urlBase = SDx_QueryUrls.getSDx_Files_URL_query_URL();
      }

      fileID = "'" + fileID + "'";
      String fullUrl = urlBase.replace("$##$", fileID);
      JSONObject var10002 = jsonToken.getJSONObject("body");
      headersProjectsDocuments.put("Authorization", "Bearer " + var10002.getString("access_token"));
      headersProjectsDocuments.put("SPFConfigUID", projectObjectUID);
      headersProjectsDocuments.put("SPFCreateConfigUID", projectObjectUID);
      headersProjectsDocuments.put("SPFQueryConfigUID", projectObjectUID);
      ProjectsDocumentsQueryParams.put("url", fullUrl);
      ProjectsDocumentsQueryParams.put("headers", headersProjectsDocuments);
      return ProjectsDocumentsQueryParams;
   }

   public static JSONObject buildJsonRegister(JSONObject documentInfo, JSONObject fileObject) {
      JSONObject unitaryRegister = new JSONObject();
      if (documentInfo.has("Name")) {
         unitaryRegister.put("sdx:Nombre_documento", documentInfo.get("Name"));
      }

      if (documentInfo.has("Titulo")) {
         unitaryRegister.put("sdx:Titulo_documento", documentInfo.get("Titulo"));
      }

      if (documentInfo.has("Revisión")) {
         unitaryRegister.put("sdx:Revision", documentInfo.get("Revisión"));
      }

      if (documentInfo.has("Tipo_de_Documento")) {
         unitaryRegister.put("sdx:Tipo_de_documento", documentInfo.get("Tipo_de_Documento"));
      }

      if (documentInfo.has("Estado")) {
         unitaryRegister.put("sdx:Estado", documentInfo.get("Estado"));
      }

      if (documentInfo.has("Disciplina")) {
         unitaryRegister.put("sdx:Disciplina", documentInfo.get("Disciplina"));
      }

      if (documentInfo.has("Contrato")) {
         unitaryRegister.put("sdx:Contrato", documentInfo.get("Contrato"));
      }

      if (documentInfo.has("Originador")) {
         unitaryRegister.put("sdx:Originador", documentInfo.get("Originador"));
      }

      if (documentInfo.has("Creación_fecha")) {
         unitaryRegister.put("sdx:Creacion_fecha", documentInfo.get("Creación_fecha"));
      }

      if (documentInfo.has("Modificación_fecha")) {
         unitaryRegister.put("sdx:Modificacion_fecha", documentInfo.get("Modificación_fecha"));
      }

      if (documentInfo.has("Área_Técnica")) {
         unitaryRegister.put("sdx:Area_tecnica", documentInfo.get("Área_Técnica"));
      }

      if (documentInfo.has("Orden_De_Servicio")) {
         unitaryRegister.put("sdx:Orden_de_servicio", documentInfo.get("Orden_De_Servicio"));
      }

      if (documentInfo.has("Área")) {
         unitaryRegister.put("sdx:Area", documentInfo.get("Área"));
      }

      if (documentInfo.has("Unidad")) {
         unitaryRegister.put("sdx:Unidad", documentInfo.get("Unidad"));
      }

      if (documentInfo.has("Tipo_de_Ingenieria")) {
         unitaryRegister.put("sdx:Tipo_de_ingenieria", documentInfo.get("Tipo_de_Ingenieria"));
      }

      if (documentInfo.has("Num_Doc_Interno")) {
         unitaryRegister.put("sdx:Num_doc_interno", documentInfo.get("Num_Doc_Interno"));
      }

      String configString;
      int posIndex;
      if (documentInfo.has("Configuración")) {
         configString = documentInfo.get("Configuración").toString();
         if (configString.contains("_")) {
            posIndex = configString.indexOf("_");
            configString = configString.substring(posIndex + 1);
         }

         unitaryRegister.put("sdx:Codigo_proyecto_1", configString);
         unitaryRegister.put("sdx:Codigo_proyecto", configString);
      }

      if (documentInfo.has("Tag")) {
         unitaryRegister.put("sdx:Tag", documentInfo.get("Tag"));
      }

      if (documentInfo.has("SOP")) {
         unitaryRegister.put("sdx:SOP", documentInfo.get("SOP"));
      }

      if (documentInfo.has("SSOP")) {
         unitaryRegister.put("sdx:SSOP", documentInfo.get("SSOP"));
      }

      if (documentInfo.has("Motivo_de_emision")) {
         unitaryRegister.put("sdx:Motivo_de_emision", documentInfo.get("Motivo_de_emision"));
      }

      if (documentInfo.has("Fecha_Emisión")) {
         unitaryRegister.put("sdx:Fecha_de_emision", documentInfo.get("Fecha_Emisión"));
      }

      if (fileObject.has("Id")) {
         unitaryRegister.put("sdx:Id_archivo", fileObject.get("Id"));
      }

      if (fileObject.has("Name")) {
         unitaryRegister.put("sdx:Nombre_archivo", fileObject.get("Name"));
      }

      if (documentInfo.has("URL")) {
         unitaryRegister.put("sdx:URL", documentInfo.get("URL"));
      }

      if (documentInfo.has("ENS_Databook")) {
         unitaryRegister.put("sdx:Databook", documentInfo.get("ENS_Databook"));
      }

      if (documentInfo.has("Orden_De_Compra")) {
         unitaryRegister.put("sdx:Orden_De_Compra", documentInfo.get("Orden_De_Compra"));
      }

      if (documentInfo.has("Name")) {
         unitaryRegister.put("maduracionproj:Nombre_documento", documentInfo.get("Name"));
      }

      if (documentInfo.has("Titulo")) {
         unitaryRegister.put("maduracionproj:Titulo_Documento_SDX", documentInfo.get("Titulo"));
      }

      if (documentInfo.has("Revisión")) {
         unitaryRegister.put("maduracionproj:Revision", documentInfo.get("Revisión"));
      }

      if (documentInfo.has("Estado")) {
         unitaryRegister.put("maduracionproj:Estado", documentInfo.get("Estado"));
      }

      if (fileObject.has("Id")) {
         unitaryRegister.put("maduracionproj:Id_archivo", fileObject.get("Id"));
      }

      if (fileObject.has("Name")) {
         unitaryRegister.put("maduracionproj:Nombre_Archivo_SDX", fileObject.get("Name"));
      }

      if (documentInfo.has("URL")) {
         unitaryRegister.put("maduracionproj:URL_SDX", documentInfo.get("URL"));
      }

      if (documentInfo.has("ENS_Databook")) {
         unitaryRegister.put("maduracionproj:Databook", documentInfo.get("ENS_Databook"));
      }

      if (documentInfo.has("Fecha_Emisión")) {
         unitaryRegister.put("maduracionproj:Fecha_de_emision", documentInfo.get("Fecha_Emisión"));
      }

      if (documentInfo.has("Creación_fecha")) {
         unitaryRegister.put("maduracionproj:Creacion_fecha", documentInfo.get("Creación_fecha"));
      }

      if (documentInfo.has("Modificación_fecha")) {
         unitaryRegister.put("maduracionproj:Modificacion_fecha", documentInfo.get("Modificación_fecha"));
      }

      if (documentInfo.has("Configuración")) {
         configString = documentInfo.getString("Configuración");
         if (configString.contains("_")) {
            posIndex = configString.indexOf("_");
            configString = configString.substring(posIndex + 1);
         }

         unitaryRegister.put("maduracionproj:Codigo_proyecto", configString);
         unitaryRegister.put("maduracionproj:Codigo_proyecto_1", configString);
      }

      if (documentInfo.has("Versión_Entregable")) {
         unitaryRegister.put("maduracionproj:Version", documentInfo.get("Versión_Entregable"));
      }

      if (documentInfo.has("Proceso")) {
         unitaryRegister.put("maduracionproj:Proceso", documentInfo.get("Proceso"));
      }

      if (documentInfo.has("Entregable")) {
         unitaryRegister.put("maduracionproj:Entregable", documentInfo.get("Entregable"));
      }

      if (documentInfo.has("VarianteCategoría")) {
         unitaryRegister.put("maduracionproj:Categoria", documentInfo.get("VarianteCategoría"));
      }

      if (documentInfo.has("FaseSubProceso")) {
         unitaryRegister.put("maduracionproj:Fase", documentInfo.get("FaseSubProceso"));
      }

      if (documentInfo.has("Estado_Revisión_Documental")) {
         unitaryRegister.put("maduracionproj:EstadoRevisionDocumental", documentInfo.get("Estado_Revisión_Documental"));
      }

      unitaryRegister.put("maduracionproj:source", "SDx");
      return unitaryRegister;
   }

   public static int validateRules(JSONObject unitaryReg) {
      boolean atEmptyOrNull = false;
      boolean tddEP = false;
      if (unitaryReg.has("sdx:Area_tecnica") && !unitaryReg.isNull("sdx:Area_tecnica") && unitaryReg.getString("sdx:Area_tecnica") != "") {
         return 1;
      } else {
         if (!unitaryReg.has("sdx:Area_tecnica") || unitaryReg.isNull("sdx:Area_tecnica")) {
            atEmptyOrNull = true;
         }

         if (unitaryReg.has("sdx:Area_tecnica") && unitaryReg.get("sdx:Area_tecnica") == "") {
            atEmptyOrNull = true;
         }

         if (unitaryReg.has("sdx:Tipo_de_documento") && !unitaryReg.isNull("sdx:Tipo_de_documento") && unitaryReg.getString("sdx:Tipo_de_documento").equals("EP")) {
            tddEP = true;
         }

         return atEmptyOrNull && tddEP ? 2 : 3;
      }
   }

   public static JSONObject makeFullUnitaryReg(JSONObject unitaryReg, Reporter reporter) {
      JSONObject fullUnitaryRegister = new JSONObject();
      String ontologyType = "sdx:ingenieria";
      int validateRulesAns = validateRules(unitaryReg);
      if (validateRulesAns == 1) {
         ontologyType = doTypeSelection(unitaryReg.getString("sdx:Area_tecnica"), reporter);
      } else {
         if (validateRulesAns != 2) {
            reporter.reportInfo(SDx_Application.getLineNumber() + " Se recibe en validación de reglas un valor no buscado.");
            if (unitaryReg.has("sdx:Area_tecnica") && unitaryReg.isNull("sdx:Area_tecnica")) {
               reporter.reportInfo(SDx_Application.getLineNumber() + " sdx:Area_tecnica es null");
            } else if (unitaryReg.has("sdx:Area_tecnica") && !unitaryReg.isNull("sdx:Area_tecnica")) {
               String var10001 = SDx_Application.getLineNumber();
               reporter.reportInfo(var10001 + " sdx:Area_tecnica:" + unitaryReg.getString("sdx:Area_tecnica"));
            }

            return null;
         }

         ontologyType = "maduracionproj:maduracionproj";
      }

      fullUnitaryRegister.put("type", ontologyType);
      String Id = "";
      String Nombre = "";
      String Revision = "";
      String Nombre_documento = "";
      if (unitaryReg.has("sdx:Id_archivo")) {
         Id = unitaryReg.getString("sdx:Id_archivo");
      }

      if (unitaryReg.has("sdx:Nombre_archivo")) {
         Nombre = unitaryReg.getString("sdx:Nombre_archivo");
      }

      if (unitaryReg.has("sdx:Revision")) {
         Revision = unitaryReg.getString("sdx:Revision");
      }

      if (unitaryReg.has("sdx:Nombre_documento")) {
         Nombre_documento = unitaryReg.getString("sdx:Nombre_documento");
      }

      String selectedOntology = fullUnitaryRegister.has("type") && fullUnitaryRegister.getString("type").equals("maduracionproj:maduracionproj") ? SDx_FirstFuncion.getOntologyTypeHLP() : SDx_FirstFuncion.getOntologyType();
      String keyUnique = Id + selectedOntology + Nombre + Revision + Nombre_documento;
      String shaUri = DigestUtils.sha1Hex(keyUnique);
      fullUnitaryRegister.put("uri", shaUri);
      fullUnitaryRegister.put("properties", unitaryReg);
      if (keyUnique.equals(selectedOntology)) {
         fullUnitaryRegister = new JSONObject();
      }

      return fullUnitaryRegister;
   }

   public static void pushAndSendToWo(JSONObject unitaryRegister, Reporter reporter) {
      String lineaControl = SDx_Application.getLineNumber();

      try {
         lineaControl = SDx_Application.getLineNumber();
         unitaryRegister = updateUnitaryRegByOntology(unitaryRegister, reporter);
         lineaControl = SDx_Application.getLineNumber();
         if (!unitaryRegister.isEmpty() && unitaryRegister.has("type") && unitaryRegister.getString("type").equals("maduracionproj:maduracionproj")) {
            lineaControl = SDx_Application.getLineNumber();
            SDx_FirstFuncion.registerGroupToSendHLP.put(unitaryRegister);
         } else if (!unitaryRegister.isEmpty()) {
            lineaControl = SDx_Application.getLineNumber();
            SDx_FirstFuncion.registerGroupToSend.put(unitaryRegister);
         }

         if (SDx_FirstFuncion.registerGroupToSend.length() >= SDx_FirstFuncion.getWhereOil_packetSize2Write()) {
            lineaControl = SDx_Application.getLineNumber();
            passToWriteInWhereOil(SDx_FirstFuncion.registerGroupToSend, SDx_FirstFuncion.getOntologyType(), reporter);
            lineaControl = SDx_Application.getLineNumber();
            SDx_FirstFuncion.registerGroupToSend = new JSONArray();
         }

         if (SDx_FirstFuncion.registerGroupToSendHLP.length() >= SDx_FirstFuncion.getWhereOil_packetSize2Write()) {
            lineaControl = SDx_Application.getLineNumber();
            passToWriteInWhereOil(SDx_FirstFuncion.registerGroupToSendHLP, SDx_FirstFuncion.getOntologyTypeHLP(), reporter);
            lineaControl = SDx_Application.getLineNumber();
            SDx_FirstFuncion.registerGroupToSendHLP = new JSONArray();
         }
      } catch (Exception var4) {
         reporter.reportError(SDx_Application.getLineNumber() + " Se ha presentado un error al ejecutar pushAndSendToWo.");
         String var10001 = SDx_Application.getLineNumber();
         reporter.reportError(var10001 + " La linea control es: " + lineaControl);
         if (unitaryRegister != null && !unitaryRegister.isEmpty()) {
            var10001 = SDx_Application.getLineNumber();
            reporter.reportError(var10001 + " Los parametros de entrada son: \n" + unitaryRegister.toString(2));
         } else {
            reporter.reportError(SDx_Application.getLineNumber() + " unitaryRegister es null o vacio");
         }

         var10001 = SDx_Application.getLineNumber();
         reporter.reportError(var10001 + " La excepcion es: \n" + var4.toString());
      }

   }

   public static void pushAndSendToWoByQueryUrl(JSONObject unitaryRegister, Reporter reporter) {
      if (!unitaryRegister.isEmpty()) {
         SDx_QueryUrls.registerGroupToSend.put(unitaryRegister);
      }

      if (SDx_QueryUrls.registerGroupToSend.length() >= SDx_QueryUrls.getWhereOil_packetSize2Write()) {
         passToWriteInWhereOilByQueryUrls(SDx_QueryUrls.registerGroupToSend, SDx_QueryUrls.getOntologyType(), reporter);
      }

   }

   public static JSONArray passToWriteInWhereOil(JSONArray groupToSend, String eventName, Reporter reporter) {
      if (groupToSend.length() > 0) {
         WhereoilConexion connectOW = new WhereoilConexion(SDx_FirstFuncion.getWHEREOIL_URL(), SDx_FirstFuncion.getWHEREOIL_USERNAME(), SDx_FirstFuncion.getWHEREOIL_PASSWORD(), SDx_FirstFuncion.getWHEREOIL_TOKEN());
         String newTicket = connectOW.getValidTicket();
         if (!newTicket.equals("error") && !newTicket.equals("false")) {
            String[] msgToSend = new String[]{groupToSend.toString()};
            String salidita = connectOW.writeConnector(msgToSend, eventName, newTicket, reporter);
            if (salidita != "" || !salidita.equals("")) {
               try {
                  JSONObject rta = new JSONObject(salidita);
                  if (!rta.has("ticket")) {
                     String var10001 = SDx_Application.getLineNumber();
                     reporter.reportInfo(var10001 + " - " + salidita);
                  }
               } catch (Exception var8) {
                  reporter.reportError(SDx_Application.getLineNumber() + " La respuesta a la solicitud de escritura no es valida.");
               }
            }

            groupToSend = new JSONArray(new ArrayList());
         } else {
            reporter.reportError("Se ha presentado un error con el ticket solicitado.");
         }
      }

      return groupToSend;
   }

   public static void eraseRequestToWhereOil(String request, String eventName, Reporter reporter) {
      String var10001;
      try {
         if (request != "") {
            WhereoilConexion connectOW = new WhereoilConexion(SDx_FirstFuncion.getWHEREOIL_URL(), SDx_FirstFuncion.getWHEREOIL_USERNAME(), SDx_FirstFuncion.getWHEREOIL_PASSWORD(), SDx_FirstFuncion.getWHEREOIL_TOKEN());
            String newTicket = connectOW.getValidTicket();
            if (!newTicket.equals("error") && !newTicket.equals("false")) {
               String[] msgToSend = new String[1];
               String salidita = connectOW.deleteRegisters(request, eventName, newTicket, reporter);
               if ((salidita != "" || !salidita.equals("")) && !salidita.equals("0")) {
                  var10001 = SDx_Application.getLineNumber();
                  reporter.reportInfo(var10001 + " - Respuesta a peticion de borrado: " + salidita);
               }
            } else {
               reporter.reportError(SDx_Application.getLineNumber() + " Se ha presentado un error con el ticket solicitado.");
            }
         }
      } catch (Exception var7) {
         var10001 = SDx_Application.getLineNumber();
         reporter.reportError(var10001 + " Se ha presentado un error general: " + var7.toString());
         reporter.reportError("request: " + request + " eventName: " + eventName);
      }

   }

   public static JSONArray passToWriteInWhereOilByQueryUrls(JSONArray groupToSend, String eventName, Reporter reporter) {
      if (groupToSend.length() > 0) {
         WhereoilConexion connectOW = new WhereoilConexion(SDx_QueryUrls.getWHEREOIL_URL(), SDx_QueryUrls.getWHEREOIL_USERNAME(), SDx_QueryUrls.getWHEREOIL_PASSWORD(), SDx_QueryUrls.getWHEREOIL_TOKEN());
         String newTicket = connectOW.getValidTicket();
         if (!newTicket.equals("error") && !newTicket.equals("false")) {
            String[] msgToSend = new String[]{groupToSend.toString()};
            String salidita = connectOW.writeConnectorPut(msgToSend, eventName, newTicket, reporter);
            if (salidita != "" || !salidita.equals("")) {
               String var10001 = SDx_Application.getLineNumber();
               reporter.reportError(var10001 + " - " + salidita);
            }

            groupToSend = new JSONArray(new ArrayList());
         } else {
            reporter.reportError(SDx_Application.getLineNumber() + " - Se ha presentado un error con el ticket solicitado.");
         }
      }

      return groupToSend;
   }

   public static JSONObject trimLongTag(JSONObject unitaryRegister, Reporter reporter) {
      try {
         if (unitaryRegister != null && !unitaryRegister.isEmpty()) {
            JSONObject propertiesInfo = unitaryRegister.getJSONObject("properties");
            if (propertiesInfo.has("sdx:Tag") && !propertiesInfo.isNull("sdx:Tag")) {
               String tag = propertiesInfo.getString("sdx:Tag");
               if (tag.length() > 5000) {
                  reporter.reportInfo("El contenido de tag es de " + tag.length() + " caracteres y es recortado a un máximo de 5000 caracteres");
                  tag = tag.substring(0, 5000);
                  propertiesInfo.put("sdx:Tag", tag);
                  unitaryRegister.put("properties", propertiesInfo);
               }
            }
         }

         return unitaryRegister;
      } catch (Exception var4) {
         reporter.reportError(SDx_Application.getLineNumber() + " se ha encontrado un error al validar longitud de textos.");
         reporter.reportError(var4.toString());
         return null;
      }
   }

   public static String doTypeSelection(String areaTecnica, Reporter reporter) {
      try {
         byte var4 = -1;
         switch(areaTecnica.hashCode()) {
         case -204689943:
            if (areaTecnica.equals("MAT, Materiales")) {
               var4 = 6;
            }
            break;
         case 2576:
            if (areaTecnica.equals("QA")) {
               var4 = 9;
            }
            break;
         case 66913:
            if (areaTecnica.equals("COM")) {
               var4 = 1;
            }
            break;
         case 66914:
            if (areaTecnica.equals("CON")) {
               var4 = 3;
            }
            break;
         case 72642:
            if (areaTecnica.equals("ING")) {
               var4 = 5;
            }
            break;
         case 76096:
            if (areaTecnica.equals("MAT")) {
               var4 = 7;
            }
            break;
         case 517322536:
            if (areaTecnica.equals("QA, Calidad")) {
               var4 = 8;
            }
            break;
         case 1006175343:
            if (areaTecnica.equals("COM, Comisionamiento")) {
               var4 = 0;
            }
            break;
         case 1318986740:
            if (areaTecnica.equals("CON, Construcción")) {
               var4 = 2;
            }
            break;
         case 1359878805:
            if (areaTecnica.equals("ING, Ingeniería")) {
               var4 = 4;
            }
         }

         String metaclaseType;
         switch(var4) {
         case 0:
         case 1:
            metaclaseType = "sdx:comisionamiento";
            break;
         case 2:
         case 3:
            metaclaseType = "sdx:construccion";
            break;
         case 4:
         case 5:
            metaclaseType = "sdx:ingenieria";
            break;
         case 6:
         case 7:
            metaclaseType = "sdx:materiales";
            break;
         case 8:
         case 9:
            metaclaseType = "sdx:calidad";
            break;
         default:
            metaclaseType = "sdx:ingenieria";
         }

         return metaclaseType;
      } catch (Exception var5) {
         reporter.reportError(SDx_Application.getLineNumber() + " Se ha presentado un error al intentar inferir la ontologia o tipo.");
         return "";
      }
   }

   public static JSONObject updateUnitaryRegByOntology(JSONObject unitaryReg, Reporter reporter) {
      try {
         if (unitaryReg != null && unitaryReg.has("type")) {
            JSONObject updatedUnitaryReg = new JSONObject();
            String var3 = unitaryReg.getString("type");
            byte var4 = -1;
            switch(var3.hashCode()) {
            case -1186435078:
               if (var3.equals("maduracionproj:maduracionproj")) {
                  var4 = 0;
               }
            }

            Iterator var5;
            String key;
            Object value;
            switch(var4) {
            case 0:
               var5 = unitaryReg.getJSONObject("properties").keySet().iterator();

               while(var5.hasNext()) {
                  key = (String)var5.next();
                  value = unitaryReg.getJSONObject("properties").get(key);
                  if (key.contains("maduracionproj:")) {
                     updatedUnitaryReg.put(key, value);
                  }
               }

               unitaryReg.put("properties", updatedUnitaryReg);
               break;
            default:
               var5 = unitaryReg.getJSONObject("properties").keySet().iterator();

               while(var5.hasNext()) {
                  key = (String)var5.next();
                  value = unitaryReg.getJSONObject("properties").get(key);
                  if (key.contains("sdx:")) {
                     updatedUnitaryReg.put(key, value);
                  }
               }

               unitaryReg.put("properties", updatedUnitaryReg);
            }
         }

         return unitaryReg;
      } catch (Exception var8) {
         reporter.reportError(SDx_Application.getLineNumber() + " Se ha presentado un error en updateUnitaryRegByOntology.");
         reporter.reportError("El valor de unitaryReg es: " + unitaryReg.toString());
         unitaryReg = new JSONObject();
         return unitaryReg;
      }
   }

   public static String encodeTildes(String original) {
      StringBuilder resultado = new StringBuilder();
      char[] var2 = original.toCharArray();
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         char c = var2[var4];
         if (c > 127) {
            try {
               String caracterCodificado = URLEncoder.encode(String.valueOf(c), "UTF-8");
               resultado.append(caracterCodificado);
            } catch (Exception var7) {
               var7.printStackTrace();
            }
         } else {
            resultado.append(c);
         }
      }

      return resultado.toString();
   }

   public static String encodeTildes1(String original) {
      StringBuilder resultado = new StringBuilder();
      char[] var2 = original.toCharArray();
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         char c = var2[var4];
         if (c > 127) {
            try {
               String caracterCodificado = StringEscapeUtils.escapeJava(String.valueOf(c));
               resultado.append(caracterCodificado);
            } catch (Exception var7) {
               var7.printStackTrace();
            }
         } else {
            resultado.append(c);
         }
      }

      return resultado.toString();
   }

   public static boolean cleanHLPontology(int num_days_back) {
      return false;
   }

   public static String getCutDate(int qttyDays, Reporter reporter) {
      try {
         String nowDate = postDate();
         Date date1 = (new SimpleDateFormat("yyyy-MM-dd")).parse(nowDate);
         if (qttyDays <= 0) {
            qttyDays = 1;
         }

         Date cutDate = DateSubs(date1, qttyDays);
         String cutDateStr = DateFormater(cutDate);
         cutDateStr = cutDateStr + "T00:00:00.000Z";
         return cutDateStr;
      } catch (Exception var6) {
         reporter.reportError(SDx_Application.getLineNumber() + " Se encontró un error al intentar generar la fecha de corte.");
         return null;
      }
   }

   public static JSONObject makeNotCurrentDocumentsQueryParams(String projectObjectUID, int skip, Reporter reporter) throws UnsupportedEncodingException {
      JSONObject headersProjectsDocuments = new JSONObject();
      JSONObject ProjectsDocumentsQueryParams = new JSONObject();

      try {
         String date4cut = getCutDate(SDx_FirstFuncion.getQtty_of_cut_off_days_for_delete(), reporter);
         reporter.reportInfo(SDx_Application.getLineNumber() + " - Fecha de corte: " + date4cut + " - UID Proyecto: " + projectObjectUID + " - Skip: " + skip);
         JSONObject var10002 = SDx_FirstFuncion.getJsonToken().getJSONObject("body");
         headersProjectsDocuments.put("Authorization", "Bearer " + var10002.getString("access_token"));
         headersProjectsDocuments.put("SPFQuerySelectedConfigOnly", "false");
         headersProjectsDocuments.put("SPFConfigUID", projectObjectUID);
         headersProjectsDocuments.put("SPFCreateConfigUID", projectObjectUID);
         headersProjectsDocuments.put("SPFQueryConfigUID", projectObjectUID);
         String complementoUrl = "$count=true&$expand=All_Files&$select=Id,Name,Configuración,Titulo,Revisión,Tipo_de_Documento,Estado,Disciplina,Contrato,Originador,Creación_fecha,Modificación_fecha,Área_Técnica,Orden_De_Servicio,Área,Unidad,Tipo_de_Ingenieria,Num_Doc_Interno,Código_Proyecto,Tag,SOP,SSOP,Motivo_de_emision,Fecha_Emisión,ENS_Databook,Orden_De_Compra,Versión_Entregable,VarianteCategoría,FaseSubProceso,Proceso,Entregable,Estado_Revisión_Documental&$filter=Estado%20ne%20'Current' and Modificación_fecha ge " + date4cut;
         String urlSinCondificar = SDx_FirstFuncion.getSDx_documents_projects_query_url() + "$top=100&$skip=" + skip + "&" + complementoUrl;
         String urlCodificada = URLEncoder.encode(urlSinCondificar, "UTF-8");
         urlCodificada = encodeTildes(urlSinCondificar);
         urlCodificada = urlCodificada.replace(" ", "%20");
         ProjectsDocumentsQueryParams.put("url", urlCodificada);
         ProjectsDocumentsQueryParams.put("headers", headersProjectsDocuments);
         return ProjectsDocumentsQueryParams;
      } catch (Exception var9) {
         String var10001 = SDx_Application.getLineNumber();
         reporter.reportError(var10001 + " Se ha presentado algún error en makeNotCurrentDocumentsQueryParams. " + var9);
         return ProjectsDocumentsQueryParams;
      }
   }

   public static JSONObject objectConformer(JSONObject object, Reporter reporter) {
      JSONObject totalObject = new JSONObject();
      JSONObject dataGroup = new JSONObject();
      new JSONObject();
      JSONArray and = new JSONArray();
      JSONObject andObject = new JSONObject();
      JSONArray eq = new JSONArray();
      String metaclassRoot = "";

      try {
         String ontologyDetected = "maduracionproj:maduracionproj";
         if (object.has("Área_Técnica")) {
            if (!object.isNull("Área_Técnica")) {
               ontologyDetected = doTypeSelection(object.getString("Área_Técnica"), reporter);
            }
         } else {
            reporter.reportError(SDx_Application.getLineNumber() + " Alerta! Alerta!, no se pudo inferir la ontolgía.");
         }

         if (ontologyDetected.equals("maduracionproj:maduracionproj")) {
            metaclassRoot = "maduracionproj";
         } else {
            metaclassRoot = "sdx";
         }

         andObject.put("classname", ontologyDetected);
         JSONObject tempObject;
         if (object.has("Código_Proyecto") && !object.isNull("Código_Proyecto")) {
            tempObject = new JSONObject();
            tempObject.put(metaclassRoot + ":Codigo_proyecto", object.getString("Código_Proyecto"));
            eq.put(tempObject);
         }

         if (object.has("Name") && !object.isNull("Name")) {
            tempObject = new JSONObject();
            tempObject.put(metaclassRoot + ":Nombre_documento", object.getString("Name"));
            eq.put(tempObject);
         }

         if (object.has("Revisión") && !object.isNull("Revisión")) {
            tempObject = new JSONObject();
            tempObject.put(metaclassRoot + ":Revision", object.getString("Revisión"));
            eq.put(tempObject);
         }

         if (ontologyDetected.equals("maduracionproj:maduracionproj.json")) {
            tempObject = new JSONObject();
            tempObject.put(metaclassRoot + ":source", "SDx");
            eq.put(tempObject);
         }

         andObject.put("eq", eq);
         and.put(andObject);
         totalObject.put("and", and);
         return totalObject;
      } catch (Exception var10) {
         String var10001 = SDx_Application.getLineNumber();
         reporter.reportError(var10001 + " Se ha producio un error, objeto d eeentrada es: " + object.toString(2));
         var10001 = SDx_Application.getLineNumber();
         reporter.reportError(var10001 + " Se ha producio un error: " + var10);
         return dataGroup;
      }
   }
}
