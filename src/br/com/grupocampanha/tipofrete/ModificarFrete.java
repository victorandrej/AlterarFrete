/*    */ package br.com.grupocampanha.tipofrete;

/*    */
 /*    */ import br.com.sankhya.extensions.actionbutton.AcaoRotinaJava;
/*    */ import br.com.sankhya.extensions.actionbutton.ContextoAcao;
import br.com.sankhya.jape.core.JapeSession;
/*    */ import br.com.sankhya.modelcore.servicecaller.ServiceCaller;
/*    */ import java.util.List;

/*    */
 /*    */ public class ModificarFrete
        /*    */ implements AcaoRotinaJava {

    /*    */ String data;
    /*    */    String empresa;
    /*    */    String rota;
    /*    */    String tipoFrete;
    /*    */    String matriz;

    /*    */
 /*    */
    @Override
    public void doAction(ContextoAcao arg0) throws Exception {
        /* 18 */ this.data = Tempo.inverter(arg0.getParam("DATA").toString());
        /* 19 */ this.empresa = arg0.getParam("EMPRESA").toString();
        /* 20 */ this.tipoFrete = arg0.getParam("TIPOFRETE").toString().replace(" ", "");
        /* 21 */ if (arg0.getParam("ROTA") == null && arg0.getParam("MATRIZ") == null) {
            /* 22 */ this.rota = null;
            /* 23 */ this.matriz = null;
            /* 24 */        } else if (arg0.getParam("ROTA") == null) {
            /* 25 */ this.rota = null;
            /* 26 */ this.matriz = arg0.getParam("MATRIZ").toString();
            /* 27 */        } else if (arg0.getParam("MATRIZ") == null) {
            /* 28 */ this.rota = arg0.getParam("ROTA").toString();
            /* 29 */ this.matriz = null;
            /*    */        } else {
            /* 31 */ this.rota = arg0.getParam("ROTA").toString();
            /* 32 */ this.matriz = arg0.getParam("MATRIZ").toString();
            /*    */        }
        /* 34 */ Banco.setArg(arg0);
        /* 35 */ List<String> nuNotas = null;
        /* 36 */ if (this.matriz != null && this.rota != null)
            /* 37 */ nuNotas = Banco.nuNotasMatrizRota(this.rota, this.matriz, this.data, this.empresa); /* 38 */
        else if (this.rota != null)
            /* 39 */ nuNotas = Banco.nuNotasRota(this.rota, this.data, this.empresa); /* 40 */
        else if (this.matriz != null)
            /* 41 */ nuNotas = Banco.nuNotasMatriz(this.matriz, this.data, this.empresa); /*    */
        else
            /* 43 */ throw new Exception("Selecione uma rota ou insira uma matriz!"); /*    */

        if (nuNotas.size() > 0) {
   

 /* 48 */ ServiceCaller sc = ServiceCallerFactory.newInstance(arg0.getUsuarioLogado());
            JapeSession.suspend();
            JapeSession.open();

            /* 51 */ for (int i = 0; i < nuNotas.size(); i++)
                /* 52 */ sc.callAsXml("CACSP.incluirAlterarCabecalhoNota", "mgecom", Xml.requisicao(this.tipoFrete, nuNotas.get(i)), new ResultadoRequisicao() {
                }
                /*    */); /*    */

            if (this.rota != null)
                arg0.setMensagemRetorno("Alteracoes na rota " + this.rota + " concluidas com sucesso");
            else
                arg0.setMensagemRetorno("Alteracoes concluidas com sucesso");

                   } else
           arg0.mostraErro("SEM PEDIDO"); /*    */
      }
}

