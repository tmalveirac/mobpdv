package br.android.mobpdv.view;

import br.android.mobpdv.R;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class PedidoActivity extends CicloVidaActivity {

	public static final int BUSCAR_PRODUTO = 1;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_pedido);
		
		//Primeira Vez em que Esta Activity é chamada, recebe o primeiro parâmetro
		Intent it = getIntent();
		if (it != null){
			String msg = it.getStringExtra(MENSAGEM);
			if (msg != null){
				Log.i(CATEGORIA, "Mensagem recebida onCreate: " + msg);
				
				//Adicionar produto no layout!
				TextView txt = new TextView(this);
				txt.setText(msg);
				txt.setPadding(0, 10, 0, 0);
				txt.setTextSize(30);
				//txt.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
				
				LinearLayout linear = (LinearLayout) findViewById(R.id.pedido_form);
				
				linear.addView(txt);
			
				setContentView(linear);
				
				
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
		
		
		
		
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		String msg = data.getStringExtra(MENSAGEM);
		if (msg != null){
			Log.i(CATEGORIA, "Mesagem recebida onResult = " + msg);
		}
		
		TextView txt = new TextView(this);
		txt.setText(msg);
		txt.setPadding(0, 10, 0, 0);
		txt.setTextSize(30);
		//txt.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
		
		LinearLayout linear = (LinearLayout) findViewById(R.id.pedido_form);
		
		linear.addView(txt);
	
		setContentView(linear);
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.venda, menu);
		return true;
	}

}
