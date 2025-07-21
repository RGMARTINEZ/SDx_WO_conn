/* Decompiler 15ms, total 242ms, lines 86 */
package com.wavecomm.SDx;

public class connectionObject {
   private double timeUpdated;
   private String acces_token;
   private String refresh_token;
   private String token_type;
   private String scope;
   private int expires_in;
   private String url;
   private String APIkey;
   private String payload;

   public double getTimeUpdated() {
      return this.timeUpdated;
   }

   public void setTimeUpdated(double timeUpdated) {
      this.timeUpdated = timeUpdated;
   }

   public String getAcces_token() {
      return this.acces_token;
   }

   public void setAcces_token(String acces_token) {
      this.acces_token = acces_token;
   }

   public String getRefresh_token() {
      return this.refresh_token;
   }

   public void setRefresh_token(String refresh_token) {
      this.refresh_token = refresh_token;
   }

   public String getToken_type() {
      return this.token_type;
   }

   public void setToken_type(String token_type) {
      this.token_type = token_type;
   }

   public String getScope() {
      return this.scope;
   }

   public void setScope(String scope) {
      this.scope = scope;
   }

   public int getExpires_in() {
      return this.expires_in;
   }

   public void setExpires_in(int expires_in) {
      this.expires_in = expires_in;
   }

   public String getUrl() {
      return this.url;
   }

   public void setUrl(String url) {
      this.url = url;
   }

   public String getAPIkey() {
      return this.APIkey;
   }

   public void setAPIkey(String APIkey) {
      this.APIkey = APIkey;
   }

   public String getPayload() {
      return this.payload;
   }

   public void setPayload(String payload) {
      this.payload = payload;
   }
}
