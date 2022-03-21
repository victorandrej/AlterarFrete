/*    */ package br.com.grupocampanha.tipofrete;

/*    */
 /*    */ import br.com.sankhya.extensions.actionbutton.ContextoAcao;
/*    */ import br.com.sankhya.modelcore.servicecaller.ServiceCaller;

/*    */
 /*    */ public class ResultadoRequisicao
        /*    */ implements ServiceCaller.ServiceResult {

    /*    */ public ContextoAcao arg;
    /*    */  

    /*    */
 /*    */ public void onFailure(int arg0, String arg1) throws Exception {
        /* 12 */ throw new Exception("Exclusao nao foi concluida " + Integer.toString(arg0) + " " + arg1);
        /*    */    }

    /*    */
 /*    */
 /*    */
    public void onSuccess(String arg0) throws Exception {

 }
    /*    */ }


/* Location:              C:\Users\jfc\Desktop\Nova pasta (6)\TSIJAR_DATA_TABLEa058d4e6-017d-1000-8002-c0a80076fe4a.jar!\br\com\grupocampanha\tipofrete\ResultadoRequisicao.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
