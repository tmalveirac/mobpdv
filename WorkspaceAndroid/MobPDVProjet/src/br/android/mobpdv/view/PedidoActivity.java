package br.android.mobpdv.view;

import br.android.mobpdv.R;
import br.android.mobpdv.model.Produto;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class PedidoActivity extends CicloVidaActivity {

	public static final int BUSCAR_PRODUTO = 1;
	
	private AlertDialog alerta;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_pedido);
		
		//Primeira Vez em que Esta Activity é chamada, recebe o primeiro parâmetro
		Intent it = getIntent();
		if (it != null){
			//String msg = it.getStringExtra(MENSAGEM);
			Produto p = (Produto) it.getParcelableExtra(MENSAGEM);	
			if (p != null){
				//Log.i(CATEGORIA, "Mensagem recebida onCreate: " + msg.toString());
				
				//Adicionar produto no layout!
				
				Log.i(CATEGORIA, "Mensagem recebida onCreate: " + p.getDescricao());
				
				TextView txt = new TextView(this);
				//txt.setText(msg);
				txt.setText(p.getDescricao());
				txt.setPadding(0, 10, 0, 0);
				txt.setTextSize(30);
				//txt.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
				
				LinearLayout linearDados = (LinearLayout) findViewById(R.id.pedido_dados);
				
				linearDados.addView(txt);
			
				Log.i(CATEGORIA, " ONCREATE");
				
			}
			else {
				Log.i(CATEGORIA, "Pedido Mensagem recebida onCreate: NULO ");
			}
		}
		
		
		Button btnBuscarProduto = (Button) findViewById(R.id.btnBpdt);
		
		
		btnBuscarProduto.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//Chamar Cardápio!
				Intent it = new Intent(PedidoActivity.this, CardapioActivity.class);
				it.putExtra(MENSAGEM, "Parãmetro enviado!");	
				
				startActivityForResult(it, BUSCAR_PRODUTO);
			}
		});
		
		
		Button btnCancelarPedido = (Button) findViewById(R.id.btnCancelarPedido);
		btnCancelarPedido.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				cancelarPedido();
			}
		});
		
		
	}
	
	
	public void cancelarPedido(){
		
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
	    builder.setTitle("Cancelar Pedido");
	    builder.setMessage("Deseja realmente cancelar o pedido?");
	    
	    builder.setPositiveButton("Cancelar", new DialogInterface.OnClickListener() {
	        public void onClick(DialogInterface arg0, int arg1) {
	        	Log.d(CATEGORIA, "Clicou em Cancelar!");
	        }
	    });

	    builder.setNegativeButton("Confirmar", new DialogInterface.OnClickListener() {
	        public void onClick(DialogInterface arg0, int arg1) {
	            Toast.makeText(PedidoActivity.this, PEDIDO_CANCELADO, Toast.LENGTH_SHORT).show();
	            finish();
	        }
	    });

	    alerta = builder.create();
	    alerta.show();
	    
	}
	
	
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		/*String msg = data.getStringExtra(MENSAGEM);
		if (msg != null){
			Log.i(CATEGORIA, "Mesagem recebida onResult = " + msg.toString());
		}
		*/

		Produto p = (Produto) data.getParcelableExtra(MENSAGEM);	
		
		
		if (p != null){
			
			
			Log.i(CATEGORIA, "Mensagem recebida onResult: " + p.getDescricao());
			
			TextView txt = new TextView(this);
			//txt.setText(msg);
			txt.setText(p.getDescricao());
			txt.setPadding(0, 10, 0, 0);
			txt.setTextSize(30);
			//txt.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
			
			LinearLayout linear = (LinearLayout) findViewById(R.id.pedido_dados);
			
			linear.addView(txt);
			
			Log.i(CATEGORIA, " ONRESULT");
		}
		else{
			Log.i(CATEGORIA, "Pedido Mensagem recebida OnResult: NULO ");
		}
	
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.venda, menu);
		return true;
	}

}
