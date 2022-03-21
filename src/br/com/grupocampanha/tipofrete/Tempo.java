/*   */ package br.com.grupocampanha.tipofrete;
/*   */ public class Tempo {
/*   */   public static String inverter(String tempo) {
/* 4 */     String inverso = "";
/* 5 */     inverso = String.valueOf(tempo.substring(8, 10)) + "/" + tempo.substring(5, 7) + "/" + tempo.substring(0, 4);
/* 6 */     return inverso;
/*   */   }
/*   */ }


/* Location:              C:\Users\jfc\Desktop\Nova pasta (6)\TSIJAR_DATA_TABLEa058d4e6-017d-1000-8002-c0a80076fe4a.jar!\br\com\grupocampanha\tipofrete\Tempo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */