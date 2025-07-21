/* Decompiler 9ms, total 477ms, lines 19 */
package com.wavecomm.SDx;

import com.kadme.rest.webtool.tool.AbstractTool;

public class ToolTest extends AbstractTool {
   protected void defineCommands() {
      this.addCommand(() -> {
         return new SDx_testConnection(this);
      });
      this.addCommand(() -> {
         return new SDx_FirstFuncion(this);
      });
   }

   public String getOntologyNamespace() {
      return "well_data";
   }
}
