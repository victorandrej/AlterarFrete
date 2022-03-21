/*    */ package br.com.grupocampanha.tipofrete;
/*    */ 
/*    */ public class Xml {
/*    */   public static String requisicao(String tipoFrete, String nuNota) {
/*  5 */     StringBuilder req = new StringBuilder();
/*  6 */     req.append("<nota NUNOTA =\"");
/*  7 */     req.append(String.valueOf(nuNota) + "\">");
/*  8 */     req.append("<cabecalho>");
/*  9 */     req.append("<NUNOTA>");
/* 10 */     req.append(nuNota);
/* 11 */     req.append("</NUNOTA>");
/* 12 */     req.append("<CIF_FOB>");
/* 13 */     req.append(tipoFrete);
/* 14 */     req.append("</CIF_FOB>");
/* 15 */     req.append("</cabecalho>");
/* 16 */     req.append("</nota>");
/* 17 */     return req.toString();
/*    */   }
/*    */ }


/* Location:              C:\Users\jfc\Desktop\Nova pasta (6)\TSIJAR_DATA_TABLEa058d4e6-017d-1000-8002-c0a80076fe4a.jar!\br\com\grupocampanha\tipofrete\Xml.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */