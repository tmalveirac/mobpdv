package br.android.mobpdv.view;

import java.util.List;

import br.android.mobpdv.model.CategoriaProduto;
import br.android.mobpdv.model.Produto;
import android.R;
import android.app.Activity;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CategoriaAdapter extends BaseExpandableListAdapter {

	private Activity activity;
	
	
	Produto p1 = new Produto(1, "Coca Cola", 2.0, CategoriaProduto.BEBIDA);
	Produto p2 = new Produto(1, "Fanta Laranja", 2.0, CategoriaProduto.BEBIDA);
	Produto p3 = new Produto(1, "Coxinha", 6.0, CategoriaProduto.SALGADO);
	Produto p4 = new Produto(1, "Pastel", 5.0, CategoriaProduto.SALGADO);
	
	
	
	
	//Simulando Dados de um BD
	//public String[] categorias = new String[] {"Bebida", "Salgado"};
	//public String[][] produtos = new String[][] {{"Coca Cola", "Fanta Laranja"}, {"Coxinha", "Pastel"}};
	
	public String[] categorias = new String[] {CategoriaProduto.BEBIDA.toString(), CategoriaProduto.SALGADO.toString()};
	
	public Produto[][] produtos = new Produto[][] {{p1,p2},{p3,p4}};
	
	
	
	public CategoriaAdapter(Activity activity){
		this.activity = activity;
	}
	
	@Override
	public Object getChild(int arg0, int arg1) {
		return produtos[arg0][arg1];
	}

	@Override
	public long getChildId(int arg0, int arg1) {
		return arg1;
	}

	@Override
	public View getChildView(int arg0, int arg1, boolean arg2, View arg3,
			ViewGroup arg4) {
		TextView txt = new TextView(this.activity);
		txt.setText(produtos[arg0][arg1].getDescricao());
		txt.setPadding(30, 0, 0, 0);
		txt.setTextSize(25);
		
		return txt;
	}

	@Override
	public int getChildrenCount(int arg0) {
		return produtos[arg0].length;
	}

	@Override
	public Object getGroup(int arg0) {
		return categorias[arg0];
	}

	@Override
	public int getGroupCount() {
		return categorias.length;
	}

	@Override
	public long getGroupId(int arg0) {
		return arg0;
	}

	@Override
	public View getGroupView(int arg0, boolean arg1, View arg2, ViewGroup arg3) {
		TextView txt = new TextView(this.activity);
		txt.setText(categorias[arg0]);
		txt.setPadding(5, 0, 0, 0);
		txt.setTextSize(30);
		txt.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
		
		ImageView image = new ImageView(this.activity);
		image.setImageResource(R.drawable.ic_menu_camera);
		
		LinearLayout linear1 = new LinearLayout(this.activity);
		linear1.setPadding(27, 0, 0, 0);
		linear1.setOrientation(LinearLayout.HORIZONTAL);
		
		LinearLayout linear2 = new LinearLayout(this.activity);
		linear2.setOrientation(LinearLayout.VERTICAL);
		
		linear1.addView(image);
		linear1.addView(linear2);
		
		linear2.addView(txt);
		
		
		return linear1;
	}

	@Override
	public boolean hasStableIds() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isChildSelectable(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return true;
	}

}
