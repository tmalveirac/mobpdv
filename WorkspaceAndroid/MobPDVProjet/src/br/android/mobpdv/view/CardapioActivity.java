package br.android.mobpdv.view;

import br.android.mobpdv.R;
import android.os.Bundle;
import android.app.ExpandableListActivity;
import android.app.ListActivity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.Toast;

public class CardapioActivity extends CicloVidaActivity {

	ExpandableListView list;
	ExpandableListAdapter adapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cardapio);
	
		list = (ExpandableListView) this.findViewById(R.id.lxpCardapio); 
		
		adapter = new CategoriaAdapter(this);
		list.setAdapter(adapter);
		
		
		list.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
			
			@Override
			public boolean onGroupClick(ExpandableListView parent, View v,
					int groupPosition, long id) {
				return list_onGroupClick(parent, v, groupPosition, id);
			}
		});
		
		list.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
			
			@Override
			public boolean onChildClick(ExpandableListView parent, View v,
					int groupPosition, int childPosition, long id) {
				return list_onChildClick(parent, v, groupPosition, childPosition, id);
			}
		});
	}
	
	public boolean list_onGroupClick(ExpandableListView parent, View v,
			int groupPosition, long id) {
		
		return false;
		
	}
	
	public boolean list_onChildClick(ExpandableListView parent, View v,
			int groupPosition, int childPosition, long id) {

		Intent rcvIntent = getIntent();
		String msg = null;
		
		if (rcvIntent != null){
			msg = rcvIntent.getStringExtra(MENSAGEM);
			if (msg != null){
				Log.i(CATEGORIA, "Mensagem recebida: " + msg);
			}
		}
		
		if (msg.equals(VER_CARDAPIO)){
			//Chama a Activity Pedido sem Result! Veio de Main
			Intent it = new Intent(CardapioActivity.this, PedidoActivity.class);
			it.putExtra(MENSAGEM, adapter.getChild(groupPosition, childPosition).toString());	
			startActivity(it);
			finish();
		}
		else{
			//Retornar para a Activity Pedido com result! Veio de Pedido
			Intent it = new Intent();
			it.putExtra(MENSAGEM, adapter.getChild(groupPosition, childPosition).toString());	
			setResult(RESULT_OK, it);
			finish();
		}
			
		
		return false;
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.cardapio, menu);
		return true;
	}
	
	

}
