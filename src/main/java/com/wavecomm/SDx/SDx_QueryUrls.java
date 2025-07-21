/* Decompiler 95ms, total 625ms, lines 376 */
package com.wavecomm.SDx;

import com.kadme.rest.webtool.tool.AbstractCommand;
import com.kadme.rest.webtool.tool.CommandProperties;
import com.kadme.rest.webtool.tool.ExecutionContext;
import com.kadme.rest.webtool.tool.Tool;
import com.kadme.rest.webtool.tool.annotation.PropertyDefinition;
import com.kadme.tool.log.Reporter;
import org.json.JSONArray;
import org.json.JSONObject;

public class SDx_QueryUrls extends AbstractCommand<Tool> {
   @PropertyDefinition(
      propertyName = "WHEREOIL_URL",
      required = true,
      description = "WHEREOIL_URL",
      defaultValue = "http://127.0.0.1/whereoil-rest-server/security/auth/login.json"
   )
   private static String WHEREOIL_URL;
   @PropertyDefinition(
      propertyName = "WHEREOIL_USERNAME",
      required = true,
      description = "WhereOil_Username",
      defaultValue = "pruebagigante2@ecopetrol.com.co"
   )
   private static String WHEREOIL_USERNAME;
   @PropertyDefinition(
      propertyName = "WHEREOIL_PASSWORD",
      required = true,
      description = "WhereOil_Password",
      defaultValue = "AmarilloEcp2024$"
   )
   private static String WHEREOIL_PASSWORD;
   @PropertyDefinition(
      propertyName = "WHEREOIL_TOKEN",
      required = true,
      description = "WhereOil token",
      defaultValue = "4e54564d596d46684f3245684d5751745a7930774c4464304e574a6b4e44596c59474e745a574d6a4d545a347a57456b"
   )
   private static String WHEREOIL_TOKEN;
   @PropertyDefinition(
      propertyName = "WHEREOIL_SEARCH_URL",
      required = true,
      description = "WHEREOIL_SEARCH_URL",
      defaultValue = "http://127.0.0.1/whereoil-rest-server/data/sdx/_search.json"
   )
   private static String WHEREOIL_SEARCH_URL;
   @PropertyDefinition(
      propertyName = "WHEREOIL_PACKET_WRITE",
      required = true,
      description = "Number of packets to insert by each query .",
      defaultValue = "5"
   )
   private static int WhereOil_packetSize2Write;
   @PropertyDefinition(
      propertyName = "DEFAULT_START_DATE",
      required = true,
      description = "DEFAULT_START_DATE yyyy-MM-dd",
      defaultValue = "2022-07-07"
   )
   private static String DEFAULT_START_DATE;
   @PropertyDefinition(
      propertyName = "WHEREOIL_URL_SDXFiles",
      required = true,
      description = "Route of the SDx files ontology.",
      defaultValue = "http://127.0.0.1/whereoil-rest-server/data/sdx/sdx:files.json"
   )
   private static String WHEREOIL_URL_SDxFiles;
   private static String ontologyType = "sdx:epp";
   @PropertyDefinition(
      propertyName = "SDx_token_URL",
      required = true,
      description = "SDx_token_URL",
      defaultValue = "https://auth.intergraphsmartcloud.com/oauth2/aus616f7itPEXnmOx0i7/v1/token"
   )
   private static String SDx_token_URL;
   @PropertyDefinition(
      propertyName = "D.SDx_Files_URL_query_URL",
      required = true,
      description = "SDx_files_url_query_url",
      defaultValue = "https://eco02-sdx.intergraphsmartcloud.com/ecpsdxserver/api/v2/SDA/Files($##$)/Intergraph.SPF.Server.API.Model.RetrieveFileURLs?$count=true"
   )
   private static String SDx_Files_URL_query_URL;
   @PropertyDefinition(
      propertyName = "SDx_Username",
      required = true,
      description = "username",
      defaultValue = "pruebagigante2@ecopetrol.com.co"
   )
   private static String SDx_Username;
   @PropertyDefinition(
      propertyName = "SDx_password",
      required = true,
      description = "SDx_password",
      defaultValue = "AmarilloEcp2024$"
   )
   private static String SDx_password;
   @PropertyDefinition(
      propertyName = "SDx_Authorization",
      required = true,
      description = "SDx_Authorization",
      defaultValue = "https://auth.intergraphsmartcloud.com/oauth2/aus616f7itPEXnmOx0i7"
   )
   private static String SDx_Authorization;
   @PropertyDefinition(
      propertyName = "SDx_client_id",
      required = true,
      description = "SDx_client_id",
      defaultValue = "0oa8uskzzkZYibsz40i7"
   )
   private static String SDx_client_id;
   @PropertyDefinition(
      propertyName = "SDx_client_secret",
      required = true,
      description = "SDx_client_secret",
      defaultValue = "L8u48Weaa0hJr3HpEcbbs-RR5PvR6hhBxpxLprXK"
   )
   private static String SDx_client_secret;
   @PropertyDefinition(
      propertyName = "SDx_scope",
      required = true,
      description = "SDx_scope",
      defaultValue = "6184E2F6-5B5D-4408-9DDB-1F58456BE73C ingr.api ingr.api"
   )
   private static String SDx_scope;
   @PropertyDefinition(
      propertyName = "SDx_days_query_size",
      required = true,
      description = "SDx_days_query_size",
      defaultValue = "7"
   )
   private static int SDx_days_query_size;
   private static JSONObject jsonToken = new JSONObject();
   static JSONArray registerGroupToSend = new JSONArray();

   public static String getWHEREOIL_URL() {
      return WHEREOIL_URL;
   }

   public static String getWHEREOIL_USERNAME() {
      return WHEREOIL_USERNAME;
   }

   public static String getWHEREOIL_PASSWORD() {
      return WHEREOIL_PASSWORD;
   }

   public static String getWHEREOIL_TOKEN() {
      return WHEREOIL_TOKEN;
   }

   public static String getWHEREOIL_SEARCH_URL() {
      return WHEREOIL_SEARCH_URL;
   }

   public static int getWhereOil_packetSize2Write() {
      return WhereOil_packetSize2Write;
   }

   public static String getWHEREOIL_URL_SDxFiles() {
      return WHEREOIL_URL_SDxFiles;
   }

   public static String getOntologyType() {
      return ontologyType;
   }

   public static String getSDx_Files_URL_query_URL() {
      return SDx_Files_URL_query_URL;
   }

   public SDx_QueryUrls(Tool tool) {
      super(tool);
   }

   public static String getSDx_token_URL() {
      return SDx_token_URL;
   }

   public static String getSDx_Username() {
      return SDx_Username;
   }

   public static String getSDx_password() {
      return SDx_password;
   }

   public static String getSDx_Authorization() {
      return SDx_Authorization;
   }

   public static String getSDx_client_id() {
      return SDx_client_id;
   }

   public static String getSDx_client_secret() {
      return SDx_client_secret;
   }

   public static String getSDx_scope() {
      return SDx_scope;
   }

   public static int getSDx_days_query_size() {
      return SDx_days_query_size;
   }

   public static JSONObject getJsonToken() {
      return jsonToken;
   }

   public static void setJsonToken(JSONObject jsonToken) {
      SDx_QueryUrls.jsonToken = jsonToken;
   }

   protected void execute(CommandProperties properties, final Reporter reporter, ExecutionContext executionContext) throws Exception {
      String var10001 = SDx_Application.getLineNumber();
      reporter.reportInfo(var10001 + "The System will execute the " + this.getName() + " procedure... ");
      connectionOperations connectionObject = new connectionOperations();
      WhereoilConexion conexionWhereOil = new WhereoilConexion(WHEREOIL_URL, WHEREOIL_USERNAME, WHEREOIL_PASSWORD, WHEREOIL_TOKEN);
      String[] className = new String[5];
      JSONArray loadProperties = new JSONArray();
      loadProperties.put("sdx:URL");
      loadProperties.put("sdx:Id_archivo");
      loadProperties.put("sdx:Codigo_proyecto");
      JSONObject query = new JSONObject();
      String[] metaclase = new String[]{"sdx:calidad", "sdx:comisionamiento", "sdx:construccion", "sdx:ingenieria", "sdx:materiales", "sdx:epp"};
      int iterator = 0;
      String startDate = DEFAULT_START_DATE;
      new JSONArray();
      JSONArray datesToRun = DataOperators.makeDatesList(startDate, SDx_days_query_size);
      var10001 = SDx_Application.getLineNumber();
      reporter.reportInfo(var10001 + " datesToRun: " + datesToRun.toString(2));

      JSONObject rta2query;
      while(iterator < metaclase.length) {
         query.put("classname", metaclase[iterator]);
         var10001 = SDx_Application.getLineNumber();
         reporter.reportInfo(var10001 + query.toString(2));
         new JSONObject();
         int totalLength = 0;

         for(int i = 0; i < datesToRun.length(); ++i) {
            JSONObject datesPair = datesToRun.getJSONObject(i);
            int counter = 0;

            do {
               JSONObject queryToWO = new JSONObject();
               JSONArray ltDate = new JSONArray();
               JSONArray geDate = new JSONArray();
               JSONObject lt = new JSONObject();
               JSONObject ge = new JSONObject();
               ge.put("sdx:Creacion_fecha", datesPair.getString("startDate") + "T00:00:00");
               lt.put("sdx:Creacion_fecha", datesPair.getString("endDate") + "T00:00:00");
               ltDate.put(lt);
               geDate.put(ge);
               query.put("lt", ltDate);
               query.put("ge", geDate);
               queryToWO.put("query", query);
               queryToWO.put("loadProperties", loadProperties);
               JSONObject pagination = new JSONObject();
               pagination.put("start", counter);
               pagination.put("count", 100);
               pagination.put("sort", "sdx:Id_archivo");
               pagination.put("dir", "ASC");
               queryToWO.put("pagination", pagination);
               String respuestaAlQuery = "";

               try {
                  respuestaAlQuery = conexionWhereOil.queryConnector(queryToWO.toString(), getWHEREOIL_SEARCH_URL(), reporter);
                  rta2query = new JSONObject(respuestaAlQuery);
                  counter += 100;
                  if (rta2query != null && rta2query.has("totalLength")) {
                     totalLength = rta2query.getInt("totalLength");
                     var10001 = SDx_Application.getLineNumber();
                     reporter.reportInfo(var10001 + "totalLength: " + rta2query.getInt("totalLength"));
                     var10001 = SDx_Application.getLineNumber();
                     reporter.reportInfo(var10001 + "counter: " + counter);
                  }

                  if (rta2query.has("entities")) {
                     JSONArray entities = rta2query.getJSONArray("entities");
                     if (entities.length() > 0) {
                        JSONObject lastResult = entities.getJSONObject(entities.length() - 1);
                        var10001 = SDx_Application.getLineNumber();
                        reporter.reportInfo(var10001 + "lastResult: " + lastResult.get("uri"));
                        processUrls(rta2query, connectionObject, reporter);
                     }
                  }
               } catch (Exception var27) {
                  var10001 = SDx_Application.getLineNumber();
                  reporter.reportError(var10001 + " El contenido de respuestaAlQuery es: " + respuestaAlQuery);
                  var10001 = SDx_Application.getLineNumber();
                  reporter.reportInfo(var10001 + " El query es: " + queryToWO.toString());
               }
            } while(totalLength >= counter);
         }

         ++iterator;
      }

      rta2query = DataOperators.makeJsonAuthParamsQueryUrlConn();
      jsonToken = DataOperators.validateJsonTokenGeneral(getJsonToken(), rta2query, reporter);
      var10001 = SDx_Application.getLineNumber();
      reporter.reportInfo(var10001 + " json Token:" + SDx_testConnection.getJsonToken().toString(2));
      reporter.reportInfo(SDx_Application.getLineNumber() + " Finalizado.");
   }

   public static void processUrls(JSONObject queryResult, connectionOperations connectionObject, Reporter reporter) {
      new JSONArray();
      if (queryResult != null && queryResult.has("entities")) {
         JSONArray entities = queryResult.getJSONArray("entities");
         int qtty = entities.length();

         for(int i = 0; i < qtty; ++i) {
            JSONObject entryInfo = entities.getJSONObject(i);
            JSONObject properties = entryInfo.getJSONObject("properties");
            String var10001;
            if (entryInfo != null && properties != null && properties.has("sdx:Codigo_proyecto") && properties.has("sdx:Id_archivo")) {
               if (!properties.getString("sdx:Codigo_proyecto").equals("") && !properties.getString("sdx:Id_archivo").equals("")) {
                  String fileId = properties.getString("sdx:Id_archivo");
                  String fileUID = properties.getString("sdx:Codigo_proyecto");
                  fileUID = "PR_" + fileUID;
                  JSONObject AuthParams = DataOperators.makeJsonAuthParamsQueryUrlConn();
                  jsonToken = DataOperators.validateJsonTokenGeneral(getJsonToken(), AuthParams, reporter);
                  JSONObject urlFilesParams = DataOperators.makeFilesUrlQueryParamsGeneral(fileId, fileUID, jsonToken);
                  JSONObject QueryUrlsResult = DataOperators.doUrlFilesQuery(connectionObject, urlFilesParams, reporter);
                  if (QueryUrlsResult != null && QueryUrlsResult.has("code")) {
                     int AnsCode = QueryUrlsResult.getInt("code");
                     if (AnsCode == 200) {
                        var10001 = SDx_Application.getLineNumber();
                        reporter.reportInfo(var10001 + " entryInfo: " + entryInfo.toString(2));
                        var10001 = SDx_Application.getLineNumber();
                        reporter.reportInfo(var10001 + " QueryUrlsResult: " + QueryUrlsResult.toString(2));
                        JSONObject registerToWrite = makeJson4Update(entryInfo, QueryUrlsResult);
                        DataOperators.pushAndSendToWoByQueryUrl(registerToWrite, reporter);
                        var10001 = SDx_Application.getLineNumber();
                        reporter.reportInfo(var10001 + "el tamaño del paquete actual es: " + registerGroupToSend.length());
                     } else {
                        var10001 = SDx_Application.getLineNumber();
                        reporter.reportInfo(var10001 + " QueryUrlsResult: " + QueryUrlsResult.toString(2));
                     }
                  }
               } else {
                  reporter.reportInfo("properties");
               }
            } else {
               var10001 = SDx_Application.getLineNumber();
               reporter.reportInfo(var10001 + " " + entryInfo.toString());
            }
         }
      }

   }

   public static JSONObject makeJson4Update(JSONObject entryInfo, JSONObject QueryUrlsResult) {
      JSONObject properties2send = new JSONObject();
      JSONObject jsonRegister = new JSONObject();
      JSONArray tempArrayValue = QueryUrlsResult.getJSONArray("value");
      JSONObject tempObject = tempArrayValue.getJSONObject(0);
      properties2send.put("sdx:URL", tempObject.getString("URL"));
      jsonRegister.put("uri", entryInfo.getString("uri"));
      jsonRegister.put("type", entryInfo.getString("type"));
      jsonRegister.put("properties", properties2send);
      return jsonRegister;
   }

   public String getName() {
      return "SDx_queryUrls";
   }

   public String getDescription() {
      return "Procedimiento de consulta y actualización de urls.";
   }
}
