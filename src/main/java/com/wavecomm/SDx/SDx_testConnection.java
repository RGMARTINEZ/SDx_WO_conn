/* Decompiler 39ms, total 868ms, lines 303 */
package com.wavecomm.SDx;

import com.kadme.rest.webtool.tool.AbstractCommand;
import com.kadme.rest.webtool.tool.CommandProperties;
import com.kadme.rest.webtool.tool.ExecutionContext;
import com.kadme.rest.webtool.tool.Tool;
import com.kadme.rest.webtool.tool.annotation.PropertyDefinition;
import com.kadme.tool.log.Reporter;
import org.json.JSONArray;
import org.json.JSONObject;

public class SDx_testConnection extends AbstractCommand<Tool> {
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
      propertyName = "WHEREOIL_URL_SDXFiles",
      required = true,
      description = "Route of the SDx files ontology.",
      defaultValue = "http://127.0.0.1/whereoil-rest-server/data/sdx/sdx:files.json"
   )
   private static String WHEREOIL_URL_SDxFiles;
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
      description = "DEFAULT_START_DATE",
      defaultValue = "2022-07-07"
   )
   private static String DEFAULT_START_DATE;
   @PropertyDefinition(
      propertyName = "SDx_token_URL",
      required = true,
      description = "SDx_token_URL",
      defaultValue = "https://auth.intergraphsmartcloud.com/oauth2/aus616f7itPEXnmOx0i7/v1/token"
   )
   private static String SDx_token_URL;
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
      propertyName = "A.SDx_facility_query_url",
      required = true,
      description = "SDx_facility_query_url",
      defaultValue = "https://eco02-sdx.intergraphsmartcloud.com/ecpsdxserver/api/v2/SDA/Plants?"
   )
   private static String SDx_facility_query_url;
   @PropertyDefinition(
      propertyName = "B.SDx_projects_query_url",
      required = true,
      description = "SDx_projects_query_url",
      defaultValue = "https://eco02-sdx.intergraphsmartcloud.com/ecpsdxserver/api/v2/SDA/Projects?"
   )
   private static String SDx_projects_query_url;
   @PropertyDefinition(
      propertyName = "C.SDx_documents_projects_query_url",
      required = true,
      description = "SDx_documents_projects_query_url",
      defaultValue = "https://eco02-sdx.intergraphsmartcloud.com/ecpsdxserver/api/v2/SDA/Documento?"
   )
   private static String SDx_documents_projects_query_url;
   @PropertyDefinition(
      propertyName = "D.SDx_Files_URL_query_URL",
      required = true,
      description = "SDx_files_url_query_url",
      defaultValue = "https://eco02-sdx.intergraphsmartcloud.com/ecpsdxserver/api/v2/SDA/Files($##$)/Intergraph.SPF.Server.API.Model.RetrieveFileURLs?$count=true"
   )
   private static String SDx_Files_URL_query_URL;
   private static String ontologyType = "sdx:epp";
   private static JSONObject jsonToken = new JSONObject();
   static JSONArray registerGroupToSend = new JSONArray();

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

   public static String getOntologyType() {
      return ontologyType;
   }

   public static String getSDx_projects_query_url() {
      return SDx_projects_query_url;
   }

   public static String getSDx_documents_projects_query_url() {
      return SDx_documents_projects_query_url;
   }

   public static String getSDx_Files_URL_query_URL() {
      return SDx_Files_URL_query_URL;
   }

   public static String getSDx_facility_query_url() {
      return SDx_facility_query_url;
   }

   public static int getWhereOil_packetSize2Write() {
      return WhereOil_packetSize2Write;
   }

   public static String getWHEREOIL_URL_SDxFiles() {
      return WHEREOIL_URL_SDxFiles;
   }

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

   public SDx_testConnection(ToolTest tool) {
      super(tool);
   }

   public static String getDEFAULT_START_DATE() {
      return DEFAULT_START_DATE;
   }

   public static void setSDx_token_URL(String SDx_token_URL) {
      SDx_testConnection.SDx_token_URL = SDx_token_URL;
   }

   public static void setSDx_Username(String SDx_Username) {
      SDx_testConnection.SDx_Username = SDx_Username;
   }

   public static void setSDx_password(String SDx_password) {
      SDx_testConnection.SDx_password = SDx_password;
   }

   public static void setSDx_Authorization(String SDx_Authorization) {
      SDx_testConnection.SDx_Authorization = SDx_Authorization;
   }

   public static void setSDx_client_id(String SDx_client_id) {
      SDx_testConnection.SDx_client_id = SDx_client_id;
   }

   public static void setSDx_client_secret(String SDx_client_secret) {
      SDx_testConnection.SDx_client_secret = SDx_client_secret;
   }

   public static void setSDx_scope(String SDx_scope) {
      SDx_testConnection.SDx_scope = SDx_scope;
   }

   public static void setSDx_facility_query_url(String SDx_facility_query_url) {
      SDx_testConnection.SDx_facility_query_url = SDx_facility_query_url;
   }

   public static void setSDx_projects_query_url(String SDx_projects_query_url) {
      SDx_testConnection.SDx_projects_query_url = SDx_projects_query_url;
   }

   public static void setSDx_documents_projects_query_url(String SDx_documents_projects_query_url) {
      SDx_testConnection.SDx_documents_projects_query_url = SDx_documents_projects_query_url;
   }

   public static void setSDx_Files_URL_query_URL(String SDx_Files_URL_query_URL) {
      SDx_testConnection.SDx_Files_URL_query_URL = SDx_Files_URL_query_URL;
   }

   public static JSONObject getJsonToken() {
      return jsonToken;
   }

   public static void setJsonToken(JSONObject jsonToken) {
      SDx_testConnection.jsonToken = jsonToken;
   }

   protected void execute(CommandProperties properties, final Reporter reporter, ExecutionContext executionContext) throws Exception {
      reporter.reportInfo("The System will execute the " + this.getName() + " procedure... ");
      new connectionOperations();
      DataOperators.validateJsonTokenTestConn(reporter);
      JSONObject var10001 = getJsonToken();
      reporter.reportInfo("json Token:" + var10001.toString(2));
      reporter.reportInfo("Finalizado.");
   }

   public String getName() {
      return "SDx_testConnection";
   }

   public String getDescription() {
      return "Procedimiento de prueba de conexion y generacion de token a SDx.";
   }
}
