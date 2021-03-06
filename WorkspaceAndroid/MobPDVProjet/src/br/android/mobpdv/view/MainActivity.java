package br.android.mobpdv.view;



import br.android.mobpdv.R;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends CicloVidaActivity {
	
	private static final String CATEGORIA = "TESTE";
	private AlertDialog alerta;
	 

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.activity_main);
        
        // Busca Botão pelo Id
        Button btnAbrirCaixa = (Button) findViewById(R.id.btnAbrCxa);
        Button btnVerCardapio = (Button) findViewById(R.id.btnVerCdp);
        Button btnFecharCaixa = (Button) findViewById(R.id.btnFecCxa);
        
        Log.d(CATEGORIA, "Iniciou Aplicação no método onCreate da MainActivity");
        
        // Abrir Caixa
        btnAbrirCaixa.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Log.d(CATEGORIA, "Abrir Caixa");
				abrirCaixa();
			}
		});
    
        // Iniciar Venda
        btnVerCardapio.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Log.d(CATEGORIA, "Ver Cardápio");
				
				Intent it = new Intent(MainActivity.this, CardapioActivity.class);
				it.putExtra(MENSAGEM, VER_CARDAPIO);				
				startActivity(it);
				
			}
		});
    
        
        btnFecharCaixa.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Log.d(CATEGORIA, "Fechar Caixa");
				fecharCaixa();
			}
		});
        
    }
    
    

    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    
    private void abrirCaixa() {

    	AlertDialog.Builder builder = new AlertDialog.Builder(this);
	    builder.setTitle("Abrir Caixa");
	    builder.setMessage("Deseja realmente abrir caixa?");
	    
	    builder.setPositiveButton("Cancelar", new DialogInterface.OnClickListener() {
	        public void onClick(DialogInterface arg0, int arg1) {
	        	Log.d(CATEGORIA, "Clicou em Cancelar!");
	        }
	    });

	    builder.setNegativeButton("Confirmar", new DialogInterface.OnClickListener() {
	        public void onClick(DialogInterface arg0, int arg1) {
	            Toast.makeText(MainActivity.this, CAIXA_ABERTO, Toast.LENGTH_SHORT).show();
	        }
	    });

	    alerta = builder.create();
	    alerta.show();
	}
    

    private void fecharCaixa() {

    	AlertDialog.Builder builder = new AlertDialog.Builder(this);
	    builder.setTitle("Fechar Caixa");
	    builder.setMessage("Deseja realmente fechar caixa?");
	    
	    builder.setPositiveButton("Cancelar", new DialogInterface.OnClickListener() {
	        public void onClick(DialogInterface arg0, int arg1) {
	        	Log.d(CATEGORIA, "Clicou em Cancelar!");
	        }
	    });

	    builder.setNegativeButton("Confirmar", new DialogInterface.OnClickListener() {
	        public void onClick(DialogInterface arg0, int arg1) {
	            Toast.makeText(MainActivity.this, CAIXA_FECHADO, Toast.LENGTH_SHORT).show();
	        }
	    });

	    alerta = builder.create();
	    alerta.show();
	}
    

}
