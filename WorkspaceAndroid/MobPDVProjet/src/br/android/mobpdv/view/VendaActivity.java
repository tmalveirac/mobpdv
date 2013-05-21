package br.android.mobpdv.view;

import br.android.mobpdv.R;
import br.android.mobpdv.R.layout;
import br.android.mobpdv.R.menu;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class VendaActivity extends CicloVidaActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_venda);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.venda, menu);
		return true;
	}

}
