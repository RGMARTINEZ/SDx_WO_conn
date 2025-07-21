/* Decompiler 866ms, total 1469ms, lines 735 */
package com.wavecomm.SDx;

import com.kadme.rest.webtool.tool.AbstractCommand;
import com.kadme.rest.webtool.tool.CommandProperties;
import com.kadme.rest.webtool.tool.ExecutionContext;
import com.kadme.rest.webtool.tool.Tool;
import com.kadme.rest.webtool.tool.annotation.PropertyDefinition;
import com.kadme.tool.log.Reporter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

public class SDx_FirstFuncion extends AbstractCommand<Tool> {
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
      propertyName = "WHEREOIL_URL_HLPFiles",
      required = true,
      description = "Route of the HLP files ontology.",
      defaultValue = "http://127.0.0.1/whereoil-rest-server/data/maduracionproj/maduracionproj:maduracionproj.json"
   )
   private static String WHEREOIL_URL_HLPFiles;
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
      propertyName = "WHEREOIL_SDX_CLASSNAME_ROOT",
      required = true,
      description = "WHEREOIL_SDX_CLASSNAME_ROOT",
      defaultValue = "http://127.0.0.1/whereoil-rest-server/data/sdx/"
   )
   private static String WHEREOIL_SDX_CLASSNAME_ROOT;
   @PropertyDefinition(
      propertyName = "WHEREOIL_HLP_CLASSNAME_ROOT",
      required = true,
      description = "WHEREOIL_HLP_CLASSNAME_ROOT",
      defaultValue = "http://10.100.29.196/whereoil-rest-server/data/maduracionproj/"
   )
   private static String WHEREOIL_HLP_CLASSNAME_ROOT;
   @PropertyDefinition(
      propertyName = "WHEREOIL_PACKET_WRITE",
      required = true,
      description = "Number of packets to insert by each query .",
      defaultValue = "5"
   )
   private static int WhereOil_packetSize2Write;
   @PropertyDefinition(
      propertyName = "SDx_token_URL",
      required = true,
      description = "SDx_token_URL",
      defaultValue = "https://auth.intergraphsmartcloud.com/oauth2/aus616f7itPEXnmOx0i7/v1/token"
   )
   private static String SDx_token_URL;
   @PropertyDefinition(
      propertyName = "server_for_query_URLs",
      required = true,
      description = "URL query server",
      defaultValue = "https://hexagon.wavecomm.net/SDx/index.php?"
   )
   private static String server_for_query_URLs;
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
   private static int Qtty_of_cut_off_days = 0;
   @PropertyDefinition(
      propertyName = "Qtty_of_cut_off_days_for_Query_Documents",
      required = true,
      description = "Number of days to set the cut off date for query documents, always > 0",
      defaultValue = "3"
   )
   private static int Qtty_of_cut_off_days_for_delete;
   @PropertyDefinition(
      propertyName = "index_of_initial_facility",
      required = true,
      description = "index_of_initial_facility",
      defaultValue = "0"
   )
   private static int index_of_initial_facility;
   @PropertyDefinition(
      propertyName = "F.plant_name_to_find",
      required = false,
      description = "plant_name_to_find (default empty)",
      defaultValue = ""
   )
   private static String searchPlant;
   @PropertyDefinition(
      propertyName = "F.project_name_to_find",
      required = false,
      description = "project_name_to_find (default empty)",
      defaultValue = ""
   )
   private static String searchProject;
   private static String ontologyType = "sdx:epp";
   private static String ontologyTypehlp = "maduracionproj:maduracionproj";
   private static JSONObject jsonToken = new JSONObject();
   static JSONArray registerGroupToSend = new JSONArray();
   static JSONArray registerGroupToSendHLP = new JSONArray();

   public static String getSDx_token_URL() {
      return SDx_token_URL;
   }

   public static String getSDx_Username() {
      return SDx_Username;
   }

   public static String getSDx_password() {
      return SDx_password;
   }

   public static String getWHEREOIL_SDX_CLASSNAME_ROOT() {
      return WHEREOIL_SDX_CLASSNAME_ROOT;
   }

   public static String getWHEREOIL_HLP_CLASSNAME_ROOT() {
      return WHEREOIL_HLP_CLASSNAME_ROOT;
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

   public static int getQtty_of_cut_off_days_for_delete() {
      return Qtty_of_cut_off_days_for_delete;
   }

   public static void setQtty_of_cut_off_days_for_delete(int Qtty_of_cut_off_days_for_delete) {
      SDx_FirstFuncion.Qtty_of_cut_off_days_for_delete = Qtty_of_cut_off_days_for_delete;
   }

   public static String getOntologyType() {
      return ontologyType;
   }

   public static String getOntologyTypeHLP() {
      return ontologyTypehlp;
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

   public static String getWHEREOIL_URL_HLPFiles() {
      return WHEREOIL_URL_HLPFiles;
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

   public SDx_FirstFuncion(ToolTest tool) {
      super(tool);
   }

   public static void setSDx_token_URL(String SDx_token_URL) {
      SDx_FirstFuncion.SDx_token_URL = SDx_token_URL;
   }

   public static void setSDx_Username(String SDx_Username) {
      SDx_FirstFuncion.SDx_Username = SDx_Username;
   }

   public static void setSDx_password(String SDx_password) {
      SDx_FirstFuncion.SDx_password = SDx_password;
   }

   public static void setSDx_Authorization(String SDx_Authorization) {
      SDx_FirstFuncion.SDx_Authorization = SDx_Authorization;
   }

   public static void setSDx_client_id(String SDx_client_id) {
      SDx_FirstFuncion.SDx_client_id = SDx_client_id;
   }

   public static void setSDx_client_secret(String SDx_client_secret) {
      SDx_FirstFuncion.SDx_client_secret = SDx_client_secret;
   }

   public static void setSDx_scope(String SDx_scope) {
      SDx_FirstFuncion.SDx_scope = SDx_scope;
   }

   public static void setSDx_facility_query_url(String SDx_facility_query_url) {
      SDx_FirstFuncion.SDx_facility_query_url = SDx_facility_query_url;
   }

   public static void setSDx_projects_query_url(String SDx_projects_query_url) {
      SDx_FirstFuncion.SDx_projects_query_url = SDx_projects_query_url;
   }

   public static void setSDx_documents_projects_query_url(String SDx_documents_projects_query_url) {
      SDx_FirstFuncion.SDx_documents_projects_query_url = SDx_documents_projects_query_url;
   }

   public static void setSDx_Files_URL_query_URL(String SDx_Files_URL_query_URL) {
      SDx_FirstFuncion.SDx_Files_URL_query_URL = SDx_Files_URL_query_URL;
   }

   public static String getSearch_Plant() {
      return searchPlant;
   }

   public static String getSearch_Project() {
      return searchProject;
   }

   public static JSONObject getJsonToken() {
      return jsonToken;
   }

   public static void setJsonToken(JSONObject jsonToken) {
      SDx_FirstFuncion.jsonToken = jsonToken;
   }

   protected void execute(CommandProperties properties, final Reporter reporter, ExecutionContext executionContext) throws Exception {
      reporter.reportInfo("The System will execute the " + this.getName() + " procedure... ");
      connectionOperations connectionObject = new connectionOperations();
      DataOperators.validateJsonToken(reporter);
      int skip1 = 0;

      JSONArray facilityValues;
      do {
         String var10001 = SDx_Application.getLineNumber();
         reporter.reportInfo(var10001 + " Skip1 es: " + skip1);
         DataOperators.validateJsonToken(reporter);
         facilityValues = DataOperators.doFacilitiesQuery(connectionObject, skip1, reporter);
         reporter.reportInfo("facilityValues.length() es: " + facilityValues.length());
         reporter.reportInfo(facilityValues.toString(2));
         if (index_of_initial_facility >= facilityValues.length() || index_of_initial_facility < 0) {
            index_of_initial_facility = 0;
         }

         if (searchPlant == null) {
            searchPlant = "";
         }

         index_of_initial_facility = plantsFinder(getSearch_Plant(), facilityValues);

         for(int i = index_of_initial_facility; i < facilityValues.length(); ++i) {
            reporter.reportInfo(SDx_Application.getLineNumber() + " El Valor de i es: " + i + " de " + facilityValues.length());
            var10001 = SDx_Application.getLineNumber();
            reporter.reportInfo(var10001 + " la facilidad actual es: " + facilityValues.getJSONObject(i).toString(2));
            JSONObject project = facilityValues.getJSONObject(i);
            DataOperators.validateJsonToken(reporter);
            int skip2 = 0;

            JSONArray projectsListValue;
            do {
               var10001 = SDx_Application.getLineNumber();
               reporter.reportInfo(var10001 + " Skip2 es: " + skip2);
               DataOperators.validateJsonToken(reporter);
               projectsListValue = DataOperators.doProjectsListQuery(project, skip2, connectionObject, reporter);
               if (searchProject == null) {
                  searchProject = "";
               }

               int index_of_initial_projects = projectsFinder(getSearch_Project(), projectsListValue);

               for(int j = index_of_initial_projects; j < projectsListValue.length(); ++j) {
                  JSONObject projectObject = projectsListValue.getJSONObject(j);
                  DataOperators.validateJsonToken(reporter);
                  int skip3 = 0;
                  new JSONArray();

                  JSONArray documentsProjectsValues;
                  do {
                     DataOperators.validateJsonToken(reporter);
                     JSONObject documentsProjects = DataOperators.doDocumentsProjectsQuery(projectObject, skip3, connectionObject, reporter);
                     JSONObject dataGroup;
                     JSONObject fileJson;
                     JSONObject tempObject;
                     if (null != documentsProjects && documentsProjects.has("value")) {
                        documentsProjectsValues = documentsProjects.getJSONArray("value");
                        int tamano = documentsProjectsValues.length();
                        if (documentsProjects.has("@odata.count")) {
                           var10001 = SDx_Application.getLineNumber();
                           reporter.reportInfo(var10001 + " el valor de @odata.count es: " + documentsProjects.get("@odata.count"));
                        }

                        if (tamano > 100) {
                           var10001 = SDx_Application.getLineNumber();
                           reporter.reportInfo(var10001 + " El tamaño de 'values' es superior a 100, es: " + tamano);
                        }

                        int docProValLen = documentsProjectsValues.length();
                        int k = 0;

                        while(true) {
                           if (k >= docProValLen) {
                              DataOperators.passToWriteInWhereOil(registerGroupToSend, getOntologyType(), reporter);
                              registerGroupToSend = new JSONArray();
                              DataOperators.passToWriteInWhereOil(registerGroupToSendHLP, getOntologyTypeHLP(), reporter);
                              registerGroupToSendHLP = new JSONArray();
                              break;
                           }

                           new JSONObject();
                           JSONObject documentsProjectsValuesElement = documentsProjectsValues.getJSONObject(k);
                           new JSONObject();
                           JSONObject unitaryRegister;
                           if (documentsProjectsValuesElement.has("All_Files")) {
                              new JSONArray();
                              JSONArray All_Files = documentsProjectsValuesElement.getJSONArray("All_Files");
                              if (All_Files.length() <= 0) {
                                 tempObject = new JSONObject();
                                 unitaryRegister = DataOperators.buildJsonRegister(documentsProjectsValuesElement, tempObject);
                                 unitaryRegister = DataOperators.makeFullUnitaryReg(unitaryRegister, reporter);
                                 unitaryRegister = DataOperators.trimLongTag(unitaryRegister, reporter);
                                 DataOperators.pushAndSendToWo(unitaryRegister, reporter);
                              } else {
                                 for(int l = 0; l < All_Files.length(); ++l) {
                                    JSONObject filesDataInfo = new JSONObject();
                                    fileJson = All_Files.getJSONObject(l);
                                    new JSONObject();
                                    unitaryRegister = DataOperators.buildJsonRegister(documentsProjectsValuesElement, fileJson);
                                    if (fileJson.has("Id")) {
                                       String fileId = fileJson.getString("Id");
                                       String fileUID = projectObject.getString("UID");
                                       DataOperators.validateJsonToken(reporter);
                                       if (fileId != "" && fileId != null && fileUID != "" && fileUID != null) {
                                          String url4server = server_for_query_URLs + "FileID=" + fileId + "&FileUID=" + fileUID;
                                          unitaryRegister.put("sdx:URL", url4server);
                                          unitaryRegister.put("maduracionproj:URL_SDX", url4server);
                                          JSONObject fullunitaryRegister = DataOperators.makeFullUnitaryReg(unitaryRegister, reporter);
                                          fullunitaryRegister = DataOperators.trimLongTag(fullunitaryRegister, reporter);
                                          if (fullunitaryRegister != null) {
                                             DataOperators.pushAndSendToWo(fullunitaryRegister, reporter);
                                          }

                                          new JSONObject();
                                       }

                                       if (filesDataInfo != null && filesDataInfo.has("code")) {
                                          int answerCode = filesDataInfo.getInt("code");
                                          if (answerCode == 200) {
                                             if (filesDataInfo.has("value")) {
                                                JSONArray filesDataInfoValue = filesDataInfo.getJSONArray("value");
                                                if (filesDataInfoValue.length() > 1) {
                                                   for(int m = 0; m < filesDataInfoValue.length(); ++m) {
                                                      JSONObject filesDataInfoValue1 = filesDataInfoValue.getJSONObject(m);
                                                      unitaryRegister.put("sdx:URL", filesDataInfoValue1.get("URL"));
                                                      JSONObject fullunitaryRegister = DataOperators.makeFullUnitaryReg(unitaryRegister, reporter);
                                                      fullunitaryRegister = DataOperators.trimLongTag(fullunitaryRegister, reporter);
                                                      DataOperators.pushAndSendToWo(fullunitaryRegister, reporter);
                                                      fullunitaryRegister.clear();
                                                   }
                                                } else {
                                                   JSONObject filesDataInfoValue1 = filesDataInfoValue.getJSONObject(0);
                                                   unitaryRegister.put("sdx:URL", filesDataInfoValue1.get("URL"));
                                                }
                                             } else {
                                                var10001 = SDx_Application.getLineNumber();
                                                reporter.reportInfo(var10001 + "filesDataInfo no contiene value. " + filesDataInfo.toString(2));
                                             }
                                          } else {
                                             reporter.reportInfo(SDx_Application.getLineNumber() + " no encontrado file para identificador: " + fileId + " y fileUID: " + fileUID);
                                          }
                                       }
                                    } else {
                                       unitaryRegister = DataOperators.makeFullUnitaryReg(unitaryRegister, reporter);
                                       unitaryRegister = DataOperators.trimLongTag(unitaryRegister, reporter);
                                       DataOperators.pushAndSendToWo(unitaryRegister, reporter);
                                    }
                                 }
                              }
                           } else {
                              dataGroup = new JSONObject();
                              unitaryRegister = DataOperators.buildJsonRegister(documentsProjects, dataGroup);
                              if (unitaryRegister == null || unitaryRegister.isEmpty()) {
                                 reporter.reportInfo(SDx_Application.getLineNumber() + " unitaryRegister es vacío.");
                              }

                              unitaryRegister = DataOperators.makeFullUnitaryReg(unitaryRegister, reporter);
                              if (unitaryRegister == null || unitaryRegister.isEmpty()) {
                                 reporter.reportInfo(SDx_Application.getLineNumber() + " unitaryRegister es vacío.");
                              }

                              unitaryRegister = DataOperators.trimLongTag(unitaryRegister, reporter);
                              if (unitaryRegister == null || unitaryRegister.isEmpty()) {
                                 reporter.reportInfo(SDx_Application.getLineNumber() + " unitaryRegister es vacío.");
                              }

                              DataOperators.pushAndSendToWo(unitaryRegister, reporter);
                           }

                           ++k;
                        }
                     } else {
                        documentsProjectsValues = new JSONArray();
                     }

                     skip3 += 100;
                     int skipNoCurrentDocs = 0;
                     new JSONArray();

                     JSONArray jsonValue;
                     do {
                        JSONObject olderDocumentsProjects = DataOperators.doNoCurrentDocumentsProjectsQuery(projectObject, skipNoCurrentDocs, connectionObject, reporter);
                        if (olderDocumentsProjects == null) {
                           reporter.reportError(SDx_Application.getLineNumber() + " Se obtuvo una respuesta null a la consulta con los siguientes datos:");
                           var10001 = projectObject.toString();
                           reporter.reportInfo("projectObject:" + var10001 + " \nskipNoCurrentDocs:" + skipNoCurrentDocs);
                           TimeUnit.SECONDS.sleep(60L);
                           olderDocumentsProjects = DataOperators.doNoCurrentDocumentsProjectsQuery(projectObject, skipNoCurrentDocs, connectionObject, reporter);
                        }

                        if (!olderDocumentsProjects.has("value")) {
                           jsonValue = null;
                        } else {
                           jsonValue = olderDocumentsProjects.getJSONArray("value");
                           if (jsonValue != null && !jsonValue.isEmpty()) {
                              var10001 = SDx_Application.getLineNumber();
                              reporter.reportInfo(var10001 + " - Resultado de la consulta de registros diferentes a current: " + jsonValue.length() + " con projectObject: " + projectObject.toString(2));
                              JSONArray keysObject4Erase = new JSONArray();

                              int k;
                              for(k = 0; k < jsonValue.length(); ++k) {
                                 new JSONObject();
                                 tempObject = jsonValue.getJSONObject(k);
                                 dataGroup = DataOperators.objectConformer(tempObject, reporter);
                                 if (dataGroup != null && !dataGroup.isEmpty()) {
                                    keysObject4Erase.put(dataGroup);
                                 }
                              }

                              var10001 = SDx_Application.getLineNumber();
                              reporter.reportInfo(var10001 + " El tamaño de la respuesta es: " + keysObject4Erase.length());

                              for(k = 0; k < keysObject4Erase.length(); ++k) {
                                 String ksmoObjetc = keysObject4Erase.getJSONObject(k).toString();
                                 tempObject = keysObject4Erase.getJSONObject(k);
                                 JSONArray andObject = tempObject.getJSONArray("and");
                                 fileJson = andObject.getJSONObject(0);
                                 DataOperators.eraseRequestToWhereOil(ksmoObjetc, fileJson.getString("classname").toString() + ".json", reporter);
                              }
                           }
                        }
                     } while(jsonValue.length() > 100);

                     var10001 = SDx_Application.getLineNumber();
                     reporter.reportInfo(var10001 + " El tamaño de documentsProjectsValues es: " + documentsProjectsValues.length());
                  } while(documentsProjectsValues.length() > 0);
               }

               skip2 += 100;
            } while(projectsListValue.length() > 0);

            if (i == facilityValues.length() - 1) {
            }
         }

         skip1 += 100;
      } while(facilityValues.length() > 0);

   }

   public JSONArray passToWriteInWhereOil(JSONArray groupToSend, String eventName, Reporter reporter) {
      if (groupToSend.length() > 0) {
         WhereoilConexion connectOW = new WhereoilConexion(WHEREOIL_URL, WHEREOIL_USERNAME, WHEREOIL_PASSWORD, WHEREOIL_TOKEN);
         String newTicket = connectOW.getValidTicket();
         if (!newTicket.equals("error") && !newTicket.equals("false")) {
            String[] msgToSend = new String[]{groupToSend.toString()};
            String salidita = connectOW.writeConnector(msgToSend, eventName, newTicket, reporter);
            if (salidita != "" || !salidita.equals("")) {
               reporter.reportInfo(salidita);
            }

            groupToSend = new JSONArray(new ArrayList());
         } else {
            reporter.reportInfo("Se ha presentado un error con el ticket solicitado.");
         }
      }

      return groupToSend;
   }

   public static JSONObject putLinkInUnitaryReg(JSONObject unitaryRegister, JSONObject documentsProjectsValuesElement, connectionOperations connectionObject, Reporter reporter) {
      if (documentsProjectsValuesElement.has("Name")) {
         unitaryRegister.put("sdx:Nombre_archivo", documentsProjectsValuesElement.get("Name"));
      }

      if (documentsProjectsValuesElement.has("Id")) {
         String fileId = documentsProjectsValuesElement.getString("Id");
         unitaryRegister.put("sdx:Id_archivo", fileId);
         JSONObject filesDataInfo = DataOperators.doUrlFilesQuery(fileId, connectionObject, reporter);
         if (filesDataInfo.has("value")) {
            JSONArray value = filesDataInfo.getJSONArray("value");
            if (value.length() > 0) {
               JSONObject valuePayload = value.getJSONObject(0);
               if (valuePayload.has("URL")) {
                  unitaryRegister.put("sdx:URL", valuePayload.getString("URL"));
               }
            }
         }
      }

      return unitaryRegister;
   }

   public static void callToDeleteRegs(Reporter reporter) throws ParseException {
      WhereoilConexion connectOW = new WhereoilConexion(WHEREOIL_URL, WHEREOIL_USERNAME, WHEREOIL_PASSWORD, WHEREOIL_TOKEN);
      String newTicket = connectOW.getValidTicket();
      if (!newTicket.equals("error") && !newTicket.equals("false")) {
         String[] classNameList = new String[]{"sdx:calidad.json", "sdx:comisionamiento.json", "sdx:construccion.json", "sdx:epp.json", "sdx:ingenieria.json", "sdx:materiales.json"};
         String nowDate = DataOperators.postDate();
         Date date1 = (new SimpleDateFormat("yyyy-MM-dd")).parse(nowDate);
         int qttyDays = Qtty_of_cut_off_days;
         if (qttyDays <= 0) {
            qttyDays = 1;
         }

         Date cutDate = DataOperators.DateSubs(date1, qttyDays);
         String cutDateStr = DataOperators.DateFormater(cutDate);
         cutDateStr = cutDateStr + "T00:00:00";

         for(int j = 0; j < classNameList.length; ++j) {
            JSONObject dateCutjson = new JSONObject();
            dateCutjson.put("kmeta:updateTime", cutDateStr);
            JSONArray compareOperator = new JSONArray();
            compareOperator.put(dateCutjson);
            JSONObject fullQuery4Delete = new JSONObject();
            fullQuery4Delete.put("classname", classNameList[j]);
            fullQuery4Delete.put("le", compareOperator);
            String var10001 = SDx_Application.getLineNumber();
            reporter.reportInfo(var10001 + " fullQuery4Delete: " + fullQuery4Delete.toString(2));
            String queryInString = fullQuery4Delete.toString();
            String result2Delete = connectOW.deleteRegisters(queryInString, classNameList[j], newTicket, reporter);
            var10001 = SDx_Application.getLineNumber();
            reporter.reportInfo(var10001 + " - " + result2Delete);
         }
      } else {
         reporter.reportError(SDx_Application.getLineNumber() + " - Se ha presentado un error con el ticket solicitado.");
      }

   }

   public static void callToDeleteHLPregisters(Reporter reporter) {
      Date fechaActual = new Date();
      System.out.println("fechaActual: " + fechaActual.toString());
      Date initDateTime = DataOperators.DateSubs(fechaActual, Qtty_of_cut_off_days);
      System.out.println("initDateTime: " + initDateTime);
      String initDate = DataOperators.DateFormater(initDateTime);
      System.out.println("initDate: " + initDate);
      initDate = initDate + "T00:00:00";
      String queryToDeleteHLP = "{\n    \"and\": [\n        {\n            \"classname\": \"maduracionproj:maduracionproj\",\n            \"eq\": [\n                {\n                    \"maduracionproj:source\": \"SDx\"\n                }\n            ],\n            \"le\": [\n                {\n                    \"kmeta:updateTime\": \"" + initDate + "\"\n                }\n            ]\n        }\n    ]\n}";
      DataOperators.eraseRequestToWhereOil(queryToDeleteHLP, "maduracionproj:maduracionproj.json", reporter);
   }

   public static int plantsFinder(String plantToFind, JSONArray plantsList) {
      for(int i = 0; i < plantsList.length(); ++i) {
         JSONObject plant = plantsList.getJSONObject(i);
         if (plant.has("UID") && plant.get("UID").equals(plantToFind)) {
            return i;
         }
      }

      return 0;
   }

   public static int projectsFinder(String projectToFind, JSONArray projectsList) {
      for(int i = 0; i < projectsList.length(); ++i) {
         JSONObject project = projectsList.getJSONObject(i);
         if (project.has("UID") && project.get("UID").equals(projectToFind)) {
            return i;
         }
      }

      return 0;
   }

   public String getName() {
      return "SDx_FirstFunction";
   }

   public String getDescription() {
      return "Procedimiento de Consulta de datos en SDx.";
   }
}
