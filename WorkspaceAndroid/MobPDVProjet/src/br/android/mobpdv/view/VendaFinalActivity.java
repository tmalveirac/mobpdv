package br.android.mobpdv.view;

import java.util.ArrayList;
import java.util.List;

import br.android.mobpdv.R;
import br.android.mobpdv.R.layout;
import br.android.mobpdv.R.menu;
import br.android.mobpdv.model.Produto;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class VendaFinalActivity extends CicloVidaActivity {
	
	private List<Produto> listaProduto = new ArrayList<Produto>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_venda_final);
		
		
		
		// Recebe a lista de produtos do pedido pelo Intent
		Produto p;

		int i = 0;
		
		while (getIntent().hasExtra(""+i)){
			p = (Produto) getIntent().getParcelableExtra(""+i);
			listaProduto.add(p);
				
			Log.i(CATEGORIA, i + " - " + p.getDescricao());
			i++;
		}
		
		
		
		
		// Inserindo a lista no layout
		
		LinearLayout linearDados = (LinearLayout) findViewById(R.id.venda_final);

		
	
		
		
		for (Produto produto : listaProduto) {

			TextView txtDesc = new TextView(this);
			//txt.setText(msg);
			txtDesc.setText(produto.getDescricao());
			txtDesc.setPadding(0, 10, 0, 0);
			txtDesc.setTextSize(30);
			//txt.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
			
			TextView txtValor = new TextView(this);
			//txt.setText(msg);
			txtValor.setText("R$ " + Double.toString(produto.getValor()));
			txtValor.setPadding(50, 10, 0, 0);
			txtValor.setTextSize(30);

			
			LinearLayout linear = new LinearLayout(this);
			LinearLayout linearValor = new LinearLayout(this);
			
			linear.setOrientation(LinearLayout.HORIZONTAL);
			linearValor.setOrientation(LinearLayout.HORIZONTAL);
			
			
			linear.addView(txtDesc);
			
			linearValor.addView(txtValor);
			
			linear.addView(linearValor);
			
			linearDados.addView(linear);
		}
				
		
		
		
		
		// STRING VALOR TOTAL
		
		TextView t = (TextView) findViewById(R.id.txtValorVendaFinal);
		
		t.setText("TOTAL - R$ "+ somaTotal(listaProduto));
		
		
		
		
		Button btnGerarComprovante = (Button) findViewById(R.id.btnGerarComprovante);
		
		btnGerarComprovante.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Intent it = new Intent(VendaFinalActivity.this, MainActivity.class);
				
				Log.d(CATEGORIA, "Gerar Comprovante");
				
				Toast.makeText(VendaFinalActivity.this, COMPROVANTE_GERADO, Toast.LENGTH_SHORT).show();
				
				startActivity(it);
				
				finish();
			}
		});
		
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.venda_final, menu);
		return true;
	}
	
	
	
	public double somaTotal(List<Produto> lista){
		
		double soma = 0;
		for ( Produto p : lista ){
			
			soma += p.getValor();
		}
		
		return soma;
	}

}
