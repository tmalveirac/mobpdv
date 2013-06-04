package br.android.mobpdv.view;

import br.android.mobpdv.R;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;

public class CicloVidaActivity extends Activity {

	protected static final String CATEGORIA = "TESTE";
	protected static final String MENSAGEM = "msg";
	protected static final String VER_CARDAPIO = "cardapio";
	protected static final String BUSCAR_PRODUTO = "produto";
	protected static final String CAIXA_ABERTO = "Caixa Aberto com Sucesso";
	protected static final String CAIXA_FECHADO = "Caixa Fechado com Sucesso";
	protected static final String PEDIDO_CANCELADO = "Pedido Cancelado";
	protected static final String REALIZAR_VENDA = "Realizar Venda";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		Log.i(CATEGORIA, getClassName() + ".onCreate() chamado: " + savedInstanceState);
		 
		setContentView(R.layout.activity_ciclo_vida);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.ciclo_vida, menu);
		return true;
	}
	
	protected void onStart() {
		super.onStart();
		Log.i(CATEGORIA, getClassName() + ".onStart() chamado.");
	}
    
    protected void onRestart() {
		super.onRestart();
		Log.i(CATEGORIA, getClassName() + ".onRestart() chamado.");
	}
    
    protected void onResume() {
		super.onResume();
		Log.i(CATEGORIA, getClassName() + ".onResume() chamado.");
	}
    
    protected void onPause() {
		super.onPause();
		Log.i(CATEGORIA, getClassName() + ".onPause() chamado.");
	}
    
    protected void onStop() {
		super.onStop();
		Log.i(CATEGORIA, getClassName() + ".onStop() chamado.");
	}

    protected void onDestroy() {
		super.onDestroy();
		Log.i(CATEGORIA, getClassName() + ".onDestroy() chamado.");
	}
    
    private String getClassName(){
    	// Retorna o nome da classe sem o pacote
    	String s = getClass().getName();
    	return s.substring(s.lastIndexOf("."));
    }
    
}
