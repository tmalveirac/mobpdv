package br.android.mobpdv.view;

import br.android.mobpdv.R;
import android.os.Bundle;
import android.app.ExpandableListActivity;
import android.app.ListActivity;
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
		Toast.makeText(CardapioActivity.this, adapter.getChild(groupPosition, childPosition).toString(), Toast.LENGTH_SHORT).show();
		return false;
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.cardapio, menu);
		return true;
	}
	
	

}
