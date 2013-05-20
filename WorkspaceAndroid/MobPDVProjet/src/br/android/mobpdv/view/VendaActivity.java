package br.android.mobpdv.view;

import br.android.mobpdv.R;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;

public class VendaActivity extends CicloVidaActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		//setContentView(R.layout.activity_venda);
		
		Intent it = getIntent();
		if (it != null){
			String msg = it.getStringExtra("msg");
			if (msg != null){
				Log.d("TESTE", "Mensagem: " + msg);
			}
		}
		
		
		
	}

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.venda, menu);
		return true;
	}

}
