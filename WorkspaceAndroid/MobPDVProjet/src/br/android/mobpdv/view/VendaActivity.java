package br.android.mobpdv.view;

import java.util.ArrayList;
import java.util.List;

import br.android.mobpdv.R;
import br.android.mobpdv.R.layout;
import br.android.mobpdv.R.menu;
import br.android.mobpdv.model.Produto;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class VendaActivity extends CicloVidaActivity {

	private AlertDialog alerta;
	private List<Produto> listaProduto = new ArrayList<Produto>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_venda);
		
		Produto p;
		
		int i = 0;
		
		while (getIntent().hasExtra(""+i)){
			p = (Produto) getIntent().getParcelableExtra(""+i);
			listaProduto.add(p);
				
			Log.i(CATEGORIA, i + " - " + p.getDescricao());
			i++;
		}
		
		ListView listaView = (ListView) findViewById(R.id.listView1);
		
		
		String[] itens = new String[] {"Dinheiro","Cartão","Vale"};
		ArrayAdapter<String> myarrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, itens);
		listaView.setAdapter(myarrayAdapter);
		listaView.setTextFilterEnabled(true);
		
		
		TextView t = (TextView) findViewById(R.id.txtPedidoTotal);
		
		t.setText("TOTAL - R$ "+ somaTotal(listaProduto));
		//t.setBackgroundColor(Color.GRAY);
		//t.setBackgroundColor(Color.TRANSPARENT);
		
		/*
		for (int j = 0; j < listaProduto.size() ; j++) {
			TextView t = new TextView (this);
			
			t.setText(listaProduto.get(j).getDescricao() + " -- R$ " + listaProduto.get(j).getValor());
			
		
		}
		*/
		
		
		
		
		Button btnCancelarVenda = (Button) findViewById(R.id.btnCancelarVenda);
		
		btnCancelarVenda.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Log.d(CATEGORIA, "Finalizar Venda!");
				cancelarVenda();
			}
		});
		
		
		
		Button btnFinalizarVenda = (Button) findViewById(R.id.btnFinalizarVenda);
		
		btnFinalizarVenda.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Log.d(CATEGORIA, "Cancelar Venda!");
				
				Intent it = new Intent(VendaActivity.this, VendaFinalActivity.class);
				
				for (int i = 0; i < listaProduto.size(); i++) {
					it.putExtra(""+i, listaProduto.get(i));
					Log.d(CATEGORIA, "inserido! " + i);
				}
				
				Log.d(CATEGORIA, "Inseriu");
				
				startActivity(it);
			}
		});
	

		
	}
	
	
	public void cancelarVenda(){
		
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
	    builder.setTitle("Cancelar Venda");
	    builder.setMessage("Deseja realmente cancelar a venda?");
	    
	    builder.setPositiveButton("Cancelar", new DialogInterface.OnClickListener() {
	        public void onClick(DialogInterface arg0, int arg1) {
	        	Log.d(CATEGORIA, "Clicou em Cancelar!");
	        }
	    });

	    builder.setNegativeButton("Confirmar", new DialogInterface.OnClickListener() {
	        public void onClick(DialogInterface arg0, int arg1) {
	        	Intent it = new Intent(VendaActivity.this, MainActivity.class);
	            Toast.makeText(VendaActivity.this, VENDA_CANCELADA, Toast.LENGTH_SHORT).show();
	         
	        	startActivity(it);
	            finish();
	        }
	    });

	    alerta = builder.create();
	    alerta.show();
	    
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.venda, menu);
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
