/*    */ package br.com.grupocampanha.tipofrete;
/*    */ 
/*    */ import br.com.sankhya.extensions.actionbutton.ContextoAcao;
/*    */ import br.com.sankhya.extensions.actionbutton.QueryExecutor;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ 
/*    */ public class Banco {
/*    */   private static ContextoAcao _arg;
/*    */   
/*    */   public static void setArg(ContextoAcao arg) {
/* 12 */     _arg = arg;
/*    */   }
/*    */   public static List<String> nuNotasRota(String rota, String data, String empresa) throws Exception {
/* 15 */     QueryExecutor query = _arg.getQuery();
/* 16 */     String Sql = "SELECT NUNOTA FROM TGFCAB WHERE DTENTSAI = {DTENTSAI} AND TIPMOV = 'P' AND AD_CODROTA = {ROTA} AND CODEMP = {EMPRESA} AND CODTIPOPER IN(311,312,313)";
/* 17 */     query.setParam("EMPRESA", empresa);
/* 18 */     query.setParam("DTENTSAI", data);
/* 19 */     query.setParam("ROTA", rota);
/* 20 */     query.nativeSelect(Sql);
/* 21 */     List<String> nUnicos = new ArrayList<>();
/* 22 */     while (query.next()) {
/* 23 */       nUnicos.add(query.getString("NUNOTA"));
/*    */     }
/* 25 */     return nUnicos;
/*    */   }
/*    */   public static List<String> nuNotasMatriz(String matriz, String data, String empresa) throws Exception {
/* 28 */     QueryExecutor query = _arg.getQuery();
/* 29 */     query.setParam("CODPARCMATRIZ", matriz);
/* 30 */     String Sql = "SELECT CODPARC FROM TGFPAR WHERE CODPARCMATRIZ = {CODPARCMATRIZ}";
/* 31 */     StringBuilder parceiros = new StringBuilder();
/* 32 */     query.nativeSelect(Sql);
/* 33 */     while (query.next()) {
/* 34 */       parceiros.append(String.valueOf(query.getString("CODPARC")) + ",");
/*    */     }
/* 36 */     parceiros.replace(parceiros.length() - 1, parceiros.length(), "");
/* 37 */     parceiros = parceiros.replace(parceiros.lastIndexOf(",") - 1, parceiros.lastIndexOf(","), "");
/* 38 */     Sql = "SELECT NUNOTA FROM TGFCAB WHERE DTENTSAI = '" + data + "' AND TIPMOV = 'P' AND CODPARC IN(" + parceiros.toString() + ") AND CODEMP = " + empresa + " AND CODTIPOPER IN(311,312,313)";
/* 39 */     query.nativeSelect(Sql);
/* 40 */     List<String> nUnicos = new ArrayList<>();
/* 41 */     while (query.next()) {
/* 42 */       nUnicos.add(query.getString("NUNOTA"));
/*    */     }
/* 44 */     return nUnicos;
/*    */   }
/*    */   public static List<String> nuNotasMatrizRota(String rota, String matriz, String data, String empresa) throws Exception {
/* 47 */     QueryExecutor query = _arg.getQuery();
/* 48 */     query.setParam("CODPARCMATRIZ", matriz);
/* 49 */     String Sql = "SELECT CODPARC FROM TGFPAR WHERE CODPARCMATRIZ = {CODPARCMATRIZ}";
/* 50 */     StringBuilder parceiros = new StringBuilder();
/* 51 */     query.nativeSelect(Sql);
/* 52 */     while (query.next()) {
/* 53 */       parceiros.append(String.valueOf(query.getString("CODPARC")) + ",");
/*    */     }
/* 55 */     parceiros.replace(parceiros.length() - 1, parceiros.length(), "");
/* 56 */     Sql = "SELECT NUNOTA FROM TGFCAB WHERE DTENTSAI = '" + data + "' AND TIPMOV = 'P' AND CODPARC IN(" + parceiros.toString() + ") AND AD_CODROTA = " + rota + " AND CODEMP = " + empresa + " AND CODTIPOPER IN(311,312,313)";
/* 57 */     query.nativeSelect(Sql);
/* 58 */     List<String> nUnicos = new ArrayList<>();
/* 59 */     while (query.next()) {
/* 60 */       nUnicos.add(query.getString("NUNOTA"));
/*    */     }
/*    */     
/* 63 */     return nUnicos;
/*    */   }
/*    */ }


/* Location:              C:\Users\jfc\Desktop\Nova pasta (6)\TSIJAR_DATA_TABLEa058d4e6-017d-1000-8002-c0a80076fe4a.jar!\br\com\grupocampanha\tipofrete\Banco.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */